package mvc_hiber.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mvc_hiber.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    private static final String HQL_DROP_USERS_TABLE = "TRUNCATE TABLE User";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void dropData() {
        entityManager.createNativeQuery(HQL_DROP_USERS_TABLE).executeUpdate();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    @Transactional
    public void removeUserById(long id) {
        entityManager.createQuery("DELETE from User u where u.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

}
