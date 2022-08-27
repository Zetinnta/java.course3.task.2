package pro.sky.java.course3.task2.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.java.course3.task2.model.Faculty;

import java.util.Collection;
import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{
    List<Faculty> findByColor(String color);
}
