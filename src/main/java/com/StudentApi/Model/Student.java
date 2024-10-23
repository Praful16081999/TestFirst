package com.StudentApi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String standerd;
	private int fees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStanderd() {
		return standerd;
	}
	public void setStanderd(String standerd) {
		this.standerd = standerd;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", standerd=" + standerd + ", fees=" + fees + "]";
	}
	public Student(int id, String name, String standerd, int fees) {
		super();
		this.id = id;
		this.name = name;
		this.standerd = standerd;
		this.fees = fees;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
