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
import fooba.VO.ReviewVO;
import fooba.action.Action;
import fooba.dao.OrderDao;

public class memberOrderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int oseq=Integer.parseInt(request.getParameter("oseq"));
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		String url="member/memberOrderDetail.jsp";
		OrderDao odao=OrderDao.getInstance();
		OrderVO ovo = odao.getOrderbyOseq(oseq);
		
		if(mvo==null) {
			url="fooba.do?command=loginForm";
		}else if( !mvo.getId().equals(ovo.getId()) ) {
			session.removeAttribute("loginUser");
			session.setAttribute("message", "잘못된 접근입니다. 다시 로그인하세요.");
			url="fooba.do?command=loginForm";
		}else {
			ArrayList<OrderViewVO> ovList=odao.selectOrderViewByOseq(oseq);
			ReviewVO review = odao.getOrderReviewByOseq(oseq);
			request.setAttribute("ovo", ovo);
			request.setAttribute("ovList", ovList);
			request.setAttribute("review", review);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
