package base.dto;

import java.io.Serializable;

public class EntityDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Integer version;
	private String creater;
	private String regenerator;
	private String deletor;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getRegenerator() {
		return regenerator;
	}
	public void setRegenerator(String regenerator) {
		this.regenerator = regenerator;
	}
	public String getDeletor() {
		return deletor;
	}
	public void setDeletor(String deletor) {
		this.deletor = deletor;
	}
	

}
