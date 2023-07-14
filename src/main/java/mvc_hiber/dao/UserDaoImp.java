package mvc_hiber.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mvc_hiber.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private static final String HQL_CREATE_USERS_TABLE = "CREATE TABLE User";
    private static final String HQL_DROP_USERS_TABLE = "DROP TABLE User";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void dropUsersTable() {
        entityManager.createNativeQuery(HQL_DROP_USERS_TABLE).executeUpdate();
    }

    @Override
    @Transactional
    public void createUsersTable() {
        entityManager.createNativeQuery(HQL_CREATE_USERS_TABLE).executeUpdate();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public void cleanUsersTable() {
//        TypedQuery query = (TypedQuery) sessionFactory.getCurrentSession().createQuery("DELETE User");
    }
}
