package ru.sveta.springcourse.Project2Boot.dao;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import ru.sveta.springcourse.Project2Boot.model.User;

import java.util.List;


@Repository
public class UserDaoHibernateImpl implements UserDao {
    private final EntityManager entityManager;

    public UserDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(User user) {
        entityManager.joinTransaction();
        entityManager.persist(user);
    }

    @Override
    public User get(long id) {
        return entityManager.createQuery("from User where id=:id", User.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    public List<User> getAll() {

        return entityManager.createQuery("FROM User user", User.class)
                .getResultList();
    }

    @Override
    public void update(long id, User user) {
        entityManager.joinTransaction();
        User someUser = get(id);
        someUser.setName(user.getName());
        someUser.setSurname(user.getSurname());
        someUser.setEmail(user.getEmail());
        entityManager.persist(someUser);

    }

    @Override
    public void delete(long id) {
        entityManager.joinTransaction();
        try {
            entityManager.remove(get(id));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    @Override
    public void delete(User user) {
        entityManager.joinTransaction();
        find(user).forEach(someUser -> entityManager.remove(someUser.getId()));

    }

    @Override
    public List<User> find(User user) {
        return entityManager.createQuery("from User where name=:n and surname=:s and email=:e", User.class)
                .setParameter("n", user.getName())
                .setParameter("s", user.getSurname())
                .setParameter("e", user.getEmail())
                .getResultList();
    }

}
