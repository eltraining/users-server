package data;

import app.User;

import java.util.List;

/**
 * Created by TBB on 05.09.2016.
 */
public interface Data{
    abstract List<User> getUsersDB();
    abstract boolean addUserDB(User user);
    abstract void prepareDB();

}