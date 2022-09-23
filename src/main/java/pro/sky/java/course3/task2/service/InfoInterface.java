package pro.sky.java.course3.task2.service;

import org.springframework.http.ResponseEntity;

public interface InfoInterface {
   ResponseEntity<Integer> getServerPort();
}
