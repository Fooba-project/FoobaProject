<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="mypage_sub.jsp"%>

<div id="memberOrderListdiv">
		<article  id="orderArticle">
            <h2>진행중인 주문내역</h2>
            <hr><br>
            <table id="memberOrderList">

                <c:forEach items="${memberOrderList }" var="ovo">
                    <tr  >
                        <td width="80">
                            <div id="memberOrderListimg">
                                <img src="images/foodmenu/${ovo.fimage }" width="50" height="50">
                            </div>
                            <div>${ovo.rname }</div>
                        </td>
                        <td width="300">
                            <div id="memberOrderListIntime" style="text-align: left; font-size: 70%; margin: 10px;">
                                <fmt:formatDate value="${ovo.indate }" type="date"/>
                            </div>
                            <div id="memberOrderListMenu" style="text-align: left; margin: 10px;">
                                ${ovo.oname }
                            </div>
                            <div id="memberOrderListPrice" style="text-align: left; margin: 10px;">
                                ${ovo.totalprice } 원
                            </div>
                        </td>
                        <td width="80">
                            <div id="memberOrderListStatement" style="margin: 10px">
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
                            </div>
                            <div id="memberOrderListDetail" margin="10" >
                                <a href="#">주문 상세</a>
                            </div>            
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
