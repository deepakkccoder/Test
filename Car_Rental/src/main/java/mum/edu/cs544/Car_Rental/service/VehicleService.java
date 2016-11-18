package mum.edu.cs544.Car_Rental.service;

import java.util.List;

import mum.edu.cs544.Car_Rental.model.Vehicle;

public interface VehicleService {
	public List <Vehicle> getAll();
	public Vehicle getVehicleById(Long key);
	public void delete(Long id);
	public void addVehicle(Vehicle product);
	
	


}
