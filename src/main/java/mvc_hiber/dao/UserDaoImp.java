package mvc_hiber.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import mvc_hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private static final String SQL_CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS `testkata`.`users` (" +
            "`id` BIGINT(255) NOT NULL AUTO_INCREMENT, " +
            "`name` VARCHAR(45) NULL , " +
            "`lastName` VARCHAR(45) NULL, " +
            "`age` TINYINT NULL, " +
            "PRIMARY KEY (`id`));";
    private static final String SQL_DROP_USERS_TABLE = "DROP TABLE IF EXISTS testkata.users;";
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void createUsersTable() {
//        Transaction transaction = null;\
//        try (Session session = sessionFactory.openSession()){
//            transaction = session.beginTransaction();
//            session.createNativeQuery(SQL_CREATE_USERS_TABLE).executeUpdate();
//            transaction.commit();
//        }
    }

    @Override
    public void dropUsersTable() {
//        Transaction transaction = null;
//        try (Session session = sessionFactory.openSession()){
//            transaction = session.beginTransaction();
//            session.createNativeQuery(SQL_DROP_USERS_TABLE).executeUpdate();
//            transaction.commit();
//            System.out.println("Table has been deleted.");
//        }
    }

    @Override
    public void saveUser(User user) {
//        entityManagerFactory. .save(user);
    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        EntityTransaction transaction = null;
        List<User> list = new LinkedList<>();
        try (EntityManager entityMan = entityManagerFactory.createEntityManager()){
            transaction = entityMan.getTransaction();
            transaction.begin();
            list = entityMan.createQuery("from User", User.class).getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
//        TypedQuery query = (TypedQuery) sessionFactory.getCurrentSession().createQuery("DELETE User");
    }
}
