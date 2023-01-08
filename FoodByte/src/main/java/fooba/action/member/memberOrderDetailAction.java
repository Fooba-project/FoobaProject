package fooba.action.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.VO.OrderVO;
import fooba.VO.OrderViewVO;
import fooba.action.Action;
import fooba.dao.OrderDao;

public class memberOrderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int oseq=Integer.parseInt(request.getParameter("oseq"));
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		String url="member/orderDetail.jsp";
		OrderDao odao=OrderDao.getInstance();
		OrderVO ovo = odao.getOrderbyOseq(oseq);
		
		if(mvo==null) {
			url="fooba.do?command=loginForm";
		}else if(mvo.getId()!=ovo.getId()) {
			url="fooba.do?command=loginForm";
		}else {	
			ArrayList<OrderViewVO> orderDetailList=odao.selectOrdersByOseq(oseq);
			request.setAttribute("orderDetailList", orderDetailList);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
