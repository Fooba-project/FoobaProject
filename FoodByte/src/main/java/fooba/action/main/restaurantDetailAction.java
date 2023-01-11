package fooba.action.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.CartVO;
import fooba.VO.FoodmenuVO;
import fooba.VO.MemberVO;
import fooba.VO.RestaurantVO;
import fooba.VO.ReviewVO;
import fooba.action.Action;
import fooba.dao.CartDao;
import fooba.dao.ResDao;

public class restaurantDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rseq=Integer.parseInt(request.getParameter("rseq"));
		int carttotalprice=0;
		ResDao rdao=ResDao.getInstance();
		
		RestaurantVO rvo=rdao.getResInfo(rseq);
		ArrayList<FoodmenuVO>foodmenuList=rdao.foodList(rseq);
		ArrayList<ReviewVO>reviewList=rdao.reviewList(rseq);

		HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("loginUser");
		if(mvo!=null) {
		CartDao cdao=CartDao.getInstance();
		ArrayList<CartVO>clist=cdao.CartList(mvo.getId(),rseq);
		
		request.setAttribute("clist", clist);
		
		int sum=cdao.CartListSum(mvo.getId(), rseq);
		carttotalprice=sum+rvo.getRtip();
		}else {
			carttotalprice=carttotalprice+rvo.getRtip();
		}
		/*가게 별점*/
		double star=0;
		star=rdao.starAvg(rseq);
		int intstar=(int)star;
		double doublestar=(int)(star*10)/(double)10;
		request.setAttribute("intstar",intstar); //별 개수
		request.setAttribute("doublestar",doublestar); //별점(소수점까지)
		/**/
		request.setAttribute("carttotalprice", carttotalprice);
		request.setAttribute("RestaurantVO", rvo);
		request.setAttribute("FoodmenuList", foodmenuList);
		request.setAttribute("ReviewList",reviewList);
		
		request.getRequestDispatcher("/main/menuDetail.jsp").forward(request, response);
	}

}
