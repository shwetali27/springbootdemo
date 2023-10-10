package com.ugtworld.springbootdemo.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Response {
	private String code;
	private Object body;
	private String message;
}