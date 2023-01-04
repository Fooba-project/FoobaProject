<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="admin_header.jsp"%>


    <h2 class="admin_list">가게 리스트</h2>
    <nav id="sub_menu">
        <ul>
            <li><a href='fooba.do?command=admin_restaurantList&start=Y'>가게리스트</a></li>
            <li><a href='fooba.do?command=admin_memberKick&start=Y'>회원리스트</a></li>
            <li><a href='fooba.do?command=admin_orderList&page=1&key='>주문리스트</a></li>
            <li><a href='fooba.do?command=admin_qnaList&page=1&key='>Q&ampA리스트</a></li>
        </ul>
    </nav>
    
    <br>
    <article>
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
            <tr>
                <td>1</td><td>bbq</td><td>0</td>          
            </tr>
            <tr>
                <td>2</td><td>bbq</td><td>0</td>     
            </tr>
            <tr>
                <td>3</td><td>bbq</td><td>0</td>       
            </tr>
            <tr>
                <td>4</td><td>bbq</td><td>0</td>     
            </tr>
            

            
        </table>
        <!-- <c:forEach items="${productList}" var="productVO">
                <tr>
                    <td height="23" align="center">${productVO.pseq}</td>
                    <td style="text-align:left; padding-left:50px;">
                        <a href="#" onClick="go_detail('${productVO.pseq}');">${productVO.name}</a>
                    </td>
                    <td><fmt:formatNumber value="${productVO.price1}"/></td>
                    <td><fmt:formatNumber value="${productVO.price2}"/></td>
                    <td><fmt:formatDate value="${productVO.indate}"/></td>
                    <td>
                        <c:choose>
                              <c:when test='${productVO.useyn=="N"}'>미사용</c:when>
                                <c:otherwise>사용</c:otherwise>
                            </c:choose>
                        </td> 
                </tr>
            </c:forEach>-->


</article>








<%@ include file="admin_footer.jsp"%>

