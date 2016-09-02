package hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static List<User> userList = new ArrayList<User>();

    public static void main(String[] args) {
        userList.add(new User("Bob", "Morane", "ELCA"));
        userList.add(new User("Timo", "Babst", "ELCA"));
        SpringApplication.run(Application.class, args);
    }
}