package fooba.action.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.VO.OrderDetailVO;
import fooba.VO.OrderVO;
import fooba.action.Action;
import fooba.dao.OrderDao;

public class memberOrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String url = "member/memberOrderList.jsp";
	      HttpSession session = request.getSession();
	      
	      MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
	      if(mvo == null) {
	         url = "fooba.do?command=loginForm";
	      }else {
	    	 ArrayList<OrderVO> finalList = new ArrayList<>();
	    	 
	         OrderDao odao = OrderDao.getInstance();
	         ArrayList<OrderVO> list = odao.selectOrdersIngById(mvo.getId());
	         
	         String oname = "";
	         for (OrderVO ovo : list) {
	        	 ArrayList<OrderDetailVO> detailList = new ArrayList<>();
	        	 detailList = odao.getOrderDetailbyOseq(ovo.getOseq());
	        	 
	        	 
	        	 
	        	 finalList.add(ovo);
	        	 
	        	 ovo.setOname(oname);
	         }
	         
	     
	         request.setAttribute("memberOrderList", list);
	         
	         
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	      
	     }
	            
	   



}
