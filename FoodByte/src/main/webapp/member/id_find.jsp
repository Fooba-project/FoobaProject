<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/fooba.css" rel="stylesheet"> 
<script type="text/javascript">

function id_find(){
	if( document.member_join_send_form.userid.value=="" ){
		alert("아이디를 입력하고 중복체크를 진행하세요" );
		documnet.member_join_send_form.userid.focus();
		return;
	}
	var url = "fooba.do?command=idCheckForm&userid=" + document.member_join_send_form.userid.value;
	var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250, scrollbars=no";
	window.open(url, "IdCheck", opt);	
}
</script>
</head>
<body>
<div id="idcheck_box">
	<div id="idcheck_text">
		<form method="post" name="idCheckForm" action="fooba.do">
			<h1 id="idcheckline">ID 찾기</h1>
			
            <input type="hidden" name="command" value="idCheckForm" />
            아이디 : <input type="text" name="userid" value="${userid}" style="font-size: 17px;">
            <input type="submit" value="검색" class="submit" id="idcheckbutton1"><label for="idcheckbutton1" id="idcheckbutton1_1"></label><br><br>
			전화번호 : <input type="text" name="userphone" value="${userphone}" style="font-size: 17px;">
			<input type="submit" value="검색" class="submit" id="idcheckbutton2"><label for="idcheckbutton2" id="idcheckbutton2_1"></label><br><br><br>
			
			<c:if test="${result == 1}">
				<script type="text/javascript">
	                    opener.document.member_join_send_form.userid.value="";
	                    opener.document.member_join_send_form.userreid.value="";
				</script>
	                회원님의 아이디는 ${userid}입니다.
			</c:if>
            <c:if test="${result == -1}">
                아이디가 없습니다 새로 만드세요.
                <input type="button" value="찾기" class="find" id="idcheckbutton2" onclick="idok('${userid}');">
            </c:if>
		</form>
	</div>
</div>
</body>
</html>