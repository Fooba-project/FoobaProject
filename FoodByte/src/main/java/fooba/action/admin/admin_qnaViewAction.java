package fooba.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.QnaVO;
import fooba.action.Action;
import fooba.dao.QnaDao;

public class admin_qnaViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="admin/admin_qnaView.jsp";
		HttpSession session=request.getSession();
		String avo=(String) session.getAttribute("loginAdmin");
		if(avo==null) {
			url="fooba.do?command=admin";
		}else {
			int qseq=Integer.parseInt(request.getParameter("qseq"));
			System.out.println(qseq);
			QnaDao qdao=QnaDao.getInstance();
			QnaVO qvo=qdao.getQna(qseq);
			request.setAttribute("qnaVO", qvo);
		}
		request.getRequestDispatcher(url).forward(request,response);


	}

}
