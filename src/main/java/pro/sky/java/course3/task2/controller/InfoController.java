package pro.sky.java.course3.task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course3.task2.model.Student;
import pro.sky.java.course3.task2.service.InfoInterface;
import pro.sky.java.course3.task2.service.InfoService;

@RestController
public class InfoController {

private final InfoInterface infoInterface;

    public InfoController(InfoInterface infoInterface) {
        this.infoInterface = infoInterface;
    }

    @GetMapping("/getPort")
    public ResponseEntity<Integer> getPort() {
        return ResponseEntity.ok(infoInterface.getServerPort());
    }

}
