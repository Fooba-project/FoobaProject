package fooba.action.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.VO.OrderViewVO;
import fooba.action.Action;
import fooba.dao.OrderDao;

public class memberOrderAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String url = "member/memberOrderList.jsp";
	      HttpSession session = request.getSession();
	      MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
	      if(mvo == null) {
	         url = "fooba.do?command=loginForm";
	      }else {
	         OrderDao odao = OrderDao.getInstance();
	         ArrayList<OrderViewVO>list = odao.selectOrdersById(mvo.getId()); 
	         request.setAttribute("memberOrderList", list);
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	}

}
