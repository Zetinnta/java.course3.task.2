package pro.sky.java.course3.task2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.java.course3.task2.model.Faculty;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findByColorIgnoreCase(String color);

//    Faculty save(Faculty faculty);
//    Optional<Faculty> findById(Long id);

    List<Faculty> findByNameIgnoreCase(String name);

}
