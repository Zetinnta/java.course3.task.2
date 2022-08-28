package pro.sky.java.course3.task2.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.java.course3.task2.model.Faculty;

import java.util.Collection;
import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer>{
    List<Faculty> findByColor(String color);
}
