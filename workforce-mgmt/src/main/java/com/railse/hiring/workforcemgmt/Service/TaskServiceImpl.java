package com.railse.hiring.workforcemgmt.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.railse.hiring.workforcemgmt.DTO.AssignByReferenceRequest;
import com.railse.hiring.workforcemgmt.DTO.TaskCreateRequest;
import com.railse.hiring.workforcemgmt.DTO.TaskDTO;
import com.railse.hiring.workforcemgmt.DTO.TaskFetchByDateRequest;
import com.railse.hiring.workforcemgmt.DTO.TaskUpdateRequest;
import com.railse.hiring.workforcemgmt.Enums.Priority;
import com.railse.hiring.workforcemgmt.Enums.ReferenceType;
import com.railse.hiring.workforcemgmt.Enums.TaskStatus;
import com.railse.hiring.workforcemgmt.Enums.TaskType;
import com.railse.hiring.workforcemgmt.Exception.ResourceNotFoundException;
import com.railse.hiring.workforcemgmt.Mapper.TaskMapper;
import com.railse.hiring.workforcemgmt.Models.Task;
import com.railse.hiring.workforcemgmt.Repositories.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
	
	private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
	@Override
	public TaskDTO findTaskById(Long id) {
		Task task=taskRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Task not found with the id: "+id));
		return taskMapper.toDto(task);
	}
	@Override
	public List<TaskDTO> createTasks(TaskCreateRequest request) {
	    List<Task> createdTasks = new ArrayList<>();
	    for (TaskCreateRequest.RequestItem item : request.getRequests()) {
	        Task newTask = new Task();
	        newTask.setReferenceId(item.getReferenceId());
	        newTask.setReferenceType(item.getReferenceType());
	        newTask.setTaskType(item.getTaskType());
	        newTask.setAssigneeId(item.getAssigneeId());
	        newTask.setPriority(item.getPriority());
	        newTask.setTaskDeadlineTime(item.getTaskDeadlineTime());
	        newTask.setStatus(TaskStatus.ASSIGNED);
	        newTask.setDescription("New task created.");
	        createdTasks.add(taskRepository.save(newTask));
	    }
	    return taskMapper.toDtoList(createdTasks);
	}

	@Override
	public List<TaskDTO> updateTasks(TaskUpdateRequest request) {
	    List<Task> updatedTasks = new ArrayList<>();
	    for (TaskUpdateRequest.RequestItem item : request.getRequests()) {
	        Task task = taskRepository.findById(item.getTaskId())
	                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + item.getTaskId()));
	        if (item.getTaskStatus() != null) {
	            task.setStatus(item.getTaskStatus());
	        }
	        if (item.getDescription() != null) {
	            task.setDescription(item.getDescription());
	        }
	        updatedTasks.add(taskRepository.save(task));
	    }
	    return taskMapper.toDtoList(updatedTasks);
	}
	//FIXEDBUG 2
	@Override
	public List<TaskDTO> fetchTasksByDate(TaskFetchByDateRequest request) {
	    List<Task> tasks = taskRepository.findByAssigneeIdIn(request.getAsigneeIds());
	    long start = request.getStartDate();
	    long end = request.getEndDate();
	    List<Task> filtered = tasks.stream()
	    	    .filter(t -> t.getStatus() != TaskStatus.CANCELLED)
	    	    .filter(t ->
	    	        (t.getTaskDeadlineTime() != null &&
	    	         ((Long) t.getTaskDeadlineTime()).longValue() >= start &&
	    	         ((Long) t.getTaskDeadlineTime()).longValue() <= end) ||
	    	        (t.getTaskDeadlineTime() != null &&
	    	         ((Long) t.getTaskDeadlineTime()).longValue() < start &&
	    	         t.getStatus() == TaskStatus.ASSIGNED)
	    	    )
	    	    .collect(Collectors.toList());

	    	return taskMapper.toDtoList(filtered);

	}
	//BUG2
