package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_joinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResDao rdao=ResDao.getInstance();

		RestaurantVO rvo=new RestaurantVO();
		
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		String path=context.getRealPath("images/title");
		
		MultipartRequest multi = new MultipartRequest(
				request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
		);
		
		rvo.setRid(multi.getParameter("rid"));
		rvo.setRpwd(multi.getParameter("rpwd"));
		rvo.setRname(multi.getParameter("rname"));
		rvo.setOwnername(multi.getParameter("ownername"));
		rvo.setRphone(multi.getParameter("rphone"));
		rvo.setRaddress(multi.getParameter("raddress1")+" "+request.getParameter("raddress2"));
		rvo.setRimage(multi.getFilesystemName("rimage"));
		rvo.setContent(multi.getParameter("content"));
		rvo.setHash(multi.getParameter("hash"));
		rvo.setRbiznum(multi.getParameter("rbiznum"));
		rvo.setKind(Integer.parseInt(multi.getParameter("kind")));
		rvo.setRtip(Integer.parseInt(multi.getParameter("rtip")));
		
		int result=rdao.insertRes(rvo);
		
		if(result==1)session.setAttribute("message","가입이 완료되었습니다. 승인을 기다리세요");
		else session.setAttribute("message","가입 실패, 다시 시도하세요.");
		
		response.sendRedirect("fooba.do?command=res_loginForm");

	}

}
