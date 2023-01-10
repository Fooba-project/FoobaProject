<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/restaurant/res_header.jsp"%>

<div id="res_main">
	<div id="res_name">${RestaurantVO.rname}</div>        
        <div id="res_info">
           		<img class="res_logo"src="images/title/${RestaurantVO.rimage}" ></img>
         
            <div id="res_basic">
            <a class="basic">배달팁</a>&nbsp;&nbsp;  ${RestaurantVO.rtip}<br>
            <a class="basic">결제</a>&nbsp;&nbsp; 신용카드, 현금<br>            
            <a class="basic">해시태그</a>&nbsp;&nbsp; ${RestaurantVO.hash}<br>
            </div>
        </div>
        
        <br>
        <div id="res_tab">
            <div class="res_infotab">전체(전체 카운트)</div>      
            <div class="res_infotab" >미답변(미답변 카운트)</div>
		</div>
	
		<div id="res_menuall_a">
                <div id="res_menuinfo">
                    <c:forEach items="${ReviewList}" var="ReviewVO">
                        <table id="review_table">
                            <tr>
                                <td><div id="nick_img"></div></td>&nbsp;
                                <td><h3>닉네임</h3></td>&nbsp;
                                <td><h4>★★★★ 4.0</h4></td>
                                <td> <h5><fmt:formatDate value="${ReviewVO.indate}" type="date" pattern="MM-dd"/></h5></td>                                
                            </tr>
                            <tr>
                                <td colspan="4">
                                    이미지가 들어갈 것이다
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    리뷰가 들어갈 것이다
                                </td>
                            </tr>
                            <!-- 여기는 if문 -->
                            <tr>
                            <c:if test="${ReviewVO.replyyn==0}">
                                <textarea name="rev_res" rows="5" cols="50" style="border-radius:10px;"> </textarea>
                            </c:if>
                            <c:if test="${ReviewVO.replyyn==1}">
                                <td><div id="nick_sa"></div></td>&nbsp;
                                    <td><h3>사장님</h3></td>&nbsp;
                                    ${ReviewVO.reply}
                            </c:if>
                            </tr>
                        </table><hr>
                    </c:forEach>
                </div>    
            </div>
	
</div>

<%@ include file="/restaurant/res_footer.jsp"%>