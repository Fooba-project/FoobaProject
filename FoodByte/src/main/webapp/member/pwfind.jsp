<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/fooba.css" rel="stylesheet"> 
<style type=text/css>
.login_form {position: relative; width:100%; height:745px;}
#logspace {width: 100%; height: 100px;}
#pw_find_message {width: 100%; height: 20px; margin-top:20px; color: red; text-align: center; }
#Login_form_space {width:100%; height:150px;}
#loginmain_logo{position: relative; text-align: center; width: 150px; height: 100px; margin: 0 auto; border-radius:50%; width: calc(5.5em / 0.7); height: calc(5em / 0.7); background-color: #fa6146; opacity:90%;}
#loginmain_logo img{width: 100px; height: 100px;}
#login_box{position: relative; height:300px; width:500px; border:2px solid rgb(224, 133, 80); margin: 0 auto; border-radius: 20px; margin-top:50px; }
#text_button_box{position:relative; width: 500px;height: 190px; margin-top: 50px; margin-left:0 auto;}
#login_idpw_box{position:relative; height:75px; width:310px; margin-top:0 auto; margin-left:90px;}
#login_id{position: relative; width:300px;height:36px; border:1px solid #616161; padding-left:10px;}
#login_phone{position: relative; width:300px; height:36px; bottom:1px; border:1px solid #616161; padding-left:10px; margin-top:10px;}
#login_name{position: relative; width:300px; height:36px; bottom:1px; border:1px solid #616161; padding-left:10px; margin-top:10px;}
#pw_buttonbox{position: relative; width: 310px; height:40px; margin-top: 80px;margin-left:90px;}
#log_button{position: relative; width: 310px; height:40px; background-color:#fa6146; opacity:80%;border-color:#fa6146; border-radius:10px; cursor: pointer;}
#log_button span{position: relative;font-size: 20px; font-weight:bold;color: white; } 
#login_idpw_box input:enabled{background:white;}
#login_idpw_box input:focus{background: rgb(255, 209, 182); outline: none;}
#loginform_linetextbox{height:25px; width:450px; margin:0 auto;}
.loginform_linetext span{ position: relative; float: left; cursor: pointer; width:100px; margin-left: 45px; }
</style>
</head>
<body>
 <form method="post" action="fooba.do?command=login" name="loginForm">
        <div class="login_form">
                <div id="logspace"></div>
                <div id="loginmain_logo">
                    <img src="images/mainlogo1.png">
                </div>
            
                <div id="login_box">
                    <div id="text_button_box">
                        <div id="login_idpw_box">
                            <input type="text" id="login_id" name="userpw" placeholder="아이디를 입력하세요"
                        	maxlength="16" value="">
                        	
                        	 <input type="text" id="login_phone" name="userpw" placeholder="휴대폰번호를 입력하세요"
                        	maxlength="16" value="">
                        	
                            <input type="text" id="login_name" name="userid" placeholder="이름을 입력하세요" title="이름"
                       		 maxlength="10" value="">
               	
                        </div>
            
                        <div id="pw_buttonbox">
                            <button type="submit" id="log_button" onclick="return loginCheck()" >
                                <span class="btn_text">비밀번호 찾기</span>
                            </button>
                        </div>
                    </div>
                     <div id="pw_find_message">${message}</div>
                    </div>
            </div>
        </div>
   </form>
</body>
</html>
<%@ include file="../footer.jsp"%>