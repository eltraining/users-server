package hello;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by TBB on 02.09.2016.
 */
public class User {
    private static final AtomicLong counter = new AtomicLong();
    private final long id;
    private final String name;
    private final String password;
    private final String group;

    public static final User notLoggedIn = new User("", "", ""); //for faster access, this has been moved outside of userList

    public User(String name, String password, String group) {

        this.id = counter.incrementAndGet();
        this.name = name;
        this.password = password;
        this.group = group;
    }

    public boolean correspondsTo(String name, String password){
        return this.name.equals(name) && this.password.equals(password);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
