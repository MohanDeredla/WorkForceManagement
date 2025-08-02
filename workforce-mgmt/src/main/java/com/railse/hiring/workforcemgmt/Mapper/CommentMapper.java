package com.railse.hiring.workforcemgmt.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.railse.hiring.workforcemgmt.DTO.CommentDTO;
import com.railse.hiring.workforcemgmt.Models.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {
	CommentDTO toDto(Comment comment);
    Comment toEntity(CommentDTO dto);
    List<CommentDTO> toDtoList(List<Comment> comments);
}
