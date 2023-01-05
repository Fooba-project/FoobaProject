<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="admin_header.jsp"%>

 <article>
    <h2 class="admin_list">가게 리스트</h2>   
    <br> 
    <form name="frm" method="post">
        <table id="admin_searchres">
            <tr>
                <td width="642">가게명: <input type="text" name="key" value="${key}">
                    <input class="admin_searchres_btn" type="button" name="btn_search" value="검색" 
                        onClick="go_search( 'adminRestaurantList' );">
                    <input class="admin_searchres_btn" type="button" name="btn_total" value="전체보기 " 
                        onClick="go_total( 'adminRestaurantList' );">
                    <input class="admin_searchres_btn" type="button" name="btn_write" value="가게등록"  onClick="go_wrt();">
                </td>
            </tr>
        </table><br>
        <table id="admin_list_table">
            <tr><th>번호</th><th>가게명</th><th>가입현황</th></tr>       
        <c:forEach items="${restaurantList}" var="RestaurantVO">
                <tr>
                    <td height="23" align="center">${RestaurantVO.rseq}</td>
                    <td style="text-align:left; padding-left:50px;">
                        <a href="#" onClick="go_detail('${RestaurantVO.rseq}');">${RestaurantVO.rname}</a>
                    </td>
                    <td>
                        <c:choose>
                              <c:when test='${RestaurantVO.ryn=="N"}'>신청안함</c:when>
                                <c:otherwise>신청</c:otherwise>
                            </c:choose>
                        </td> 
                </tr>
            </c:forEach>
            </table>
	</form>
</article>


<%@ include file="admin_footer.jsp"%>

