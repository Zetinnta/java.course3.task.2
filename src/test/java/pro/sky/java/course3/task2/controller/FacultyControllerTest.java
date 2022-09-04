package pro.sky.java.course3.task2.controller;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pro.sky.java.course3.task2.model.Faculty;
import pro.sky.java.course3.task2.repositories.FacultyRepository;
import pro.sky.java.course3.task2.service.FacultyService;
import org.json.JSONObject;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = FacultyController.class)
public class FacultyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyRepository facultyRepository;

    @SpyBean
    private FacultyService facultyService;

    @InjectMocks
    private FacultyController facultyController;

    @Test
    public void testFaculties () throws Exception {
        final String name = "randomBlueFaculty";
        final String color = "blue";
        final long id = 1;

        Faculty faculty = new Faculty();
        faculty.setName(name);
        faculty.setColor(color);
        faculty.setId(id);

        JSONObject facultyObject = new JSONObject();
        facultyObject.put("name", name);
        facultyObject.put("color", color);
        facultyObject.put("id", id);

        when(facultyRepository.save(any(Faculty.class))).thenReturn(faculty);
        when(facultyRepository.findById(eq(id))).thenReturn(Optional.of(faculty));
        when(facultyRepository.findByColorIgnoreCase(eq(color))).thenReturn(Collections.singleton(faculty));


}

