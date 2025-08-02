package com.railse.hiring.workforcemgmt.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommentDTO {
	
	private Long id;
	private Long taskId;
	private Long userId;
	private String comment;
	private LocalDateTime createdAt;
	
}
