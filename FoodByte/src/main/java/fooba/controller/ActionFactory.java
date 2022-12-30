package fooba.controller;

import fooba.action.Action;
import fooba.action.indexAction;
import fooba.action.admin.adminAction;
import fooba.action.admin.adminLoginAction;
import fooba.action.admin.adminLogoutAction;
import fooba.action.admin.adminMemberKickAction;
import fooba.action.admin.adminOrderListAction;
import fooba.action.admin.adminQnaListAction;
import fooba.action.admin.adminRestaurantKickAction;
import fooba.action.admin.adminRestaurantListAction;
import fooba.action.admin.adminRestaurantOkAction;
import fooba.action.admin.qnaDeleteAction;
import fooba.action.admin.qnaUpdateAction;
import fooba.action.admin.qnaUpdateFormAction;
import fooba.action.admin.qnaWriteAction;
import fooba.action.admin.qnaWriteFormAction;
import fooba.action.food_cart.cartDeleteAction;
import fooba.action.food_cart.cartInsertAction;
import fooba.action.food_cart.categoryAction;
import fooba.action.food_cart.foodDetailAction;
import fooba.action.food_cart.searchAction;
import fooba.action.member.contractAction;
import fooba.action.member.findZipNumAction;
import fooba.action.member.idCheckFormAction;
import fooba.action.member.joinAction;
import fooba.action.member.joinFormAction;
import fooba.action.member.loginAction;
import fooba.action.member.loginFormAction;
import fooba.action.member.logoutAction;
import fooba.action.mypage.editFormAction;
import fooba.action.mypage.memberUpdateAction;
import fooba.action.mypage.mypageAction;
import fooba.action.mypage.orderAllAction;
import fooba.action.mypage.orderDetailAction;
import fooba.action.mypage.orderListAction;
import fooba.action.mypage.reviewWriteAction;
import fooba.action.mypage.reviewWriteFormAction;
import fooba.action.mypage.withdrawalMemberAction;
import fooba.action.qna.qnaListAction;
import fooba.action.qna.qnaViewAction;
import fooba.action.res_info.res_infoAction;
import fooba.action.res_info.res_menuAction;
import fooba.action.res_info.res_menuAddAction;
import fooba.action.res_info.res_menuAddFormAction;
import fooba.action.res_info.res_menuDeleteAction;
import fooba.action.res_info.res_menuUpdateAction;
import fooba.action.res_info.res_menuUpdateFormAction;
import fooba.action.res_info.res_orderAction;
import fooba.action.res_info.res_orderCompleteAction;
import fooba.action.res_info.res_orderDetailAction;
import fooba.action.res_info.res_reviewAction;
import fooba.action.res_info.res_reviewReplyWriteAction;
import fooba.action.res_info.res_showAction;
import fooba.action.restaurant.res_contractAction;
import fooba.action.restaurant.res_editFormAction;
import fooba.action.restaurant.res_findZipNumAction;
import fooba.action.restaurant.res_idCheckFormAction;
import fooba.action.restaurant.res_joinAction;
import fooba.action.restaurant.res_joinFormAction;
import fooba.action.restaurant.res_loginAction;
import fooba.action.restaurant.res_loginFormAction;
import fooba.action.restaurant.res_logoutAction;
import fooba.action.restaurant.res_updateAction;
import fooba.action.restaurant.res_withdrawalAction;

public class ActionFactory {
	
