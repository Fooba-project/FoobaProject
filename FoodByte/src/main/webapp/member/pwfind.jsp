<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/fooba.css" rel="stylesheet"> 
<style type=text/css>
.id_find_box{text-align: center;}
</style>
</head>
<body>
<form name="id_find_check" method = "post">
    <div class = "id_find_box">
            <h3>비밀번호 찾기</h3>
        <div class = "find-name">
            <label>이름</label>
            <input type="text" name="member_name" class = "btn-name" placeholder ="등록한 이름">
        <br>
        </div>
        <div class = "find-phone">
            <label>번호</label>
            <input type="text" onKeyup = "addHypen(this);" name="member_phone" class = "btn-phone" placeholder = "휴대폰 번호 입력" maxlength="13"> 
        </div>
        <br>

        <div class ="id_find_btn">
            <input type="button" name="find" value="찾기" onclick="member_id_find()">
            <input type="button" name="cancle" value="취소" onclick="history.back()">
        </div>
    </div>
</form>
</body>
</html>
<%@ include file="../footer.jsp"%>