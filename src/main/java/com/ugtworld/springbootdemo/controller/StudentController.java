package com.ugtworld.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ugtworld.springbootdemo.model.Response;
import com.ugtworld.springbootdemo.service.StudentService;

@RestController
@RequestMapping("/demo/")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/getAllStudents", produces = "application/json")
	public Response getAllStudents() {
		Response resp = null;
		try {
			resp = studentService.getAllStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
}