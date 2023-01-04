<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/restaurant/res_header.jsp"%>

<!-- RestaurantVO, FoodmenuList, ReviewList-->

        <div id="res_main">
        <div id="res_name">${RestaurantVO.rname}</div>
        <div id="res_info">
           		<img class="res_logo"src="../images/title/${RestaurantVO.rimage}" ></img>
         
            <div id="res_basic">
            <a class="res_total">★★★★☆</a> 4.4<br>
            <a class="basic">배달팁</a>&nbsp;&nbsp;  ${RestaurantVO.rtip}<br>
            <a class="basic">결제</a>&nbsp;&nbsp; 신용카드, 현금<br>            
            <a class="basic">해시태그</a>&nbsp;&nbsp; #${RestaurantVO.hash}<br>
            </div>
        </div>
        
        <br>
        <div id="res_tab">
            <div class="res_infotab" onclick="menumove(-1);" >메뉴</div>
            <div class="res_infotab" onclick="menumove(1);">가게 정보/리뷰</div>
        </div>
        
        <div id="res_menuall">
            <div id="res_menuinfo">
            	<c:forEach items="${FoodmenuList}" var="FoodmenuVO">
	                <div id="res_menu">
	                    <h3>${FoodmenuVO.fname }</h3>
	                    <a class="basic">${FoodmenuVO.fcontent }</a><br>
	                    ${FoodmenuVO.fprice}원
	                    <img class="res_meima" src="../images/foodmenu/${FoodmenuVO.fimage}">
	                </div>
                </c:forEach>
            </div>

            <div id="info_rev">
                <div id="res_info">
                
                    <div id="res_cont">
                                            <h3>사장님 알림</h3><hr>
                        ${RestaurantVO.content}
                    </div>
                    
                    <br>
                    <div id="res_num">
                        <h3>업체 정보</h3><hr>
                        <a class="basic">사업자 번호</a>&nbsp; ${RestaurantVO.rbiznum}<br>
                        <a class="basic">전화 번호</a>&nbsp; ${RestaurantVO.rphone}<br>
                        <a class="basic">가게 주소</a>&nbsp; ${RestaurantVO.raddress}<br><br>
                    </div>
                </div>
                
                <div id="res_revbogi">
                    <div id="res_star">
                        <h2>클린리뷰</h2>
                        <h1>★★★★☆ 4.4</h1>
                    </div>
                    <c:forEach items="${ReviewList}" var="ReviewVO">
	                    <div class="res_review_nae">
	                        <div class="res_revcon">
	                        <a class="res_revnick">${ReviewVO.id }</a>님 &nbsp; 
	                        <a class="basic"><fmt:formatDate value="${orderVO.indate }" type="date"/></a><br>
	                        <a class="res_star">
								<c:choose>
			                    	<c:when test="${ReviewVO.star==1}">★ 1.0</c:when>
			                    	<c:when test="${ReviewVO.star==2}">★★ 2.0</c:when>
			                    	<c:when test="${ReviewVO.star==3}">★★★ 3.0</c:when>
			                    	<c:when test="${ReviewVO.star==4}">★★★★ 4.0</c:when>
			                    	<c:otherwise>★★★★★ 5.0</c:otherwise>
			                    </c:choose>
							</a><br><br>
	                        <br>
								${ReviewVO.content }
	                        </div>
	                        <c:choose>
		                        <c:when test="${ReviewVO.image==null}"></c:when>
		                        <c:otherwise>
			                        <div class="rev_image">
			                            <img class="reviewimage" src="../images/${ReviewVO.image}">
			                        </div>
		                        </c:otherwise>
	                        </c:choose>
	                    </div>
	                </c:forEach>
                 </div>
            </div>
        </div>
    </div>
    



<%@ include file="/restaurant/res_footer.jsp"%>