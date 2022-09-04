package pro.sky.java.course3.task2.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.java.course3.task2.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    List<Student> findByAge(Integer age);

//    Student save(Student student);
//
//    Optional<Student> findById(Long id);

    List<Student> findByAgeBetween(Integer min, Integer max);

}
