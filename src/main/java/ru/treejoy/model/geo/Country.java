package ru.treejoy.model.geo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity representing country.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Entity
@Table(name = "countries")
public class Country {
    /**
     * Default constructor.
     */
    public Country() {
    }

    /**
     * Country ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    /**
     * Country name.
     */
    @Column(name = "country", nullable = false)
    private String name;

    /**
     * List of cities for this country.
     */
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<City> cities = new ArrayList<>();

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
     * Getter for cities list.
     *
     * @return cities list.
     */
    public List<City> getCities() {
        return cities;
    }

    /**
     * Setter for cities list.
     *
     * @param cities .
     */
    public void setCities(List<City> cities) {
        this.cities = cities;
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
        Country country = (Country) o;
        return Objects.equals(id, country.id)
                && Objects.equals(name, country.name);
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
