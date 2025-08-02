package com.railse.hiring.workforcemgmt.Repositories;

import java.util.List;

import com.railse.hiring.workforcemgmt.Models.Comment;


public interface CommentRepository {

	Comment save(Comment comment);

	List<Comment> findByTaskId(Long taskId);
	 
}
