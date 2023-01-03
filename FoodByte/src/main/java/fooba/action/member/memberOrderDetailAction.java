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

public class memberOrderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int oseq=Integer.parseInt(request.getParameter("oseq"));
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		String url="";
		if(loginUser==null) {
			url="fooba.do?command=loginForm";
		}else {
			OrderDao odao=OrderDao.getInstance();
			ArrayList<OrderViewVO> orderList=odao.selectOrdersByOseq(oseq);
		
			request.setAttribute("orderList", orderList);
			request.setAttribute("orderDetail",orderList.get(0));
			
			url="member/orderDetail.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	

	}

}
