package dto;

import base.dto.EntityDto;
import entity.Task;

import org.springframework.beans.BeanUtils;

public class TaskDto extends EntityDto{
	//购物项
	private String itemName;
	
	//数量
	private Integer amount;
	
	//描述
	private String detail;
	
	public TaskDto(){}

	public TaskDto(Task t) {
		BeanUtils.copyProperties(t, this);
	}

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
}
