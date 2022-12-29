package fooba.action.mypage;

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

public class orderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int oseq=Integer.parseInt(request.getParameter("oseq"));
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		String url="";
		if(loginUser==null) {
			url="shop.do?command=loginForm";
		}else {
			
			//�ֹ���ȣ�� ��ȸ�� �ֹ�(��ǰ) ����Ʈ ����
			OrderDao odao=OrderDao.getInstance();
			ArrayList<OrderViewVO> orderList=odao.selectOrdersByOseq(oseq);
			
			//������Ʈ�� �ֹ�����Ʈ�� �ݴ´�
			request.setAttribute("orderList", orderList);
			
			//���Ϲ��� �ֹ�����Ʈ�� ù��°�� �̿��Ͽ� orderDetail �̶� �̸����� ������Ʈ�� ��´�.
			request.setAttribute("orderDetail",orderList.get(0));
			
			
			url="mypage/orderDetail.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	

	}

}
