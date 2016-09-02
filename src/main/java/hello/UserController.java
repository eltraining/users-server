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


    private static final String noParams = "Hello! Please login!";
    private static final String known = "Hello, %s! You are logged in!";
    private static final String unknown = "Login failed!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/login")
    public Response login(@RequestParam(value="name", defaultValue="") String name, @RequestParam(value="password", defaultValue="") String password) {

        if(notExisiting.isMe(name, password)){
            return new Response(counter.incrementAndGet(), false,noParams);
        }
        else
            for(User user: Application.userList){
                if(user.isMe(name, password)){
                    return new Response(counter.incrementAndGet(), true,String.format(known,name));
            }
        }
        return new Response(counter.incrementAndGet(), false,unknown);
    }

    /*@RequestMapping("/create")
    public*/

}
