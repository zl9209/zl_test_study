package cn.itheima.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itheima.domain.Customer;
import cn.itheima.service.CustomerService;
@Controller
@Scope("prototype")
@Namespace("/customer")
@ParentPackage("struts-default")
public class CustomerAction extends ActionSupport  implements ModelDriven<Customer> {
	@Autowired
	private CustomerService customerService;
	
	private Customer customer = new Customer();
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	

	
	
	@Action(value="findAllCustomer",results={@Result(name="success",location="/jsp/customerList.jsp")})
	public String findAllCustomer(){
		
		List<Customer> cs = customerService.findAllCustomer();
		
		//将cs存储到valueStack中  手动
		ActionContext.getContext().getValueStack().set("cs", cs);
		return SUCCESS;
	}

								
	@Action(value="delCustomer",results={@Result(name="success",location="findAllCustomer",type="redirectAction")})
	public String delCustomer(){
		String id = ServletActionContext.getRequest().getParameter("delCustomerId");
		
		Integer id2 = Integer.parseInt(id);
		customerService.delCustomer(id2);
		return SUCCESS;
	}
}







