package com.railse.hiring.workforcemgmt.DTO;

import com.railse.hiring.workforcemgmt.Enums.Priority;
import com.railse.hiring.workforcemgmt.Enums.ReferenceType;
import com.railse.hiring.workforcemgmt.Enums.TaskStatus;
import com.railse.hiring.workforcemgmt.Enums.TaskType;

import lombok.Data;

@Data
public class TaskDTO {
	private Long id;
	private Long referenceId;
	private ReferenceType referenceType;
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
    
    
}
