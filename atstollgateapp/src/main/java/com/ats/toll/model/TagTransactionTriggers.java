package com.ats.toll.model;

import java.util.Date;

public class TagTransactionTriggers {
	private Integer transactionId;
	
	private Integer tagId;
	
	private String vehicleRegNum;
	
	private Integer tollPlazaId;
	
	private Long tollAmnt;
	
	private String transactionStatus;
	
	private String trFailureReason;
	
	private String trRemainderMsg;

	private Date createDt;

	private Date updateDt;

	private String createdBy;

	private String updatedBy;

	
	public TagTransactionTriggers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public TagTransactionTriggers( Integer tagId, String vehicleRegNum, Integer tollPlazaId,
			Long tollAmnt, String transactionStatus, String trFailureReason, String trRemainderMsg, Date createDt,
			Date updateDt, String createdBy, String updatedBy) {
		super();
		this.tagId = tagId;
		this.vehicleRegNum = vehicleRegNum;
		this.tollPlazaId = tollPlazaId;
		this.tollAmnt = tollAmnt;
		this.transactionStatus = transactionStatus;
		this.trFailureReason = trFailureReason;
		this.trRemainderMsg = trRemainderMsg;
		this.createDt = createDt;
		this.updateDt = updateDt;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}



	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
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

	public Integer getTollPlazaId() {
		return tollPlazaId;
	}

	public void setTollPlazaId(Integer tollPlazaId) {
		this.tollPlazaId = tollPlazaId;
	}

	public Long getTollAmnt() {
		return tollAmnt;
	}

	public void setTollAmnt(Long tollAmnt) {
		this.tollAmnt = tollAmnt;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getTrFailureReason() {
		return trFailureReason;
	}

	public void setTrFailureReason(String trFailureReason) {
		this.trFailureReason = trFailureReason;
	}

	public String getTrRemainderMsg() {
		return trRemainderMsg;
	}

	public void setTrRemainderMsg(String trRemainderMsg) {
		this.trRemainderMsg = trRemainderMsg;
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



	@Override
	public String toString() {
		return "TagTransactionTriggers [transactionId=" + transactionId + ", tagId=" + tagId + ", vehicleRegNum="
				+ vehicleRegNum + ", tollPlazaId=" + tollPlazaId + ", tollAmnt=" + tollAmnt + ", transactionStatus="
				+ transactionStatus + ", trFailureReason=" + trFailureReason + ", trRemainderMsg=" + trRemainderMsg
				+ ", createDt=" + createDt + ", updateDt=" + updateDt + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + "]";
	}


}
