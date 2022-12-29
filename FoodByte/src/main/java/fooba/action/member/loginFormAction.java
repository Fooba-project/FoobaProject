package fooba.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.action.Action;

public class loginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="member/login.jsp";
		
		//login 상태의 화면과 logout 된 상태의 화면이 동일하므로 로그인상태를 체크하지 않고
		//header.jsp에서 로그인 상태에 따라 메뉴를 다리 보여주는 것으로 마무리 된다.
		
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);

	}

}
