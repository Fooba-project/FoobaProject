package fooba.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.action.Action;
import fooba.dao.CartDao;

public class deleteCartmenuAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cseq=Integer.parseInt(request.getParameter("cseq"));
		
		CartDao cdao=CartDao.getInstance();
		int rseq=cdao.deletecart(cseq);
		System.out.println(rseq);
		
		request.getRequestDispatcher("fooba.do?command=restaurantDetail&rseq="+rseq).forward(request, response);
	}

}
