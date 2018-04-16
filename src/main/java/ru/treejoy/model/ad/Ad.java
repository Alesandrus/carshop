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
import java.util.Objects;

/**
 * Abstract class representing an ad.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Ad implements Serializable {
    /**
     * Private constructor.
     */
    public Ad() {
    }

    /**
     * Ad ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    /**
     * City, where the ad is located.
     */
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    /**
     * Ad's images list.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "images")
    @OrderColumn
    @Column(name = "file")
    private List<String> images = new ArrayList<>();

    /**
     * Price.
     */
    @Column(name = "price", nullable = false)
    private BigInteger price;

    /**
     * Sale status (true - if car is sold).
     */
    @Column(name = "status", nullable = false)
    private boolean status;

    /**
     * Ad creator.
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User creator;

    /**
     * Ad description.
     */
    @Column(name = "description", length = 3000)
    private String description;

    /**
     * Time of ad creation.
     */
    @Column(name = "creation_time")
    @org.hibernate.annotations.CreationTimestamp
    private Timestamp created;

    /**
     * Getter ID.
     *
     * @return ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter ID.
     *
     * @param id .
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for city.
     *
     * @return city.
     */
    public City getCity() {
        return city;
    }

    /**
     * Setter for citty.
     *
     * @param city .
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * Getter for price.
     *
     * @return price.
     */
    public BigInteger getPrice() {
        return price;
    }

    /**
     * Setter for price.
     *
     * @param price .
     */
    public void setPrice(BigInteger price) {
        this.price = price;
    }

    /**
     * Getter for status.
     *
     * @return status.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Setter for status.
     *
     * @param status .
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Getter for creator.
     *
     * @return ad creator.
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Setter for creator.
     *
     * @param creator .
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * Getter for description.
     *
     * @return description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description.
     *
     * @param description .
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for images list.
     *
     * @return images list.
     */
    public List<String> getImages() {
        return images;
    }

    /**
     * Setter for images list.
     *
     * @param images list.
     */
    public void setImages(List<String> images) {
        this.images = images;
    }

    /**
     * Getter for time of ad creation.
     *
     * @return ad creation.
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * Setter for time of ad creation.
     *
     * @param created .
     */
    public void setCreated(Timestamp created) {
        this.created = created;
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
        Ad ad = (Ad) o;
        return Objects.equals(id, ad.id);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
