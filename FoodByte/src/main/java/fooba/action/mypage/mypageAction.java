package fooba.action.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fooba.VO.MemberVO;
import fooba.action.Action;

public class mypageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="mypage/mypage.jsp";
		HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("loginUser");
		if(mvo==null) {
			url="fooba.do?command=loginForm";
		}else {
			/*
			//mypage.jsp �� ���� ���޵ż� ȭ�鿡 ������ ����Ʈ ����
			ArrayList<OrderViewVO> finalList = new ArrayList<>();
			//(finalList.get(0).getName() -> "xxxx�� 2��")
			
			//�������� �ֹ� ����
			//���� �α��� �� ������� ���� ��۾ȵ� �ֹ������� ��������.
			//���� ��� �ѹ��� 2,3���� ��ǰ�� 3ȸ�� ���ļ� �ֹ��� ���¶��.... �׸��� �� �ֹ����� �ϳ��� ����� �ȵ� ����(�����)�̶��
			//�������� �ֹ������� 3���� ǥ�õȴ�.(orders���̺� ���� �ֹ� �Ǻ� ǥ��)
			//ǥ�ó����� �ֹ��Ǻ� ��ǥ��ǰ�� �̸��� �̿��Ͽ� 	������ ����3, �ܿ����� �� 2... ����� �������� ��3���� ǥ�õȴ�.
			//�׸��� �� �࿡�� �󼼺��� ��ư�� �־ Ŭ���ϸ� �� �ֹ��� ���� ������ ��ǰ�� �� �� �ִ�.
			
			//�̸� ���ؼ� ���� ���� �ʿ��� ������ �ֹ���ȣ�� �̴�
			//order_view ���� �ֹ��� ���̵�� �˻��ϰ�, result�� 1�� �ֹ����� �˻��ؼ�, �ֹ���ȣ���� ��ȸ�Ѵ�.
			//���� ���� �� ���¶�� �ֹ���ȣ���� ������ ����.
			//22 22 22  24 24 24  26 26 26  27 27 27 <-��ȸ�� �ֹ� ��ȣ��
			
			//�׷��� ���� �츮���� �ʿ��Ѱ� 22 25 26 27 �̹Ƿ�, ��ȸ�Ҷ� distinct Ű���带 �Ἥ ��ȸ�� �´�.
			//select distinct oseq from order_viiew where id=? and result='1'
			//�ֹ���ȣ(oseq)�� ��ȸ�Ҳ���� orders ���̺��� distinct ���� ��ȸ�ϸ� �ɵ� ������
			//orders ���̺��� result �ʵ尡 ��� ����� �ֹ��� ���е� ��ȣ�� ��ȸ�� ���� �ʴ´�.
			
			//�ߺ��� ���� �����(ó����) �ֹ���ȣ���� ��ȸ�Ѵ�.
			OrderDao odao=OrderDao.getInstance();
			ArrayList<Integer> oseqList=odao.selectOseqOrderIng(mvo.getId());
			
			//��ȸ�� �ֹ���ȣ��� �ݺ������Ѵ�.
			for(Integer oseq : oseqList) {
				//���� �ֹ� ��ȣ�� �ֹ����� ��ȸ
				ArrayList<OrderViewVO> orderListByOseq=odao.selectOrdersByOseq(oseq);
					
				//��ȸ�� �ֹ�����Ʈ�� ������ ��ǰ�� �ִٸ�
				//ù��° ��ǰ�� ������
				OrderViewVO ovo=orderListByOseq.get(0);
					
				//���� ��ǰ�� �̸��� "�����ǰ�̸� ���� X��" ���� �����Ѵ�
				ovo.setPname(ovo.getPname()+" ���� "+orderListByOseq.size()+"��");
				ovo.setResult("4"); //��ǥ��ǰ�� ����� "����Ȯ��"���� ����
				//������ �ѱݾ��� ����� ��
				int totalPrice=0;
				for(OrderViewVO ovo1 : orderListByOseq) {
					totalPrice+=ovo1.getPrice2()*ovo1.getQuantity();
					if(!ovo1.getResult().equals("4"))
						ovo.setResult(ovo1.getResult());
					//�ֹ��� ���Ե� ��ǰ�� ����� �ϳ��� ��ȸ�ؼ� 4�� �ƴϸ� ��ǥ��ǰ�� ����� �����ǰ�� ���������
				}
				//ovo��ü�� price2 �� �տ��� ����� �� �ݾ����� �����Ѵ�
				ovo.setPrice2(totalPrice);
				
				//��� ������ ��ģ ovo�� finalList�� ��´�
				finalList.add(ovo);
			}
			request.setAttribute("orderList", finalList);
			request.setAttribute("title","���� ���� �ֹ� ����");
			*/
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}


