package hello;

/**
 * Created by TBB on 02.09.2016.
 */
public class User {

    private final long id;
    private final String name;
    private final String password;
    private final String group;

    public User(long id, String name, String password, String group) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.group = group;
    }

    public boolean isMe(String name, String password){
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
}
