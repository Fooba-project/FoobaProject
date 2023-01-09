<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="admin_header.jsp"%>

<script type="text/javascript">
function go_mod_save(){
	if (document.frm.subject.value == '') {
		  alert('제목을 입력하세요.'); 	  
			document.frm.subject.focus();
	 } else if (document.frm.content.value == '') {
		  alert('내용을 입력하세요.');	  
			document.frm.name.focus();
	 }else{
		if( confirm('수정하시겠습니까?') ){
			 document.frm.action = "shop.do?command=admin_qnaUpdate";
			 document.frm.submit();
		}
	}
}
</script>



<div class="res_join">
    <div class="res_join_title">QnA</div>
    <div style="border-top: 2px solid rgb(23,55,94); margin-top:15px;"></div>
        <table class="member_join_table"><br>
            <div class="qna_subject">
                제목 : 
                <input type="text" name="subject" size="40" value="${qnaVO.subject}"></input>           
             </div>
                   
             <div class="qna_content">
                 내용 : 
                 <input style="height:140px; width: 550px" name="content" value="${qnaVO.content}"></input>
             </div>
        </table>
         	
            <div id="join_btn">
            	<input type="hidden" name="qseq" value="${qnaVO.qseq}">
            	<input style="margin:auto; background-color:rgb(23,55,94)" class="join_btn1" type="button" value="수정" onclick="go_mod_save()">
                <input style="margin:auto; background-color:rgb(23,55,94)" class="join_btn1" type="button" value="취소" onclick="location.href='fooba.do?command=admin_qnaView&qseq=${qnaVO.qseq}'">
            </div>
    </form>
</div>



<%@ include file="admin_footer.jsp"%>