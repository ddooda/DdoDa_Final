package com.kh.ddoda.opendiary.store;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ddoda.common.PageInfo;
import com.kh.ddoda.common.Search;
import com.kh.ddoda.opendiary.domain.Opendiary;
import com.kh.ddoda.opendiary.domain.OpendiaryComment;

@Repository
public class OpendiaryStoreLogic implements OpendiaryStore{

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int getListCount() {
		int count = sqlSession.selectOne("OpendiaryMapper.getListCount");
		return count;
	}

	@Override
	public ArrayList<Opendiary> odList(PageInfo pi) {
		return (ArrayList)sqlSession.selectList("OpendiaryMapper.odList", pi);
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
