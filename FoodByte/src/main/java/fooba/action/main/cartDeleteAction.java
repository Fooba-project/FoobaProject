package fooba.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.action.Action;
import fooba.dao.CartDao;

public class cartDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] cseqArr=request.getParameterValues("cseq");
		
		CartDao cdao=CartDao.getInstance();
		for(String cseq : cseqArr) {
			//cdao.deleteCart(Integer.parseInt(cseq));
			System.out.println(cseq);
		}
		response.sendRedirect("fooba.do?command=cartList");

	}

}
