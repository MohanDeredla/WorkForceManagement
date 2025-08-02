package com.railse.hiring.workforcemgmt.Service;

import org.springframework.stereotype.Service;

import com.railse.hiring.workforcemgmt.Mapper.TaskMapper;
import com.railse.hiring.workforcemgmt.Repositories.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService{
	
	private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
	public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
		super();
		this.taskRepository = taskRepository;
		this.taskMapper = taskMapper;
	}
    
    
}
