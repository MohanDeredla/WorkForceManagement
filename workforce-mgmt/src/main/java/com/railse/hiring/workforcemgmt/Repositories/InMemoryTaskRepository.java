package com.railse.hiring.workforcemgmt.Repositories;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.railse.hiring.workforcemgmt.Models.Task;

public class InMemoryTaskRepository implements TaskRepository{
	private final Map<Long, Task> taskStore = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();
    
}
