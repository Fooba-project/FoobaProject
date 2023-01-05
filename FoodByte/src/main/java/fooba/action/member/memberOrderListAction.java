package fooba.action.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.FoodmenuVO;
import fooba.VO.MemberVO;
import fooba.VO.OrderDetailVO;
import fooba.VO.OrderVO;
import fooba.action.Action;
import fooba.dao.FoodDao;
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
	         
	         int total = 0; // 총 주문금액
	         String oname = ""; // 주문내역
	         
	         for (OrderVO ovo : list) { // 현재 주문배송중인 레스토랑수만큼 반복
	        	 ArrayList<OrderDetailVO> detailList = new ArrayList<>();
	        	 detailList = odao.getOrderDetailbyOseq(ovo.getOseq());
	        	 System.out.println("ovo.getOseq() : "+ovo.getOseq());
	        	 for (OrderDetailVO odvo : detailList) { // 주문한 메뉴별(odseq 수만큼)로 반복
	        		 FoodDao fdao = FoodDao.getInstance();
	        		 FoodmenuVO fvo = new FoodmenuVO();
	        		 fvo = fdao.getFoodDetail(odvo.getFseq());
	        		 oname = oname+fvo.getFname();
	        		 System.out.println("fvo.getFname() : "+fvo.getFname());
	        		 if (odvo.getSideyn1()+odvo.getSideyn2()+odvo.getSideyn3()>0) {
	        			 oname = oname + "(";
		        		 if (odvo.getSideyn1()==1) {
		        			 fvo.setFprice(fvo.getFprice()+fvo.getFsideprice1());
		        			 oname = oname + fvo.getFside1();
		        			 if (odvo.getSideyn2()==1 || odvo.getSideyn3()==1) {
		        				 oname = oname + ", ";
		        			 }
		        		 }
		        		 if (odvo.getSideyn2()==1) {
		        			 fvo.setFprice(fvo.getFprice()+fvo.getFsideprice2());
		        			 oname = oname + fvo.getFside2();
		        			 if (odvo.getSideyn3()==1) {
		        				 oname = oname + ", ";
		        			 }
		        		 }
		        		 if (odvo.getSideyn3()==1) {
		        			 fvo.setFprice(fvo.getFprice()+fvo.getFsideprice3());
		        			 oname = oname + fvo.getFside3();
		        		 }
		        		 oname = oname + "), ";
	        		 } else oname = oname+", ";
	        		 total = total + (fvo.getFprice()*odvo.getQuantity());
	        		 System.out.println("oname : "+oname);
	        		 ovo.setRname(fdao.getRname(fvo.getRseq()));
	        	 }
	        	 ovo.setTotalprice(total);
	        	 ovo.setOname(oname);
	        	 finalList.add(ovo);
	         }
	         request.setAttribute("memberOrderList", finalList);
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	      
	}
}
