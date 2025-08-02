package com.railse.hiring.workforcemgmt.Repositories;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.railse.hiring.workforcemgmt.Models.ActivityLog;

@Repository
public class InMemoryActivityLogRepository implements ActivityLogRepository{
	
	private final Map<Long, ActivityLog> store = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
	@Override
	public List<ActivityLog> findByTaskId(Long taskId) {
		 return store.values().stream()
	                .filter(l -> l.getTaskId().equals(taskId))
	                .sorted(Comparator.comparing(ActivityLog::getCreatedAt))
	                .collect(Collectors.toList());
	}
	@Override
	public ActivityLog save(ActivityLog log) {
		// TODO Auto-generated method stub
		log.setId(idGenerator.getAndIncrement());
        store.put(log.getId(), log);
        return log;
	}

}
