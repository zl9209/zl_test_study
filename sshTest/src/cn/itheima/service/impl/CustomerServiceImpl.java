package cn.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itheima.dao.CustomerDao;
import cn.itheima.domain.Customer;
import cn.itheima.service.CustomerService;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public List<Customer> findAllCustomer() {
		return customerDao.findAllCustomer();
	}
	
	public Customer findCustomerById(Integer id) {
		return customerDao.findCustomerById(id);
	}


	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	public void delCustomer(Integer id) {
		
		Customer customer = findCustomerById(id);
		customerDao.delCustomer(customer);
	}
}
