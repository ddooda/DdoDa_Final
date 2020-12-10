package com.kh.ddoda.opendiary.domain;

public class DiaryImg {

	private int userId;
	private String imgPath;
	private String imgRenamePath;
	private int diaryNo;
	private int OpendiaryNo;
	
	public DiaryImg() {}

	public DiaryImg(int userId, String imgPath, String imgRenamePath, int diaryNo, int opendiaryNo) {
		super();
		this.userId = userId;
		this.imgPath = imgPath;
		this.imgRenamePath = imgRenamePath;
		this.diaryNo = diaryNo;
		OpendiaryNo = opendiaryNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImgRenamePath() {
		return imgRenamePath;
	}

	public void setImgRenamePath(String imgRenamePath) {
		this.imgRenamePath = imgRenamePath;
	}

	public int getDiaryNo() {
		return diaryNo;
	}

	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}

	public int getOpendiaryNo() {
		return OpendiaryNo;
	}

	public void setOpendiaryNo(int opendiaryNo) {
		OpendiaryNo = opendiaryNo;
	}

	@Override
	public String toString() {
		return "DiaryImg [userId=" + userId + ", imgPath=" + imgPath + ", imgRenamePath=" + imgRenamePath + ", diaryNo="
				+ diaryNo + ", OpendiaryNo=" + OpendiaryNo + "]";
	}
	
	
	
}
