package ru.sveta.springcourse.Project2Boot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sveta.springcourse.Project2Boot.dao.UserDao;
import ru.sveta.springcourse.Project2Boot.model.User;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void create(User user) { userDao.create(user); }

    @Override
    @Transactional(readOnly = true)
    public User get(long id) { return userDao.get(id); }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() { return userDao.getAll(); }

    @Override
    public void update(long id, User user) { userDao.update(id, user); }

    @Override
    public void delete(long id) {userDao.delete(id); }

    @Override
    public void delete(User user) {userDao.delete(user); }

    @Override
    @Transactional(readOnly = true)
    public List<User> find(User user) {return userDao.find(user); }
}
