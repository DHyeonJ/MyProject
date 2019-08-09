package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import com.sist.dao.*;


public class UpdateOkModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request) throws Throwable {
		try{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex){}
		// 데이터 받기
		String name = request.getParameter("name");
		String no = request.getParameter("no");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");
		
		BoardVO vo = new BoardVO();
		vo.setContent(content);
		vo.setName(name);
		vo.setSubject(subject);
		vo.setPwd(pwd);
		vo.setNo(Integer.parseInt(no));
		
		boolean bCheck = BoardDAO.boardUpdate(vo);
		
		request.setAttribute("bCheck", bCheck);
		
		if(bCheck==true){
			request.setAttribute("no", no);
		}
		return "board/update_ok.jsp";
	}

}
