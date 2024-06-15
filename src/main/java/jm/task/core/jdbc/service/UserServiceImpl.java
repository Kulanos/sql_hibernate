package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return this.userDao = new UserDaoHibernateImpl();
    }



    public void createUsersTable() {
       getUserDao().createUsersTable();

    }

    public void dropUsersTable() {
       getUserDao().dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) {
        getUserDao().saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {

       return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
       userDao.cleanUsersTable();

    }

}
