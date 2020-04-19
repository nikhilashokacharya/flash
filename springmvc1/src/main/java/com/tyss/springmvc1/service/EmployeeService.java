package com.tyss.springmvc1.service;

import java.util.List;

import com.tyss.springmvc1.beans.EmployeeInfoBean;

public interface EmployeeService {

	public EmployeeInfoBean getEmployee(int empId);

	public void saveEmployee(EmployeeInfoBean employeeInfoBean);

	public void updateUser(EmployeeInfoBean employeeInfoBean);

	public void deleteUser(int id);

	public List<EmployeeInfoBean> getAllUser();
}
