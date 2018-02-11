package ru.treejoy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.treejoy.model.ad.Ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Сущность, обозначающая пользователя.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Entity
@Table(name = "users")
public class User {
    /**
     * Конструктор по умолчанию.
     */
    public User() {
    }

    /**
     * ID пользователя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    /**
     * Логин.
     */
    @Column(name = "login", nullable = false, unique = true)
    private String login;

    /**
     * Пароль.
     */
    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;

    /**
     * Имя пользователя.
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Фамилия пользователя.
     */
    @Column(name = "surname", nullable = false)
    private String surname;

    /**
     * Электронная почта.
     */
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * Список объявлений.
     */
    @OneToMany(mappedBy = "creator")
    @JsonIgnore
    private List<Ad> ads = new ArrayList<>();

    /**
     * Геттер ID.
     *
     * @return ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Сеттер ID.
     *
     * @param id .
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Геттер логина.
     *
     * @return логин.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Сеттер логина.
     *
     * @param login .
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Геттер пароля.
     *
     * @return пароль.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Сеттер пароля.
     *
     * @param password .
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Геттер имени.
     *
     * @return имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер имени.
     *
     * @param name .
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер фамилии.
     *
     * @return фамилия.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Сеттер фамилии.
     *
     * @param surname .
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Геттер электроннй почты.
     *
     * @return электронная почта.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Сеттер электронная почта.
     *
     * @param email электронная почта.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Геттер списка объявлений.
     *
     * @return список объявлений.
     */
    public List<Ad> getAds() {
        return ads;
    }
}
