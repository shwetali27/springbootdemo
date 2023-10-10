package com.ugtworld.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugtworld.springbootdemo.dao.Student;
import com.ugtworld.springbootdemo.dao.StudentRepo;
import com.ugtworld.springbootdemo.model.Response;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepo;

	public Response getAllStudents() {
		List<Student> students = studentRepo.findAll();
		Response response = Response.builder()
							.code("200")
							.body(students)
							.message("Success").build();
		
		return response;
	}
}