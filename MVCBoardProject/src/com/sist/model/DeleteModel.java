package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

public class DeleteModel implements Model {

		@Override
		public String handlerRequest(HttpServletRequest request) throws Throwable {
			//������ �ޱ�(�Խù� ��ȣ)
			String no= request.getParameter("no");
			request.setAttribute("no", no);
			return "board/delete.jsp";
		}
	}