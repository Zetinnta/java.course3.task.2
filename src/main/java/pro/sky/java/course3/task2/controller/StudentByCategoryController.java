package pro.sky.java.course3.task2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course3.task2.model.Student;
import pro.sky.java.course3.task2.service.StudentService;

import java.util.List;

@RestController
public class StudentByCategoryController {

    private final StudentService studentService;

    public StudentByCategoryController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students-by-amount")
    public Long getStudentsByAmount() {
        return studentService.getStudentsByAmount();
    }

    @GetMapping("/students-average-age")
    public double getStudentsAverageAge() {
        return studentService.getStudentsAverageAge();
    }

    @GetMapping("/students-last-five")
    public List<Student> getFiveLastStudents() {
        return studentService.getFiveLastStudents();
    }

}
