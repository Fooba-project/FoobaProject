package fooba.controller;

import fooba.action.Action;
import fooba.action.indexAction;
import fooba.action.admin.admin_fooba_privacyAction;
import fooba.action.admin.admin_fooba_tosAction;
import fooba.action.admin.admin_loginAction;
import fooba.action.admin.admin_loginFormAction;
import fooba.action.admin.admin_logoutAction;
import fooba.action.admin.admin_memberListAction;
import fooba.action.admin.admin_orderListAction;
import fooba.action.admin.admin_orderList_lbAction;
import fooba.action.admin.admin_orderList_rbAction;
import fooba.action.admin.admin_qnaDeleteAction;
import fooba.action.admin.admin_qnaListAction;
import fooba.action.admin.admin_qnaUpdateAction;
import fooba.action.admin.admin_qnaUpdateFormAction;
import fooba.action.admin.admin_qnaViewAction;
import fooba.action.admin.admin_qnaWriteAction;
import fooba.action.admin.admin_qnaWriteFormAction;
import fooba.action.admin.admin_restaurantDetailAction;
import fooba.action.admin.admin_restaurantKickAction;
import fooba.action.admin.admin_restaurantListAction;
import fooba.action.admin.admin_restaurantOkAction;
import fooba.action.main.categoryAction;
import fooba.action.main.deleteCartmenuAction;
import fooba.action.main.fooba_privacyAction;
import fooba.action.main.fooba_tosAction;
import fooba.action.main.jangbaguniAction;
import fooba.action.main.loginAction;
import fooba.action.main.loginFormAction;
import fooba.action.main.logoutAction;
import fooba.action.main.menupopupAction;
import fooba.action.main.miniLoginAction;
import fooba.action.main.miniLoginFormAction;
import fooba.action.main.orderAction;
import fooba.action.main.orderFormAction;
import fooba.action.main.restaurantDetailAction;
import fooba.action.main.searchAction;
import fooba.action.member.memberFindIdAction;
import fooba.action.member.memberFindIdFormAction;
import fooba.action.member.memberFindPwAction;
import fooba.action.member.memberFindPwFormAction;
import fooba.action.member.memberFindZipNumAction;
import fooba.action.member.memberIdCheckFormAction;
import fooba.action.member.memberJoinAction;
import fooba.action.member.memberJoinFormAction;
import fooba.action.member.memberOrderAllAction;
import fooba.action.member.memberOrderDetailAction;
import fooba.action.member.memberOrderListAction;
import fooba.action.member.memberQnalistAction;
import fooba.action.member.memberReviewWriteAction;
import fooba.action.member.memberUpdateAction;
import fooba.action.member.memberUpdateFormAction;
import fooba.action.member.memberWithdrawalAction;
import fooba.action.restaurant.res_FindIdAction;
import fooba.action.restaurant.res_FindIdFormAction;
import fooba.action.restaurant.res_FindPwAction;
import fooba.action.restaurant.res_FindPwFormAction;
import fooba.action.restaurant.res_editFormAction;
import fooba.action.restaurant.res_findZipNumAction;
import fooba.action.restaurant.res_fooba_privacyAction;
import fooba.action.restaurant.res_fooba_tosAction;
import fooba.action.restaurant.res_foodmenuAction;
import fooba.action.restaurant.res_foodmenuAddAction;
import fooba.action.restaurant.res_foodmenuAddFormAction;
import fooba.action.restaurant.res_foodmenuDeleteAction;
import fooba.action.restaurant.res_foodmenuUpdateAction;
import fooba.action.restaurant.res_foodmenuUpdateFormAction;
import fooba.action.restaurant.res_idCheckFormAction;
import fooba.action.restaurant.res_joinAction;
import fooba.action.restaurant.res_joinFormAction;
import fooba.action.restaurant.res_loginAction;
import fooba.action.restaurant.res_loginFormAction;
import fooba.action.restaurant.res_logoutAction;
import fooba.action.restaurant.res_orderAction;
import fooba.action.restaurant.res_orderAllAction;
import fooba.action.restaurant.res_orderCompleteAction;
import fooba.action.restaurant.res_qnalist_footerAction;
import fooba.action.restaurant.res_restaurantRestAction;
import fooba.action.restaurant.res_restaurantReturnAction;
import fooba.action.restaurant.res_reviewAction;
import fooba.action.restaurant.res_reviewReplyWriteAction;
import fooba.action.restaurant.res_showAction;
import fooba.action.restaurant.res_updateAction;
import fooba.action.restaurant.res_withdrawalAction;

