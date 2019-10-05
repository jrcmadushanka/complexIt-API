package com.example.travella.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.travella.exception.ResourceNotFoundException;
import com.example.travella.model.Vehicle;
import com.example.travella.repository.VehicleRepository;

@RestController
@RequestMapping("api")
public class VehicleController {

	@Autowired
	VehicleRepository vehicleRepository;
	
	@GetMapping("/vehicles/test")
	public String test() {
	    return "Test pass" ;
	}
	
	@GetMapping("/vehicles")
	public List<Vehicle> getAllVehicles() {
	    return vehicleRepository.findAll();
	}

	@PostMapping("/vehicles")
	public Vehicle createVehicle(@Valid @RequestBody Vehicle vehicle) {
	    return vehicleRepository.save(vehicle);
	}

	@GetMapping("/vehicles/{id}")
	public Vehicle getVehicleById(@PathVariable(value = "id") Long vehicleId) {
	    return vehicleRepository.findById(vehicleId).orElseThrow(() ->
	    new ResourceNotFoundException("Vehicle", "Id", vehicleId));
	}
	
	@PutMapping("/vehicles/{id}")
	public Vehicle updateVehicle(@PathVariable(value = "id") Long vehicleId,
	                                        @Valid @RequestBody Vehicle vehicleDetails) {

	    Vehicle vehicle = vehicleRepository.findById(vehicleId)
	            .orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", vehicleId));

	    vehicle.setNumber(vehicleDetails.getNumber());
	    vehicle.setFacility(vehicleDetails.getFacility());
	    vehicle.setRoutId(vehicleDetails.getRoutId());
	    vehicle.setStatus(vehicleDetails.getStatus());
	    vehicle.setType(vehicleDetails.getType());
	    
	    Vehicle updatedVehicle = vehicleRepository.save(vehicle);
	    return updatedVehicle;
	}
	
	@DeleteMapping("/vehicles/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable(value = "id") Long vehicleId) {
	    Vehicle vehicle = vehicleRepository.findById(vehicleId)
	            .orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id", vehicleId));

	    vehicleRepository.delete(vehicle);

	    return ResponseEntity.ok().build();
	}
	
}
