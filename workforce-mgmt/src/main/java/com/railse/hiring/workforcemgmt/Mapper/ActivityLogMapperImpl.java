package com.railse.hiring.workforcemgmt.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.railse.hiring.workforcemgmt.DTO.ActivityLogDTO;
import com.railse.hiring.workforcemgmt.Models.ActivityLog;

@Component
public class ActivityLogMapperImpl implements ActivityLogMapper{

	@Override
    public ActivityLogDTO toDto(ActivityLog log) {
        if (log == null) return null;

        ActivityLogDTO dto = new ActivityLogDTO();
        dto.setId(log.getId());
        dto.setTaskId(log.getTaskId());
        dto.setMessage(log.getMessage());
        dto.setCreatedAt(log.getCreatedAt());
        return dto;
    }

    @Override
    public ActivityLog toEntity(ActivityLogDTO dto) {
        if (dto == null) return null;

        ActivityLog log = new ActivityLog();
        log.setId(dto.getId());
        log.setTaskId(dto.getTaskId());
        log.setMessage(dto.getMessage());
        log.setCreatedAt(dto.getCreatedAt());
        return log;
    }

    @Override
    public List<ActivityLogDTO> toDtoList(List<ActivityLog> logs) {
        if (logs == null) return null;

        return logs.stream()
                   .map(this::toDto)
                   .collect(Collectors.toList());
    }

}
