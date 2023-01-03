package fooba.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.QnaVO;
import fooba.action.Action;
import fooba.dao.QnaDao;

public class admin_qnaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="fooba.do?command=admin_qnaList";
		HttpSession session=request.getSession();
		String adminId=(String) session.getAttribute("loginAdmin");
		
		if(adminId==null)
			url="fooba.do?command=admin_loginForm";		
		else {
		QnaVO qvo=new QnaVO();
			qvo.setSubject(request.getParameter("subject"));
			qvo.setContent(request.getParameter("content"));
			QnaDao qdao=QnaDao.getInstance();
			qdao.insertQna(qvo);
		}
		
		response.sendRedirect(url);

	}

}
