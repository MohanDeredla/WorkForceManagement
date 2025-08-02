package com.railse.hiring.workforcemgmt.Models;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ActivityLog {
	
	private Long id;
	private Long taskId;
	private String message;
	private LocalDateTime createdAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "ActivityLog [id=" + id + ", taskId=" + taskId + ", message=" + message + ", createdAt=" + createdAt
				+ "]";
	}
	public ActivityLog(Long id, Long taskId, String message, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.taskId = taskId;
		this.message = message;
		this.createdAt = createdAt;
	}
	
	
}
