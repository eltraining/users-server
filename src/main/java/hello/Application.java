package hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static List<User> userList = new ArrayList<User>();

    public static void main(String[] args) {
        userList.add(new User(1,"Bob", "Morane", "ELCA"));
        userList.add(new User(2,"Timo", "Babst", "ELCA"));
        SpringApplication.run(Application.class, args);
    }
}