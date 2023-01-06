package fooba.action.restaurant;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import fooba.VO.FoodmenuVO;
import fooba.VO.RestaurantVO;
import fooba.action.Action;
import fooba.dao.ResDao;

public class res_foodmenuUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="fooba.do?command=res_foodmenu";
        HttpSession session=request.getSession();
        RestaurantVO rvo=(RestaurantVO)session.getAttribute("loginRes");
        if(rvo==null) {
           url="fooba.do?command=res_loginForm";
        }else {
           FoodmenuVO fvo=new FoodmenuVO();
           ServletContext context=session.getServletContext();
           String path=context.getRealPath("images/foodmenu");
           
           MultipartRequest multi = new MultipartRequest(
                 request, path, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
           );
           
           fvo.setRseq(Integer.parseInt(multi.getParameter("rseq")));
           fvo.setFseq(Integer.parseInt(multi.getParameter("fseq")));
           fvo.setFname(multi.getParameter("fname"));         
           fvo.setFprice(Integer.parseInt(multi.getParameter("fprice")));
           fvo.setFcontent(multi.getParameter("fcontent"));
           fvo.setFside1(multi.getParameter("fside1"));
           fvo.setFsideprice1(Integer.parseInt(multi.getParameter("fsideprice1")));
           fvo.setFside2(multi.getParameter("fside2"));
           fvo.setFsideprice2(Integer.parseInt(multi.getParameter("fsideprice2")));
           fvo.setFside3(multi.getParameter("fside3"));
           fvo.setFsideprice3(Integer.parseInt(multi.getParameter("fsideprice3")));
           if(multi.getFilesystemName("fimage")==null)fvo.setFimage(multi.getParameter("oldImage"));
           else fvo.setFimage(multi.getFilesystemName("fimage"));
           
           ResDao rdao=ResDao.getInstance();
           rdao.updateFoodMenu(fvo);
           url=url+"&rseq="+fvo.getRseq();
           
        }
        request.getRequestDispatcher(url).forward(request, response);


	}

}
