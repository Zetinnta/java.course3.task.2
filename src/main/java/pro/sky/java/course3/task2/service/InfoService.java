package pro.sky.java.course3.task2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InfoService implements InfoInterface {

    @Value("${server.port}")

    private Integer serverPort;

    public ResponseEntity<Integer> getServerPort() {
        return ResponseEntity.ok(serverPort);
    }


}
