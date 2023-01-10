<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<style type="text/css">

.member_list{text-align: center; margin-top:30px;}
#member_list_table{margin: auto; width:810px;}
#member_list_table th{background-color:#fa6146; font-size: 17px; color: white;}
#qna_image{width: 35px; width: 20px;}
.qna_title{ padding-left: 10px; height: 30px; margin-top: 13px;}
.qna_box{border: 1px solid black;}
.qna_content{padding-left:30px;}
qna_content:hover{height:120px;}
</style>

<article>
        <h2 class="member_list">자주 묻는 질문</h2>   
        <br> 
        <form name="frm" method="post">
            <table id="member_list_table">
                
                <c:forEach items="${qnaList}" var="QnaVO">        
                <tr> 
                    <div class="qna_box">
                        <div class="qna_title">
                             Q : ${QnaVO.subject} 
                        </div>
                    </div>
                </tr>
                <tr> 
                    <div class="qna_box">
                        <div class="qna_content">
                             A : ${QnaVO.content} 
                        </div>
                    </div>
                </tr>
                </c:forEach>
            </table>
        </form>
            <div class="clear"></div>
    </article> 
<br>
<jsp:include page="/member/paging/paging.jsp">
<jsp:param name="command" value="fooba.do?command=memberQnalist"/>
</jsp:include>	
<br><br><br><br><br><br><br><br><br><br><br><br>
<%@ include file="../footer.jsp"%>