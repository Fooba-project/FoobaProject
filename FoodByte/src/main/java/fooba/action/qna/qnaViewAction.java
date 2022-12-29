package fooba.action.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.QnaVO;
import fooba.action.Action;
import fooba.dao.QnaDao;

public class qnaViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="qna/qnaView.jsp";
		int qseq=Integer.parseInt(request.getParameter("qseq"));
		
		//QnaDao에 추가될 메서드 이름 getQna
		HttpSession session=request.getSession();
		
		QnaDao qdao=QnaDao.getInstance();
		QnaVO qvo=qdao.getQna(qseq);
		request.setAttribute("qnaVO", qvo);
		
		request.getRequestDispatcher(url).forward(request,response);


	}

}
