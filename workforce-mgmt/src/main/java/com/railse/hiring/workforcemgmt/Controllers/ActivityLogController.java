package com.railse.hiring.workforcemgmt.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.railse.hiring.workforcemgmt.DTO.ActivityLogDTO;
import com.railse.hiring.workforcemgmt.Mapper.ActivityLogMapper;
import com.railse.hiring.workforcemgmt.Service.ActivityLogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/activity-logs")
@RequiredArgsConstructor
public class ActivityLogController {
	private final ActivityLogService activityLogService;
    private final ActivityLogMapper activityLogMapper;
    
    @PostMapping("/log")
    public ResponseEntity<ActivityLogDTO> addLog(@RequestBody ActivityLogDTO logDTO) {
        return ResponseEntity.ok(activityLogService.logActivity(logDTO));
    }
    @GetMapping("/task/{taskId}")
    public List<ActivityLogDTO> getLogsByTask(@PathVariable Long taskId) {
        return activityLogMapper.toDtoList(activityLogService.getLogsByTaskId(taskId));
    }
}
