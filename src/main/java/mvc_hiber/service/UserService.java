package mvc_hiber.service;

import mvc_hiber.model.User;

import java.util.List;

public interface UserService {

    void dropUsersTable();

    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();

}
