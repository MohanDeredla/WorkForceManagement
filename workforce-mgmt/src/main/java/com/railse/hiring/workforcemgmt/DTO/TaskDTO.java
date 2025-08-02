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
	
}
