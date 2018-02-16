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
 * Сущность, обозначающая город.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Entity
@Table(name = "cities")
public class City {
    /**
     * Конструктор по умолчанию.
     */
    public City() {
    }

    /**
     * ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    /**
     * Название города.
     */
    @Column(name = "city", nullable = false)
    private String name;

    /**
     * Страна, в которой расположен город.
     */
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    @JsonIgnore
    private Country country;

    /**
     * Список объявлений, поданных в одном городе.
     */
    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Ad> ad = new ArrayList<>();

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
     * Геттер названия.
     *
     * @return название.
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер названия.
     *
     * @param name .
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер страны.
     *
     * @return страна.
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Сеттер страны.
     *
     * @param country .
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * Геттер списка объявлений.
     *
     * @return список объявлений.
     */
    public List<Ad> getAd() {
        return ad;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
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
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