//	@Override
//	public List<TaskDTO> fetchTasksByDate(TaskFetchByDateRequest request) {
//	    List<Task> tasks = taskRepository.findByAssigneeIdIn(request.getAsigneeIds());
//	    long start = request.getStartDate();
//	    long end = request.getEndDate();
//
//	    //BUG: No filtering of CANCELLED tasks
//	    List<Task> filtered = tasks.stream()
//	            .filter(t -> t.getTaskDeadlineTime() != null &&
//	                         t.getTaskDeadlineTime() >= start &&
//	                         t.getTaskDeadlineTime() <= end)
//	            .collect(Collectors.toList());
//
//	    return taskMapper.toDtoList(filtered);
//	}



	//FIXEDBUG 1
	@Override
	public String assignByReference(AssignByReferenceRequest request) {
		ReferenceType referenceType = request.getReferenceType();
        Long referenceId = request.getReferencId();
        Long assigneeId = request.getAsigneeId();

        List<TaskType> applicableTaskTypes = null;
		try {
			applicableTaskTypes = TaskType.getTasksByReferenceType(referenceType);
		} catch (Exception e) {
			e.printStackTrace();
		}
        List<Task> existingTasks = taskRepository.findByReferenceIdAndReferenceType(referenceId, referenceType);

        for (TaskType taskType : applicableTaskTypes) {
            List<Task> tasksOfType = existingTasks.stream()
                    .filter(t -> t.getTaskType() == taskType && t.getStatus() != TaskStatus.COMPLETED)
                    .collect(Collectors.toList());

            if (!tasksOfType.isEmpty()) {
                boolean assigned = false;
                for (Task task : tasksOfType) {
                    if (!assigned) {
                        task.setAssigneeId(assigneeId);
                        assigned = true;
                    } else {
                        task.setStatus(TaskStatus.CANCELLED);
                    }
                    taskRepository.save(task);
                }
            } else {
                Task newTask = new Task();
                newTask.setReferenceId(referenceId);
                newTask.setReferenceType(referenceType);
                newTask.setTaskType(taskType);
                newTask.setAssigneeId(assigneeId);
                newTask.setStatus(TaskStatus.ASSIGNED);
                newTask.setDescription("Assigned by reference.");
                taskRepository.save(newTask);
            }
        }

        return "Tasks assigned successfully for reference " + referenceId;
	}
	//Bug 1 code
//	@Override
//	public String assignByReference(AssignByReferenceRequest request) {
//	    ReferenceType referenceType = request.getReferenceType();
//	    Long referenceId = request.getReferencId();
//	    Long assigneeId = request.getAsigneeId();
//
//	    List<TaskType> applicableTaskTypes = null;
//	    try {
//	        applicableTaskTypes = TaskType.getTasksByReferenceType(referenceType);
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//	    List<Task> existingTasks = taskRepository.findByReferenceIdAndReferenceType(referenceId, referenceType);
//
//	    for (TaskType taskType : applicableTaskTypes) {
//	        
//	        List<Task> tasksOfType = existingTasks.stream()
//	                .filter(t -> t.getTaskType() == taskType)
//	                .collect(Collectors.toList());
//
//	        if (!tasksOfType.isEmpty()) {
//	            // Reassign the task (without canceling the old one)
//	            Task task = tasksOfType.get(0);
//	            task.setAssigneeId(assigneeId);
//	            taskRepository.save(task);
//	        } else {
//	            Task newTask = new Task();
//	            newTask.setReferenceId(referenceId);
//	            newTask.setReferenceType(referenceType);
//	            newTask.setTaskType(taskType);
//	            newTask.setAssigneeId(assigneeId);
//	            newTask.setStatus(TaskStatus.ASSIGNED);
//	            newTask.setDescription("Assigned by reference.");
//	            taskRepository.save(newTask);
//	        }
//	    }
//
//	    return "Tasks assigned successfully for reference " + referenceId;
//	}

	@Override
	public List<TaskDTO> findByPriority(Priority priority) {
	    return taskMapper.toDtoList(taskRepository.findByPriority(priority));
	}

    
}
