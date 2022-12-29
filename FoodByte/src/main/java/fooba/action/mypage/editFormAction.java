package fooba.action.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.action.Action;

public class editFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//비밀번호 입력하면 수정이 되게 한다.
		
		RequestDispatcher dp=request.getRequestDispatcher("mypage/updateForm.jsp");
		dp.forward(request, response);
		

	}

}
