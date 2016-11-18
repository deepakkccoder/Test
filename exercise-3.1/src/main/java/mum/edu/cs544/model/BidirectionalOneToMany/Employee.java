package mum.edu.cs544.model.BidirectionalOneToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Long employeeNo;
	private String name;
	@ManyToOne
	@JoinColumn(name="department_Id")
	private Department department;
	@ManyToOne
	@JoinColumn(name="deep")
	private Office office;
	public Long getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
