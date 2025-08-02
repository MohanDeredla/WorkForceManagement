package com.railse.hiring.workforcemgmt.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.railse.hiring.workforcemgmt.DTO.AssignByReferenceRequest;
import com.railse.hiring.workforcemgmt.DTO.TaskCreateRequest;
import com.railse.hiring.workforcemgmt.DTO.TaskDTO;
import com.railse.hiring.workforcemgmt.DTO.TaskFetchByDateRequest;
import com.railse.hiring.workforcemgmt.DTO.TaskUpdateRequest;
import com.railse.hiring.workforcemgmt.Enums.Priority;
import com.railse.hiring.workforcemgmt.Service.TaskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
	
	private final TaskService taskService;
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskDTO> getTaskById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(taskService.findTaskById(id));
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<List<TaskDTO>> createTasks(@RequestBody TaskCreateRequest request) {
		return ResponseEntity.ok(taskService.createTasks(request));
	}
	
	@PostMapping("/update")
	public ResponseEntity<List<TaskDTO>> updateTasks(@RequestBody TaskUpdateRequest request) {
        return ResponseEntity.ok(taskService.updateTasks(request));
    }

    @PostMapping("/assign-by-reference")
    public ResponseEntity<String> assignByReference(@RequestBody AssignByReferenceRequest request) {
        return ResponseEntity.ok(taskService.assignByReference(request));
    }

    @PostMapping("/fetch-by-date")
    public ResponseEntity<List<TaskDTO>> fetchByDate(@RequestBody TaskFetchByDateRequest request) {
        return ResponseEntity.ok(taskService.fetchTasksByDate(request));
    }
    @GetMapping("/by-priority")
    public ResponseEntity<List<TaskDTO>> getTasksByPriority(@RequestParam("priority") Priority priority) {
        return ResponseEntity.ok(taskService.findByPriority(priority));
    }

}
