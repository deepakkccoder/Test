package mum.edu.cs544.Car_Rental.service;

import java.util.List;

import mum.edu.cs544.Car_Rental.model.Category;

public interface CategoryService {
	public List<Category> getAll();
	public Category getCategoryById(Long key);
	public void add(Category category);
	public void delete(Long id);

}
