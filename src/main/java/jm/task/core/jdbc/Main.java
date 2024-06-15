package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;


import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        Util.getSessionFactory();
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.dropUsersTable();
        userDao.createUsersTable();
        userDao.saveUser("Alexandra", "Belay", (byte)35);




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
