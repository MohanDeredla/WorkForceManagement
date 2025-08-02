package com.railse.hiring.workforcemgmt.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ActivityLogDTO {

	private Long id;
	private Long taskId;
	private String message;
	private LocalDateTime createdAt;
	
}
