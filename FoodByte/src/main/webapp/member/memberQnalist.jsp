<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<style type="text/css">

#logspace {font-size: 30px; font-weight:bold; text-align:center;}
.member_list{text-align: center; margin-top:30px;}
#member_searchres {margin:auto;  width:700px;}
#member_searchres td {font-weight: 700; }
.member_searchres_btn{height:35px; background-color: #fa6146; float: right; margin-right: 5px; border: 2px solid black ; color: white; box-shadow: 1px 1px black; border-radius: 4px;  }   
#member_list_table{margin: auto; border: 1px solid; width:810px;}
#member_list_table th{background-color:#fa6146; font-size: 17px; color: white;}

</style>

<script type="text/javascript">
 function go_detail( qseq ){
	var url = "fooba.do?command=memberQnaView&qseq=" + qseq;
	document.frm.action = url; 
	document.frm.submit();
}
function go_wrt(){
		document.frm.action = "fooba.do?command=memberQnaWiteForm";
		document.frm.submit();
	}
</script>

<article>
        <h2 class="member_list">질문 리스트</h2>   
        <br> 
        <form name="frm" method="post">
            <table id="member_searchres">
                <tr>
                    <td style="font-size:17px; width:642;">질문 번호: <input class="keyy" type="text" name="key" value="${key}">
                        <input class="member_searchres_btn" type="button" name="btn_write" value="QnA등록"  onClick="go_wrt();">           
                        <input class="member_searchres_btn" type="button" name="btn_total" value="전체보기" 
                            onClick="go_total( 'admin_restaurantList' );">
                        <input class="member_searchres_btn" type="button" name="btn_search" value="검색" 
                            onClick="go_search( 'admin_restaurantList' );">
                    </td>
                </tr>
            </table><br>
            <table id="member_list_table">
                <tr><th>질문번호</th><th>제목</th></tr>
            <c:forEach items="${qnaList}" var="QnaVO">
                    <tr>
                        <td style="text-align:center;">${QnaVO.qseq}</td>
                        <td style="text-align:left; padding-left:20px;">
                        <a style="text-decoration-line: none;"href="#" onClick="go_detail('${QnaVO.qseq}');">${QnaVO.subject}</a>                
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