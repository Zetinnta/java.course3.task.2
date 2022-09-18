package pro.sky.java.course3.task2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course3.task2.model.Student;
import pro.sky.java.course3.task2.repositories.StudentRepository;

import java.util.*;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    public Collection<Student> findByAge (Integer age) {
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween (Integer min, Integer max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    // 4.1

    public Long getStudentsByAmount() {
        return studentRepository.getStudentsByAmount();
    }

    public double getStudentsAverageAge() {
        return studentRepository.getStudentsAverageAge();
    }

    public List<Student> getFiveLastStudents() {
        return studentRepository.getFiveLastStudents();
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.getStudentByName(name);
    }

}
