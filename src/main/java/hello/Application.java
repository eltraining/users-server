package hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

//libs for the DB
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class Application {



    public static List<User> userList = new ArrayList<User>();

    public static void main(String[] args) {
        userList.add(new User("Bob", "Morane", "ELCA"));
        userList.add(new User("Timo", "Babst", "ELCA"));
        db_test();
        SpringApplication.run(Application.class, args);
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
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }

}