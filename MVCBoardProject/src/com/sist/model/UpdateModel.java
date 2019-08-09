package com.sist.model;
import javax.servlet.http.HttpServletRequest;
import com.sist.dao.*;
/*
 * 	1. ������ �б� (java) => Model
 * 		������ �ϴ� Ŭ���� �̿�(Servlet) => Controller
 * 	2. ���� ������ ��� (jsp) => View
 * 
 * 	=> java ==> jsp���� (X)
 * 					��> jsp���� java�� �޼ҵ� ȣ���� ���� �����ϴ� (Model1���, MVC���X)
 * 	   java ==> servlet(jsp) ===> jsp
 * 
 * 		=> Model => Controller => View
 * 	=> jsp
 * 		<%
 * 		
 * 		%>
 * 		<html>
 * 		===> ��� �� ���α׷� ==> ������ �б� ===> ���� ������ ���
 */
public class UpdateModel implements Model {

	@Override
	public String handlerRequest(HttpServletRequest request) throws Throwable {
		//������ �ޱ�(�Խù� ��ȣ)
		String no= request.getParameter("no");
		BoardVO vo=BoardDAO.boardUpdateData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		//update.jsp => request.�� �߰��� ���� ����
		return "board/update.jsp";
	}

}
