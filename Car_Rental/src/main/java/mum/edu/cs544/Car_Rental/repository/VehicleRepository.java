package mum.edu.cs544.Car_Rental.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.cs544.Car_Rental.model.Vehicle;

@Repository
public interface VehicleRepository extends  CrudRepository<Vehicle, Long>{

	
	
	

}
