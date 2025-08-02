package com.railse.hiring.workforcemgmt.Repositories;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.railse.hiring.workforcemgmt.Models.ActivityLog;

@Repository
public class ActivityLogRepository {

	private final Map<Long, ActivityLog> logStore = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

}