	private ActionFactory() {}
	private static ActionFactory itc=new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	public Action getAction(String command) {
		Action ac=null;
//		
//		request.getRequestDispatcher(fooba.do?command=index).forward(request, response);
		
		
		// member 가입, 로그인, 로그아웃 등 기본기능
		if(command.equals("index")) ac=new indexAction(); // 메인화면 표시
		else if(command.equals("loginForm"))ac=new loginFormAction();
		else if (command.equals("login")) ac = new loginAction();
		else if (command.equals("logout")) ac = new logoutAction();
		else if (command.equals("contract")) ac = new contractAction();
		else if (command.equals("joinForm")) ac = new joinFormAction();
		else if (command.equals("idCheckForm")) ac = new idCheckFormAction();
		else if (command.equals("findZipNum")) ac = new findZipNumAction();
		else if (command.equals("join")) ac = new joinAction();

		// 마이페이지 회원정보, 주문내역확인, 리뷰작성 등
		else if (command.equals("mypage")) ac = new mypageAction();
		else if (command.equals("editForm")) ac = new editFormAction();
		else if (command.equals("memberUpdate")) ac = new memberUpdateAction();
		else if (command.equals("withdrawalMember")) ac = new withdrawalMemberAction();
		else if (command.equals("orderList")) ac = new orderListAction();// 진행중인 주문 내역
		else if (command.equals("orderAll")) ac = new orderAllAction();// 전체 주문 내역
		else if (command.equals("orderDetail")) ac = new orderDetailAction();// 주문 번호별 상세 내역
		
		
		//보류 review yn, order_view에 review넣을지
		else if (command.equals("reviewWriteForm")) ac = new reviewWriteFormAction();// 별점 및 리뷰 작성페이지로 이동
		else if (command.equals("reviewWrite")) ac = new reviewWriteAction();// 별점 및 리뷰 작성된 내용 저장
		
		
		
		// food_cart 액션
		// 장바구니넣기, 수정, 삭제, 주문하기,
		else if (command.equals("search")) ac = new searchAction();// 검색 후 가게 리스팅
		else if (command.equals("category")) ac = new categoryAction();// 카테고리별 가게 리스팅
		else if (command.equals("foodDetail")) ac = new foodDetailAction();// 가게 클릭시 가게 소개 및 메뉴 리스팅
		else if (command.equals("cartInsert")) ac = new cartInsertAction();// 카트에 담기
		else if (command.equals("cartDelete")) ac = new cartDeleteAction();// 카트에서 삭제
//		else if (command.equals("orderInsert")) ac = new orderInsertAction();// 주문하기 보류
		
		// restaurant 가입-정보-수정 액션
		// 가게정보, 주문관리, 메뉴관리, 리뷰관리, 가게미리보기
		else if (command.equals("res_loginForm")) ac=new res_loginFormAction();
		else if (command.equals("res_login")) ac = new res_loginAction();
		else if (command.equals("res_logout")) ac = new res_logoutAction();
		else if (command.equals("res_contract")) ac = new res_contractAction();
		else if (command.equals("res_joinForm")) ac = new res_joinFormAction();
		else if (command.equals("res_idCheckForm")) ac = new res_idCheckFormAction();
		else if (command.equals("res_findZipNum")) ac = new res_findZipNumAction();
		else if (command.equals("res_join")) ac = new res_joinAction();
		else if (command.equals("res_editForm")) ac = new res_editFormAction();
		else if (command.equals("res_Update")) ac = new res_updateAction();
		else if (command.equals("res_withdrawal")) ac = new res_withdrawalAction();
		
		// 레스토랑 관리
		else if (command.equals("res_info")) ac = new res_infoAction();// 로그인 후 레스토랑 관리페이지 입장
		// 리뷰
		else if (command.equals("res_review")) ac = new res_reviewAction();// 리뷰 탭
		else if (command.equals("res_reviewReplyWrite")) ac = new res_reviewReplyWriteAction();// 답글 달기
		// 주문관리
		else if (command.equals("res_order")) ac = new res_orderAction();// 주문 관리 탭, 주문리스트 표시
		else if (command.equals("res_orderDetail")) ac = new res_orderDetailAction(); // 주문 상세보기
		else if (command.equals("res_orderComplete")) ac = new res_orderCompleteAction();// 배달완료 처리
		// 메뉴
		else if (command.equals("res_menu")) ac = new res_menuAction();// 메뉴 리스트
		else if (command.equals("res_menuUpdateForm")) ac = new res_menuUpdateFormAction();
		else if (command.equals("res_menuUpdate")) ac = new res_menuUpdateAction();// 메뉴 업데이트
		else if (command.equals("res_menuAddForm")) ac = new res_menuAddFormAction();
		else if (command.equals("res_menuAdd")) ac = new res_menuAddAction();// 메뉴 추가
		else if (command.equals("res_menuDelete")) ac = new res_menuDeleteAction();// 메뉴 삭제
		// 레스토랑 미리보기
		else if (command.equals("res_show")) ac = new res_showAction();// 가게 미리보기
		

		// qna 액션(고객센터 - 자주묻는 질문)
		else if (command.equals("qnaList")) ac = new qnaListAction(); // qna 리스트  고객이 보는모습
		else if (command.equals("qnaView")) ac = new qnaViewAction(); // qna 상세 보기  고객이 보는모습
		
		/*
		else if (command.equals("qnaList")) ac = new qnaListAction();
		else if (command.equals("qnaView")) ac = new qnaViewAction();
		else if (command.equals("qnaWriteForm")) ac = new qnaWriteFormAction();
		else if (command.equals("qnaWrite")) ac = new qnaWriteAction();
		else if (command.equals("qnaPassCheckForm")) ac = new qnaPassCheckFormAction();
		else if (command.equals("qnaPassCheck")) ac = new qnaPassCheckAction();
		else if (command.equals("qnaUpdateForm")) ac = new qnaUpdateFormAction();
		else if (command.equals("qnaUpdate")) ac = new qnaUpdateAction();
		else if (command.equals("qnaDelete")) ac = new qnaDeleteAction();
		*/
		
		// admin 액션
		else if (command.equals("admin")) ac = new adminAction(); // admin 로그인창 
		else if (command.equals("adminLogin")) ac = new adminLoginAction(); // 로그인 명령
		else if (command.equals("adminLogout")) ac = new adminLogoutAction();
		else if (command.equals("adminRestaurantList")) ac = new adminRestaurantListAction(); // 가게관리 result 1 운영 가능 가게 
		else if (command.equals("adminRestaurantOk")) ac = new adminRestaurantOkAction(); // 가게관리 result 0 가입신청한 가게
		else if (command.equals("adminRestaurantKick")) ac = new adminRestaurantKickAction(); // 가게관리 result 2 퇴출된 가게
		else if (command.equals("adminMemberKick")) ac = new adminMemberKickAction(); // 회원관리 - 리스트옆에 방출버튼
		//else if (command.equals("adminMemberList")) ac = new adminMemberListAction();   //KickAction으로
		//else if (command.equals("adminProductDetail")) ac = new adminProductDetailAction();
		//else if (command.equals("adminProductUpdateForm")) ac = new adminProductUpdateFormAction();
		//else if (command.equals("adminProductUpdate")) ac = new adminProductUpdateAction();
		else if (command.equals("adminOrderList")) ac = new adminOrderListAction();
		//else if (command.equals("adminOrderSave")) ac = new adminOrderSaveAction();
		//else if (command.equals("adminQnaDetail")) ac = new adminQnaDetailAction();
		//else if (command.equals("adminQnaRepSave")) ac = new adminQnaRepSaveAction();
		
		else if (command.equals("adminQnaList")) ac = new adminQnaListAction();
		else if (command.equals("qnaWriteForm")) ac = new qnaWriteFormAction(); // 작성 폼  밑으로 admin
		else if (command.equals("qnaWrite")) ac = new qnaWriteAction(); // 작성 명령
		else if (command.equals("qnaUpdateForm")) ac = new qnaUpdateFormAction(); // 수정 폼
		else if (command.equals("qnaUpdate")) ac = new qnaUpdateAction(); // 수정명령
		else if (command.equals("qnaDelete")) ac = new qnaDeleteAction(); // 삭제
		
		
		
		
		return ac;
	}

	
}
