package hello;

/**
 * Created by TBB on 02.09.2016.
 */

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static User notExisiting = new User(0,"", "", "");
    private static User onlyUser = new User(1,"Bob", "Morane", "ELCA");

    private static final String noParams = "Hello! Please login!";
    private static final String known = "Hello, %s! You are logged in!";
    private static final String unknown = "Login failed!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/login")
    public Greeting login(@RequestParam(value="name", defaultValue="") String name, @RequestParam(value="password", defaultValue="") String password) {

        if(notExisiting.isMe(name, password)){
            return new Greeting(counter.incrementAndGet(),noParams);
        }
        else if(onlyUser.isMe(name, password)){
            return new Greeting(counter.incrementAndGet(),String.format(known,name));
        }
        else
        return new Greeting(counter.incrementAndGet(),unknown);
    }
}
