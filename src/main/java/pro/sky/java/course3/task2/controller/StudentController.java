package pro.sky.java.course3.task2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course3.task2.model.Student;
import pro.sky.java.course3.task2.service.StudentService;

import java.util.Collection;
import java.util.Collections;


@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Student newStudent = studentService.getStudent(id);
        if (newStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newStudent);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student newStudent = studentService.addStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student updateStudent = studentService.editStudent(student.getId(), student);
        if (updateStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> findFaculties (@RequestParam(required = false) int age) {
        if (age > 0) {
            return ResponseEntity.ok(studentService.findByAge(age));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

}
