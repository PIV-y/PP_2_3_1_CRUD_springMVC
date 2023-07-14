package mvc_hiber.dao;

import mvc_hiber.model.User;

import java.util.List;

public interface UserDao {

    void dropUsersTable();
    void createUsersTable();
    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
