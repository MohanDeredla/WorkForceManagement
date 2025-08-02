package com.railse.hiring.workforcemgmt.DTO;

import com.railse.hiring.workforcemgmt.Enums.ReferenceType;

import lombok.Data;

@Data
public class AssignByReferenceRequest {
	private Long ReferencId;
	private ReferenceType referenceType;
	private Long asigneeId;
	public Long getReferencId() {
		return ReferencId;
	}
	public void setReferencId(Long referencId) {
		ReferencId = referencId;
	}
	public ReferenceType getReferenceType() {
		return referenceType;
	}
	public void setReferenceType(ReferenceType referenceType) {
		this.referenceType = referenceType;
	}
	public Long getAsigneeId() {
		return asigneeId;
	}
	public void setAsigneeId(Long asigneeId) {
		this.asigneeId = asigneeId;
	}
	
	
}

