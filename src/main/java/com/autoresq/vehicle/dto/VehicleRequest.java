package com.autoresq.vehicle.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public class VehicleRequest {
    @NotBlank(message = "Owner name is required")
    private String ownerName;
    @NotBlank(message = "Vehicle number is required")
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


