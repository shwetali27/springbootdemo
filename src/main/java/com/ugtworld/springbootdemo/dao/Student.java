package com.ugtworld.springbootdemo.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="students")
@NamedQuery(name="Student.findAll", query="select i from Student i")
public class Student {
	@Id
	@Column(name = "roll_num")
	private Integer rollNo;

	private String name;

	private Integer marks;

	@Column(name = "class")
	private Integer studentClass;

	private String gender;

}