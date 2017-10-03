package dto;

import org.springframework.beans.BeanUtils;

import entity.MemberInfo;

public class MemberInfoDto {
	private String Id;
	
	private String name;
	
	private Integer gender;
	
	private String loginName;
	
	public MemberInfoDto(){
	}

	public MemberInfoDto(MemberInfo memberInfo) {
		BeanUtils.copyProperties(memberInfo, this);
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
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
}
