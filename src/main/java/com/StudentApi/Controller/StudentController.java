package com.StudentApi.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentApi.Model.Student;
import com.StudentApi.Service.StudentService;


@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    
    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.findAll();
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.save(student); // Save the new student
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student studentDetails) {
        return studentService.findById(id)
                .map(existingStudent -> {
                    existingStudent.setName(studentDetails.getName());
                    existingStudent.setStanderd(studentDetails.getStanderd());
                    existingStudent.setFees(studentDetails.getFees()); // Ensure you use the correct field here
                    Student updatedStudent = studentService.save(existingStudent);
                    return ResponseEntity.ok(updatedStudent);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        if (studentService.findById(id).isPresent()) {
            studentService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }}
