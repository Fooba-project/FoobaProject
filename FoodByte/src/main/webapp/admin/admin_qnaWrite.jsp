<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="admin_header.jsp"%>

<article><br><br><br>
<h2 style="margin-left:31%"> QnA 게시판 </h2> 
        <form name="formm" method="post"action="fooba.do">
            <input type="hidden" name="command" value="admin_qnaWrite">
            <fieldset style="width:700px; height:300px; margin:auto;">
                <legend style="font-weight: 700; font-size: 19px; ">QnA 작성</legend><br>
                <table>
                    <th style="font-weight: 700;">제목:&nbsp;&nbsp; </th>
                    <th><input type="text" name="subject"></input></th>
                </table>
                <table>
                    <th style="font-weight: 700;">내용:&nbsp;&nbsp; </th>
                    <th><textarea style="height:160px; width: 600px;" rows="8" cols="65" name="content"></textarea></th>
                </table>
                
                <div class="qna_buttons">
                    <input type="submit"  value="글쓰기" class="qna_button"> 
                    <input type="button"   value="취소"  class="qna_button" onclick="location.href='fooba.do?command=admin_qnaList'">   
                </div>
            </fieldset>
      
        </form>
</article>
<br><br><br><br><br><br><br><br><br>
<%@ include file="admin_footer.jsp"%>