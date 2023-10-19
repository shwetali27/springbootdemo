package com.ugtworld.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.ugtworld.springbootdemo.dao.Student;
import com.ugtworld.springbootdemo.dao.StudentRepo;
import com.ugtworld.springbootdemo.model.Request;
import com.ugtworld.springbootdemo.model.Response;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentRepo;

	public Response getAllStudents() {
		List<Student> students = studentRepo.findAll();
		Response response = Response.builder().code("200").body(students).message("Success").build();

		return response;
	}

	public Response saveNewStudent(Request req) {
		// saving student
		Student student = studentRepo.save(Student.builder()
									.rollNo(req.getId())
									.name(req.getName())
									.marks(req.getMarks())
									.studentClass(req.getStudentClass())
									.gender(req.getGender())
									.build());
		
		Response response = Response.builder()
							.code("200")
							.body(student)
							.message("Success").build();
		return response;
	}
	
	public Response updateStudent(Request req) {
		Response response = null;
		try {
			Student student = studentRepo.getReferenceById(req.getId());
			System.out.println(student);
			// updating student
			student.setName(req.getName());
			student.setMarks(req.getMarks());
			student.setStudentClass(req.getStudentClass());
			student.setGender(req.getGender());
			
			// saving student
			student = studentRepo.save(student);
			
			response = Response.builder()
								.code("200")
								.body(student)
								.message("Success").build();
		} catch(EntityNotFoundException e) {
			response = Response.builder()
					.code("400")
					.body("Student with id not present")
					.message("Failed").build();
		}
		return response;
	}
	
	public Response deleteStudent(int id) {
		Response response = null;
		try {
			Student student = studentRepo.getReferenceById(id);
			System.out.println(student);
			studentRepo.delete(student);
			
			response = Response.builder()
								.code("200")
								.body("Student deleted successfully")
								.message("Success").build();
		}catch(EntityNotFoundException e) {
			response = Response.builder()
					.code("400")
					.body("Student with id not present")
					.message("Failed").build();
		}
		return response;
	}
	
	public Response updateName(int id, String name) {
		Response response = null;
		
		try {
			Student student = studentRepo.getReferenceById(id);
			System.out.println(student);
			// updating student
			student.setName(name);
			// saving student
			student = studentRepo.save(student);
			
			response = Response.builder()
								.code("200")
								.body(student)
								.message("Success").build();
		}catch(EntityNotFoundException e) {
			response = Response.builder()
					.code("400")
					.body("Student with id not present")
					.message("Failed").build();
		}
		
		return response;
	}
}