package com.ats.trailer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
@Entity
@Table(name="TAB_MASTER")
public class TagMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TAG_SEQ")
	private int tagSequence;
	
	@Column(name="TAG_ID")
	private Integer tagId;
	
	@Column(name="VHCLE_REG_NUM")
	private String vehicleRegNum;
	
	@Column(name="VHCLE_TYPE")
	private String vehicleType;
	
	@Column(name="tag_bal")
	private long tagBalance;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TAG_ST_DT")
	private Date tagStartDt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TAB_ED_DT")
	private Date tagEndDt;
	
	@Column(name="PID")
	private int personId;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DT")
	private Date createDt;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED_DT")
	private Date updateDt;
	
	
	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	
	public int getTagSequence() {
		return tagSequence;
	}
	public void setTagSequence(int tagSequence) {
		this.tagSequence = tagSequence;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getVehicleRegNum() {
		return vehicleRegNum;
	}
	public void setVehicleRegNum(String vehicleRegNum) {
		this.vehicleRegNum = vehicleRegNum;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	
	
	public long getTagBalance() {
		return tagBalance;
	}
	public void setTagBalance(long tagBalance) {
		this.tagBalance = tagBalance;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public Date getTagStartDt() {
		return tagStartDt;
	}
	public void setTagStartDt(Date tagStartDt) {
		this.tagStartDt = tagStartDt;
	}
	public Date getTagEndDt() {
		return tagEndDt;
	}
	public void setTagEndDt(Date tagEndDt) {
		this.tagEndDt = tagEndDt;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public Date getCreateDt() {
		return createDt;
	}
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	public Date getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
	

}
