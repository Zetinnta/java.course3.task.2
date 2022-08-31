package pro.sky.java.course3.task2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.java.course3.task2.model.Faculty;
import pro.sky.java.course3.task2.model.Student;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findByColorIgnoreCase(String color);

    List<Faculty> findByNameIgnoreCase(String name);

}
