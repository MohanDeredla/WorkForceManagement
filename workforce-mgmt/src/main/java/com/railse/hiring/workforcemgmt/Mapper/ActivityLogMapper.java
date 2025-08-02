package com.railse.hiring.workforcemgmt.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.railse.hiring.workforcemgmt.DTO.ActivityLogDTO;
import com.railse.hiring.workforcemgmt.Models.ActivityLog;

@Mapper(componentModel = "spring")
public interface ActivityLogMapper {
	ActivityLogDTO toDto(ActivityLog log);
    ActivityLog toEntity(ActivityLogDTO dto);
    List<ActivityLogDTO> toDtoList(List<ActivityLog> logs);
}
