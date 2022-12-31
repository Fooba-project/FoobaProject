<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/fooba.css" rel="stylesheet">
<script type="text/javascript" src="/code.jquery.com/jquery-2.1.3.min.js"></script>
<script src = "script/jquery-3.6.1.js"></script>
<script src="script/fooba.js"></script>
</head>
<body>
	<div id="popup">
		<h1>우편번호 검색</h1>
		<form method="post" name="formm" action="fooba.do">
			<input type="hidden" name="command" value="findZipNum">
			동 이름 : <input name="dong" type="text"><input type="submit" value="찾기" class="submit">
		</form> 
		
		<!--  검색된 우편번호와 동 표시 -->
		<table id="zipcode">
			<tr><th width="100">우편번호</th><th>주소</th></tr>
			<c:forEach items="${addressList }" var="add">
				<tr>
					<td>
						<a href="#" onClick="result('${add.zip_num}','${add.sido }','${add.gugun }','${add.dong }');">
							${add.zip_num }
						</a>
					</td>
					<td>
						<a href="#" onClick="result('${add.zip_num}','${add.sido }','${add.gugun }','${add.dong }');">
							${add.sido } ${add.gugun } ${add.dong }
							<!-- 함수의 호출 형태 - result('123-123', '서울시', '서대문구', '대현동') -->
							<!-- 호출된 result함수는 '우편번호123-123'를 zip_num 입력란에 들어가고, '서울시 서대문구 대현동' 이라는 주소를 address1 입력란에 넣음 -->
						</a>
					</td>
				</tr>	
			</c:forEach>
		</table>
	</div>
</body>
</html>