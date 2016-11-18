package mum.edu.cs544.Car_Rental.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;



import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Category {
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@NotEmpty()
	private String cName;
	@NotEmpty
	private String description;
	/*//@JsonIgnore 
	@Transient
	private MultipartFile  categoryImage;*/
	
	@OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Vehicle> vehicle;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*//@XmlTransient 
	public MultipartFile getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(MultipartFile categoryImage) {
		this.categoryImage = categoryImage;
	}*/
	public List<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
}
