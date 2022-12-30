<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<fmt:setLocale value="ko_KR"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fooba</title>
<link href="css/fooba.css" rel="stylesheet">
<script type="text/javascript" src="/code.jquery.com/jquery-2.1.3.min.js"></script>
<script src = "script/jquery-3.6.1.js"></script>
<script src="script/fooba.js"></script>
<link href="css/fooba.css" rel="stylesheet">
</head>
<body>
 
    <div id="headback">
        <div id="mainlogo">
            <a href="fooba.do?command=index"><img src="images/mainlogo1.png"></a>
        </div>
    </div>
    
    <div class="headbuttons">
	    <input type="button" value="로그인" class="headbutton" name="userLogin" onclick="location.href='fooba.do?command=loginForm'">
	    <input type="button" value="회원가입" class="headbutton" name="userJoin" onclick="location.href='fooba.do?command=joinForm'">
    </div>