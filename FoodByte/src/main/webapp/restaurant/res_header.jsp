<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<fmt:setLocale value="ko_KR"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fooba</title>
<link href="../css/fooba.css" rel="stylesheet">
<script type="text/javascript" src="/code.jquery.com/jquery-2.1.3.min.js"></script>
<script src = "../script/jquery-3.6.1.js"></script>
<script src="../script/fooba.js"></script>
</head>
<body>

    <div class="headback" id="resheadback">
        <div id="mainlogo">
            <a href="fooba.do?command=index"><img src="images/mainlogo1.png"></a>
        </div>
    </div>
    
    <div class="headbuttons" id="resheadbuttons">
    	<c:choose>
    		<c:when test="${empty loginAdmin}">
	    		<input type="button" value="가입신청" class="headbutton" name="userLogin" onclick="location.href='fooba.do?command=res_joinForm'">
	    		<input type="button" value="Home" class="headbutton" name="userJoin" onclick="location.href='fooba.do?command=index'">
    		</c:when>
    		<c:otherwise>
    			<input type="button" value="로그아웃" class="headbutton" onclick="location.href='fooba.do?command=res_logout'">
	    		<input type="button" value="주문관리" class="headbutton" onclick="location.href='fooba.do?command=res_order'">
	    		<input type="button" value="리뷰관리" class="headbutton" onclick="location.href='fooba.do?command=res_review'">
	    		<input type="button" value="메뉴관리" class="headbutton" onclick="location.href='fooba.do?command=res_menu'">
	    		<input type="button" value="레스토랑미리보기" class="headbutton" onclick="location.href='fooba.do?command=res_show'">    		
	    	</c:otherwise>
    	</c:choose>
    </div>