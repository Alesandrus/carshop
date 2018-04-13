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
 * Класс DAO для CRUD операций с пользователем в базе данных.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 30.01.2018
 */
@Service("userService")
@Repository
@Transactional
public class HibernateUserService implements UserService {
    /**
     * Логгер.
     */
    private static final Logger LOGGER = LogManager.getLogger(Logger.class.getName());

    private static final HibernateUserService HIBERNATE_USER_SERVICE = new HibernateUserService();

    @Autowired
    private UserRepository userRepository;

    private HibernateUserService() {
    }

    public static HibernateUserService getInstance() {
        return HIBERNATE_USER_SERVICE;
    }
    /**
     * Создание пользователя в базе данных.
     *
     * @param entity пользователь.
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
     * Получение всех пользователей из базы данных.
     *
     * @return список пользователей.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> getAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    /**
     * Получение пользователя из базы данных по ID.
     *
     * @param id пользователя.
     * @return пользователя.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User getByID(long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Обновить пользователя в базе данных.
     *
     * @param entity пользователь.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(User entity) {
        userRepository.save(entity);
    }

    /**
     * Удалить пользователя из базы данных. Скорее всего каскадно не удалит.
     *
     * @param entity пользователь.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    /**
     * Получение пользователя по логину и паролю.
     *
     * @param login    логин.
     * @param password пароль.
     * @return пользователя.
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User getByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }
}
