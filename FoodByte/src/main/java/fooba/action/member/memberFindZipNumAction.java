package fooba.action.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fooba.VO.AddressVO;
import fooba.action.Action;
import fooba.dao.MemberDao;

public class memberFindZipNumAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dong=request.getParameter("dong");
		
		if(dong!=null) {
			if(dong.equals("")==false) {
				MemberDao mdao=MemberDao.getInstance();
				ArrayList<AddressVO> list=mdao.selectAddress(dong);
				request.setAttribute("addressList", list);
			}
		}
		
		RequestDispatcher dp=request.getRequestDispatcher("member/memberFindZipnum.jsp");
		dp.forward(request, response);

	}

}
