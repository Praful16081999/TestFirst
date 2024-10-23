package com.StudentApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentApi.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
