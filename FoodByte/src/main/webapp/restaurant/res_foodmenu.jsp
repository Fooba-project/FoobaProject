<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/restaurant/res_header.jsp"%>



<!-- RestaurantVO, FoodmenuList, ReviewList-->

        <div id="res_main">
        <div id="res_name">${RestaurantVO.rname}</div>
        
        <div id="res_info">
           		<img class="res_logo"src="images/title/${RestaurantVO.rimage}" ></img>
         
            <div id="res_basic">
            <a class="res_total">★★★★☆</a> 4.4<br>
            <a class="basic">배달팁</a>&nbsp;&nbsp;  ${RestaurantVO.rtip}<br>
            <a class="basic">결제</a>&nbsp;&nbsp; 신용카드, 현금<br>            
            <a class="basic">해시태그</a>&nbsp;&nbsp; #${RestaurantVO.hash}<br>
            </div>
        </div>
        
        <br>
        <div id="res_tab">
            <div class="res_infotab" >메뉴</div>
            <div class="res_infotab" onclick="location.href='fooba.do?command=res_foodmenuAdd'">
            메뉴 추가</div>
        </div>
        
        <div id="res_menuall">
            <div id="res_menuinfo">
            	<c:forEach items="${FoodList}" var="FoodmenuVO">
	                <div id="res_menu">	                	
	                    	<h3>${FoodmenuVO.fname }
	                    		<img id="res_menu_icon" src="images/update.png" onClick="location.href='fooba.do?command=res_foodmenuUpdateForm'">	 
	                    		<img id="res_menu_icon" src="images/delete.png" onClick="location.href='fooba.do?command=#'">	                    
	                    	</h3>
	                    			  
	                    <a class="basic">${FoodmenuVO.fcontent }</a><br>
	                    ${FoodmenuVO.fprice}원
	                    <img class="res_meima" src="images/foodmenu/${FoodmenuVO.fimage}">
	                </div>
                </c:forEach>
            </div>


            
        </div>
        
    </div>




<%@ include file="/restaurant/res_footer.jsp"%>