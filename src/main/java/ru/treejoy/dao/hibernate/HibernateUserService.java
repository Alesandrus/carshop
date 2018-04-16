package ru.treejoy.dao.hibernate;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.treejoy.dao.services.UserService;
import ru.treejoy.dao.repositories.UserRepository;
import ru.treejoy.exceptions.CreateEmailException;
import ru.treejoy.exceptions.CreateLoginException;
import ru.treejoy.model.User;

import java.util.List;

/**
 * Implementation of UserService.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 10.04.2018
 */
@Service("userService")
@Repository
@Transactional
public class HibernateUserService implements UserService {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    /**
     * Singleton object.
     */
    private static final HibernateUserService HIBERNATE_USER_SERVICE = new HibernateUserService();

    /**
     * User repository.
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Private constructor.
     */
    private HibernateUserService() {
    }

    /**
     * Getting instance of HibernateUserService.
     *
     * @return HibernateUserService.
     */
    public static HibernateUserService getInstance() {
        return HIBERNATE_USER_SERVICE;
    }

    /**
     * Saves user.
     *
     * @param entity user.
     * @throws CreateLoginException if data base contains same login.
     * @throws CreateEmailException if data base contains same email.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void create(User entity) throws CreateLoginException, CreateEmailException {
        List<User> users = userRepository.findAllByLoginOrEmail(entity.getLogin(), entity.getEmail());
        for (User user : users) {
            if (user.getLogin().equals(entity.getLogin())) {
                throw new CreateLoginException();
            }
            if (user.getEmail().equals(entity.getEmail())) {
                throw new CreateEmailException();
            }
        }
        userRepository.save(entity);
    }

    /**
     * Get all users.
     *
     * @return list of users.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> getAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    /**
     * Get user by ID.
     *
     * @param id user's.
     * @return user.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User getByID(long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Update user.
     *
     * @param entity user.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(User entity) {
        userRepository.save(entity);
    }

    /**
     * Delete user.
     *
     * @param entity user.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    /**
     * Get user by login and password.
     *
     * @param login    login.
     * @param password password.
     * @return user.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User getByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }
}
