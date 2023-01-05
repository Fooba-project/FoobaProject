<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="admin_header.jsp"%>

<article>
    <h2 class="admin_list">주문 리스트</h2>   
    <br> 
    <form name="frm" method="post">
        <table id="admin_searchres">
            <tr>
                <td width="642">주문 번호: <input type="text" name="key" value="${key}">
                    <input class="admin_searchres_btn" type="button" name="btn_search" value="검색" 
                        onClick="go_search( 'admin_restaurantList' );">
                    <input class="admin_searchres_btn" type="button" name="btn_total" value="전체보기 " 
                        onClick="go_total( 'admin_restaurantList' );">
                </td>
            </tr>
        </table><br>
        <table id="admin_list_table">
            <tr><th>주문번호</th><th>주문자 ID</th><th>가게이름</th><th>가격</th><th>주문시간</th>      
        <c:forEach items="${orderList}" var="OrderViewVO">
                <tr>
                    <td style="text-align:center;">${OrderViewVO.oseq}</td>
                    <td style="text-align:center;">${OrderViewVO.id}</td>
                    <td style="text-align:center;">${OrderViewVO.rname}</td>
                    <td style="text-align:center;">${OrderViewVO.totalprice}</td>                    
                    <td style="text-align:center;"><fmt:formatDate value="${OrderViewVO.indate}"/></td> 
                </tr>
         </c:forEach>
         </table>
	</form>
		<div class="clear"></div>
</article>
<br>
<jsp:include page="/admin/paging/paging.jsp">
<jsp:param name="command" value="fooba.do?command=admin_orderList"/>
</jsp:include>	
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<%@ include file="admin_footer.jsp"%>