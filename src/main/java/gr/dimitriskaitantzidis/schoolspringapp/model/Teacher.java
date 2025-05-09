package gr.dimitriskaitantzidis.schoolspringapp.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Teacher POJO class. 
 *
 *
 */
@Entity
@Table(name = "teachers")
@NamedQueries({
		@NamedQuery(name = "Teacher.findAllRelatedCourses"
				, query = "select t" +
				" from Teacher t" +
				" left join fetch t.courses " +
				"where t.id = :teacherId")
})
public class Teacher extends BaseEntity {


	@Column(name = "Firstname")
	private String fname;

	@Column(name = "Surname")
	private String sname;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "courses_teachers",
			joinColumns = @JoinColumn(name = "T_id"),
			inverseJoinColumns = @JoinColumn(name = "C_id"))
	private List<Course> courses;


	public Teacher() {}
	
	public Teacher(int id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.sname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return id + "\t" + fname + "\t" + sname;
	}
}
