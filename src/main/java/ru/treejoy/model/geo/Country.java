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

/**
 * Сущность, обозначающая страну.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Entity
@Table(name = "countries")
public class Country {
    /**
     * Конструктор по умолчанию.
     */
    public Country() {
    }

    /**
     * ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    /**
     * Название страны.
     */
    @Column(name = "country", nullable = false)
    private String name;

    /**
     * Список стран.
     */
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<City> cities = new ArrayList<>();

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
     * Сеттер названия страны.
     *
     * @param name .
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер списка городов.
     *
     * @return список городов.
     */
    public List<City> getCities() {
        return cities;
    }

    /**
     * Сеттер списка городов.
     *
     * @param cities .
     */
    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
