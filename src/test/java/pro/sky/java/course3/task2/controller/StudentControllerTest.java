package pro.sky.java.course3.task2.controller;


import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pro.sky.java.course3.task2.model.Student;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoad() throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    public void testStudents() throws Exception {
        Student firstStudent = new Student();
        firstStudent.setName("First Student");
        firstStudent.setAge(18);
//        firstStudent.setId(1L);

        Student secondStudent = new Student();
        secondStudent.setName("Second Student");
        secondStudent.setAge(23);
//        secondStudent.setId(2L);

        ResponseEntity<Student> responsePOST = restTemplate.postForEntity("http://localhost:" + port + "/student", firstStudent, Student.class);
        assertThat(responsePOST.getStatusCode(), is(HttpStatus.OK));
        assertThat(responsePOST.getBody().getId(), notNullValue());
        assertThat(responsePOST.getBody().getName(), is("First Student"));
        assertThat(responsePOST.getBody().getAge(), is(18));

        ResponseEntity<Student> responseGET = restTemplate.getForEntity("http://localhost:" + port + "/student/" +
                responsePOST.getBody().getId(), Student.class);
        assertThat(responsePOST.getBody().getName(), is("First Student"));
        assertThat(responsePOST.getBody().getAge(), is(18));

        HttpEntity<Student> entity = new HttpEntity<Student>(secondStudent);

        ResponseEntity<Student> responsePUT = restTemplate.exchange("/student", HttpMethod.PUT, entity, Student.class);
        assertThat(responsePUT.getStatusCode(), is(HttpStatus.OK));
        assertThat(responsePUT.getBody().getId(), notNullValue());
        assertThat(responsePUT.getBody().getName(), is("Second Student"));
        assertThat(responsePUT.getBody().getAge(), is(23));

        ResponseEntity<Void> responseDELETE = restTemplate.exchange("/student/" + responsePUT.getBody().getId()
                , HttpMethod.DELETE, null, Void.class);
        assertThat(responseDELETE.getStatusCode(), is(HttpStatus.OK));
//        assertThat(responseDELETE.getBody().isNull());


//        Assertions
//                .assertThat(this.restTemplate.postForEntity("http://localhost:" + port + "/student", student, Object.class))
//                .isEqualTo(student);
//
//
//
//        this.restTemplate.put("http://localhost:" + port + "/student", secondStudent, Object.class);
//
//        Assertions
//                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student", Object.class))
//                .isEqualTo(secondStudent);
//
//        this.restTemplate.delete("http://localhost:" + port + "/student", secondStudent);
//
//        Assertions
//                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student", Object.class))
//                .isNull();
//
    }
}
