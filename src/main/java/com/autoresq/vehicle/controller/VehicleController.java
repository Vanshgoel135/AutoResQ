package com.autoresq.vehicle.controller;

import com.autoresq.vehicle.Entity.Vehicle;
import com.autoresq.vehicle.Service.VehicleService;
import com.autoresq.vehicle.dto.VehicleRequest;

import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/addvehicle")
    public Vehicle addVehicle(@RequestBody VehicleRequest request) {

        return vehicleService.addVehicle(request);

    }
    @GetMapping("/{allVehicle}")
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }
    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id){
        return vehicleService.getById(id);
    }
    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id,@RequestBody VehicleRequest request){
        return vehicleService.updateVehicle(id,request);
    }
    @DeleteMapping("/{id}")
    public String deletedVehicle(@PathVariable Long id) {

        Vehicle vehicle = vehicleService.deletedVehicle(id);

        if (vehicle == null) {
            return "Vehicle Not Found";
        }

        return "Vehicle Deleted Successfully";
    }
}
