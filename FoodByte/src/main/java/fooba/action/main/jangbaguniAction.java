package fooba.action.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.CartVO;
import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.CartDao;

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
		cvo.setFseq(Integer.parseInt(request.getParameter("fseq")));
		cvo.setId(mvo.getId());		
		cvo.setSideyn1(request.getParameter("fside1"));
		cvo.setSideyn2(request.getParameter("fside2"));
		cvo.setSideyn3(request.getParameter("fside3"));
		cvo.setCprice(Integer.parseInt(request.getParameter("totalprice")));
		cvo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		cvo.setCfname(request.getParameter("fname"));
		
		CartDao cdao=CartDao.getInstance();
		
		cdao.insertCart(cvo);
		
		ArrayList<CartVO>clist=cdao.CartList(mvo.getId());
		
		request.setAttribute("jangresult", "1");
		
		}
		request.setAttribute("rseq", request.getParameter("rseq"));
		
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
