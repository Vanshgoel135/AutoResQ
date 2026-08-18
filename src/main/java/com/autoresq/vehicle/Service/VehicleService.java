package com.autoresq.vehicle.Service;

import com.autoresq.vehicle.Entity.Vehicle;
import com.autoresq.vehicle.dto.VehicleRequest;
import com.autoresq.vehicle.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle addVehicle(VehicleRequest request) {

        Vehicle vehicle = new Vehicle();

        vehicle.setOwnerName(request.getOwnerName());
        vehicle.setVehicleNumber(request.getVehicleNumber());
        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setFuelType(request.getFuelType());
        vehicle.setManufacturingYear(request.getManufacturingYear());
        vehicle.setColor(request.getColor());

        return vehicleRepository.save(vehicle);
    }
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
    public Vehicle getById(Long id){
        return vehicleRepository.findById(id).orElse(null);
    }
    public Vehicle updateVehicle(Long id,VehicleRequest request){
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
        if(vehicle==null){
            return null;
        }
        vehicle.setOwnerName(request.getOwnerName());
        vehicle.setVehicleNumber(request.getVehicleNumber());
        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setFuelType(request.getFuelType());
        vehicle.setManufacturingYear(request.getManufacturingYear());
        vehicle.setColor(request.getColor());
        return vehicleRepository.save(vehicle);
    }
    public Vehicle deletedVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);

        if (vehicle == null) {
            return null;
        }

        vehicleRepository.delete(vehicle);
        return vehicle;
    }
}