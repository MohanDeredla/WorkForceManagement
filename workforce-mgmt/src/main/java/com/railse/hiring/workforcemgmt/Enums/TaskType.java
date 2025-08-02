package com.railse.hiring.workforcemgmt.Enums;

import java.util.List;

public enum TaskType {
	DELIVERY,
    FOLLOW_UP,
    MEETING;
	public static List<TaskType> getTasksByReferenceType(ReferenceType referenceType) {
		switch (referenceType) {
        case ORDER:
            return List.of(DELIVERY);
        case ENQUIRY:
            return List.of(FOLLOW_UP);
        case ENTITY:
            return List.of(FOLLOW_UP);
        default:
            throw new IllegalArgumentException("Unsupported reference type: " + referenceType);
    }
	}
}
