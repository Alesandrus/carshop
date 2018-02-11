package ru.treejoy.model.brands;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.treejoy.model.ad.CarAd;

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

/**
 * Сущность, обозначающая модель автомобиля.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Entity
@Table(name = "models")
public class Model {
    /**
     * Конструктор по умолчанию.
     */
    public Model() {
    }

    /**
     * ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Long id;

    /**
     * Название модели.
     */
    @Column(name = "model", nullable = false)
    private String name;

    /**
     * Бренд модели.
     */
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    /**
     * Список автомобильных объявлений.
     */
    @OneToMany(mappedBy = "model")
    @JsonIgnore
    private List<CarAd> carAd = new ArrayList<>();

    /**
     * Геттер ID.
     * @return ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Сеттер ID.
     * @param id .
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Геттер названия.
     * @return название.
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер названия.
     * @param name .
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер бренда.
     * @return бренд.
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Сеттер бренда.
     * @param brand .
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * Геттер списка объявлений.
     * @return список объявлений.
     */
    public List<CarAd> getCarAd() {
        return carAd;
    }
}
