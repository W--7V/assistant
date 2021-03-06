package base.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;

@MappedSuperclass
public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8651807699824571800L;
	
	@Id
	@Column(length = 32)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Version
	protected Integer version;

	@Column
	Boolean isDeleted = Boolean.valueOf(false);

	@Column
	@IndexColumn(name="index_createTime")
	private Date createTime;

	@Column
	private Date updateTime;

	@Column
	private Date deleteTime;

	@Column(length = 32)
	private String creater;

	@Column(length = 32)
	private String regenerator;
	
	@Column(length = 32)
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
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
