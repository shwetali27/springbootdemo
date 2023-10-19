package com.ugtworld.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ugtworld.springbootdemo.model.Request;
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
	
	@PostMapping(value = "/saveNewStudent")
	public Response saveNewStudent(@RequestBody Request request) {
		Response resp = null;
		try {
			resp = studentService.saveNewStudent(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	@PutMapping(value = "/updateStudent")
	public Response updateStudent(@RequestBody Request request) {
		Response resp = null;
		try {
			resp = studentService.updateStudent(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	@DeleteMapping(value = "/deleteStudent")
	public Response updateStudent(@RequestParam(name="id") int id) {
		Response resp = null;
		try {
			resp = studentService.deleteStudent(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	@PatchMapping(value = "/updateName")
	public Response updateStudent(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name) {
		Response resp = null;
		try {
			resp = studentService.updateName(id, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
}