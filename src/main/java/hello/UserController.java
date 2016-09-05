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

    private static final String noParams = "Hello! Please login!";
    private static final String known = "Hello, %s! You are logged in! Your ID is %s";
    private static final String unknown = "Login failed!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/login")
    public Response login(@RequestParam(value="name", defaultValue="") String name, @RequestParam(value="password", defaultValue="") String password) {

        if(User.notLoggedIn.correspondsTo(name, password)){
            return new Response(counter.incrementAndGet(), false, Application.db_test());
            //return new Response(counter.incrementAndGet(), false,noParams);
        }
        else
            for(User user: Application.userList){
                if(user.correspondsTo(name, password)){
                    return new Response(counter.incrementAndGet(), true,String.format(known,name,user.getId()));
            }
        }
        return new Response(counter.incrementAndGet(), false,unknown);
    }

    @RequestMapping("/create")
    public Response create(@RequestParam(value="name", defaultValue = "") String name, @RequestParam(value="password", defaultValue = "") String password,
                           @RequestParam(value="group", defaultValue = "") String group) {

        if (name.equals("") || password.equals("") || group.equals("")) {
            return new Response(counter.incrementAndGet(), false, "All fields must be non empty");
        } else {
            for (User user : Application.userList) {
                if (user.getName().equals(name)) {
                    return new Response(counter.incrementAndGet(), false, "Username already taken");
                }
            }
            User newUser = new User(name, password, group);
            Application.userList.add(newUser);
            return new Response(counter.incrementAndGet(), true, String.format("Account for %s has been created under ID %s!" + Application.userList.toString(), name, newUser.getId()));
        }
    }
}
