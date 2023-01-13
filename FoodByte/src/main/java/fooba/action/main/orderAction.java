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
import fooba.VO.OrderVO;
import fooba.action.Action;
import fooba.dao.CartDao;
import fooba.dao.OrderDao;

public class orderAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="fooba.do?command=memberOrderList";
		HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			url="fooba.do?command=loginForm";
			request.setAttribute("message", "로그인이 필요한 서비스입니다.");
		}else {
			int rseq=Integer.parseInt(request.getParameter("rseq"));
			int totalprice=Integer.parseInt(request.getParameter("totalprice"));
			
			
			//orders 를 채우고
			OrderVO ovo=new OrderVO();
			ovo.setId(mvo.getId());
			ovo.setRideryn(Integer.parseInt(request.getParameter("rideryn")));
			ovo.setPlasticyn(Integer.parseInt(request.getParameter("plasticyn")));
			ovo.setPayment(Integer.parseInt(request.getParameter("payment")));
			if(Integer.parseInt(request.getParameter("bdjs"))==0) {
				ovo.setAddress1(mvo.getAddress1());
				ovo.setAddress2(mvo.getAddress2());
				ovo.setPhone(mvo.getPhone());
			}else {
				ovo.setAddress1(request.getParameter("useraddress1"));
				ovo.setAddress2(request.getParameter("useraddress2"));
				ovo.setPhone(request.getParameter("phone"));
			}
			ovo.setTotalprice(totalprice);
			OrderDao odao=OrderDao.getInstance();
			CartDao cdao=CartDao.getInstance();
			ArrayList<CartVO>clist=cdao.CartList(mvo.getId(),rseq);
			if(clist.size()!=0) {
				odao.insertOrders(ovo);
				odao.insertOrder(clist,mvo.getId());
			}
		}
		response.sendRedirect(url);
	}

}
