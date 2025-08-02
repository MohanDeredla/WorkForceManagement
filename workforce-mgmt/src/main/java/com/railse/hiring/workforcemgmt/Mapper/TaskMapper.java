package com.railse.hiring.workforcemgmt.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.railse.hiring.workforcemgmt.DTO.TaskDTO;
import com.railse.hiring.workforcemgmt.Models.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
	TaskDTO toDto(Task task);
    Task toEntity(TaskDTO dto);
    List<TaskDTO> toDtoList(List<Task> tasks);
}
