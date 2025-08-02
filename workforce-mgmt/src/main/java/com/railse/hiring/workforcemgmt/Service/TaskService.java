package com.railse.hiring.workforcemgmt.Service;

import java.util.List;

import com.railse.hiring.workforcemgmt.DTO.AssignByReferenceRequest;
import com.railse.hiring.workforcemgmt.DTO.TaskCreateRequest;
import com.railse.hiring.workforcemgmt.DTO.TaskDTO;
import com.railse.hiring.workforcemgmt.DTO.TaskFetchByDateRequest;
import com.railse.hiring.workforcemgmt.DTO.TaskUpdateRequest;
import com.railse.hiring.workforcemgmt.Enums.Priority;

public interface TaskService {

	TaskDTO findTaskById(Long id);

	List<TaskDTO> createTasks(TaskCreateRequest request);

	List<TaskDTO> updateTasks(TaskUpdateRequest request);

	String assignByReference(AssignByReferenceRequest request);

	List<TaskDTO> fetchTasksByDate(TaskFetchByDateRequest request);

	List<TaskDTO> findByPriority(Priority priority);

	
}
