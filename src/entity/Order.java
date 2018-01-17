package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import base.entity.BaseEntity;

@Entity
@Table(name="t_order")
public class Order extends BaseEntity{
	private static final long serialVersionUID = -5408417035375104241L;

	@Column
	public String code;
	
	@Column
	public String num;
	
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	List<Good>goods = new ArrayList<Good>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Good> getGoods() {
		return goods;
	}

	public void setGoods(List<Good> goods) {
		this.goods = goods;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
}
