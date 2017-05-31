package cn.itheima.dao;

import java.util.List;

import cn.itheima.domain.Customer;

public interface CustomerDao {

	List<Customer> findAllCustomer();

	void addCustomer(Customer customer);

	Customer findCustomerById(Integer id);

	void delCustomer(Customer customer);

}
