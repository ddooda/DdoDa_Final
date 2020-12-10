package com.kh.ddoda.require.service;

import java.util.ArrayList;

import com.kh.ddoda.require.domain.Require;
import com.kh.ddoda.common.Search;
import com.kh.ddoda.common.PageInfo;

public interface RequireService {

	/**
	 * 요구사항 전체 수 조회
	 * @return
	 */
	public int getListCount();
	/**
	 * 요구사항 전체 조회
	 * @param pi
	 * @return
	 */
	public ArrayList<Require> requireList(PageInfo pi);
	/**
	 * 요구사항 상세보기
	 * @param requireNo
	 * @return
	 */
	public Require selectOneRequire(int requireNo);
	/**
	 * 요구사항 삽입
	 * @param require
	 * @return
	 */
	public int insertRequire(Require require);
	/**
	 * 요구사항 삭제
	 * @param requireNo
	 * @return
	 */
	public int deleteRequire(int requireNo);
	/**
	 * 요구사항 수정
	 * @param requireNo
	 * @return
	 */
	public int updateRequire(Require require);
	/**
	 * 요구사항 검색
	 * @param requireNo
	 * @return
	 */
	public ArrayList<Require> selectSearchList(Search search, PageInfo pi);
	/**
	 * 요구사항 상세조회 시 조회수 증가
	 * @param requireNo
	 * @return
	 */
	public int addReadCount (int requireNo);
}


