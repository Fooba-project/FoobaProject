package fooba.action.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.CartVO;
import fooba.VO.MemberVO;
import fooba.action.Action;
import fooba.dao.CartDao;

public class cartInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("loginUser");
		String url="";
		if(mvo==null) {
			url="fooba.do?command=loginForm";
		}else {
			CartVO cvo=new CartVO();
			int rseq=Integer.parseInt(request.getParameter("rseq"));
			cvo.setId(mvo.getId());
			cvo.setFseq(Integer.parseInt(request.getParameter("fseq")));
			cvo.setSideyn1(Integer.parseInt(request.getParameter("sideyn1")));
			cvo.setSideyn2(Integer.parseInt(request.getParameter("sideyn2")));
			cvo.setSideyn3(Integer.parseInt(request.getParameter("sideyn3")));
			cvo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			
			CartDao cdao=CartDao.getInstance();
			cdao.insertCart(cvo);
			url="fooba.do?command=cartList";
			
		}

		response.sendRedirect(url);
	}

}
