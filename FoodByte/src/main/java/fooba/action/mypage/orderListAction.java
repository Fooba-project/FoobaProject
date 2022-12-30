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

public class orderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 유저의 nick과 result가 0(진행중)로 데이터베이스에서 찾아온다
		
	      String url = "mypage/orderList.jsp";
	      HttpSession session = request.getSession();
	      String nick = request.getParameter("nick");
	      MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
	      if(mvo == null) {
	         url = "fooba.do?command=loginForm";
	      }else {         
	         OrderDao odao = OrderDao.getInstance();
	         ArrayList<OrderViewVO>list = odao.selectOrdersByNick(nick, "0"); // 0- 배달 완료 전
	      
	         request.setAttribute("orderList", list);
	         
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	      
	     }
	            
	   



}
