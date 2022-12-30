<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


<div id="mainlist">
        <div id="search">
            <input id="searchtextlist" placeholder="   검색어를 입력하세요"
            size="30px"/>
            <div id="searchiconlist">
                <img src="images/search.png">
            </div>
        </div>
    
        <div id="kindboxeslist">
            <div class="kindbox">
                <span class="kindtext">한식</span><br>
                <img src="images/korean.png">
            </div>
            <div class="kindbox">
                <span class="kindtext">중식</span><br>
                <img src="images/china.png">
            </div>
            <div class="kindbox">
                <span class="kindtext">양식</span><br>
                <img src="images/western.png">
            </div>
            <div class="kindbox">
                <span class="kindtext">일식</span><br>
                <img src="images/japan.png">
            </div>
            <div class="kindbox">
                <span class="kindtext">피자</span><br>
                <img src="images/pizza.png">
            </div>
             <div class="kindbox">
                   <span class="kindtext">치킨</span><br>
                   <img src="images/chicken.png">
                </div>
            <div class="kindbox">
                <span class="kindtext">분식</span><br>
                <img src="images/bunsic.png">
            </div>
            <div class="kindbox">
                <span class="kindtext">디저트</span><br>
                <img src="images/dessert.png">
            </div>
        </div>
    </div>


    <div class="row">
    
     <!-- 
                <c:forEach items="${productKindList}"  var="productVo">
					<div id="item">
						<a href="shop.do?command=productDetail&pseq=${productVo.pseq}">
						<img src="product_images/${productVo.image}"/>
						<h3>${productVo.name}</h3>
						<p>${productVo.price2}</p>
						</a>
					</div>	
				</c:forEach> -->
				
       <%-- <c:forEach items="${RList}" var="RestaurantVO">
       		<div class="resList">
            <a href="#" class="rimage">                
              	 	<div class="res_imgbox">
                    	<img src="images/title/${RestaurantVO.rimage}" alt="${RestaurantVO.rname}" id="rtitle">
                	</div>
                
                <div class="rtext">
                    <p class="res_name">${RestaurantVO.rname}</p>
                    <p class="res_kind">
                    	<c:choose>
	                    	<c:when test="${RestaurantVO.kind==1}">한식</c:when>
	                    	<c:when test="${RestaurantVO.kind==2}">중식</c:when>
	                    	<c:when test="${RestaurantVO.kind==3}">양식</c:when>
	                    	<c:when test="${RestaurantVO.kind==4}">일식</c:when>
	                    	<c:when test="${RestaurantVO.kind==5}">피자</c:when>
	                    	<c:when test="${RestaurantVO.kind==6}">치킨</c:when>
	                    	<c:when test="${RestaurantVO.kind==7}">분식</c:when>
	                    	<c:otherwise>디저트</c:otherwise>
	                    </c:choose>
                    </p>
                    <p class="res_tag">${RestaurantVO.hash}</p>
                </div>
            </a>
        </div>
			</c:forEach> --%>
		
        <div class="resList">
            <a href="#" class="rimage">
                
                <div class="res_imgbox">
                    <img src="images/title/2.jpg" alt="가게이름명" id="rtitle">
                </div>
                
                <div class="rtext">
                    <p class="res_name">가게 이름명1</p>
                    <p class="res_kind">가게설명</p>
                    <p class="res_tag">해시태그
                    </p>
                </div>
            </a>
        </div>

        <div class="resList">
            <a href="#" class="rimage">
                
                <div class="res_imgbox">
                    <img src="images/title/3.jpg" alt="가게이름명" id="rtitle">
                </div>
                
                <div class="rtext">
                    <p class="res_name">가게 이름명1</p>
                    <p class="res_kind">가게설명</p>
                    <p class="res_tag">해시태그
                    </p>
                </div>
            </a>
        </div>

        <div class="resList">
            <a href="#" class="rimage">
                
                <div class="res_imgbox">
                    <img src="images/title/4.jpg" alt="가게이름명" id="rtitle">
                </div>
                
                <div class="rtext">
                    <p class="res_name">가게 이름명1</p>
                    <p class="res_kind">가게설명</p>
                    <p class="res_tag">해시태그
                    </p>
                </div>
            </a>
        </div>

        <div class="resList">
            <a href="#" class="rimage">
                
                <div class="res_imgbox">
                    <img src="images/title/5.jpg" alt="가게이름명" id="rtitle">
                </div>
                
                <div class="rtext">
                    <p class="res_name">가게 이름명1</p>
                    <p class="res_kind">가게설명</p>
                    <p class="res_tag">해시태그
                    </p>
                </div>
            </a>
        </div>

        <div class="resList">
            <a href="#" class="rimage">
                
                <div class="res_imgbox">
                    <img src="images/title/6.jpg" alt="가게이름명" id="rtitle">
                </div>
                
                <div class="rtext">
                    <p class="res_name">가게 이름명1</p>
                    <p class="res_kind">가게설명</p>
                    <p class="res_tag">해시태그
                    </p>
                </div>
            </a>
        </div>

        

    </div>


<%@ include file="../footer.jsp"%>