public class ActionFactory {
	
	private ActionFactory() {}
	private static ActionFactory itc=new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	public Action getAction(String command) {
		Action ac=null;
		
		// main 로그인, 로그아웃
		if(command.equals("index")) ac=new indexAction(); // 메인화면 표시
		else if(command.equals("loginForm"))ac=new loginFormAction();
		else if (command.equals("login")) ac = new loginAction();
		else if (command.equals("logout")) ac = new logoutAction();
		else if (command.equals("miniLoginForm")) ac = new miniLoginFormAction(); //팝업
		else if (command.equals("miniLogin")) ac = new miniLoginAction();
		else if (command.equals("search")) ac = new searchAction();// 검색 후 가게 리스팅
		else if (command.equals("category")) ac = new categoryAction();// 카테고리별 가게 리스팅
		else if (command.equals("restaurantDetail")) ac = new restaurantDetailAction();// 가게 클릭시 가게 소개 및 메뉴 리스팅
		else if (command.equals("fooba_tos")) ac = new fooba_tosAction();
		else if (command.equals("fooba_privacy")) ac = new fooba_privacyAction();
		else if (command.equals("memberQnalist")) ac = new memberQnalistAction();
		else if (command.equals("memberFindIdForm")) ac = new memberFindIdFormAction();
		else if (command.equals("memberFindId")) ac = new memberFindIdAction(); // 아이디 찾기
		else if (command.equals("memberFindPwForm")) ac = new memberFindPwFormAction();// 비밀번호 찾기
		else if (command.equals("memberFindPw")) ac = new memberFindPwAction();
		// member 멤버
		else if (command.equals("memberJoinForm")) ac = new memberJoinFormAction();
		else if (command.equals("memberIdCheckForm")) ac = new memberIdCheckFormAction();
		else if (command.equals("memberFindZipNum")) ac = new memberFindZipNumAction();
		else if (command.equals("memberJoin")) ac = new memberJoinAction();
		//카트담기 및 메뉴주문
		else if (command.equals("menupopup")) ac= new menupopupAction(); //메뉴 팝업창
		else if (command.equals("jangbaguni")) ac= new jangbaguniAction(); //메뉴 팝업창
		else if (command.equals("deleteCartmenu"))ac=new deleteCartmenuAction();
		else if (command.equals("orderForm")) ac = new orderFormAction();// 주문하기 폼
		else if(command.equals("order")) ac = new orderAction();
		// 마이페이지 (회원정보, 주문내역확인, 리뷰작성)
		else if (command.equals("memberUpdateForm")) ac = new memberUpdateFormAction();
		else if (command.equals("memberUpdate")) ac = new memberUpdateAction();
		else if (command.equals("memberWithdrawal")) ac = new memberWithdrawalAction();
		else if (command.equals("memberOrderList")) ac = new memberOrderListAction();// 진행중인 주문 내역
		else if (command.equals("memberOrderAll")) ac = new memberOrderAllAction();// 전체 주문 내역
		else if (command.equals("memberOrderDetail")) ac = new memberOrderDetailAction();// 주문 번호별 상세 내역
		else if (command.equals("memberReviewWrite")) ac = new memberReviewWriteAction();// 별점 및 리뷰 작성된 내용 저장
		// restaurant 가입-정보-수정 액션
		// 가게정보, 주문관리, 메뉴관리, 리뷰관리, 가게미리보기
		else if (command.equals("res_loginForm")) ac=new res_loginFormAction();
		else if (command.equals("res_login")) ac = new res_loginAction();
		else if (command.equals("res_logout")) ac = new res_logoutAction();
		else if (command.equals("res_FindIdForm")) ac = new res_FindIdFormAction();
		else if (command.equals("res_FindId")) ac = new res_FindIdAction();
		else if (command.equals("res_FindPwForm")) ac = new res_FindPwFormAction();
		else if (command.equals("res_FindPw")) ac = new res_FindPwAction();
		else if (command.equals("res_show")) ac = new res_showAction();// 가게 미리보기
		else if (command.equals("res_joinForm")) ac = new res_joinFormAction();
		else if (command.equals("res_idCheckForm")) ac = new res_idCheckFormAction();
		else if (command.equals("res_findZipNum")) ac = new res_findZipNumAction();
		else if (command.equals("res_join")) ac = new res_joinAction();
		else if (command.equals("res_editForm")) ac = new res_editFormAction();
		else if (command.equals("res_Update")) ac = new res_updateAction();
		else if (command.equals("res_withdrawal")) ac = new res_withdrawalAction();
		// 리뷰
		else if (command.equals("res_review")) ac = new res_reviewAction();// 리뷰 탭
		else if (command.equals("res_reviewReplyWrite")) ac = new res_reviewReplyWriteAction();// 답글 달기
		// 주문관리
		else if (command.equals("res_order")) ac = new res_orderAction();// 주문 관리 탭, 주문리스트 표시
		else if (command.equals("res_orderAll")) ac = new res_orderAllAction();
		else if (command.equals("res_orderComplete")) ac = new res_orderCompleteAction();// 배달완료 처리
		// 메뉴
		else if (command.equals("res_foodmenu")) ac = new res_foodmenuAction();// 메뉴 리스트
		else if (command.equals("res_foodmenuUpdateForm")) ac = new res_foodmenuUpdateFormAction();
		else if (command.equals("res_foodmenuUpdate")) ac = new res_foodmenuUpdateAction();// 메뉴 업데이트
		else if (command.equals("res_foodmenuAddForm")) ac = new res_foodmenuAddFormAction();
		else if (command.equals("res_foodmenuAdd")) ac = new res_foodmenuAddAction();// 메뉴 추가
		else if (command.equals("res_foodmenuDelete")) ac = new res_foodmenuDeleteAction();// 메뉴 삭제
		else if(command.equals("res_fooba_tos"))ac=new res_fooba_tosAction();
		else if(command.equals("res_fooba_privacy"))ac=new res_fooba_privacyAction();		
		else if (command.equals("res_qnalist_footer")) ac = new res_qnalist_footerAction();
		else if(command.equals("res_restaurantRest"))ac = new res_restaurantRestAction();	//휴업으로 변경
		else if(command.equals("res_restaurantReturn"))ac=new res_restaurantReturnAction();//영업으로 변경
		// admin 액션
		else if (command.equals("admin_loginForm")) ac = new admin_loginFormAction(); // admin 로그인창 
		else if (command.equals("admin_login")) ac = new admin_loginAction(); // 로그인 명령
		else if (command.equals("admin_logout")) ac = new admin_logoutAction();
		else if (command.equals("admin_restaurantList")) ac = new admin_restaurantListAction(); // 가게관리 result 1 운영 가능 가게 
		else if (command.equals("admin_restaurantOk")) ac = new admin_restaurantOkAction(); // 가게관리 result 0 가입신청한 가게
		else if (command.equals("admin_restaurantKick")) ac = new admin_restaurantKickAction(); // 가게관리 result 2 퇴출된 가게
		else if (command.equals("admin_restaurantDetail")) ac = new admin_restaurantDetailAction(); // 상세페이지 -채이진
		else if (command.equals("admin_memberList")) ac = new admin_memberListAction(); // 회원관리 - 리스트옆에 방출버튼
		else if (command.equals("admin_orderList")) ac = new admin_orderListAction();
		else if (command.equals("admin_orderList_lb")) ac = new admin_orderList_lbAction();
		else if (command.equals("admin_orderList_rb")) ac = new admin_orderList_rbAction();
		else if (command.equals("admin_qnaList")) ac = new admin_qnaListAction(); // qna 리스트  고객이 보는모습
		else if (command.equals("admin_qnaView")) ac = new admin_qnaViewAction(); // qna 상세 보기  고객이 보는모습
		else if (command.equals("admin_qnaWriteForm")) ac = new admin_qnaWriteFormAction(); // 작성 폼  밑으로 admin
		else if (command.equals("admin_qnaWrite")) ac = new admin_qnaWriteAction(); // 작성 명령
		else if (command.equals("admin_qnaUpdateForm")) ac = new admin_qnaUpdateFormAction(); // 수정 폼
		else if (command.equals("admin_qnaUpdate")) ac = new admin_qnaUpdateAction(); // 수정명령
		else if (command.equals("admin_qnaDelete")) ac = new admin_qnaDeleteAction(); // 삭제
		else if(command.equals("admin_fooba_tos"))ac=new admin_fooba_tosAction();
		else if(command.equals("admin_fooba_privacy"))ac=new admin_fooba_privacyAction();
		 
		
		return ac;
	}

	
}
