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
            <a class="basic">해시태그</a>&nbsp;&nbsp; #${RestaurantVO.hash}<br>
            </div>
        </div>
        
        <br>
        <div id="res_tab">
            <div class="res_infotab" onclick="location.href='fooba.do?command=res_foodmenu'" >돌아가기</div>
            <div class="res_infotab" onclick="#">수정</div>
        </div>
        
        <div id="res_menuall_a">
        
        <form id="res_menuall_a" name="food_menu" method="post" enctype="multipart/form-data" >
        	<input type="hidden" name="rseq" value="${RestaurantVO.rseq}"> 
        	<input type="hidden" name="fseq" value="${FoodmenuVO.fseq}"> 
        	<input type="hidden" name="oldImage" value="${FoodmenuVO.fimage}">
            	<div id="res_menuinfo">

	            	<div id="res_menu1">	                	
	                    	<h2>메뉴 수정</h2><hr>
                            <h3>메뉴 이름</h3>
                            <div id="food_text">
                                <input type="text" class="food_text" name="fname" value="${FoodmenuVO.fname}"/>
                            </div><hr>
                            

                            <h3>메뉴 가격</h3>
                            <div id="food_text">
                                <input type="text" class="food_text" name="fprice" value=${FoodmenuVO.fprice}> 원
                            </div><hr>
                            
                            <h3>메뉴 소개</h3>
                            <div id="food_text">
                            	<textarea name="fcontent" rows="5" cols="50" style="border-radius:10px;"
                            	>${FoodmenuVO.fcontent}</textarea>
                                
                            </div><hr>
	                    			  
                            <h3>메뉴 사진</h3>        
                            	<img src="images/foodmenu/${FoodmenuVO.fimage}" width="100px"><br>            
                                <input type="file" name="fimage" />
                                
                             <h3>사이드메뉴 1</h3>
                            <div id="food_text">
                           		<input type="text" class="food_text" 
                           		style="width:120px; height:35px;" name="fside1" value=" ${FoodmenuVO.fside1}"/>
                           		&nbsp;
                                <input type="text" class="food_text" 
                                style="width:120px; height:35px;" name="fsideprice1" value=${FoodmenuVO.fsideprice1}> 원
                            </div><hr>
                            
                             <h3>사이드메뉴 2</h3>
                            <div id="food_text">
                           		<input type="text" class="food_text" 
                           		style="width:120px; height:35px;" name="fside2" value=" ${FoodmenuVO.fside2}"/>
                           		&nbsp;
                                <input type="text" class="food_text" 
                                style="width:120px; height:35px;" name="fsideprice2" value=${FoodmenuVO.fsideprice2}> 원
                            </div><hr>
                            
                             <h3>사이드메뉴 3</h3>
                            <div id="food_text">
                           		<input type="text" class="food_text" 
                           		style="width:120px; height:35px;" name="fside3" value="${FoodmenuVO.fside3}"/>
                           		&nbsp;
                                <input type="text" class="food_text" 
                                style="width:120px; height:35px;" name="fsideprice3" value=${FoodmenuVO.fsideprice3}> 원
                            </div><hr>
                                
                            <div id="res_tab">
            					<div class="res_infotab"  style="width:100%; height:50px; border-radius:5px; background:rgb(255,204,0);"
            					onclick="menu_update()" >수정</div>                                
                    		</div>
	        
	                </div>               
              
              
             </div>
          
            </form>
            </div>   
        </div>

<%@ include file="/restaurant/res_footer.jsp"%>