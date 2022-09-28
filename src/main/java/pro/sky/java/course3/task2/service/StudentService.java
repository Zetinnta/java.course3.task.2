package pro.sky.java.course3.task2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.java.course3.task2.model.Student;
import pro.sky.java.course3.task2.repositories.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class StudentService {


    private final Logger logger = LoggerFactory.getLogger(StudentService.class);

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

    public Collection<Student> findByAge(Integer age) {
        logger.info("Was invoked method for find student by age");
        return studentRepository.findByAge(age);
    }

    public Collection<Student> findByAgeBetween(Integer min, Integer max) {
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

    // 4.5 lesson

    public List<String> getStudentsWithFirstLetterSortedByAlphabet(char letter) {
        logger.info("Was invoked method for get students by name sorted");
        String part = String.valueOf(letter).toUpperCase();
        Collection<Student> students = findAll();
        return students.stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(student -> student.startsWith(part))
                .sorted()
                .collect(Collectors.toList());
    }

    public double getStudentsAverageAgeUsingStream() {
        logger.info("Was invoked method for get students average age using stream");
        Collection<Student> students = findAll();
        return students.stream()
                .mapToDouble(Student::getAge)
                .average()
                .orElseThrow();
    }

    public Integer task() {
        int sum = Stream.iterate(1, a -> a + 1)
                .limit(1_000_000)
                .parallel()
                .reduce(0, Integer::sum);
        return sum;
    }

    // 4.6 task

    public void printStudent(Student student) {
        try {
            System.out.println(student.toString());
            Thread.sleep(500);
        } catch (InterruptedException exception) {
            System.out.println("Method was interrupted");
        }
    }

    public void getStudentsUsingThread() {
        List<Student> students = studentRepository.getStudentsSortedById();
        printStudent(students.get(0));
        printStudent(students.get(1));

        new Thread(() -> {
            printStudent(students.get(2));
            printStudent(students.get(3));
        }).start();

        new Thread(() -> {
            printStudent(students.get(4));
            printStudent(students.get(5));
        }).start();
    }

    public final Object flag = new Object();

    public /* synchronized */ void printStudentSynchronized(Student student) {
//        synchronized (flag) {
            try {
                System.out.println(student.toString());
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                System.out.println("Method was interrupted");
            }
//        }
    }

    public void getStudentsUsingThreadSynchronized() {
        List<Student> students = studentRepository.getStudentsSortedById();

        printStudentSynchronized(students.get(0));
        printStudentSynchronized(students.get(1));

        synchronized (flag) {
            new Thread(() -> {
                printStudentSynchronized(students.get(2));
                printStudentSynchronized(students.get(3));
            }).start();
        }

        synchronized (flag) {
            new Thread(() -> {
                printStudentSynchronized(students.get(3));
                printStudentSynchronized(students.get(4));
            }).start();
        }
    }
}
