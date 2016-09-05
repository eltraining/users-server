package app;

/**
 * Created by TBB on 02.09.2016.
 */
public class User {
    //private static final AtomicInteger counter = new AtomicInteger();
    private final int id;
    private final String name;
    private final String password;
    private final String group;

    public static final User notLoggedIn = new User("", "", ""); //for faster access, this has been moved outside of userList

    public User(int id, String name, String password, String group) {

        this.id = id;
        this.name = name;
        this.password = password;
        this.group = group;
    }

    public User(String name, String password, String group) {
        this(-1,name,password,group);
    }

    public boolean correspondsTo(String name, String password){
        return this.name.equals(name) && this.password.equals(password);
    }

    public int getId() {
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
