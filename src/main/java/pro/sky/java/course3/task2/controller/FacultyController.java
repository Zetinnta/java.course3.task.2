package pro.sky.java.course3.task2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course3.task2.model.Faculty;
import pro.sky.java.course3.task2.service.FacultyService;
import pro.sky.java.course3.task2.service.StudentService;

import java.util.Collection;
import java.util.Collections;


@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{/id}")
    public ResponseEntity<Faculty> findFaculty(@PathVariable long id) {
        Faculty newFaculty = facultyService.findFaculty(id);
        if (newFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newFaculty);
    }

    @PostMapping
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty) {
        Faculty newFaculty = facultyService.addFaculty(faculty);
        return ResponseEntity.ok(newFaculty);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty updateFaculty = facultyService.editFaculty(faculty);
        return ResponseEntity.ok(updateFaculty);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity<Void> deleteFaculty (@PathVariable long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> findFaculties(@RequestParam String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findByColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }

}
