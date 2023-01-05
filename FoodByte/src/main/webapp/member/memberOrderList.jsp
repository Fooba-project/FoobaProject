<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="mypage_sub.jsp"%>

<div id="memberOrderList">
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
        <c:forEach items="${memberOrderList }" var="ovo">
            <tr>
                <td>
                    ${ovo.rname }
                </td>
                <td>
                    ${ovo.oname }
                </td>
                <td>
                    ${ovo.totalprice }
                </td>
                <td>
                    <fmt:formatDate value="${ovo.indate }" type="date"/>
                </td>
                <td>
                    <c:choose>
                    	<c:when test="${ovo.result==0}">
                    		주문확인중
                    	</c:when>
                    	<c:when test="${ovo.result==1}">
                    		배송중
                    	</c:when>
                    	<c:when test="${ovo.result==2}">
                    		배송완료
                    	</c:when>
                    </c:choose>                  
                </td>
            </tr>
        </c:forEach>
    </table>
</article>

<jsp:include page="paging/paging.jsp">
	<jsp:param name="command" value="fooba.do?command=memberOrderList"/>
</jsp:include>	
</div>
<%@ include file="../footer.jsp"%>
