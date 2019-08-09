package com.sist.model;

import javax.servlet.http.HttpServletRequest;
/*
 *      요청 =====> DispatcherServlet =====> Model  =====> DispatcherServlet ====> jsp
 *                                  MVC동작 
 */
import java.util.*;
import com.sist.dao.*;
public class ListModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request) throws Throwable {
		// TODO Auto-generated method stub
		// 목록받기 
		// 페이지 받기
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=10;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		
		// map에 저장 
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<BoardVO> list=BoardDAO.boardListData(map);
		// list.jsp 전송 
		request.setAttribute("list", list);
		return "board/list.jsp";
	}

}









