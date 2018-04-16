package ru.treejoy.model.brands;

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
 * Entity representing car brand.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Entity
@Table(name = "brands")
public class Brand {
    /**
     * Default constructor.
     */
    public Brand() {
    }

    /**
     * Brand Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;

    /**
     * Brand name.
     */
    @Column(name = "brand", nullable = false)
    private String name;

    /**
     * Model list for brand.
     */
    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Model> models = new ArrayList<>();

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
     * @return brand name.
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
     * Getter for models list.
     *
     * @return models list.
     */
    public List<Model> getModels() {
        return models;
    }

    /**
     * Setter for models list.
     *
     * @param models .
     */
    public void setModels(List<Model> models) {
        this.models = models;
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
        Brand brand = (Brand) o;
        return Objects.equals(id, brand.id)
                && Objects.equals(name, brand.name);
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
