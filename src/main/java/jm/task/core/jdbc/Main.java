package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;


import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {

        Util.getSessionFactory();
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Ivanov", (byte) 20);
        System.out.println("User с именем - Ivan добавлен в базу данных");
        userService.saveUser("Olga", "Titova", (byte) 25);
        List<User> users = userService.getAllUsers();
        System.out.println(users);

//        UserDao userDao = new UserDaoJDBCImpl();
//        userDao.dropUsersTable();
//        userDao.createUsersTable();
//        userDao.saveUser("Alexandra", "Belay", (byte)35);


//        Util.getConnection();
//        UserDao userDao = new UserDaoJDBCImpl();
//        userDao.createUsersTable();
//        userDao.saveUser("Ivan", "Ivanov", (byte) 20);
//        System.out.println("User с именем - Ivan добавлен в базу данных");
//        userDao.saveUser("Olga", "Titova", (byte) 25);
//        System.out.println("User с именем - Olga добавлена в базу данных");
//        userDao.saveUser("Zaur", "Tregulov", (byte) 31);
//        System.out.println("User с именем - Zaur добавлен в базу данных");
//        userDao.saveUser("Alex", "Vlasov", (byte) 38);
//        System.out.println("User с именем - Alex добавлен в базу данных");

        //      System.out.println(userDao.getAllUsers());
//        userDao.cleanUsersTable();
//        userDao.dropUsersTable();


        //  реализуйте алгоритм здесь
    }
}
