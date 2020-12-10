package com.kh.ddoda.require.domain;

import java.sql.Date;

public class Require {

	private int requireNo;
	private String requireTitle;
	private String requireContents;
	private Date requireDate;
	private Date requireModifyDate;
	private String requireYN;
	private String userId;
	private String originalFilename;
	private String renameFilename;
	private int rCount;
	
	public Require() {}

	public Require(int requireNo, String requireTitle, String requireContents, Date requireDate, Date requireModifyDate,
			String requireYN, String userId, String originalFilename, String renameFilename, int rCount) {
		super();
		this.requireNo = requireNo;
		this.requireTitle = requireTitle;
		this.requireContents = requireContents;
		this.requireDate = requireDate;
		this.requireModifyDate = requireModifyDate;
		this.requireYN = requireYN;
		this.userId = userId;
		this.originalFilename = originalFilename;
		this.renameFilename = renameFilename;
		this.rCount = rCount;
	}

	public int getRequireNo() {
		return requireNo;
	}

	public void setRequireNo(int requireNo) {
		this.requireNo = requireNo;
	}

	public String getRequireTitle() {
		return requireTitle;
	}

	public void setRequireTitle(String requireTitle) {
		this.requireTitle = requireTitle;
	}

	public String getRequireContents() {
		return requireContents;
	}

	public void setRequireContents(String requireContents) {
		this.requireContents = requireContents;
	}

	public Date getRequireDate() {
		return requireDate;
	}

	public void setRequireDate(Date requireDate) {
		this.requireDate = requireDate;
	}

	public Date getRequireModifyDate() {
		return requireModifyDate;
	}

	public void setRequireModifyDate(Date requireModifyDate) {
		this.requireModifyDate = requireModifyDate;
	}

	public String getRequireYN() {
		return requireYN;
	}

	public void setRequireYN(String requireYN) {
		this.requireYN = requireYN;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public String getRenameFilename() {
		return renameFilename;
	}

	public void setRenameFilename(String renameFilename) {
		this.renameFilename = renameFilename;
	}

	public int getrCount() {
		return rCount;
	}

	public void setrCount(int rCount) {
		this.rCount = rCount;
	}

	@Override
	public String toString() {
		return "Require [requireNo=" + requireNo + ", requireTitle=" + requireTitle + ", requireContents="
				+ requireContents + ", requireDate=" + requireDate + ", requireModifyDate=" + requireModifyDate
				+ ", requireYN=" + requireYN + ", userId=" + userId + ", originalFilename=" + originalFilename
				+ ", renameFilename=" + renameFilename + ", rCount=" + rCount + "]";
	}

	
}
