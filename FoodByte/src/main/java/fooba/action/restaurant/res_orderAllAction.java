package fooba.action.restaurant;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.OrderVO;
import fooba.VO.OrderViewVO;
import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.OrderDao;
import fooba.util.Paging;

public class res_orderAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String url = "restaurant/res_orderAllList.jsp";		// 레스토랑 주문현황으로 이동
	      HttpSession session = request.getSession();
	      RestaurantVO rvo = (RestaurantVO) session.getAttribute("loginRes");
	      if(rvo == null) {
	         url = "fooba.do?command=res_loginForm";
	      }else {
		         
				OrderDao odao = OrderDao.getInstance();

				ArrayList<OrderVO> finalList = new ArrayList<>();
		        ArrayList<OrderVO> list = odao.selectOrdersAllByRseq(rvo.getRseq());

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
			        		 if(size==i) oname=oname+") "+ovvo.getQuantity()+"개"; // 주문한메뉴갯수==반복횟수 일때
			        		 else oname = oname + ") "+ovvo.getQuantity()+"개, "; // 주문한메뉴갯수>반복횟수일 때
		        		 } else if (size!=i) {oname = oname+" "+ovvo.getQuantity()+"개, ";}
		        		 else oname = oname+" "+ovvo.getQuantity()+"개";// 주문한메뉴갯수>반복횟수일 때
		        	 }
		        	 ovo.setOname(oname);
		        	 ovo.setNick(ovList.get(0).getNick());
		        	 finalList.add(ovo);
		        	 System.out.println("result : " + ovo.getResult());
		         }
		        request.setAttribute("res_OrderList", finalList);       
		        request.setAttribute("RestaurantVO", rvo);
	      }
	      request.getRequestDispatcher(url).forward(request, response);

	}

}
