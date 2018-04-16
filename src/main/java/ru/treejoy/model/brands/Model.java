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
import java.util.Objects;

/**
 * Entity representing car model.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Entity
@Table(name = "models")
public class Model {
    /**
     * Default constructor.
     */
    public Model() {
    }

    /**
     * Model ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Long id;

    /**
     * Model name.
     */
    @Column(name = "model", nullable = false)
    private String name;

    /**
     * Model brand.
     */
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    /**
     * Car ads list with this brand.
     */
    @OneToMany(mappedBy = "model")
    @JsonIgnore
    private List<CarAd> carAd = new ArrayList<>();

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
     * Getter for brand.
     *
     * @return brand.
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Setter for brand.
     *
     * @param brand .
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * Getter for ads list.
     *
     * @return ads list.
     */
    public List<CarAd> getCarAd() {
        return carAd;
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
        Model model = (Model) o;
        return Objects.equals(id, model.id)
                && Objects.equals(name, model.name);
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
