<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/restaurant/res_header.jsp"%>
<script type="text/javascript">
function menu_insert(){
	
	document.food_menu.action="fooba.do?command=res_foodmenuAdd";
	document.food_menu.submit();
	
}
</script>



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
            <div class="res_infotab" onclick="location.href='fooba.do?command=res_foodmenu'" >메뉴</div>
            <div class="res_infotab" onclick="#" style="color:white;">
            메뉴 추가</div>
        </div>
        
        <div id="res_menuall_a">
        
        <form id="res_menuall_a" name="food_menu" method="post" enctype="multipart/form-data" >
        	<input type="hidden" name="rseq" value="${RestaurantVO.rseq}"> 
            	<div id="res_menuinfo">

	            	<div id="res_menu1">	                	
	                    	<h2>메뉴 정보</h2><hr>
                            <h3>메뉴 이름</h3>
                            <div id="food_text">
                                <input type="text" class="food_text" name="fname" placeholder=" 예) 떡볶이"/>
                            </div><hr>
                            

                            <h3>메뉴 가격</h3>
                            <div id="food_text">
                                <input type="text" class="food_text" name="fprice" placeholder=" 예) 6000"/> 원
                            </div><hr>
                            
                            <h3>메뉴 소개</h3>
                            <div id="food_text">
                            	<textarea name="fcontent" rows="5" cols="50" style="border-radius:10px;"> </textarea>
                                
                            </div><hr>
	                    			  
                            <h3>메뉴 사진</h3>                    
                                <input type="file" name="fimage" />
                                
                             <h3>사이드메뉴 1</h3>
                            <div id="food_text">
                           		<input type="text" class="food_text" 
                           		style="width:120px; height:35px;" name="fside1" placeholder=" 예) 콘치즈 추가"/>
                           		&nbsp;
                                <input type="text" class="food_text" 
                                style="width:120px; height:35px;" name="fsideprice1" placeholder=" 예) 3000"/> 원
                            </div><hr>
                            
                             <h3>사이드메뉴 2</h3>
                            <div id="food_text">
                           		<input type="text" class="food_text" 
                           		style="width:120px; height:35px;" name="fside2" placeholder=" 예) 콘치즈 추가"/>
                           		&nbsp;
                                <input type="text" class="food_text" 
                                style="width:120px; height:35px;" name="fsideprice2" placeholder=" 예) 3000"/> 원
                            </div><hr>
                            
                             <h3>사이드메뉴 3</h3>
                            <div id="food_text">
                           		<input type="text" class="food_text" 
                           		style="width:120px; height:35px;" name="fside3" placeholder=" 예) 콘치즈 추가"/>
                           		&nbsp;
                                <input type="text" class="food_text" 
                                style="width:120px; height:35px;" name="fsideprice3" placeholder=" 예) 3000"/> 원
                            </div><hr>
                                
                            <div id="res_tab">
            					<div class="res_infotab"  style="width:100%; height:50px; border-radius:5px; background:rgb(255,204,0);"
            					onclick="menu_insert()" >등록</div>                                
                    		</div>
	        
	                </div>               
              
              
             </div>
          
            </form>
            </div>   
        </div>
        
        
        


<%@ include file="/restaurant/res_footer.jsp"%>