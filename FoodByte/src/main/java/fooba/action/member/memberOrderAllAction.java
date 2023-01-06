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
import fooba.util.Paging;

public class memberOrderAllAction implements Action {

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
	         
	         int page=1;
				if(request.getParameter("page")!=null) { 
					page=Integer.parseInt(request.getParameter("page"));
					session.setAttribute("page", page);
				}else if(session.getAttribute("page")!=null) { 
					page=(Integer)session.getAttribute("page");
				}else { 
					session.removeAttribute("page");
				}
			 
			Paging paging = new Paging();
			paging.setPage(page);
			paging.setDisplayRow(10);
			paging.setDisplayPage(10);
			
			int count = odao.getOrderIngCount(mvo.getId());
			paging.setTotalCount(count);
			
	         ArrayList<OrderVO> list = odao.selectOrdersById(mvo.getId(), paging);
	         
	         int total = 0; // 총 주문금액
	         String oname = ""; // 주문내역
	         
	         for (OrderVO ovo : list) { // 현재 주문배송중인 레스토랑수만큼 반복
	        	 ArrayList<OrderDetailVO> detailList = new ArrayList<>();
	        	 int j = 0;
	        	 detailList = odao.getOrderDetailbyOseq(ovo.getOseq());
	        	 int size = detailList.size();
	        	 for (OrderDetailVO odvo : detailList) { // 주문한 메뉴별(odseq 수만큼)로 반복
	        		 j++;
	        		 FoodDao fdao = FoodDao.getInstance();
	        		 FoodmenuVO fvo = new FoodmenuVO();
	        		 fvo = fdao.getFoodDetail(odvo.getFseq());
	        		 oname = oname+fvo.getFname();
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
		        		 if(size==j) oname=oname+")";
		        		 else oname = oname + "), ";
	        		 } else oname = oname+", ";
	        		 total = total + (fvo.getFprice()*odvo.getQuantity());
	        		 ovo.setRname(fdao.getRname(fvo.getRseq()));
	        		 ovo.setFimage(fvo.getFimage());
	        	 }
	        	 
	        	 ovo.setTotalprice(total);
	        	 ovo.setOname(oname);
	        	 finalList.add(ovo);
	         }
	         request.setAttribute("memberOrderList", finalList);
	         request.setAttribute("paging", paging);
	         
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	}

}
