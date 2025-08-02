package com.railse.hiring.workforcemgmt.DTO;

import java.util.List;

import com.railse.hiring.workforcemgmt.Enums.TaskStatus;

import lombok.Data;

@Data
public class TaskUpdateRequest {

	private List<RequestItem> requests;
	@Data
	public static class RequestItem{
		private Long taskId;
		private TaskStatus taskStatus;
		private String description;
		public Long getTaskId() {
			return taskId;
		}
		public void setTaskId(Long taskId) {
			this.taskId = taskId;
		}
		public TaskStatus getTaskStatus() {
			return taskStatus;
		}
		public void setTaskStatus(TaskStatus taskStatus) {
			this.taskStatus = taskStatus;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		
	}
	public List<RequestItem> getRequests() {
		return requests;
	}
	public void setRequests(List<RequestItem> requests) {
		this.requests = requests;
	}
	
}
