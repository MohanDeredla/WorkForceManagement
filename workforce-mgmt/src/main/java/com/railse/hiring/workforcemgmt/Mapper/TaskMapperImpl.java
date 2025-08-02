package com.railse.hiring.workforcemgmt.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.railse.hiring.workforcemgmt.DTO.TaskDTO;
import com.railse.hiring.workforcemgmt.Models.Task;

@Component
public class TaskMapperImpl implements TaskMapper{

	@Override
    public TaskDTO toDto(Task task) {
        if (task == null) return null;

        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setReferenceId(task.getReferenceId());
        dto.setReferenceType(task.getReferenceType());
        dto.setTaskType(task.getTaskType());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setAssigneeId(task.getAssigneeId());
        dto.setTaskDeadlineTime(task.getTaskDeadlineTime());
        dto.setPriority(task.getPriority());
        dto.setCreatedAt(task.getCreatedAt());
        dto.setUpdatedAt(task.getUpdatedAt());

        return dto;
    }

    @Override
    public Task toEntity(TaskDTO dto) {
        if (dto == null) return null;

        Task task = new Task();
        task.setId(dto.getId());
        task.setReferenceId(dto.getReferenceId());
        task.setReferenceType(dto.getReferenceType());
        task.setTaskType(dto.getTaskType());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setAssigneeId(dto.getAssigneeId());
        task.setTaskDeadlineTime(dto.getTaskDeadlineTime());
        task.setPriority(dto.getPriority());
        task.setCreatedAt(dto.getCreatedAt());
        task.setUpdatedAt(dto.getUpdatedAt());

        return task;
    }

    @Override
    public List<TaskDTO> toDtoList(List<Task> tasks) {
        if (tasks == null) return null;

        return tasks.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
