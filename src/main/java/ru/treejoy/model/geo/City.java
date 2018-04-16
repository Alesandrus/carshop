package ru.treejoy.model.geo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.treejoy.model.ad.Ad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity representing city.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Entity
@Table(name = "cities")
public class City {
    /**
     * Default constructor.
     */
    public City() {
    }

    /**
     * City ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    /**
     * City name.
     */
    @Column(name = "city", nullable = false)
    private String name;

    /**
     * Country for this city.
     */
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    @JsonIgnore
    private Country country;

    /**
     * Car ads list for this city.
     */
    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Ad> ad = new ArrayList<>();

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
     * Getter for country.
     *
     * @return country.
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Setter for country.
     *
     * @param country .
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * Getter for car ads list.
     *
     * @return car ads.
     */
    public List<Ad> getAd() {
        return ad;
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
        City city = (City) o;
        return Objects.equals(id, city.id)
                && Objects.equals(name, city.name);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
