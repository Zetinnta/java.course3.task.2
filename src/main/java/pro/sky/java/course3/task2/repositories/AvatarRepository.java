package pro.sky.java.course3.task2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.java.course3.task2.model.Avatar;
import pro.sky.java.course3.task2.model.Faculty;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    Optional<Avatar> findByStudentId(Long studentId);
}
