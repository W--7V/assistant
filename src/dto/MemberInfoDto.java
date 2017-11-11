package dto;

import org.springframework.beans.BeanUtils;

import base.dto.EntityDto;
import entity.MemberInfo;

public class MemberInfoDto extends EntityDto{
	
	private String name;
	
	private Integer gender;
	
	private String genderName;
	
	private String loginName;
	
	private Integer age;
	
	public MemberInfoDto(){
	}

	public MemberInfoDto(MemberInfo memberInfo) {
		BeanUtils.copyProperties(memberInfo, this);
		if(memberInfo.getGender() == 0){
			this.setGenderName("ÄÐ");
		}else{
			this.setGenderName("Å®");
		}
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

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

}
