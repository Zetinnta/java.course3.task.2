package pro.sky.java.course3.task2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pro.sky.java.course3.task2.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByAge(Integer age);

    List<Student> findByAgeBetween(Integer min, Integer max);

    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    Long getStudentsByAmount();

    @Query(value = "SELECT AVG(age) from student", nativeQuery = true)
    double getStudentsAverageAge();

    @Query(value = "SELECT * from student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Student> getFiveLastStudents();

}
