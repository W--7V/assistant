package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import base.entity.BaseEntity;

@Entity
@Table(name = "t_Task")
public class Task extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//������
	@Column(length = 50)
	private String itemName;
	
	//����
	@Column(length = 10)
	private Integer amount;
	
	//����
	@Column(length = 100)
	private String detail;
	
	//������
	@ManyToOne(fetch = FetchType.LAZY)
	private MemberInfo memberInfo;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public MemberInfo getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
	}
	
}
