package com.tyss.springmvc1.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.springmvc1.beans.EmployeeInfoBean;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = entityManager.find(EmployeeInfoBean.class, empId);
		entityManager.close();
		
		return employeeInfoBean;
		
	}// End of getEmployee()
	
	@Override
	public void saveEmployee(EmployeeInfoBean employeeInfoBean) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(employeeInfoBean);
		entityTransaction.commit();

	}

	@Override
	public void updateUser(EmployeeInfoBean employeeInfoBean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		// save the student object
		Query query = entityManager
				.createQuery("update User set name= '" + employeeInfoBean.getName() + "',email='" + employeeInfoBean.getEmail()
						+ "',dateofbirth='" + employeeInfoBean.getDateofbirth() + "',dateofjoining='" + employeeInfoBean.getDateofjoining()
						+ "',deptID='" + employeeInfoBean.getDeptID() + "',designation='" + employeeInfoBean.getDesignation() + "',salary='"+employeeInfoBean.getSalary()+"',managerID='"+employeeInfoBean.getManagerID()+"',mobileNo='"+employeeInfoBean.getMobileNo()+"',password='"+employeeInfoBean.getPassword()+"' where id="+employeeInfoBean.getId());
		query.executeUpdate();
		// commit transaction
		entityTransaction.commit();

	}

	@Override
	public void deleteUser(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		// Delete a user object
		EmployeeInfoBean employeeInfoBean = entityManager.find(EmployeeInfoBean.class, id);
		if (employeeInfoBean != null) {
			entityManager.remove(employeeInfoBean);
			System.out.println("user is deleted");
		}

		// commit transaction
		entityTransaction.commit();
	}

	@Override	
	@SuppressWarnings("unchecked")
	public List<EmployeeInfoBean> getAllUser() {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		List<EmployeeInfoBean> listOfUser = entityManager.createQuery("from EmployeeInfoBean").getResultList();

		// commit transaction
		entityTransaction.commit();
		return listOfUser;
	}

}// End of class
