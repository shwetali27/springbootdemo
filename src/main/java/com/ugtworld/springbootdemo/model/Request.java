package com.ugtworld.springbootdemo.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Request {
	String name;
	int id;
	int marks;
	int inclass;
	String gender;
}