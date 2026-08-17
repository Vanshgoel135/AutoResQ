package com.autoresq.vehicle.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Owner name is required")
    private String ownerName;
    @NotBlank(message = "VehicleNumber name is required")
    private String vehicleNumber;
    @NotBlank(message = "Brand is required")
    private String brand;
    private String model;
    @NotBlank(message = "Fuel type is required")
    private String fuelType;
    @NotNull(message = "Manufacturing year is required")
    private Integer manufacturingYear;
    @NotBlank(message = "Color is required")
    private String color;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public void setOwnerName(String ownerName){
        this.ownerName=ownerName;
    }
    public String getVehicleNumber(){
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber){
        this.vehicleNumber=vehicleNumber;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public String getModel(){
        return model;
    }
    public void setModel(String model){
        this.model=model;
    }
    public String getFuelType(){
        return fuelType;
    }
    public void setFuelType(String fuelType){
        this.fuelType=fuelType;
    }
    public Integer getManufacturingYear(){
        return manufacturingYear;
    }
    public void setManufacturingYear(Integer manufacturingYear){
        this.manufacturingYear=manufacturingYear;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color=color;
    }
}
