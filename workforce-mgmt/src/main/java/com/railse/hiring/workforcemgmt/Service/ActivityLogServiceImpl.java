package com.railse.hiring.workforcemgmt.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.railse.hiring.workforcemgmt.DTO.ActivityLogDTO;
import com.railse.hiring.workforcemgmt.Mapper.ActivityLogMapper;
import com.railse.hiring.workforcemgmt.Models.ActivityLog;
import com.railse.hiring.workforcemgmt.Repositories.ActivityLogRepository;

@Service
public class ActivityLogServiceImpl implements ActivityLogService{
	
	private final ActivityLogRepository activityLogRepository = null;
	private final ActivityLogMapper mapper = null;
	@Override
	public List<ActivityLog> getLogsByTaskId(Long taskId) {
		// TODO Auto-generated method stub
		return activityLogRepository.findByTaskId(taskId);
		
	}
	@Override
	public void log(Long taskId, String message) {
		ActivityLog log = new ActivityLog();
        log.setTaskId(taskId);
        log.setMessage(message);
        log.setCreatedAt(LocalDateTime.now());
        activityLogRepository.save(log);
		
	}
	@Override
	public ActivityLogDTO logActivity(ActivityLogDTO dto) {
		ActivityLog saved = activityLogRepository.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
	}

}
