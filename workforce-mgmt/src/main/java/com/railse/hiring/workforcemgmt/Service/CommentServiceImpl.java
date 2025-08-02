package com.railse.hiring.workforcemgmt.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.railse.hiring.workforcemgmt.DTO.CommentDTO;
import com.railse.hiring.workforcemgmt.Models.Comment;
import com.railse.hiring.workforcemgmt.Repositories.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
	
	
	private final CommentRepository commentRepository;
	@Override
	public CommentDTO addComment(CommentDTO dto) {
	Comment comment = new Comment();
    comment.setTaskId(dto.getTaskId());
    comment.setUserId(dto.getUserId());
    comment.setComment(dto.getComment());
    comment.setCreatedAt(dto.getCreatedAt());

    Comment saved = commentRepository.save(comment);
    dto.setId(saved.getId());
    dto.setCreatedAt(saved.getCreatedAt());
    return dto;
	}

	@Override
	public List<CommentDTO> getCommentsForTask(Long taskId) {
		return commentRepository.findByTaskId(taskId).stream()
                .map(c -> {
                    CommentDTO dto = new CommentDTO();
                    dto.setId(c.getId());
                    dto.setTaskId(c.getTaskId());
                    dto.setUserId(c.getUserId());
                    dto.setComment(c.getComment());
                    dto.setCreatedAt(c.getCreatedAt());
                    return dto;
                }).collect(Collectors.toList());
	}

}
