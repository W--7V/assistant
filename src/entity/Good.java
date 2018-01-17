package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import base.entity.BaseEntity;

@Entity
@Table(name="t_good")
public class Good extends BaseEntity{
	private static final long serialVersionUID = 7040723401610365290L;

	@Column
	public String name;
	
	@Column
	public String price;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	public Order order;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
