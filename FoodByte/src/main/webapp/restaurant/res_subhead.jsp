<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<div id="res_main">
	<div id="res_name">${RestaurantVO.rname}</div>
	<div id="res_info">
		<img class="res_logo"src="images/title/${RestaurantVO.rimage}" ></img>
	    <div id="res_basic">
	    	<a class="basic">별점</a>&nbsp;&nbsp;<a class="starr">
	    		<c:choose>
            		<c:when test="${intstar==0}">☆☆☆☆☆</c:when>
            		<c:when test="${intstar==1}">★☆☆☆☆</c:when>
            		<c:when test="${intstar==2}">★★☆☆☆</c:when>
            		<c:when test="${intstar==3}">★★★☆☆</c:when>
            		<c:when test="${intstar==4}">★★★★☆</c:when>
            		<c:otherwise>★★★★★</c:otherwise>
            	</c:choose>${doublestar}</a>
	    	<br> 
			<a class="basic">배달팁</a>&nbsp;&nbsp;  ${RestaurantVO.rtip}<br>
			<a class="basic">결제</a>&nbsp;&nbsp; 신용카드, 현금<br>            
			<a class="basic">해시태그</a>&nbsp;&nbsp; #${RestaurantVO.hash}<br>
	    </div>
	</div>
	<br>