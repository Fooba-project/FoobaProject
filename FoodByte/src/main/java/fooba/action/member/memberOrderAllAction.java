package fooba.action.mypage;

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

public class orderAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String url = "mypage/orderList.jsp";
	      HttpSession session = request.getSession();
	      String nick = request.getParameter("nick");
	      MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
	      if(mvo == null) {
	         url = "fooba.do?command=loginForm";
	      }else {         
	         OrderDao odao = OrderDao.getInstance();
	         ArrayList<OrderViewVO>list = odao.selectOrdersByNick(nick, ""); // 0 - 배달완료 전
	      
	         request.setAttribute("orderList", list);
	         
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	      
	     
	}

}
