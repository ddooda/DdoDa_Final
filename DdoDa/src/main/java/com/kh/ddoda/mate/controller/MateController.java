package com.kh.ddoda.mate.controller;

import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kh.ddoda.common.PageInfo;
import com.kh.ddoda.common.Pagination;
import com.kh.ddoda.mate.domain.Mate;
import com.kh.ddoda.mate.domain.MateComment;
import com.kh.ddoda.mate.domain.Mymate;
import com.kh.ddoda.mate.service.MateService;
import com.kh.ddoda.member.domain.Member;

@Controller
public class MateController {

	@Autowired
	private MateService mService;
	
	@RequestMapping(value="mateWriteView.doa", method=RequestMethod.GET)
	public String mateWriteView() {
		return "mate/mateInsertForm";
	}
	
	//모이트 모집 게시판
	@RequestMapping(value="mateList.doa", method=RequestMethod.GET)
	public ModelAndView mateList(ModelAndView mv, @RequestParam(value="page", required=false)Integer page) {
		int currentPage = (page != null) ? page : 1;
		int listCount = mService.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<Mate> mateList = mService.mateList(pi);
		System.out.println(mateList);
		if(!mateList.isEmpty()) {
//			System.out.println(currentPage+", "+listCount);
			mv.addObject("mateList", mateList);
			mv.addObject("pi", pi);
			mv.setViewName("mate/mateList");
		} else {
			mv.addObject("mateList", mateList);
			mv.addObject("pi", pi);
			mv.setViewName("mate/mateList");
		}
		return mv;
	}
	
	
	//메이트모집 글 등록
	@RequestMapping(value="mateInsert.doa", method=RequestMethod.POST)
	public String insertMate(Mate mate, HttpServletRequest request, Model model,
				@RequestParam(value="mateTitle") String mateTitle,
				@RequestParam(value="userId") String userId,
				@RequestParam(value="matePlace") String matePlace,
				@RequestParam(value="detailAddr", required=false) String detailAddr,
				@RequestParam(value="roadAddr", required=false) String roadAddr,
				@RequestParam(value="latLong", required=false) String latLong,
				@RequestParam(value="mateRequireNo", required=false) String mateRequireNo,
				@RequestParam(value="mateContents") String mateContents,
				@RequestParam(value="sido") String sido) {
		int result = 0;
		String path = null;
		result = mService.insertMate(mate);
		if(result>0) {
			path = "redirect:mateList.doa";
		} else {
			model.addAttribute("msg", "공지사항 등록 실패!");
			path = "common/errorPage";
		}
		return path;
	}
	
	//메이트 상세조회
	@RequestMapping(value="mateDetail.doa", method=RequestMethod.GET)
	public ModelAndView mateDetail(ModelAndView mv, int mateNo, Integer page) {
		int currentPage = page != null? page : 1;
		mService.addViewCount(mateNo);
		Mate mate = mService.selectOneMate(mateNo);
		if(mate != null) {
			mv.addObject("mateOne", mate)
				.addObject("currentPage", currentPage)
					.setViewName("mate/mateDetail");
		}else {
			mv.addObject("msg", "게시글 상세조회 실패");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	//메이트 댓글 등록
	@ResponseBody
	@RequestMapping(value="addMateComments.doa", method=RequestMethod.POST)
	public String addMateComments (MateComment mateCom, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		mateCom.setUserId(userId);
		System.out.println(userId);
		int result = mService.insertMateCom(mateCom);
		if(result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	//메이트 댓글 리스트
	@RequestMapping(value="mateComList.doa", method=RequestMethod.GET)
	public void mateComList(HttpServletResponse response, int mateNo) throws Exception {
		ArrayList<MateComment> mateComList = mService.selectMateCom(mateNo);
		for(MateComment mateCom : mateComList) {
			mateCom.setMateComContents(URLEncoder.encode(mateCom.getMateComContents(), "utf-8"));
		}
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(mateComList, response.getWriter());
		System.out.println(mateComList);
	}
	
	//참여
	@ResponseBody
	@RequestMapping(value="addMymate.doa", method=RequestMethod.POST)
	public String addMymate(Mymate mymate, HttpSession session) {
		Member loginUser = (Member)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		mymate.setUserId(userId);
		int result = mService.insertMymate(mymate);
		if(result >0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	//참여 리스트
	@RequestMapping(value="myMateList.doa", method=RequestMethod.GET)
	public void myMateList(HttpServletResponse response, int mateNo) throws Exception {
		ArrayList<Mymate> mymateList = mService.selectMymate(mateNo);
		for (Mymate mym : mymateList) {
			mym.setUserId(URLEncoder.encode(mym.getUserId(), "utf-8"));
		}
		System.out.println(mymateList);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		gson.toJson(mymateList, response.getWriter());
	}

}
