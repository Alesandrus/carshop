package ru.treejoy.model.ad;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.ParamDef;
import ru.treejoy.model.brands.Model;
import ru.treejoy.model.parts.Body;
import ru.treejoy.model.parts.Motor;
import ru.treejoy.model.parts.Transmission;
import ru.treejoy.model.parts.WheelDrive;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Сущность, обозначающая автомобильное объявление.
 *
 * @author Alexander Ivanov
 * @version 1.0
 * @since 11.02.2018
 */
@Entity
@FilterDefs({
        @FilterDef(name = "limitByImage"),
        @FilterDef(name = "limitByBrand", parameters = {@ParamDef(name = "brandID", type = "long")}),
        @FilterDef(name = "limitByModel", parameters = {@ParamDef(name = "modelID", type = "long")}),
        @FilterDef(name = "limitToDay")
})

@Filter(name = "limitByImage", condition = "id IN (SELECT images.ad_id FROM images)")
@Filter(name = "limitByBrand", condition = "model_id IN "
        + "(SELECT models.model_id FROM models WHERE models.brand_id = :brandID)")
@Filter(name = "limitByModel", condition = "model_id = :modelID")
@Filter(name = "limitToDay", condition = "current_date = DATE(creation_time)")
@Table(name = "car_ads")
public class CarAd extends Ad {
    /**
     * Конструктор по умолчанию.
     */
    public CarAd() {
    }

    /**
     * Модель автомобиля.
     */
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    /**
     * Трансмиссия.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "transmission", nullable = false)
    private Transmission transmission;

    /**
     * Двигатель.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "motor", nullable = false)
    private Motor motor;

    /**
     * Кузов.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "body", nullable = false)
    private Body body;

    /**
     * Год производства.
     */
    @Column(name = "year_of_manufacture", nullable = false)
    private int yearOfManufacture;

    /**
     * Пробег.
     */
    @Column(name = "kilometrage", nullable = false)
    private int kilometrage;

    /**
     * Мощность.
     */
    @Column(name = "power", nullable = false)
    private int power;

    /**
     * Привод.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "wheel_drive", nullable = false)
    private WheelDrive wheelDrive;

    /**
     * Геттер модели.
     *
     * @return модель.
     */
    public Model getModel() {
        return model;
    }

    /**
     * Сеттер модели.
     *
     * @param model .
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Геттер трансмиссии.
     *
     * @return трансмиссия.
     */
    public Transmission getTransmission() {
        return transmission;
    }

    /**
     * Сеттер трансмиссии.
     *
     * @param transmission .
     */
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    /**
     * Геттре двигателя.
     *
     * @return двигатель.
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * Сеттре двигателя.
     *
     * @param motor .
     */
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    /**
     * Геттер кузова.
     *
     * @return кузов.
     */
    public Body getBody() {
        return body;
    }

    /**
     * Сеттер кузова.
     *
     * @param body .
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /**
     * Геттер года производства.
     *
     * @return год производства.
     */
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    /**
     * Сеттер года производства.
     *
     * @param yearOfManufacture .
     */
    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    /**
     * Геттер пробега.
     *
     * @return пробег.
     */
    public int getKilometrage() {
        return kilometrage;
    }

    /**
     * Сеттер пробег.
     *
     * @param kilometrage .
     */
    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    /**
     * Геттер привода.
     *
     * @return привод.
     */
    public WheelDrive getWheelDrive() {
        return wheelDrive;
    }

    /**
     * Сеттер привода.
     *
     * @param wheelDrive .
     */
    public void setWheelDrive(WheelDrive wheelDrive) {
        this.wheelDrive = wheelDrive;
    }

    /**
     * Геттер мощности.
     *
     * @return мощность.
     */
    public int getPower() {
        return power;
    }

    /**
     * Сеттер мощности.
     *
     * @param power .
     */
    public void setPower(int power) {
        this.power = power;
    }
}
