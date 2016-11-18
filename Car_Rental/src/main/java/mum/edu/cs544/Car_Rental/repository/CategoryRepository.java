package mum.edu.cs544.Car_Rental.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.cs544.Car_Rental.model.Category;


@Repository
public interface CategoryRepository extends  CrudRepository<Category, Long>{
		
}
