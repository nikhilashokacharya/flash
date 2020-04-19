package com.tyss.springmvc1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tyss.springmvc1.beans.EmployeeInfoBean;
import com.tyss.springmvc1.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/getEmployeeForm")
	public String getSearchEmployeeForm() {
		
		return "searchEmp";
	}// End of getSearchEmployeeForm()
	
	@GetMapping("/getEmployee")
	public String getEmployee(int id, ModelMap modelMap) {
		EmployeeInfoBean employeeInfoBean = service.getEmployee(id);
		
		if (employeeInfoBean != null) {
			modelMap.addAttribute("employee1", employeeInfoBean);
		} else {
			modelMap.addAttribute("errMsg", "Employee Id " + id + " Not Found!");
		}
		
		return "searchEmp";
	}
	@GetMapping("/listEmployee")
	public String listEmployee(ModelMap modelMap) {
		List<EmployeeInfoBean> employeeInfoBean = service.getAllUser();
		modelMap.addAttribute("listUser",employeeInfoBean);
		return "user-list";
		
	}
	
	@GetMapping("/addEmployeeForm")
	public String addEmployeeForm() {
		return "user-form";
	}
	@GetMapping("/addEmployee")
	public String addEmployee(EmployeeInfoBean employeeInfoBean,ModelMap modelMap) {
		service.saveEmployee(employeeInfoBean);
		modelMap.addAttribute("listUser",employeeInfoBean);
		return "user-list";
		
	}
	
	
	
}// End of controller
