package com.railse.hiring.workforcemgmt.Service;

import java.util.List;

import com.railse.hiring.workforcemgmt.DTO.CommentDTO;

public interface CommentService {

	CommentDTO addComment(CommentDTO dto);

	List<CommentDTO> getCommentsForTask(Long taskId);

}
