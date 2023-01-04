<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
	<!-- RestaurantVO, FoodmenuList, ReviewList-->
        <div id="jenche">
        <div id="gageirm">${RestaurantVO.rname}</div>
        <div id="gagemain">
           		<img class="smlogo"src="images/title/${RestaurantVO.rimage}" ></img>
         
            <div id="gibon">
            <a class="redd">★★★★☆</a> 4.4<br>
            <a class="grayy">배달팁</a>&nbsp;&nbsp;  ${RestaurantVO.rtip}<br>
            <a class="grayy">결제</a>&nbsp;&nbsp; 신용카드, 현금<br>            
            <a class="grayy">해시태그</a>&nbsp;&nbsp; #${RestaurantVO.hash}<br>
            </div>
        </div>
        <br>
        <div id="menujengbo">
            <div class="menujengbotab" onclick="menumove(-1);" >메뉴</div>
            <div class="menujengbotab" onclick="menumove(1);">가게 정보/리뷰</div>
        </div>
        
        <div id="tul">
            <div id="menudel">
            	<c:forEach items="${FoodmenuList}" var="FoodmenuVO">
	                <div id="gagemenu">
	                    <h3>${FoodmenuVO.fname }</h3>
	                    <a class="grayy">${FoodmenuVO.fcontent }</a><br>
	                    ${FoodmenuVO.fprice}원
	                    <img class="smmenu" src="images/foodmenu/${FoodmenuVO.fimage}">
	                </div>
                </c:forEach>
            </div>

            <div id="jengboreview">
                <div id="gagejengbo">
                    <div id="gagesoge">
                        <h3>사장님 알림</h3><hr>
                        ${RestaurantVO.content}
                    </div>
                    <br>
                    <div id="gagebunho">
                        <h3>업체 정보</h3><hr>
                        <a class="grayy">사업자 번호</a>&nbsp; ${RestaurantVO.rbiznum}<br>
                        <a class="grayy">전화 번호</a>&nbsp; ${RestaurantVO.rphone}<br>
                        <a class="grayy">가게 주소</a>&nbsp; ${RestaurantVO.raddress}<br><br>
                    </div>
                </div>
                <div id="reviewbogi">
                    <div id="reviewww">
                        <h2>클린리뷰</h2>
                        <h1>★★★★☆ 4.4</h1>
                    </div>
                    <c:forEach items="${ReviewList}" var="ReviewVO">
	                    <div class="reviewdel">
	                        <div class="rvnaeyong">
	                        <a class="rvnick">꿀돼지</a>님 &nbsp; 
	                        <a class="grayy">2022년 12월 16일</a><br>
	                        <a class="starr">★★★★★ 5.0</a><br>
	                        <a class="grayy">황금올리브/자메이카 </a><br>
	                        <br>
	                        맛있어요!!!!<br>
	                        뻥이에요!!!!
	                        </div>
	                        <div class="rvsajin">
	                            <img class="reviewimage" src="/images/Chicken/bbq/26000_5890f998d7d53c05daaa574d5531380b1615794251.jpg">
	                        </div>
	                    </div>
	                </c:forEach>
                 </div>
            </div>
        </div>
    </div>
    

<%@ include file="../footer.jsp"%>