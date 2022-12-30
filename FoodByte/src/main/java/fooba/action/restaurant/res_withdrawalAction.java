package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_withdrawalAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="fooba.do?command=res_loginForm";
		
		
		HttpSession session=request.getSession();
		RestaurantVO rvo=(RestaurantVO) session.getAttribute("loginUser");
		

		if(rvo==null) {
			url="fooba.do?command=res_loginForm";
			request.setAttribute("message","�α����� �ʿ��� �����Դϴ�.");
		}else {

			ResDao rdao=ResDao.getInstance();
			rdao.withDrawalRes(rvo.getRid());
			request.setAttribute("message",
					"Ż��Ǿ����ϴ�. Ż��ȸ���� ������ 3������ �����Ǹ� �� �Ⱓ�ȿ� ������ ���Ծ��� ���� ������ �����մϴ�.");
			session.removeAttribute("loginUser");
		}
		
		request.getRequestDispatcher(url).forward(request,response); 

	}

}