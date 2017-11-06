package dto;

import org.springframework.beans.BeanUtils;

import entity.MemberInfo;

public class MemberInfoDto {
	private String id;
	
	private String name;
	
	private Integer gender;
	
	private String loginName;
	
	private Integer age;
	
	public MemberInfoDto(){
	}

	public MemberInfoDto(MemberInfo memberInfo) {
		BeanUtils.copyProperties(memberInfo, this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
