package com.railse.hiring.workforcemgmt.Models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	private Long id;
	private Long taskId;
	private Long userId;
	private String Comment;
	private LocalDateTime createdAt;
	
}
