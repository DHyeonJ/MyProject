package com.sist.model;
import javax.servlet.http.HttpServletRequest;
import com.sist.dao.*;
/*
 * 	1. 데이터 읽기 (java) => Model
 * 		전송을 하는 클래스 이용(Servlet) => Controller
 * 	2. 읽은 데이터 출력 (jsp) => View
 * 
 * 	=> java ==> jsp전송 (X)
 * 					ㄴ> jsp에서 java의 메소드 호출일 경우는 가능하다 (Model1방식, MVC방식X)
 * 	   java ==> servlet(jsp) ===> jsp
 * 
 * 		=> Model => Controller => View
 * 	=> jsp
 * 		<%
 * 		
 * 		%>
 * 		<html>
 * 		===> 모든 웹 프로그램 ==> 데이터 읽기 ===> 읽은 데이터 출력
 */
public class UpdateModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request) throws Throwable {
		//데이터 받기(게시물 번호)
		String no= request.getParameter("no");
		BoardVO vo=BoardDAO.boardUpdateData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		//update.jsp => request.의 추가된 값을 전송
		return "board/update.jsp";
	}

}
