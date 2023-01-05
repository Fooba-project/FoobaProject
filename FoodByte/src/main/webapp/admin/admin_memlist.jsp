<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="admin_header.jsp"%>

 
<article>
    <h2 class="admin_list">회원 리스트</h2>   
    <br> 
    <form name="frm" method="post">
        <table id="admin_searchres">
            <tr>
                <td style="font-size:17px; width:642;">회원 ID: <input class="keyy" type="text" name="key" value="${key}">
                    <input class="admin_searchres_btn" type="button" name="btn_search" value="검색" 
                        onClick="go_search( 'admin_restaurantList' );">
                    <input class="admin_searchres_btn" type="button" name="btn_total" value="전체보기 " 
                        onClick="go_total( 'admin_restaurantList' );">
                    <input class="admin_searchres_btn" type="button" name="btn_write" value="회원등록"  onClick="go_wrt();">
                </td>
            </tr>
        </table><br>
        <table id="admin_list_table">
            <tr><th>회원 ID</th><th>회원 닉네임</th><th>전화번호</th><th>이메일</th><th>가입날짜</th><th>회원정보삭제</th></tr>       
        <c:forEach items="${memberList}" var="MemberVO">
                <tr>
                    <td style="text-align:center;">${MemberVO.id}</td>
                    <td style="text-align:center;">${MemberVO.nick}</td>
                    <td style="text-align:center;">${MemberVO.phone}</td>
                    <td style="text-align:center;">${MemberVO.email}</td>                    
                    <td style=text-align:center;><fmt:formatDate value="${MemberVO.indate}"/></td> 
                    <td style="text-align:center;"><input type="button" value="탈퇴"></td>
                </tr>
         </c:forEach>
         </table>
	</form>
		<div class="clear"></div>
</article>
<br>
<jsp:include page="/admin/paging/paging.jsp">
<jsp:param name="command" value="fooba.do?command=admin_memberKick"/>
</jsp:include>	
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

<%@ include file="admin_footer.jsp"%>