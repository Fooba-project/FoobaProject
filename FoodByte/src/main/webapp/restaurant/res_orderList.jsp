<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/restaurant/res_header.jsp"%>

<div id="res_main">
        <div id="res_name">레스토랑 이름</div>
        
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
            <div class="res_infotab" style="color:white;">주문 현황</div>
            <div class="res_infotab" onclick="location.href='fooba.do?command=res_foodmenuAddForm'">
            배달 완료</div>
        </div>
        
        <div id="res_menuall">
            <div id="res_menuinfo">
            	<c:forEach items="${FoodList}" var="FoodmenuVO">
	                <div id="res_menu">	                	
	                    	<h3><fmt:formatDate value="${board.writedate}" pattern="(a)hh:mm" />시간이 출력 예정&nbsp;<img src="images/order.png" style="width:20px;"><br>
	                    			  
	                    <a class="basic">베리 굿</a><br>
	                    5000원
	                    <img class="res_meima" 
                        >
	                </div>
                </c:forEach>
            </div>


            
        </div>
        
    </div>

<%@ include file="/restaurant/res_footer.jsp"%>