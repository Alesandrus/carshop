package ru.treejoy.model.ad;

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

@Entity
@Table(name = "car_ads")
public class CarAd extends Ad {
    public CarAd() {
    }

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @Enumerated(EnumType.STRING)
    @Column(name = "transmission", nullable = false)
    private Transmission transmission;

    @Enumerated(EnumType.STRING)
    @Column(name = "motor", nullable = false)
    private Motor motor;

    @Enumerated(EnumType.STRING)
    @Column(name = "body", nullable = false)
    private Body body;

    @Column(name = "year_of_manufacture", nullable = false)
    private int yearOfManufacture;

    @Column(name = "kilometrage", nullable = false)
    private int kilometrage;

    @Column(name = "power", nullable = false)
    private int power;

    @Enumerated(EnumType.STRING)
    @Column(name = "wheel_drive", nullable = false)
    private WheelDrive wheelDrive;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public WheelDrive getWheelDrive() {
        return wheelDrive;
    }

    public void setWheelDrive(WheelDrive wheelDrive) {
        this.wheelDrive = wheelDrive;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
