package com.tyss.springmvc1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.springmvc1.beans.EmployeeInfoBean;
import com.tyss.springmvc1.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;
	
	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		if (empId < 1) {
			return null;
		}
		
		return dao.getEmployee(empId);
		
	}// End of getEmployee()

	@Override
	public void saveEmployee(EmployeeInfoBean employeeInfoBean) {
		dao.saveEmployee(employeeInfoBean);
		
	}

	@Override
	public void updateUser(EmployeeInfoBean employeeInfoBean) {
		dao.updateUser(employeeInfoBean);
	}

	@Override
	public void deleteUser(int id) {
		dao.deleteUser(id);
		
	}

	@Override
	public List<EmployeeInfoBean> getAllUser() {
		return dao.getAllUser();
	}
	
	

}// End of class
