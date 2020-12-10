package com.kh.ddoda.require.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ddoda.common.PageInfo;
import com.kh.ddoda.common.Search;
import com.kh.ddoda.require.domain.Require;
import com.kh.ddoda.require.store.RequireStore;

@Service
public class RequireServiceImpl implements RequireService{

	@Autowired
	private RequireStore rStore;

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return rStore.getListCount();
	}

	@Override
	public ArrayList<Require> requireList(PageInfo pi) {
		// TODO Auto-generated method stub
		return rStore.requireList(pi);
	}

	@Override
	public Require selectOneRequire(int requireNo) {
		// TODO Auto-generated method stub
		return rStore.selectOneRequire(requireNo);
	}

	@Override
	public int insertRequire(Require require) {
		// TODO Auto-generated method stub
		return rStore.insertRequire(require);
	}

	@Override
	public int deleteRequire(int requireNo) {
		// TODO Auto-generated method stub
		return rStore.deleteRequire(requireNo);
	}

	@Override
	public int updateRequire(Require require) {
		// TODO Auto-generated method stub
		return rStore.updateRequire(require);
	}

	@Override
	public ArrayList<Require> selectSearchList(Search search, PageInfo pi) {
		// TODO Auto-generated method stub
		return rStore.selectSearchList(search, pi);
	}

	@Override
	public int addReadCount(int requireNo) {
		// TODO Auto-generated method stub
		return rStore.addReadCount(requireNo);
	}

}
