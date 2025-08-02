package com.railse.hiring.workforcemgmt.DTO;

import java.util.List;

import com.railse.hiring.workforcemgmt.Enums.Priority;
import com.railse.hiring.workforcemgmt.Enums.ReferenceType;
import com.railse.hiring.workforcemgmt.Enums.TaskType;

import lombok.Data;

@Data
public class TaskCreateRequest {
	private List<RequestItem> requests;
	@Data
	public static class RequestItem{
		
		 	private Long referenceId;
	        private ReferenceType referenceType;
	        private TaskType taskType;
	        private Long assigneeId;
	        private Priority priority;
	        private Long taskDeadlineTime;
	}
	
	
}
