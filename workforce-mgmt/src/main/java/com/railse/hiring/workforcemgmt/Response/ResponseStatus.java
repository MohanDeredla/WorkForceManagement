package com.railse.hiring.workforcemgmt.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseStatus {
	private int code;
    private String message;
}
