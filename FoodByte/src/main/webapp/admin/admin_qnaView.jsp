<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="admin_header.jsp"%>
    
<div class="res_join">
    <div class="res_join_title">QnA</div>
    <div style="border-top: 2px solid rgb(23,55,94); margin-top:15px;"></div>
    <form name="res_join_send_form" id="res_join_send_form" method="post" action="fooba.do?command=res_join" enctype="multipart/form-data">
        <table class="member_join_table">
            <div class="qna_subject">
                제목 : ${qnaVO.subject}"           
            </div> 
            <div class="qna_content">
                <input type="text"  value="내용 : ${qnaVO.content}" readonly/> 
            </div>

        </table>
            <br><br>
            <div id="join_btn">
                <input style="margin-left:80px; background-color:rgb(23,55,94)" class="join_btn" type="button" value="목록" onclick="location.href='fooba.do?command=admin_qnaList'">
            </div>
    </form>
</div>

<%@ include file="admin_footer.jsp"%>