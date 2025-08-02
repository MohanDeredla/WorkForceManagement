package com.railse.hiring.workforcemgmt.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railse.hiring.workforcemgmt.DTO.CommentDTO;
import com.railse.hiring.workforcemgmt.Service.CommentService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
	
	private final CommentService commentService;
	
	 @PostMapping("/add")
	    public ResponseEntity<CommentDTO> addComment(@RequestBody CommentDTO dto) {
	        return ResponseEntity.ok(commentService.addComment(dto));
	    }

	    @GetMapping("/task/{taskId}")
	    public ResponseEntity<List<CommentDTO>> getCommentsByTask(@PathVariable("taskId") Long taskId) {
	        return ResponseEntity.ok(commentService.getCommentsForTask(taskId));
	    }

}
