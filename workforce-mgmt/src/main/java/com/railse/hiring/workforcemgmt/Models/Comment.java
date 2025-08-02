package com.railse.hiring.workforcemgmt.Models;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Comment {
	private Long id;
	private Long taskId;
	private Long userId;
	private String Comment;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", taskId=" + taskId + ", userId=" + userId + ", Comment=" + Comment
				+ ", createdAt=" + createdAt + "]";
	}
	public Comment(Long id, Long taskId, Long userId, String comment, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.taskId = taskId;
		this.userId = userId;
		Comment = comment;
		this.createdAt = createdAt;
	}
	
	
}
