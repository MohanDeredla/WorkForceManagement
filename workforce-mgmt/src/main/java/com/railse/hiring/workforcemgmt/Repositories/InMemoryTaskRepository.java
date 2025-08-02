package com.railse.hiring.workforcemgmt.Repositories;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.railse.hiring.workforcemgmt.Enums.Priority;
import com.railse.hiring.workforcemgmt.Enums.ReferenceType;
import com.railse.hiring.workforcemgmt.Models.Task;
@Repository
public class InMemoryTaskRepository implements TaskRepository{
	private final Map<Long, Task> taskStore = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);
	@Override
	public Optional<Task> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(taskStore.get(id));
	}
	@Override
	public Task save(Task task) {
		// TODO Auto-generated method stub
		if(task.getId()==null) {
			task.setId(idGenerator.getAndIncrement());
		}
		 taskStore.put(task.getId(), task);
		return task;
	}
	@Override
	public List<Task> findByAssigneeIdIn(List<Long> asigneeIds) {
		return taskStore.values().stream()
                .filter(task -> asigneeIds.contains(task.getAssigneeId()))
                .collect(Collectors.toList());
	}
	@Override
	public List<Task> findByReferenceIdAndReferenceType(Long referenceId, ReferenceType referenceType) {
		return taskStore.values().stream()
                .filter(task -> Objects.equals(task.getReferenceId(), referenceId) &&
                                task.getReferenceType() == referenceType)
                .collect(Collectors.toList());
	}
	@Override
	public List<Task> findAll() {
		return taskStore.values().stream().collect(Collectors.toList());
	}
	@Override
	public List<Task> findByPriority(Priority priority) {
		 return taskStore.values().stream()
	                .filter(task -> priority.equals(task.getPriority()))
	                .collect(Collectors.toList());
	    
	}
	
}
