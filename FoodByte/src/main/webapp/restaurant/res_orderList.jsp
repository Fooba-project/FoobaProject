<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/restaurant/res_header.jsp"%>

<div id="res_main">
        <div id="res_name">${RestaurantVO.rname}</div>
        
        <div id="res_info">
           		<img class="res_logo"src="images/title/${RestaurantVO.rimage}" ></img>
         
            <div id="res_basic">
            <a class="res_total">★★★★☆</a> 4.4<br>
            <a class="basic">배달팁</a>&nbsp;&nbsp;  1000원<br>
            <a class="basic">결제</a>&nbsp;&nbsp; 신용카드, 현금<br>            
            <a class="basic">해시태그</a>&nbsp;&nbsp; #건강푸드<br>
            </div>
        </div>
        
        <br>
        <div id="res_tab">
            <div class="res_infotab" style="color:white; width:700px;" >주문 현황</div>      
        </div>
        
        <div id="res_menuall">
            <div id="res_menuinfo">
            <table id="resOrderList">
            	 <c:forEach items="${res_OrderList}" var="ovo">
                    <tr>
                        <td width="80">       
                        	<div id="memberOrderListimg" style="text-align:center; font-weight:bold;">
                               주문번호: <br>${ovo.oseq} <img src="images/order.png" style="width:20px;" 
                               onclick="location.href='fooba.do?command=memberOrderDetail&oseq=${ovo.oseq}'">
                            </div>                 
                            <div>${ovo.rname}</div>
                        </td>
                        <td width="300">
                            <div id="res_OrderListIntime" style="text-align: left; font-size: 70%; margin: 10px; ">
                               <h2><fmt:formatDate value="${ovo.indate}" type="date" pattern="(a)hh:mm" /></h2>
                            </div>
                            <div id="res_OrderListMenu" style="text-align: left; margin: 10px;">
                                ${ovo.oname }
                            </div>
                            <div id="res_OrderListPrice" style="text-align: left; margin: 10px;">
                                 <fmt:formatNumber value="${ovo.totalprice }" pattern="#,###"/>원
                            </div>
                        </td>
                        <td width="80">
                            <div id="res_OrderListStatement" style="margin: 10px;" >
                  				
	                            <c:choose>
			                    	<c:when test="${ovo.result==0}">
			                    		주문확인중
			                    	</c:when>
			                    	<c:when test="${ovo.result==1}">
			                    		배달중
			                    	</c:when>
			                    	<c:when test="${ovo.result==2}">
			                    		배달완료
			                    	</c:when>
			                    	<c:when test="${ovo.result==3}">
			                    		후기작성완료
			                    	</c:when>
		                    	</c:choose>	
		                    	
                            </div>
                            <div id="res_OrderListDetail" style="margin: 10px;" >
                                <input type="button" value="주문상세" id="res_OrderResultButton" 
                                onclick="location.href='fooba.do?command=resultAdd'" />                             
                            </div>            
                        </td>
                    </tr>
                </c:forEach>
                </table>
            </div>


            
        </div>
        
    </div>

<%@ include file="/restaurant/res_footer.jsp"%>