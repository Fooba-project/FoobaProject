package fooba.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.CartVO;
import fooba.VO.MemberVO;
import fooba.action.Action;

public class jangbaguniAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("loginUser");
		String url="";
		if(mvo==null) {
			url="fooba.do?command=miniLoginForm";
			request.setAttribute("fseq", request.getParameter("fseq"));
		}else {
		
		
		url="main/popupMenu.jsp";
		
		
		
		CartVO cvo=new CartVO();
		request.setAttribute("jangresult", "1");
		
		
		}
		request.setAttribute("rseq", request.getParameter("rseq"));
		
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
