package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import com.sist.dao.*;
public class FindModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request) throws Throwable {
		try{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		
		
		String fs=request.getParameter("fs");
		String ss=request.getParameter("ss");
		//WHERE ${fs} LIKE '%'||#{ss}||'%'
		Map map = new HashMap();
		map.put("fs", fs);
		map.put("ss", ss);
		List<BoardVO> list = BoardDAO.boardFindData(map);
		
		request.setAttribute("list", list);
		request.setAttribute("count", list.size());
		return "board/find.jsp";
	}

}
