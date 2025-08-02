package com.railse.hiring.workforcemgmt.Models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityLog {
	
	private Long id;
	private Long taskId;
	private String message;
	private LocalDateTime createdAt;
	
}
