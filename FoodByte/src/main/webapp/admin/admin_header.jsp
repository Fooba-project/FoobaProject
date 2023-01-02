<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<fmt:setLocale value="ko_KR"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fooba</title>
<script type="text/javascript" src="/code.jquery.com/jquery-2.1.3.min.js"></script>
<script src = "../script/jquery-3.6.1.js"></script>
<script src="../script/fooba.js"></script>
</head>
<style type="text/css">
body {margin: 0; position:relative;}
.headback {width: 100%; height: 100px; background-color: rgb(23,55,94); margin: 0;}
#mainlogo {position: relative; text-align: center; width: 150px; height: 100px; margin: auto auto;}
#mainlogo img {width: 100px; height: 100px;}

.headbuttons {position:absolute; width: 320px; top:23px; left:calc(50% + 300px); }
.headbutton {width: 150px; height: 50px;border-radius: 5px; text-decoration: none; font-weight: bold; font-size: 100%; font-family: Verdana, Geneva, Tahoma, sans-serif; background-color: #fff; line-height: 50px; color:#fff; background-color: transparent; border: 2px solid white; }
.headbutton:hover {background-color: white; color: rgb(23,55,94); cursor: pointer;}

.footerbox{position:relative; height: 100px; width: 100%; background-color: white;}
.footerbox #copy{position:absolute; top: 50px; text-align: center; right:20px; font-size: 15px; opacity: 80%; color: rgb(23,55,94);}
.footerbox  #logo{position:absolute; width:80px; height: 90px;  left: 15px; opacity: 60%; }
.footerbox #logotextbox{position:absolute; top:10px; left: 110px; line-height:25px; width: 500px; }
.footerbox #logotext{font-family: Verdana; font-weight: bold; color: rgb(23,55,94); }
.footerbox .linemenubox{width: 150px; height: 20px; cursor: pointer; float: right; margin:10px; font-weight: bold; color: rgb(23,55,94); text-align: center;}

.login_form {position: relative; width:100%; height:745px;}
#logspace {width: 100%; height: 100px;}
#loginmessage {width: 100%; height: 20px; margin-top: 30px; color: red; text-align: center; }
#Login_form_space {width:100%; height:150px;}
#loginmain_logo{position: relative; text-align: center; width: 150px; height: 100px; margin: 0 auto; border-radius:50%; width: calc(5.5em / 0.7); height: calc(5em / 0.7); background-color: rgb(23,55,94); opacity:90%;}
#loginmain_logo img{width: 100px; height: 100px;}
#login_box{position: relative; height:300px; width:500px; border:2px solid rgb(224, 133, 80); margin: 0 auto; border-radius: 20px; margin-top:50px; }
#text_button_box{position:relative; width: 500px;height: 190px; margin-top: 50px; margin-left:0 auto;}
#login_idpw_box{position:relative; height:75px; width:310px; margin-top:0 auto; margin-left:90px;}
#login_id{position: relative; width:300px;height:36px; border:1px solid #616161; padding-left:10px;}
#login_pw{position: relative; width:300px; height:36px; bottom:1px; border:1px solid #616161; padding-left:10px; margin-top:10px;}
#log_buttonbox{position: relative; width: 310px; height:40px; margin-top: 40px;margin-left:90px;}
#log_button{position: relative; width: 310px; height:40px; background-color:rgb(23,55,94); opacity:80%;border-color:rgb(23,55,94); border-radius:10px; cursor: pointer;}
#log_button span{position: relative;font-size: 20px; font-weight:bold;color: white; } 
#login_idpw_box input:enabled{background:white;}
#login_idpw_box input:focus{background: rgb(255, 209, 182); outline: none;}
#loginform_linetextbox{height:25px; width:450px; margin:0 auto;}
.loginform_linetext span{ position: relative; float: left; cursor: pointer; width:100px; margin-left: 45px; }

#logspace {font-size: 30px; font-weight:bold; text-align:center;}
</style>
<body>
    <div class="headback" id="adminheadback">
        <div id="mainlogo">
            <a href="fooba.do?command=index"><img src="images/mainlogo1.png"></a>
        </div>
    </div>
    
    <div class="headbuttons" id="adminheadbuttons">
    	<c:choose>
    		<c:when test="${empty loginAdmin}">
	    		<input type="button" value="Restaurant" class="headbutton" onclick="location.href='fooba.do?command=res_info'">
	    		<input type="button" value="Home" class="headbutton" onclick="location.href='fooba.do?command=index'">
    		</c:when>
    		<c:otherwise>
    			<input type="button" value="로그아웃" class="headbutton" onclick="location.href='fooba.do?command=adminLogout'">
	    		<input type="button" value="가게관리" class="headbutton" onclick="location.href='fooba.do?command=adminRestaurantList'">
	    		<input type="button" value="회원관리" class="headbutton" onclick="location.href='fooba.do?command=adminMemberList'">
	    		<input type="button" value="QnA" class="headbutton" onclick="location.href='fooba.do?command=adminQnaList'">
    		</c:otherwise>
    	</c:choose>
    </div>