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

public class orderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int oseq=Integer.parseInt(request.getParameter("oseq"));
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		String url="";
		if(loginUser==null) {
			url="shop.do?command=loginForm";
		}else {
			
			//주문번호로 조회한 주문(상품) 리스트 리턴
			OrderDao odao=OrderDao.getInstance();
			ArrayList<OrderViewVO> orderList=odao.selectOrdersByOseq(oseq);
			
			//리퀘스트에 주문리스트를 닫는다
			request.setAttribute("orderList", orderList);
			
			//리턴받은 주문리스트의 첫번째를 이용하여 orderDetail 이란 이름으로 리퀘스트에 담는다.
			request.setAttribute("orderDetail",orderList.get(0));
			
			
			url="mypage/orderDetail.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	

	}

}
