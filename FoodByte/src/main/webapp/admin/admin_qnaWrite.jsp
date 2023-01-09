<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="admin_header.jsp"%>

<article>
<h2> QnA 게시판 </h2> 
	<form name="formm" method="post"	action="fooba.do">
		<input type="hidden" name="command" value="qnaWrite">
		<fieldset> 
			<legend>QnA 작성</legend>  
		    <label>제목 </label><input type="text" name="subject"  size="60" ><br>
			<label>내용 </label><textarea rows="8" cols="65" name="content"></textarea>
		</fieldset>
		<div class="clear"></div>
		<div id="buttons" style="float:right">
			<input type="submit"  value="글쓰기"     class="submit"> 
			<input type="reset"   value="취소"     class="cancel" onclick="location.href='fooba.do?command=qnaList'">
		</div>
	</form>
</article>

<%@ include file="admin_footer.jsp"%>