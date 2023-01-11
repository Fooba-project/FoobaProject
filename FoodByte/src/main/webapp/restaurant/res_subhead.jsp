<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<div id="res_main">
	<div id="res_name">${RestaurantVO.rname}</div>
	<div id="res_info">
		<img class="res_logo"src="images/title/${RestaurantVO.rimage}" ></img>
	    <div id="res_basic">
			<a class="basic">배달팁</a>&nbsp;&nbsp;  ${RestaurantVO.rtip}<br>
			<a class="basic">결제</a>&nbsp;&nbsp; 신용카드, 현금<br>            
			<a class="basic">해시태그</a>&nbsp;&nbsp; #${RestaurantVO.hash}<br>
	    </div>
	</div>
	<br>