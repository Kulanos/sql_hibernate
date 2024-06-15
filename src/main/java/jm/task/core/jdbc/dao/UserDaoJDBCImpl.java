package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {


    public UserDaoJDBCImpl() {


    }

    public void createUsersTable() {
        try (Connection connection = Util.getConnection();) {

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS `BD_test`.`users` (\n" +
                            "  `id` BIGINT(200) NOT NULL AUTO_INCREMENT,\n" +
                            "  `name` VARCHAR(45) NOT NULL,\n" +
                            "  `lastName` VARCHAR(45) NOT NULL,\n" +
                            "  `age` TINYINT(3) NOT NULL,\n" +
                            "  PRIMARY KEY (`id`));");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void dropUsersTable() {
        try (Connection connection = Util.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("DROP TABLE IF EXISTS `BD_test`.`users`");
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {

        try (Connection connection = Util.getConnection()) {
            String insertUserSQL = "INSERT INTO  users (name, lastName, age) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void removeUserById(long id) {
        try (Connection connection = Util.getConnection()) {
            User user = new User();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `users` WHERE `id` = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection connection = Util.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                byte age = resultSet.getByte("age");
                users.add(new User(name, lastName, age));
            }
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;


    }

    public void cleanUsersTable() {
        try (Connection connection = Util.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `users`");
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
