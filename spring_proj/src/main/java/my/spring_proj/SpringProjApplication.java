package my.spring_proj;

import my.spring_proj.model.DoTask;
import my.spring_proj.model.MyDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@SpringBootApplication
@RestController
public class SpringProjApplication {

    public static void main(String[] args) {
        MyDB.onStart();
        SpringApplication.run(SpringProjApplication.class, args);
    }
}
