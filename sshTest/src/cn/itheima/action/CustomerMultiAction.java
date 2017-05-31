package cn.itheima.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.SuccessCallback;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itheima.domain.Customer;
import cn.itheima.service.CustomerService;

@Controller
@Scope("prototype")
@Namespace("/customer")
@ParentPackage("struts-default")
public class CustomerMultiAction extends ActionSupport {
	@Autowired
	private CustomerService customerService;

	private File cusImg;
	private String cusImgFileName;

	private String cusName;
	private String cusPhone;

	@Action(value = "addCutomer", results = {
			@Result(name = "success", location = "findAllCustomer", type = "redirectAction") })
	public String addCutomer() {
		// 处理上传文件
		File destFile = new File(ServletActionContext.getServletContext().getRealPath("/upload"), cusImgFileName);
		try {
			FileUtils.copyFile(cusImg, destFile);// 源:cusImg 目标:destFile
		} catch (IOException e) {
			e.printStackTrace();
		}
		Customer customer = new Customer();
		customer.setCusName(cusName);
		customer.setCusPhone(cusPhone);
		String cusImgsrc = ServletActionContext.getRequest().getContextPath() + "/upload/" + cusImgFileName;
		customer.setCusImgsrc(cusImgsrc);

		customerService.addCustomer(customer);

		return SUCCESS;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public File getCusImg() {
		return cusImg;
	}

	public void setCusImg(File cusImg) {
		this.cusImg = cusImg;
	}

	public String getCusImgFileName() {
		return cusImgFileName;
	}

	public void setCusImgFileName(String cusImgFileName) {
		this.cusImgFileName = cusImgFileName;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusPhone() {
		return cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

}
