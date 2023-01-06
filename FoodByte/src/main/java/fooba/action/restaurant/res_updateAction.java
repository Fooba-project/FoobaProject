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
import fooba.dao.AdminDao;
import fooba.dao.ResDao;

public class res_updateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="fooba.do?command=res_show";
		HttpSession session=request.getSession();
        RestaurantVO rvo=(RestaurantVO)session.getAttribute("loginRes");
        if(rvo==null) {
			url="fooba.do?command=res_loginForm";
		}else {
			ServletContext context=session.getServletContext();
			String path=context.getRealPath("images/title"); //폴더 이미지로 변경
			
			MultipartRequest multi = new MultipartRequest(
					request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
			);
			
			ResDao rdao=ResDao.getInstance();
			rvo.setRseq(Integer.parseInt(multi.getParameter("rseq")));
			rvo.setRphone(multi.getParameter("rphone"));
			rvo.setRaddress(multi.getParameter("raddress"));
			rvo.setContent(multi.getParameter("content"));
			rvo.setHash(multi.getParameter("hash"));
			rvo.setRtip(Integer.parseInt(multi.getParameter("rtip")));
			if(multi.getFilesystemName("rimage")==null)rvo.setRimage(multi.getParameter("oldImage"));
			else rvo.setRimage(multi.getFilesystemName("rimage"));
			
			
			rdao.updateRes(rvo);
			
		}
		request.getRequestDispatcher(url).forward(request, response);

		
	}

}
