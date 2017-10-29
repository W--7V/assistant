package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import base.entity.BaseEntity;

@Entity
@Table(name = "t_member")
public class MemberInfo extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(length = 10)
	private String name;
	
	@Column(length = 10)
	private String loginName;
	
	@Column(length = 1)// ÄÐ£º1    Å®£º0
	private Integer gender;
	
	@Column(length = 3)
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
