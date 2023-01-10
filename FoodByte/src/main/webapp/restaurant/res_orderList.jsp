<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/restaurant/res_header.jsp"%>

<div id="res_main">
        <div id="res_name">${RestaurantVO.rname}</div>
        
        <div id="res_info">
           		<img class="res_logo"src="images/title/${RestaurantVO.rimage}" ></img>
         
            <div id="res_basic">
            <a class="res_total">★★★★☆</a> 4.4<br>
            <a class="basic">배달팁</a>&nbsp;&nbsp;  ${RestaurantVO.rtip}<br>
            <a class="basic">결제</a>&nbsp;&nbsp; 신용카드, 현금<br>            
            <a class="basic">해시태그</a>&nbsp;&nbsp; ${RestaurantVO.hash}<br>
            </div>
        </div>
        
        <br>
        <div id="res_tab">
            <div class="res_infotab" style="color:white;" >진행중인 주문 현황</div>      
            <div class="res_infotab" style="color:white;" >총 주문현황</div>
        </div>
        
        <form id="res_menuall_a" name="rfm" method="post" >
        	<input type="hidden" name="oseq" value="${ovo.oseq}">
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
	                               <h2><fmt:formatDate value="${ovo.indate}" type="date" pattern="yyyy-MM-dd (a)hh:mm:ss" /></h2>
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
	                            	<c:choose>
	                            		<c:when test="{ovo.result==2}">
			                                <input type="button" value="다음으로" id="res_OrderResultButton" 
			                                onclick="#"/></c:when>
			                            <c:otherwise>
			                                <input type="button" value="다음으로" id="res_OrderResultButton" 
			                                onclick="go_order_save(${ovo.oseq})"/>
			                            </c:otherwise>      
	                                </c:choose>                           
	                            </div>            
	                        </td>
	                    </tr>
	                    
	                    <tr style="border-top: 1px solid black;">             
	                    	<div id="menuorderdetail">							  									
								    <div class="menuorderdetaildiv">
								    	<div id="menuorderdetaildiv3">닉네임 : ${ovList[0].nick}</div>
								        <div id="menuorderdetaildiv3">배달주소 : ${ovo.address1}&nbsp;${ovo.address2}</div>
								        <div id="menuorderdetaildiv3">전화번호 : ${ovo.phone}</div>
								        <div id="menuorderdetaildiv3">배달/포장여부 : 
								            <c:if test="${ovo.rideryn==0}">
								                포장
								            </c:if>
								            <c:if test="${ovo.rideryn==1}">
								                배달 (배달료 : + ${ovList[0].rtip }원)
								            </c:if>
								        </div>
								        <div id="menuorderdetaildiv3">일회용품 여부 : 
								            <c:if test="${ovo.rideryn==0}">
								                포함
								            </c:if>
								            <c:if test="${ovo.rideryn==1}">
								                미포함
								            </c:if>
								        </div>
								        <div id="menuorderdetaildiv3">결제방법 : 
								            <c:if test="${ovo.rideryn==0}">
								                현금결제
								            </c:if>
								            <c:if test="${ovo.rideryn==1}">
								                카드결제
								            </c:if>
								        </div>
								    </div>					    
								</div>                 	
	                    </tr>	                    
	                </c:forEach>               
	                </table>
	            </div>      
	        </div>
        </form>
    </div>

<%@ include file="/restaurant/res_footer.jsp"%>