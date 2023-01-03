<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_head.jsp"%>

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
				</c:forEach>
				 -->
				 
				 
       		<c:forEach items="${RList}" var="RestaurantVO">
       		
       		<div class="resList">
            <a href="#" class="rimage">                
              	 	<div class="res_imgbox">
              	 	<c:forEach items="${FList}" var="FoodmenuVO" >
              	 	<c:if test="${FoodmenuVO.rseq==RestaurantVO.rseq}">
              	 		<img src="images/foodmenu/${FoodmenuVO.fimage}" alt="${FoodmenuVO.fimage}" id="rtitle">
              	 	</c:if>
              	 	</c:forEach>              	 	
                    	
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
                    <p class="res_tag">#${RestaurantVO.hash}</p>
                </div>
            </a>
        </div>
			</c:forEach> 
		
        <!-- <div class="resList">
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
        </div> -->

        

    </div>


<%@ include file="../footer.jsp"%>