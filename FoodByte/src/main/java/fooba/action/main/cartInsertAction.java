package fooba.action.food_cart;

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
		//cartvo에 전달 파라미터를 넣고, cart 테이블에 레코드를 추가한다.
		//cart 관련(mypage관련) 동작은 로그인 이후에 유효한 동작이므로, 현재 로그인 상태인지 먼저 점검한다.
		
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
