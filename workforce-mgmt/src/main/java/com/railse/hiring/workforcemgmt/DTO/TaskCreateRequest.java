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
	        
			public Long getReferenceId() {
				return referenceId;
			}
			public void setReferenceId(Long referenceId) {
				this.referenceId = referenceId;
			}
			public ReferenceType getReferenceType() {
				return referenceType;
			}
			public void setReferenceType(ReferenceType referenceType) {
				this.referenceType = referenceType;
			}
			public TaskType getTaskType() {
				return taskType;
			}
			public void setTaskType(TaskType taskType) {
				this.taskType = taskType;
			}
			public Long getAssigneeId() {
				return assigneeId;
			}
			public void setAssigneeId(Long assigneeId) {
				this.assigneeId = assigneeId;
			}
			public Priority getPriority() {
				return priority;
			}
			public void setPriority(Priority priority) {
				this.priority = priority;
			}
			public Long getTaskDeadlineTime() {
				return taskDeadlineTime;
			}
			public void setTaskDeadlineTime(Long taskDeadlineTime) {
				this.taskDeadlineTime = taskDeadlineTime;
			}
	        
	        
	}
	public List<RequestItem> getRequests() {
		return requests;
	}
	public void setRequests(List<RequestItem> requests) {
		this.requests = requests;
	}
	
}
