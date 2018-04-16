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
 * Entity representing car ad.
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
     * Default constructor.
     */
    public CarAd() {
    }

    /**
     * Car model.
     */
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    /**
     * Transmission type.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "transmission", nullable = false)
    private Transmission transmission;

    /**
     * Motor type.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "motor", nullable = false)
    private Motor motor;

    /**
     * Body type.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "body", nullable = false)
    private Body body;

    /**
     * Year of manufacture..
     */
    @Column(name = "year_of_manufacture", nullable = false)
    private int yearOfManufacture;

    /**
     * Car mileage.
     */
    @Column(name = "kilometrage", nullable = false)
    private int kilometrage;

    /**
     * Power.
     */
    @Column(name = "power", nullable = false)
    private int power;

    /**
     * Wheel drive.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "wheel_drive", nullable = false)
    private WheelDrive wheelDrive;

    /**
     * Getter for model.
     *
     * @return model.
     */
    public Model getModel() {
        return model;
    }

    /**
     * Setter for model.
     *
     * @param model .
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Getter for transmission.
     *
     * @return transmission.
     */
    public Transmission getTransmission() {
        return transmission;
    }

    /**
     * Setter for transmission.
     *
     * @param transmission .
     */
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    /**
     * Getter for motor.
     *
     * @return motor.
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * Setter for motor.
     *
     * @param motor .
     */
    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    /**
     * Getter for body.
     *
     * @return body.
     */
    public Body getBody() {
        return body;
    }

    /**
     * Setter for body.
     *
     * @param body .
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /**
     * Getter for year of manufacture.
     *
     * @return year of manufacture.
     */
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    /**
     * Setter for year of manufacture.
     *
     * @param yearOfManufacture .
     */
    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    /**
     * Getter for mileage.
     *
     * @return mileage in kilometers.
     */
    public int getKilometrage() {
        return kilometrage;
    }

    /**
     * Setter for mileage.
     *
     * @param kilometrage .
     */
    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    /**
     * Getter for wheel drive.
     *
     * @return wheel drive.
     */
    public WheelDrive getWheelDrive() {
        return wheelDrive;
    }

    /**
     * Setter for wheel drive.
     *
     * @param wheelDrive .
     */
    public void setWheelDrive(WheelDrive wheelDrive) {
        this.wheelDrive = wheelDrive;
    }

    /**
     * Getter for power.
     *
     * @return power.
     */
    public int getPower() {
        return power;
    }

    /**
     * Setter for power.
     *
     * @param power .
     */
    public void setPower(int power) {
        this.power = power;
    }
}
