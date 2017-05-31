package cn.itheima.service;

import java.util.List;

import cn.itheima.domain.Customer;

public interface CustomerService {

	List<Customer> findAllCustomer();

	void addCustomer(Customer customer);

	void delCustomer(Integer id2);

}
