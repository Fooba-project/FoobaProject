package fooba.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.CartDao;

public class deleteCartmenuAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("loginUser");
		String url="";
		if(mvo==null)  url="fooba.do?command=loginForm";
		else {
		
		int cseq=Integer.parseInt(request.getParameter("cseq"));
		
		CartDao cdao=CartDao.getInstance();
		int rseq=cdao.deletecart(cseq);
		rseq=Integer.parseInt(request.getParameter("rseq"));
		url="fooba.do?command=restaurantDetail&rseq="+rseq;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
