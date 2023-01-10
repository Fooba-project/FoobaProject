package fooba.action.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.CartVO;
import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.CartDao;

public class orderFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="main/menuorder.jsp";
		HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			url="fooba.do?command=loginForm";
			request.setAttribute("message", "로그인이 필요한 서비스입니다.");
		}else {
			int rseq=Integer.parseInt(request.getParameter("rseq"));
			CartDao cdao=CartDao.getInstance();
			ArrayList<CartVO>clist=cdao.CartList(mvo.getId(),rseq);
			
			System.out.print(request.getParameter("rtip"));
			int carttotalprice=Integer.parseInt(request.getParameter("carttotalprice"));
			request.setAttribute("rtip", request.getParameter("rtip"));
			request.setAttribute("rseq", rseq);
			request.setAttribute("clist", clist);
			request.setAttribute("carttotalprice", carttotalprice);
			request.setAttribute("mvo", mvo);
		}
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
