<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="res_header.jsp"%>

<form method="post" action="fooba.do?command=res_login" name="loginForm">
	<div class="login_form">
			<div id="logspace"></div>
	        <div id="loginmain_logo">
	            <img src="images/mainlogo1.png">
	        </div>
	    
	        <div id="login_box">
	            <div id="text_button_box">
	                <div id="login_idpw_box">
	                    <input type="text" id="login_id" name="resid" placeholder="아이디" title="아이디"
	                maxlength="30" value="">
	    
	                    <input type="password" id="login_pw" name="respw" placeholder="비밀번호" title="비밀번호"
	                maxlength="16" value="">
	                </div>
	    
	                <div id="log_buttonbox">
	                    <button type="submit" id="log_button" >
	                        <span class="btn_text">로그인</span>
	                    </button>
	                </div>
	            </div>
	        <div id="loginform_linetextbox">
	            <div class="loginform_linetext">
	                <span class="text1"> 비밀번호찾기</span>
	            </div>
	            <div class="loginform_linetext">
	                <span class="text2"> 아이디찾기</span>
	            </div>
	            <div class="loginform_linetext">
	                <span class="text3"> 회원가입</span>
	            </div>
	        </div>
	    </div>
	    <div id="loginmessage">${message}</div>
	</div>
</form>

<%@ include file="res_footer.jsp"%>