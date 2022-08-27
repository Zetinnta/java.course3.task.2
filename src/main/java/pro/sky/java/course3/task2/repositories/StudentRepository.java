package pro.sky.java.course3.task2.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.java.course3.task2.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Student> findByAge(int age);
}
