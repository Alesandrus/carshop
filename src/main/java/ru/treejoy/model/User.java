package ru.treejoy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.treejoy.model.ad.Ad;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity representing user.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Entity
@Table(name = "users")
public class User {
    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * User ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    /**
     * Login.
     */
    @Column(name = "login", nullable = false, unique = true)
    @Size(min = 3, max = 20, message = "Длина логина должна быть от 3 до 20 символов")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Логин должен состоять из латинских букв или цифр без пробелов")
    private String login;

    /**
     * Password.
     */
    @Column(name = "password", nullable = false)
    @JsonIgnore
    @Size(min = 6, max = 20, message = "Длина пароля должна быть от 6 до 20 символов")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]+$", message = "Пароль должен состоять из"
            + " латинских букв и цифр без пробелов")
    private String password;

    /**
     * User name.
     */
    @Column(name = "name", nullable = false)
    @Size(min = 3, max = 20, message = "Длина имени должна быть от 3 до 20 символов")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Логин должен состоять из букв без пробелов")
    private String name;

    /**
     * User surname.
     */
    @Column(name = "surname", nullable = false)
    @Size(min = 3, max = 20, message = "Длина фамилии должна быть от 3 до 20 символов")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Логин должен состоять из букв без пробелов")
    private String surname;

    /**
     * Email.
     */
    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotEmpty(message = "Укажите email")
    @Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")"
            + "@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
            message = "Неверный формат")
    private String email;

    /**
     * User list of ads.
     */
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Ad> ads = new ArrayList<>();

    /**
     * Getter for ID.
     *
     * @return ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for ID.
     *
     * @param id .
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for login.
     *
     * @return login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter for login.
     *
     * @param login .
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Getter for password.
     *
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password.
     *
     * @param password .
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for name.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name .
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for surname.
     *
     * @return surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setter for surname.
     *
     * @param surname .
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Getter for email.
     *
     * @return email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email.
     *
     * @param email .
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for ads list.
     *
     * @return ads list.
     */
    public List<Ad> getAds() {
        return ads;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o other object.
     * @return if this object is the same as the obj argument.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id)
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }
}
