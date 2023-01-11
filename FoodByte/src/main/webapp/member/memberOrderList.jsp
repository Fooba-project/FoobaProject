<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="mypage_sub.jsp"%>

<div id="memberOrderListdiv">
		<article  id="orderArticle">
			<h2>
	            ${memberOrderListT } 주문내역
	         </h2>
            <hr><br>
            <table id="memberOrderList">
                <c:forEach items="${memberOrderList }" var="ovo">
                    <tr  >
                        <td width="80">
                            <div id="memberOrderListimg">
                                <a href="fooba.do?command=restaurantDetail&rseq=${ovo.rseq }"><img src="images/title/${ovo.rimage }" width="80" height="80"></a>
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
                                 <fmt:formatNumber value="${ovo.totalprice }" pattern="#,###"/>원
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
			                    	<c:when test="${ovo.result==3}">
			                    		후기작성완료
			                    	</c:when>
		                    	</c:choose>	
                            </div>
                            <div id="memberOrderListDetail" margin="10" >
                                <input type="button" value="주문상세" id="memberOrderDetailButton" onclick="location.href='fooba.do?command=memberOrderDetail&oseq=${ovo.oseq}'"/>
                            </div>            
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </article>
<c:if test="${orderList=='ing'}">
<jsp:include page="paging/paging.jsp">
	<jsp:param name="command" value="fooba.do?command=memberOrderList"/>
</jsp:include>
</c:if>
<c:if test="${orderList=='all'}">
<jsp:include page="paging/paging.jsp">
	<jsp:param name="command" value="fooba.do?command=memberOrderAll"/>
</jsp:include>
</c:if>
</div>
<%@ include file="../footer.jsp"%>
