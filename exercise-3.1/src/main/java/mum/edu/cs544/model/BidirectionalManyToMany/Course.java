package mum.edu.cs544.model.BidirectionalManyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private Long courseId;
	private String CourseNo;
	private String Name;
	
	@ManyToMany(mappedBy="courseList")
	private List<Student> students = new ArrayList<Student>();

	public Long getId() {
		return courseId;
	}

	public void setId(Long id) {
		this.courseId = id;
	}

	public String getCourseNo() {
		return CourseNo;
	}

	public void setCourseNo(String courseNo) {
		CourseNo = courseNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	
}
