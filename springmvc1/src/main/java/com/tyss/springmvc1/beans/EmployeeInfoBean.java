package com.tyss.springmvc1.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "employee1")
public class EmployeeInfoBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
    private int id;  
	@Column
    private String name;  
	@Column
	private String email; 
	@Column
	private LocalDate dateofbirth;
	@Column
	private LocalDate dateofjoining;
	@Column
	private int deptID;
	@Column
	private String designation;
	@Column
	private int salary;
	@Column
	private int managerID;
	@Column
	private long mobileNo;
	@Column
	private String password;
	
	public EmployeeInfoBean(){}
	
	public EmployeeInfoBean(int id) {
		this.id=id;
		
	
	}

	public EmployeeInfoBean(String name, String email, LocalDate dateofbirth, LocalDate dateofjoining, int deptID,
			String designation, int salary, int managerID, long mobileNo, String password) {
		super();
		this.name = name;
		this.email = email;
		this.dateofbirth = dateofbirth;
		this.dateofjoining = dateofjoining;
		this.deptID = deptID;
		this.designation = designation;
		this.salary = salary;
		this.managerID = managerID;
		this.mobileNo = mobileNo;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public LocalDate getDateofjoining() {
		return dateofjoining;
	}

	public void setDateofjoining(LocalDate dateofjoining) {
		this.dateofjoining = dateofjoining;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
