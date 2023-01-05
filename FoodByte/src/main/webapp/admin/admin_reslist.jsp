<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="admin_header.jsp"%>
 
 <article>
    <h2 class="admin_list">가게 리스트</h2>   
    <br> 
    <form name="frm" method="post">
        <table id="admin_searchres">
            <tr>
                <td style="font-size:17px; width:642;">가게명: <input class="keyy" type="text" name="key" value="${key}">
                    <input class="admin_searchres_btn" type="button" name="btn_search" value="검색" 
                        onClick="go_search( 'admin_restaurantList' );">
                    <input class="admin_searchres_btn" type="button" name="btn_total" value="전체보기 " 
                        onClick="go_total( 'admin_restaurantList' );">
                    <input class="admin_searchres_btn" type="button" name="btn_write" value="가게등록"  onClick="go_wrt();">
                </td>
            </tr>
        </table><br>
        <table id="admin_list_table">
            <tr><th>번호</th><th>가게명</th><th>가입현황</th></tr>       
        <c:forEach items="${resList}" var="RestaurantVO">
                <tr>
                    <td height="23" align="center">${RestaurantVO.rseq}</td>
                    <td style="text-align:left; padding-left:40px;">
                        <a style="text-decoration-line: none;"href="#" onClick="go_detail('${RestaurantVO.rseq}');">${RestaurantVO.rname}</a>
                    </td>
                    <td style=text-align:center;>
                        <c:choose>
                              <c:when test='${RestaurantVO.ryn=="0"}'>신청</c:when>
                                <c:otherwise>신청안함  </c:otherwise>
                            </c:choose>
                    </td> 
                </tr>
            </c:forEach>
            </table>
	</form>
		<div class="clear"></div>
</article>
<br>
<jsp:include page="/admin/paging/paging.jsp">
<jsp:param name="command" value="fooba.do?command=admin_restaurantList" />
</jsp:include>	
<br><br><br><br><br><br><br><br><br><br><br>

<%@ include file="admin_footer.jsp"%>

