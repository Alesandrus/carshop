package ru.treejoy.model.ad;

import ru.treejoy.model.User;
import ru.treejoy.model.geo.City;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактный сущность, обозначающая объявление.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Ad implements Serializable {
    /**
     * Конструктор по умолчанию.
     */
    public Ad() {
    }

    /**
     * ID объявления.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * Город размещения объявления.
     */
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    /**
     * Список изображений объявления.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "images")
    @OrderColumn
    @Column(name = "file")
    private List<String> images = new ArrayList<>();

    /**
     * Цена.
     */
    @Column(name = "price", nullable = false)
    private BigInteger price;

    /**
     * Статус продажи (true - если продано).
     */
    @Column(name = "status", nullable = false)
    private boolean status;

    /**
     * Создатель объявления.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User creator;

    /**
     * Описание объявления.
     */
    @Column(name = "description", length = 1500)
    private String description;

    /**
     * Время создания объявления.
     */
    @Column(name = "creation_time")
    @org.hibernate.annotations.CreationTimestamp
    private Timestamp created;

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
     * Геттер города.
     *
     * @return город.
     */
    public City getCity() {
        return city;
    }

    /**
     * Сеттер города.
     *
     * @param city .
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * Геттер цены.
     *
     * @return цену.
     */
    public BigInteger getPrice() {
        return price;
    }

    /**
     * Сеттер цены.
     *
     * @param price .
     */
    public void setPrice(BigInteger price) {
        this.price = price;
    }

    /**
     * Геттер статуса.
     *
     * @return статус.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Сеттер статуса.
     *
     * @param status .
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Геттер создателя.
     *
     * @return создатель.
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Сеттер создателя.
     *
     * @param creator .
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * Геттер описания.
     *
     * @return описание.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Сеттер описания.
     *
     * @param description .
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Геттер списка изображений.
     *
     * @return список изображений.
     */
    public List<String> getImages() {
        return images;
    }

    /**
     * Сеттер списка изображений.
     *
     * @param images .
     */
    public void setImages(List<String> images) {
        this.images = images;
    }

    /**
     * Геттер времени создания.
     *
     * @return время создания.
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * Сеттер времени создания.
     *
     * @param created .
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
