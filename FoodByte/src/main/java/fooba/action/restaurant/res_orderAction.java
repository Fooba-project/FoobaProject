package fooba.action.restaurant;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.FoodmenuVO;
import fooba.VO.MemberVO;
import fooba.VO.OrderVO;
import fooba.VO.OrderViewVO;
import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.MemberDao;
import fooba.dao.OrderDao;
import fooba.dao.ResDao;
import fooba.util.Paging;

public class res_orderAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		  
		  String url = "restaurant/res_orderList.jsp";		// 레스토랑 주문현황으로 이동
	      HttpSession session = request.getSession();
	      RestaurantVO rvo = (RestaurantVO) session.getAttribute("loginRes");
	      if(rvo == null) {
	         url = "fooba.do?command=res_loginForm";
	      }else {
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
				OrderDao odao = OrderDao.getInstance();
				System.out.println("rv.getid"+rvo.getRid());
				System.out.println("rseq"+rvo.getRseq());
				int count = odao.getOrderIngCountByRseq( rvo.getRseq());
				paging.setTotalCount(count);
				
				ArrayList<OrderVO> finalList = new ArrayList<>();
				
		        ArrayList<OrderVO> list = odao.selectOrdersIngByRseq(rvo.getRseq(), paging);
		         
		         String oname = ""; // 주문메뉴(서브메뉴)

		         for (OrderVO ovo : list) { // 현재 주문배송중인 레스토랑수만큼 반복
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
			        		 if(size==i) oname=oname+") "+ovvo.getQuantity()+"개"; // 주문한메뉴갯수==반복횟수 일때
			        		 else oname = oname + ") "+ovvo.getQuantity()+"개, "; // 주문한메뉴갯수>반복횟수일 때
		        		 } else if (size!=i) {oname = oname+" "+ovvo.getQuantity()+"개, ";}
		        		 else oname = oname+" "+ovvo.getQuantity()+"개";// 주문한메뉴갯수>반복횟수일 때
		        	 }
		        	 ovo.setOname(oname);
		        	 ovo.setNick(ovList.get(0).getNick());
		        	 finalList.add(ovo);
		         }
		        request.setAttribute("res_OrderList", finalList);
		        request.setAttribute("paging", paging);	       
		        request.setAttribute("RestaurantVO", rvo);
	      }
	      request.getRequestDispatcher(url).forward(request, response);
	     
	}

}
