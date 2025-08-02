package com.railse.hiring.workforcemgmt.DTO;

import java.util.List;

public class TaskFetchByDateRequest {
	
	private Long startDate;
	private Long endDate;
	private List<Long> asigneeIds;
	public Long getStartDate() {
		return startDate;
	}
	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}
	public Long getEndDate() {
		return endDate;
	}
	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}
	public List<Long> getAsigneeIds() {
		return asigneeIds;
	}
	public void setAsigneeIds(List<Long> asigneeIds) {
		this.asigneeIds = asigneeIds;
	}
	
}
