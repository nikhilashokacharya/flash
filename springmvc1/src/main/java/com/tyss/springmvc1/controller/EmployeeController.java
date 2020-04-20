package com.tyss.springmvc1.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	@PostMapping("/addEmployee")
	private void insertUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String name = request.getParameter("name");
		        String email = request.getParameter("email");
		        LocalDate dateofbirth = LocalDate.parse(request.getParameter("dateofbirth"));
		        LocalDate dateofjoining = LocalDate.parse(request.getParameter("dateofjoining"));
		        int deptID = Integer.parseInt(request.getParameter("deptID"));
		        String designation = request.getParameter("designation");
		        int salary = Integer.parseInt(request.getParameter("salary"));
		        int managerID = Integer.parseInt(request.getParameter("managerID"));
		        long mobileNo = Long.parseLong(request.getParameter("mobileNo"));
		        String password = request.getParameter("password");
		        EmployeeInfoBean newUser = new EmployeeInfoBean(name, email, dateofbirth, dateofjoining, deptID, designation, salary, managerID, mobileNo ,password);
		        service.saveEmployee(newUser);
		        response.sendRedirect("/springmvc1/listEmployee");
		    }
	@GetMapping("/updateEmployeeForm")
	private void updateEmployeeForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        EmployeeInfoBean existingUser = service.getEmployee(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/addEmployee");
		        request.setAttribute("user", existingUser);
		        dispatcher.forward(request, response);

		    }
	
	@PostMapping("/updateEmployee")
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String name = request.getParameter("name");
		        String email = request.getParameter("email");
		        LocalDate dateofbirth = LocalDate.parse(request.getParameter("dateofbirth"));
		        LocalDate dateofjoining = LocalDate.parse(request.getParameter("dateofjoining"));
		        int deptID = Integer.parseInt(request.getParameter("deptID"));
		        String designation = request.getParameter("designation");
		        int salary = Integer.parseInt(request.getParameter("salary"));
		        int managerID = Integer.parseInt(request.getParameter("managerID"));
		        long mobileNo = Long.parseLong(request.getParameter("mobileNo"));
		        String password = request.getParameter("password");

		        EmployeeInfoBean user = new EmployeeInfoBean(name, email, dateofbirth, dateofjoining, deptID, designation, salary, managerID, mobileNo ,password);
		        service.updateUser(user);
		        response.sendRedirect("/springmvc1/listEmployee");
		    }
	
	@GetMapping("/deleteUser")
	 private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        service.deleteUser(id);
			        response.sendRedirect("/springmvc1/listEmployee");
			    }
	

	
}// End of controller
