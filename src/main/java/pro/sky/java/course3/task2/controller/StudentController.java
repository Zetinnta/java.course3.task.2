package pro.sky.java.course3.task2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course3.task2.model.Faculty;
import pro.sky.java.course3.task2.model.Student;
import pro.sky.java.course3.task2.service.StudentService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;


@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudent(@PathVariable Long id) {
        Student newStudent = studentService.findStudent(id);
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
        Student updateStudent = studentService.editStudent(student);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> findStudents(@RequestParam(required = false) Integer age,
                                                            @RequestParam(required = false) Integer min,
                                                            @RequestParam(required = false) Integer max) {
        if (min != null && max != null && min > 0 && max < Integer.MAX_VALUE) {
            return ResponseEntity.ok(studentService.findByAgeBetween(min, max));
        }
        if (age != null && age > 0) {
            return ResponseEntity.ok(studentService.findByAge(age));
        }
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/{id}/faculty")
    public ResponseEntity<Faculty> findFacultyByStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudent(id).getFaculty());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable("name") String name) {
        List<Student> students = studentService.getStudentsByName(name);
        return ResponseEntity.ok(students);
    }

    // 4.5 lesson

    @GetMapping("/sorted_name")
    public List<String> getStudentsWithFirstLetterSortedByAlphabet(@RequestParam(name = "char") char letter) {
        return studentService.getStudentsWithFirstLetterSortedByAlphabet(letter);
    }

    @GetMapping("/average_age")
    public double getStudentsAverageAgeUsingStream() {
        return studentService.getStudentsAverageAgeUsingStream();
    }

    @GetMapping("/task")
    public Integer task() {
        return studentService.task();
    }


}
