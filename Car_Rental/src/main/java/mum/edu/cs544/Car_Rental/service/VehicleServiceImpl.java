package mum.edu.cs544.Car_Rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.cs544.Car_Rental.model.Vehicle;
import mum.edu.cs544.Car_Rental.repository.VehicleRepository;

@Service
@Transactional

public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	VehicleRepository vehicleRepository;

	

	@Override
	public Vehicle getVehicleById(Long key) {
		return vehicleRepository.findOne(key);
	}

	
	@Override
	public void delete(Long id) {
		vehicleRepository.delete(id);
		
	}

	
	@Override
	public List<Vehicle> getAll() {
		
		return (List<Vehicle>) vehicleRepository.findAll();
	}


	@Override
	public void addVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		
	}


	


}
