package com.railse.hiring.workforcemgmt.Repositories;

import java.util.List;
import java.util.Optional;

import com.railse.hiring.workforcemgmt.Enums.Priority;
import com.railse.hiring.workforcemgmt.Enums.ReferenceType;
import com.railse.hiring.workforcemgmt.Models.Task;

public interface TaskRepository {

	Optional<Task> findById(Long id);

	Task save(Task newTask);

	List<Task> findByAssigneeIdIn(List<Long> asigneeIds);

	List<Task> findByReferenceIdAndReferenceType(Long referenceId, ReferenceType referenceType);

	List<Task> findAll();
	List<Task> findByPriority(Priority priority);


}
