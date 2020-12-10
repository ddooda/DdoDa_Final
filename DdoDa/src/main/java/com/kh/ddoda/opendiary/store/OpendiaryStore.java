package com.kh.ddoda.opendiary.store;

import java.util.ArrayList;

import com.kh.ddoda.common.PageInfo;
import com.kh.ddoda.common.Search;
import com.kh.ddoda.opendiary.domain.Opendiary;
import com.kh.ddoda.opendiary.domain.OpendiaryComment;

public interface OpendiaryStore {


	/**
	 * 공유일기 전체 수 조회
	 * @return
	 */
	public int getListCount();
	/**
	 * 공유일기 전체 조회
	 * @return
	 */
	public ArrayList<Opendiary> odList(PageInfo pi);
	/**
	 * 공유일기 상세보기
	 * @param opendiaryNo
	 * @return
	 */
	public Opendiary selectOndOd(int opendiaryNo);
	/**
	 * 공유일기 등록
	 * @param opendiary
	 * @return
	 */
	public int insertOd(Opendiary opendiary);
	/**
	 * 공유일기 수정
	 * @param opendiary
	 * @return
	 */
	public int updateOd(Opendiary opendiary);
	/**
	 * 공유일기 삭제
	 * @param opendiaryNo
	 * @return
	 */
	public int deleteOd(int opendiaryNo);
	/**
	 * 공유일기 댓글 입력
	 * @param opendiaryCom 
	 * @return
	 */
	public int insertOdCom(OpendiaryComment opendiaryCom);
	/**
	 * 공유일기 댓글 수정
	 * @param opendiaryCom
	 * @return
	 */
	public int updateOdCom(OpendiaryComment opendiaryCom);
	/**
	 * 공유일기 댓글 삭제
	 * @param opendiaryNo
	 * @return
	 */
	public int deleteOdCom(int opendiaryNo);
	/**
	 * 공유일기 검색
	 * @param search
	 * @return
	 */
	public ArrayList<Opendiary> selectSearchList(Search search);
}
