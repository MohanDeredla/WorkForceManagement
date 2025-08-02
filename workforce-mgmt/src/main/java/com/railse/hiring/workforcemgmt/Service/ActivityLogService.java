package com.railse.hiring.workforcemgmt.Service;

import java.util.List;

import com.railse.hiring.workforcemgmt.DTO.ActivityLogDTO;
import com.railse.hiring.workforcemgmt.Models.ActivityLog;

public interface ActivityLogService {

	List<ActivityLog> getLogsByTaskId(Long taskId);
	void log(Long taskId,String message);
	ActivityLogDTO logActivity(ActivityLogDTO logDTO);
}
