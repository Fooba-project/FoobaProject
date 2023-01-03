package fooba.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.action.Action;

public class memberMypageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="member/mypage.jsp";
		HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			url="fooba.do?command=loginForm";
		}else {
			/*
			//mypage.jsp 에 최종 전달돼서 화면에 보여질 리스트 생성
			ArrayList<OrderViewVO> finalList = new ArrayList<>();
			//(finalList.get(0).getName() -> "xxxx외 2건")
			
			//진행중인 주문 내역
			//현재 로그인 한 사용자의 아직 배송안된 주문내역이 보여진다.
			//예를 들어 한번에 2,3개의 상품씩 3회에 걸쳐서 주문한 상태라면.... 그리고 그 주문들이 하나도 배송이 안된 상태(배송전)이라면
			//진행중인 주문내역은 3줄이 표시된다.(orders테이블 기준 주문 건별 표시)
			//표시내용은 주문건별 대표상품의 이름을 이용하여 	슬리퍼 포함3, 겨울용부츠 외 2... 등등의 내용으로 총3줄이 표시된다.
			//그리고 각 행에는 상세보기 버튼이 있어서 클릭하면 그 주문에 속한 세개의 상품을 볼 수 있다.
			
			//이를 위해서 가장 먼저 필요한 사항은 주문번호들 이다
			//order_view 에서 주문자 아이디로 검색하고, result가 1인 주문들을 검색해서, 주문번호들을 조회한다.
			//위의 예를 든 상태라면 주문번호들이 다음과 같다.
			//22 22 22  24 24 24  26 26 26  27 27 27 <-조회된 주문 번호들
			
			//그러나 정작 우리에게 필요한건 22 25 26 27 이므로, 조회할때 distinct 키워드를 써서 조회해 온다.
			//select distinct oseq from order_viiew where id=? and result='1'
			//주문번호(oseq)만 조회할꺼라면 orders 테이블에서 distinct 없이 조회하면 될듯도 하지만
			//orders 테이블에는 result 필드가 없어서 배송전 주문이 구분된 번호가 조회가 되지 않는다.
			
			//중복을 없앤 배송전(처리전) 주문번호들을 조회한다.
			OrderDao odao=OrderDao.getInstance();
			ArrayList<Integer> oseqList=odao.selectOseqOrderIng(mvo.getId());
			
			//조회된 주문번호들로 반복실행한다.
			for(Integer oseq : oseqList) {
				//현재 주문 번호로 주문내역 조회
				ArrayList<OrderViewVO> orderListByOseq=odao.selectOrdersByOseq(oseq);
					
				//조회한 주문리스트에 세개의 상품이 있다면
				//첫번째 상품을 꺼낸다
				OrderViewVO ovo=orderListByOseq.get(0);
					
				//꺼낸 상품의 이름을 "현재상품이름 포함 X건" 으로 수정한다
				ovo.setPname(ovo.getPname()+" 포함 "+orderListByOseq.size()+"건");
				ovo.setResult("4"); //대표상품의 결과를 "구매확정"으로 설정
				//결제한 총금액을 계산한 후
				int totalPrice=0;
				for(OrderViewVO ovo1 : orderListByOseq) {
					totalPrice+=ovo1.getPrice2()*ovo1.getQuantity();
					if(!ovo1.getResult().equals("4"))
						ovo.setResult(ovo1.getResult());
					//주문에 포함된 제품의 결과를 하나씩 조회해서 4가 아니면 대표상품의 결과를 현재상품의 결과값으로
				}
				//ovo객체의 price2 를 앞에서 계산한 총 금액으로 수정한다
				ovo.setPrice2(totalPrice);
				
				//모든 변경을 마친 ovo를 finalList에 담는다
				finalList.add(ovo);
			}
			request.setAttribute("orderList", finalList);
			request.setAttribute("title","진행 중인 주문 내역");
			*/
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}


