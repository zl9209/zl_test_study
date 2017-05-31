package cn.itheima.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="t_order")
public class Order {
	@Id
	@GenericGenerator(name = "myuuid", strategy = "uuid")
	@GeneratedValue(generator = "myuuid")
	private String orderNum;
	
	private String receiverInfo;
	@Column(precision=23,scale=2)
	private BigDecimal price;

	@ManyToOne(targetEntity=Customer.class)
	@JoinColumn(name="customer_id")
	private Customer customer;

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getReceiverInfo() {
		return receiverInfo;
	}

	public void setReceiverInfo(String receiverInfo) {
		this.receiverInfo = receiverInfo;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
