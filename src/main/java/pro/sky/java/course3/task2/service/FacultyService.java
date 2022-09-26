package pro.sky.java.course3.task2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.java.course3.task2.model.Faculty;
import pro.sky.java.course3.task2.model.Student;
import pro.sky.java.course3.task2.repositories.FacultyRepository;

import java.util.*;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    final Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        logger.info("Was invoked method for add faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(Long id) {
        logger.info("Was invoked method for find faculty");
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.info("Was invoked method for edit faculty");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        logger.info("Was invoked method for delete faculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> findAll() {
        logger.info("Was invoked method for find all faculties");
        return facultyRepository.findAll();
    }

    public Collection<Faculty> findByColor(String color) {
        logger.info("Was invoked method for find faculty by color");
        return facultyRepository.findByColorIgnoreCase(color);
    }

    public Collection<Faculty> findByName(String name) {
        logger.info("Was invoked method for find faculty by name");
        return facultyRepository.findByNameIgnoreCase(name);
    }

    public Collection<Faculty> getFacultiesByNameAndColor(String name, String color) {
        logger.info("Was invoked method for find faculty by name and color");
        return facultyRepository.getFacultiesByNameAndColor(name, color);
    }

    // 4.5 lesson

    public String getLongestFacultyName() {
        logger.info("Was invoked method for get faculty with longest name");
        List<String> facultyNames = new ArrayList<>();
        Collection<Faculty> faculties = findAll();
        faculties.forEach(f -> facultyNames.add(f.getName()));
        return facultyNames.stream()
                .max(Comparator.comparingInt(String::length))
                .get();

        // Не знаю, как быть в том случае, если есть сразу несколько факультетов с одинаковой длиной названий(
    }

}
