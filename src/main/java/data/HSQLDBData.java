package data;


import app.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TBB on 05.09.2016.
 *
 *
 */
public class HSQLDBData implements Data{
    private String dbLocation;

    public HSQLDBData(String dbLocation) {
        this.dbLocation = dbLocation;
    }

    @Override
    public void prepareDB(){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        String result = "";
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(
                    dbLocation, "SA", "");
            // "jdbc:hsqldb:file:C:/JavaInstallation/HSQLDB/DB", "SA", "");
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("CREATE TABLE IF NOT EXISTS users (\n" +
                            "  id INT IDENTITY,\n" +
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
    @Override
    public List<User> getUsersDB(){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        List result = new ArrayList<User>();
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(
                    dbLocation, "SA", "");
            // "jdbc:hsqldb:file:C:/JavaInstallation/HSQLDB/DB", "SA", "");
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT * FROM users ");
            while (resultSet.next()) {
                result.add(new User(Integer.parseInt(resultSet.getString("id")),resultSet.getString("name"), resultSet.getString("password"), resultSet.getString("ugroup")));
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
    @Override
    public boolean addUserDB(User user){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        boolean result = true;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection(
                    dbLocation, "SA", "");
            // "jdbc:hsqldb:file:C:/JavaInstallation/HSQLDB/DB", "SA", "");
            //statement = connection.createStatement();
            PreparedStatement pst=connection.prepareStatement("insert into users values(DEFAULT,?,?,?)");
            pst.clearParameters();

            pst.setString(1, user.getName());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getGroup());
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
}
