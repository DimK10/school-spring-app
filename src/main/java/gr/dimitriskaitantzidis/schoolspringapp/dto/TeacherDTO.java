package gr.dimitriskaitantzidis.schoolspringapp.dto;

import gr.dimitriskaitantzidis.schoolspringapp.model.Teacher;

import java.io.Serial;
import java.io.Serializable;

public class TeacherDTO implements BaseDTO<Teacher>, Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private int id;
	private String fname;
	private String sname;
	
	public TeacherDTO() {}
	
	public TeacherDTO(int id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.sname = lname;
	}

	@Override
	public Teacher toEntity() {
		Teacher teacher = new Teacher();
		teacher.setId(id);
		teacher.setFname(fname);
		teacher.setSname(sname);
		return teacher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
