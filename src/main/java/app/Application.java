package app;


import data.HSQLDBData;
import data.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//libs for the DB


@SpringBootApplication
public class Application {

    private static String dbString = "jdbc:hsqldb:file:C:\\Users\\TBB\\tutorial_project\\\\users-server\\userDB\\DB";


    public static Data dataBase = new HSQLDBData(dbString);

    public static void main(String[] args) {

        dataBase.prepareDB();
        SpringApplication.run(Application.class, args);
    }

    public static void prepareDB(){
        dataBase.prepareDB();
    }

    public static List<User> getUsersDB(){
        return dataBase.getUsersDB();
    }

    public static boolean addUserDB(User user){
        return dataBase.addUserDB(user);
    }
}