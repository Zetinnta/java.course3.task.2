package pro.sky.java.course3.task2.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course3.task2.model.Faculty;

import java.util.*;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long count = 0;

    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(count++);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty getFaculty(long id) {
        return faculties.get(id);
    }

    public Faculty editFaculty(long id, Faculty faculty) {
        if (faculties.containsKey(id)) {
            faculties.put(id, faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty(long id) {
        return faculties.remove(id);
    }

    public Collection<Faculty> findByColor(String color) {
        ArrayList<Faculty> result = new ArrayList<>();
        for (Faculty faculty : faculties.values()) {
            if (Objects.equals(faculty.getColor(), color)) {
                result.add(faculty);
            }
        }
        return result;
    }

}
