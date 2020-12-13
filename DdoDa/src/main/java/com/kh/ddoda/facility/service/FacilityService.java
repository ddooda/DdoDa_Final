package com.kh.ddoda.facility.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.ddoda.facility.domain.ExerciseFacility;
import com.kh.ddoda.facility.domain.FacilityPicture;
import com.kh.ddoda.facility.domain.FacilityPrice;
import com.kh.ddoda.facility.domain.InstructorInfo;
import com.kh.ddoda.facility.domain.MapLocation;

public interface FacilityService {
	
	/**
	 * ��, �� �޾ƿ���(ok)
	 * @return
	 */
	public ArrayList<MapLocation> locationList();
	
	
	
	/**
	 * ���� ����� �ü����
	 * @param userId
	 * @return
	 */
	public ArrayList<ExerciseFacility> FacilityList(String userId);
	
	/**
	 * �ü� �󼼺���(ok)
	 * @param facilityNo
	 * @return
	 */
	public ExerciseFacility facilityInfo(int facilityNo);
	
	/**
	 * �ü��� ���� ��������
	 * @param facilityNo
	 * @return
	 */
	public ArrayList<FacilityPicture> facilityPicture(int facilityNo);
	
	/**
	 * �������� ��������
	 * @param facilityNo
	 * @return
	 */
	public ArrayList<InstructorInfo> instructorInfo(int facilityNo);
	
	/**
	 * �ü��������� ��������
	 * @param facilityNo
	 * @return
	 */
	public ArrayList<FacilityPrice> facilityPriceInfo(int facilityNo);

	
	/**
	 * �� ���� �ü� ���(ok)
	 * @param facilityInfo
	 * @return
	 */
	public ArrayList<ExerciseFacility> markerCountyList(HashMap<String, String> facilityInfo);
	
	public ArrayList<String> markerPoints(HashMap<String, String> facilityInfo);
	
	/**
	 * �ü� ���� ���
	 * @return
	 */
	public int facilityRegistration(ExerciseFacility exerciseFacility);
	
	/**
	 * �ü����� ���
	 * @return
	 */
	public int facilityPictureRegist(HashMap<String, String> facilityHash);
	
	/**
	 * �ü����ݵ��
	 * @return
	 */
	public int facilityPriceRegist(FacilityPrice facilityPrice);
	
	/**
	 * �̿��� �ֱ�
	 * @param termsOfUse
	 * @return
	 */
	public int facilityTerms(String termsOfUse);
	
	/**
	 * �������� ����ϱ�
	 * @return
	 */
	public int instructorRegist(InstructorInfo instructorInfo);
}
