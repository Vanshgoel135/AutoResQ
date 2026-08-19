package com.autoresq.vehicle.controller;

import com.autoresq.vehicle.Entity.Vehicle;
import com.autoresq.vehicle.Service.VehicleService;
import com.autoresq.vehicle.dto.VehicleRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/addvehicle")
    public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody VehicleRequest request) {

        Vehicle vehicle = vehicleService.addVehicle(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vehicle);
    }
    @GetMapping("/all")
    public Page<Vehicle> getAllVehicles(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "5") int size,

            @RequestParam(defaultValue = "id") String sortBy

    ) {

        return vehicleService.getAllVehicles(page, size, sortBy);

    }
    @GetMapping("/{id}")
    public Vehicle getById(@PathVariable Long id){
        return vehicleService.getById(id);
    }
    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id,@Valid @RequestBody VehicleRequest request){
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
    @GetMapping("/search/owner")
    public List<Vehicle> searchByOwnerName(
            @RequestParam String ownerName) {

        return vehicleService.searchByOwnerName(ownerName);
    }
    @GetMapping("/search/number")
    public Optional<Vehicle> searchByVehicleNumber(
            @RequestParam String vehicleNumber) {

        return vehicleService.searchByVehicleNumber(vehicleNumber);
    }
}
