package com.kh.ddoda.opendiary.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ddoda.common.PageInfo;
import com.kh.ddoda.common.Search;
import com.kh.ddoda.opendiary.domain.Opendiary;
import com.kh.ddoda.opendiary.domain.OpendiaryComment;
import com.kh.ddoda.opendiary.store.OpendiaryStore;
@Service
public class OpendiaryServiceImpl implements OpendiaryService{

	@Autowired
	private OpendiaryStore odStore;
	
	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return odStore.getListCount();
	}

	@Override
	public ArrayList<Opendiary> odList(PageInfo pi) {
		// TODO Auto-generated method stub
		return odStore.odList(pi);
	}

	@Override
	public Opendiary selectOndOd(int opendiaryNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOd(Opendiary opendiary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOd(Opendiary opendiary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOd(int opendiaryNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertOdCom(OpendiaryComment opendiaryCom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOdCom(OpendiaryComment opendiaryCom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOdCom(int opendiaryNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Opendiary> selectSearchList(Search search) {
		// TODO Auto-generated method stub
		return null;
	}

}
