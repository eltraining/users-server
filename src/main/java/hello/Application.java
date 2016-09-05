package hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//libs for the DB


@SpringBootApplication
public class Application {

    private static String dbString = "jdbc:hsqldb:file:C:\\Users\\TBB\\tutorial_project\\\\users-server\\userDB";


    //public static List<User> userList = new ArrayList<User>();

    public static void main(String[] args) {
        prepareDB();
        //userList.add(new User("Bob", "Morane", "ELCA"));
        //userList.add(new User("Timo", "Babst", "ELCA"));
        //addUserDB(new User("Bob", "Morane", "ELCA"));
        //addUserDB(new User("Timo", "Babst", "ELCA"));

        //db_test();
        SpringApplication.run(Application.class, args);
    }

    public static void prepareDB(){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        String result = "";
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(
                    dbString, "SA", "");
            // "jdbc:hsqldb:file:C:/JavaInstallation/HSQLDB/DB", "SA", "");
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("CREATE TABLE IF NOT EXISTS users (\n" +
                            "  id INT NOT NULL,\n" +
                            "  name varchar(64),\n" +
                            "  password varchar(64),\n" +
                            "  ugroup varchar(64),\n" +
                            " PRIMARY KEY (id)\n" +
                            " ); ");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static List<User> getUsersDB(){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        List result = new ArrayList<User>();
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(
                    dbString, "SA", "");
            // "jdbc:hsqldb:file:C:/JavaInstallation/HSQLDB/DB", "SA", "");
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT * FROM users ");
            while (resultSet.next()) {
                result.add(new User(resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("ugroup")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    public static boolean addUserDB(User user){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        boolean result = true;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(
                    dbString, "SA", "");
            // "jdbc:hsqldb:file:C:/JavaInstallation/HSQLDB/DB", "SA", "");
            //statement = connection.createStatement();
            PreparedStatement pst=connection.prepareStatement("insert into users values(?,?,?,?)");
            pst.clearParameters();
            pst.setInt(1, user.getId());
            pst.setString(2, user.getName());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getGroup());
            int i=pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            try {

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
                result = false;
            }
            return result;
        }
    }

    public static String db_test(){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        String result = "";
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(
                    "jdbc:hsqldb:file:C:\\Users\\TBB\\tutorial_project\\DBtut2", "SA", "");
            // "jdbc:hsqldb:file:C:/JavaInstallation/HSQLDB/DB", "SA", "");
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT Salary FROM SALARYDETAILS WHERE EmpID='54601A'");
            while (resultSet.next()) {
                result +=("EMPLOYEE Salary:"
                        + resultSet.getString("Salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }

}