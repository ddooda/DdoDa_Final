package com.kh.ddoda.opendiary.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ddoda.common.PageInfo;
import com.kh.ddoda.common.Pagination;
import com.kh.ddoda.member.domain.Member;
import com.kh.ddoda.opendiary.domain.Opendiary;
import com.kh.ddoda.opendiary.service.OpendiaryService;

@Controller
public class OpendiaryController {

	@Autowired
	private OpendiaryService odService;
	
	//공유일기 전체리스트 조회 
	@RequestMapping("opendiaryList.doa")
	public ModelAndView openList(ModelAndView mv, @RequestParam(value="page", required=false)Integer page) {
		int currentPage = (page != null) ? page: 1;
		int listCount = odService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<Opendiary> opendiaryList = odService.odList(pi);
		if( !opendiaryList.isEmpty()) {
			mv.addObject("opendiaryList", opendiaryList);
			mv.addObject("pi", pi);
			mv.setViewName("opendiary/opendiaryList");
		} else {
			mv.addObject("opendiaryList", opendiaryList);
			mv.addObject("pi", pi);
//			System.out.println(mv.toString());
			mv.setViewName("opendiary/opendiaryList");
		}
		return mv;
	}
	
	//공유일기 작성폼 
	@RequestMapping(value="openInsertView.doa", method=RequestMethod.GET)
	public String openWriteView() {
		return "opendiary/openInsertForm";
	}
}
