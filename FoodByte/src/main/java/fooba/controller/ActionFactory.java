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
import fooba.action.res_info.res_infoAction;
import fooba.action.restaurant.res_loginAction;

public class ActionFactory {
	
	private ActionFactory() {}
	private static ActionFactory itc=new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	public Action getAction(String command) {
		Action ac=null;
//		
//		request.getRequestDispatcher(fooba.do?command=index).forward(request, response);
		
		
		// member ����, �α���, �α׾ƿ� �� �⺻���
		if(command.equals("index")) ac=new indexAction(); // ����ȭ�� ǥ��
		else if(command.equals("loginForm"))ac=new loginFormAction();
		else if (command.equals("login")) ac = new loginAction();
		else if (command.equals("logout")) ac = new logoutAction();
		else if (command.equals("contract")) ac = new contractAction();
		else if (command.equals("joinForm")) ac = new joinFormAction();
		else if (command.equals("idCheckForm")) ac = new idCheckFormAction();
		else if (command.equals("findZipNum")) ac = new findZipNumAction();
		else if (command.equals("join")) ac = new joinAction();

		// ���������� ȸ������, �ֹ�����Ȯ��, �����ۼ� ��
		else if (command.equals("mypage")) ac = new mypageAction();
		else if (command.equals("editForm")) ac = new editFormAction();
		else if (command.equals("memberUpdate")) ac = new memberUpdateAction();
		else if (command.equals("withdrawalMember")) ac = new withdrawalMemberAction();
		else if (command.equals("orderList")) ac = new orderListAction();// �������� �ֹ� ����
		else if (command.equals("orderAll")) ac = new orderAllAction();// ��ü �ֹ� ����
		else if (command.equals("orderDetail")) ac = new orderDetailAction();// �ֹ� ��ȣ�� �� ����
		
		
		//���� review yn, order_view�� review������
		else if (command.equals("reviewWriteForm")) ac = new reviewWriteFormAction();// ���� �� ���� �ۼ��������� �̵�
		else if (command.equals("reviewWrite")) ac = new reviewWriteAction();// ���� �� ���� �ۼ��� ���� ����
		
		
		
		// food_cart �׼�
		// ��ٱ��ϳֱ�, ����, ����, �ֹ��ϱ�,
		else if (command.equals("search")) ac = new searchAction();// �˻� �� ���� ������
		else if (command.equals("category")) ac = new categoryAction();// ī�װ��� ���� ������
		else if (command.equals("foodDetail")) ac = new foodDetailAction();// ���� Ŭ���� ���� �Ұ� �� �޴� ������
		else if (command.equals("cartInsert")) ac = new cartInsertAction();// īƮ�� ���
		else if (command.equals("cartDelete")) ac = new cartDeleteAction();// īƮ���� ����
		else if (command.equals("orderInsert")) ac = new orderInsertAction();// �ֹ��ϱ�
		
		// restaurant ����-����-���� �׼�
		// ��������, �ֹ�����, �޴�����, �������, ���Թ̸�����
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
		
		// ������� ����
		else if (command.equals("res_info")) ac = new res_infoAction();// �α��� �� ������� ���������� ����
		// ����
		else if (command.equals("res_review")) ac = new res_reviewAction();// ���� ��
		else if (command.equals("res_reviewReplyWrite")) ac = new res_reviewReplyWriteAction();// ��� �ޱ�
		// �ֹ�����
		else if (command.equals("res_order")) ac = new res_orderAction();// �ֹ� ���� ��, �ֹ�����Ʈ ǥ��
		else if (command.equals("res_orderComplete")) ac = new res_orderCompleteAction();// ��ۿϷ� ó��
		// �޴�
		else if (command.equals("res_menu")) ac = new res_menuAction();// �޴� ����Ʈ
		else if (command.equals("res_menuUpdateForm")) ac = new res_menuUpdateFormAction();
		else if (command.equals("res_menuUpdate")) ac = new res_menuUpdateAction();// �޴� ������Ʈ
		else if (command.equals("res_menuAddForm")) ac = new res_menuAddFormAction();
		else if (command.equals("res_menuAdd")) ac = new res_menuAddAction();// �޴� �߰�
		else if (command.equals("res_menuDelete")) ac = new res_menuDeleteAction();// �޴� ����
		// ������� �̸�����
		else if (command.equals("res_show")) ac = new res_showAction();// ���� �̸�����
		

		// qna �׼�(������ - ���ֹ��� ����)
		else if (command.equals("qnaList")) ac = new qnaListAction(); // qna ����Ʈ  ���� ���¸��
		else if (command.equals("qnaView")) ac = new qnaViewAction(); // qna �� ����  ���� ���¸��
		
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
		
		// admin �׼�
		else if (command.equals("admin")) ac = new adminAction(); // admin �α���â 
		else if (command.equals("adminLogin")) ac = new adminLoginAction(); // �α��� ���
		else if (command.equals("adminLogout")) ac = new adminLogoutAction();
		else if (command.equals("adminRestaurantList")) ac = new adminRestaurantListAction(); // ���԰��� result 1
		else if (command.equals("adminRestaurantOk")) ac = new adminRestaurantOkAction(); // ���԰��� result 0
		else if (command.equals("adminRestaurantKick")) ac = new adminRestaurantKickAction(); // ���԰��� result 2
		else if (command.equals("adminMemberKick")) ac = new adminMemberKickAction(); // ȸ������ - ����Ʈ���� �����ư
		//else if (command.equals("adminMemberList")) ac = new adminMemberListAction();   //KickAction����
		//else if (command.equals("adminProductDetail")) ac = new adminProductDetailAction();
		//else if (command.equals("adminProductUpdateForm")) ac = new adminProductUpdateFormAction();
		//else if (command.equals("adminProductUpdate")) ac = new adminProductUpdateAction();
		else if (command.equals("adminOrderList")) ac = new adminOrderListAction();
		//else if (command.equals("adminOrderSave")) ac = new adminOrderSaveAction();
		//else if (command.equals("adminQnaDetail")) ac = new adminQnaDetailAction();
		//else if (command.equals("adminQnaRepSave")) ac = new adminQnaRepSaveAction();
		
		else if (command.equals("adminQnaList")) ac = new adminQnaListAction();
		else if (command.equals("qnaWriteForm")) ac = new qnaWriteFormAction(); // �ۼ� ��  ������ admin
		else if (command.equals("qnaWrite")) ac = new qnaWriteAction(); // �ۼ� ���
		else if (command.equals("qnaUpdateForm")) ac = new qnaUpdateFormAction(); // ���� ��
		else if (command.equals("qnaUpdate")) ac = new qnaUpdateAction(); // �������
		else if (command.equals("qnaDelete")) ac = new qnaDeleteAction(); // ����
		
		
		
		
		return ac;
	}

	
}
