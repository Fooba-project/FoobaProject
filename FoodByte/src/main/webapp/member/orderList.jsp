<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<nav id="sub_menu">
    <ul>
        <li><a href="fooba.do?command=memberOrderList">진행중인 주문내역</a></li>
        <li><a href="fooba.do?command=memberOrderAll">총 주문내역</a></li>		
        <li><a href="fooba.do?command=memberUpdateForm">회원정보수정</a></li>
        <li><a onclick="withdrawalMember()" a href="#">회원탈퇴</a></li>
    </ul>
</nav>

<article  id="orderArticle">
    <h2>진행중인 주문내역</h2>
    <hr><br>
    <table id="memberOrderList">
        <tr>
            <th width="80">가게명</th>
            <th width="200">주문메뉴</th>
            <th width="80">주문금액</th>
            <th width="70">주문일</th>
            <th width="80">진행상태</th>
        </tr>
        <c:forEach items="${orderList }" var="orderVO">
            <tr>
                <td>
                    가게
                </td>
                <td>
                    메뉴
                </td>
                <td>
                    금액
                </td>
                <td>
                    주문일
                </td>
                <td>
                    주문확인중
                </td>
                <!-- <td><a href="fooba.do?command=memberOrderDetail&oseq=${orderVO.oseq }">
                <h3>${orderVO.pname }</h3></a></td>
                <td>${orderVO.quantity }</td>
                <td><fmt:formatNumber value="${orderVO.price2*orderVO.quantity }" type="currency"/></td>
                <td><fmt:formatDate value="${orderVO.indate }" type="date"/></td>
                <td>처리 진행중</td> -->
            </tr>
        </c:forEach>
        
    </table>
</article>

<%@ include file="../footer.jsp"%>