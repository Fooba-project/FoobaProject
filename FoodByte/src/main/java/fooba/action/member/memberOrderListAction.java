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
import fooba.VO.OrderViewVO;
import fooba.action.Action;
import fooba.dao.FoodDao;
import fooba.dao.OrderDao;
import fooba.util.Paging;

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
			paging.setDisplayRow(5);
			paging.setDisplayPage(10);
			
			int count = odao.getOrderIngCount(mvo.getId());
			paging.setTotalCount(count);
			
	         ArrayList<OrderVO> list = odao.selectOrdersIngById(mvo.getId(), paging);
	         
	          // 주문메뉴(서브메뉴)

	         for (OrderVO ovo : list) { // 현재 주문배송중인 레스토랑수만큼 반복
	        	 String oname = "";
	        	 ArrayList<OrderViewVO> ovList = odao.selectOrderViewByOseq(ovo.getOseq());
	        	 int i = 0;
	        	 int size = ovList.size();
	        	 
	        	 for (OrderViewVO ovvo : ovList) { // 주문한 메뉴별(odseq 수만큼)로 반복
	        		 i++;
	        		 oname = oname+ovvo.getFname();
	        		 if (ovvo.getSideyn1()+ovvo.getSideyn2()+ovvo.getSideyn3()>0) {
	        			 oname = oname + "(";
		        		 if (ovvo.getSideyn1()==1) {
		        			 oname = oname + ovvo.getFside1();
		        			 if (ovvo.getSideyn2()==1 || ovvo.getSideyn3()==1) {
		        				 oname = oname + ", ";
		        			 }
		        		 }
		        		 if (ovvo.getSideyn2()==1) {
		        			 oname = oname + ovvo.getFside2();
		        			 if (ovvo.getSideyn3()==1) {
		        				 oname = oname + ", ";
		        			 }
		        		 }
		        		 if (ovvo.getSideyn3()==1) {
		        			 oname = oname + ovvo.getFside3();
		        		 }
		        		 if(size==i) oname=oname+")"; // 주문한메뉴갯수==반복횟수 일때
		        		 else oname = oname + "), "; // 주문한메뉴갯수>반복횟수일 때
	        		 } else if (size!=i) {oname = oname+", ";}// 주문한메뉴갯수>반복횟수일 때
	        	 }
	        	 ovo.setRname(ovList.get(0).getRname());
	        	 ovo.setRimage(ovList.get(0).getRimage());
	        	 ovo.setRseq(ovList.get(0).getRseq());
	        	 ovo.setOname(oname);
	        	 finalList.add(ovo);
	         }
	         request.setAttribute("memberOrderList", finalList);
	         request.setAttribute("memberOrderListT", "진행중인");
	         request.setAttribute("paging", paging);	 
	         request.setAttribute("orderList", "ing");
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	      
	      
	      
	}
}
