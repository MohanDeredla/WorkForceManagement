package com.railse.hiring.workforcemgmt.Repositories;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.railse.hiring.workforcemgmt.Models.Comment;

@Repository
public class CommentRepository {
	 private final Map<Long, Comment> commentStore = new ConcurrentHashMap<>();
	    private final AtomicLong idCounter = new AtomicLong(0);
}
