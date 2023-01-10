package fooba.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.QnaVO;
import fooba.action.Action;
import fooba.dao.QnaDao;

public class admin_qnaUpdateAction implements Action {

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
			qvo.setQseq(Integer.parseInt(request.getParameter("qseq")));
			System.out.println(Integer.parseInt(request.getParameter("qseq")));
			QnaDao qdao=QnaDao.getInstance();
			qdao.updateQna(qvo);
		}
		System.out.println(request.getParameter("qseq"));
		request.getRequestDispatcher(url).forward(request, response);

	}

}
