package com.railse.hiring.workforcemgmt.Repositories;

import java.util.List;

import com.railse.hiring.workforcemgmt.Models.ActivityLog;

public interface ActivityLogRepository {

	List<ActivityLog> findByTaskId(Long taskId);

	ActivityLog save(ActivityLog log);


}
