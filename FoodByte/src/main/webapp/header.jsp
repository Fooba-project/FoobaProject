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
<script src="javascript/fooba.js"></script>
<style type="css/text">
    #head {width: 100%; background-color: red; height: 100px;}
    .log_join {}

</style>
</head>
<body>
<div id="head">

    <input type="button" value="로그인" class="log_join">
    <input type="button" value="회원가입" class="log_join">
    <input type="button" value="로그아웃" class="log_join">
    <input type="button" value="마이페이지" class="log_join">

    마이페이지 -> 주문진행사항, 과거주문내역, 회원정보수정, 회원탈퇴

</div>

<footer>
	<hr>
	<div id="copy">	All contents Copyright 2022 Fooba.Co all rights reserved<br>
	Contact mail : abc@abc.com  Tel : +82 02 1234 1234 Fax : +82 02 1233 1233&nbsp;&nbsp;&nbsp;
	<a href="fooba.do?command=admin">administrator</a>
	</div>
</footer>

</div>
</body>
</html>