package com.railse.hiring.workforcemgmt.Models;



import com.railse.hiring.workforcemgmt.Enums.Priority;
import com.railse.hiring.workforcemgmt.Enums.ReferenceType;
import com.railse.hiring.workforcemgmt.Enums.TaskStatus;
import com.railse.hiring.workforcemgmt.Enums.TaskType;

import lombok.Data;

@Data
public class Task {
	
	private Long id;
	private Long referenceId;
	private ReferenceType refernceType;
	private TaskType taskType;
	private String description;
	private TaskStatus status;
	private Long assigneeId;
	private Long taskDeadlineTime;
	private Priority priority;
	private Long createdAt;
	private Long updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	public ReferenceType getRefernceType() {
		return refernceType;
	}

	public void setRefernceType(ReferenceType refernceType) {
		this.refernceType = refernceType;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public Long getAssigneeId() {
		return assigneeId;
	}

	public void setAssigneeId(Long assigneeId) {
		this.assigneeId = assigneeId;
	}

	public Long getTaskDeadlineTime() {
		return taskDeadlineTime;
	}

	public void setTaskDeadlineTime(Long taskDeadlineTime) {
		this.taskDeadlineTime = taskDeadlineTime;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", referenceId=" + referenceId + ", refernceType=" + refernceType + ", taskType="
				+ taskType + ", description=" + description + ", status=" + status + ", assigneeId=" + assigneeId
				+ ", taskDeadlineTime=" + taskDeadlineTime + ", priority=" + priority + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

	public Task(Long id, Long referenceId, ReferenceType refernceType, TaskType taskType, String description,
			TaskStatus status, Long assigneeId, Long taskDeadlineTime, Priority priority, Long createdAt,
			Long updatedAt) {
		super();
		this.id = id;
		this.referenceId = referenceId;
		this.refernceType = refernceType;
		this.taskType = taskType;
		this.description = description;
		this.status = status;
		this.assigneeId = assigneeId;
		this.taskDeadlineTime = taskDeadlineTime;
		this.priority = priority;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
}


