package pro.sky.java.course3.task2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.java.course3.task2.model.Student;
import pro.sky.java.course3.task2.repositories.StudentRepository;

import java.util.*;

@Service
public class StudentService {


    Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student addStudent(Student student) {
        logger.info("Was invoked method for add student");
        logger.debug("We added student {}", student);
        return studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        logger.info("Was invoked method for find student");
        return studentRepository.findById(id).orElse(null);
    }

    public Student editStudent(Student student) {
        logger.info("Was invoked method for edit student");
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        logger.info("Was invoked method for delete student");
        logger.debug("We deleted student {}", studentRepository.findById(id));
        studentRepository.deleteById(id);
    }

    public Collection<Student> findAll() {
        logger.info("Was invoked method for find all students");
        return studentRepository.findAll();
    }

    public Collection<Student> findByAge (Integer age) {
        logger.info("Was invoked method for find student by age");
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween (Integer min, Integer max) {
        logger.info("Was invoked method for find students by age between min and max");
        return studentRepository.findByAgeBetween(min, max);
    }

    // 4.1

    public Long getStudentsByAmount() {
        logger.info("Was invoked method for get students by amount");
        return studentRepository.getStudentsByAmount();
    }

    public double getStudentsAverageAge() {
        logger.info("Was invoked method for get students average age");
        return studentRepository.getStudentsAverageAge();
    }

    public List<Student> getFiveLastStudents() {
        logger.info("Was invoked method for get five last students");
        return studentRepository.getFiveLastStudents();
    }

    public List<Student> getStudentsByName(String name) {
        logger.info("Was invoked method for get students by name");
        return studentRepository.getStudentByName(name);
    }

}
