package com.railse.hiring.workforcemgmt.Repositories;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.railse.hiring.workforcemgmt.DTO.CommentDTO;
import com.railse.hiring.workforcemgmt.Models.Comment;



@Repository
public class InMemoryCommentRepository implements CommentRepository{
	 private final Map<Long, Comment> store = new ConcurrentHashMap<>();
	 private final AtomicLong idGenerator = new AtomicLong(1);
	    
	@Override
	public Comment save(Comment comment) {
		 if (comment.getId() == null) {
	            comment.setId(idGenerator.getAndIncrement());
	        }
	        store.put(comment.getId(), comment);
	        return comment;
	}

	@Override
	public List<Comment> findByTaskId(Long taskId) {
		 return store.values().stream()
		            .filter(c -> c.getTaskId().equals(taskId))
		            .sorted((c1, c2) -> c1.getCreatedAt().compareTo(c2.getCreatedAt()))
		            .collect(Collectors.toList());
	}
	
}
