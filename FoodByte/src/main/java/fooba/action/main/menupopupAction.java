package fooba.action.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.FoodmenuVO;
import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.FoodDao;

public class menupopupAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="main/popupMenu.jsp";
		
			
		int fseq=Integer.parseInt(request.getParameter("fseq"));
		FoodDao fdao=FoodDao.getInstance();
		FoodmenuVO fvo=fdao.getFoodDetail(fseq);
		
		request.setAttribute("FoodmenuVO", fvo);
			
		
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
