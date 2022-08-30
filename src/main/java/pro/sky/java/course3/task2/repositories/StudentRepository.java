package pro.sky.java.course3.task2.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.java.course3.task2.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

    List<Student> findByAge(Integer age);

    List<Student> findByAgeBetween(Integer min, Integer max);

//    List<Student> findAllByFaculty(Integer id);
}
