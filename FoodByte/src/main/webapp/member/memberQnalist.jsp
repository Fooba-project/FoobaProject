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

body {margin: 0; position:relative;}
.headback {width: 100%; height: 100px; background-color: #fa6146; margin: 0;}
#mainlogo {position: relative; text-align: center; width: 150px; height: 100px; margin: auto auto;}
#mainlogo img {width: 100px; height: 100px;}

.headbuttons {position:absolute; width: 320px; top:23px; left:calc(50% + 300px); }
.headbutton {width: 150px; height: 50px;border-radius: 5px; text-decoration: none; font-weight: bold; font-size: 100%; font-family: Verdana, Geneva, Tahoma, sans-serif; background-color: #fff; line-height: 50px; color:#fff; background-color: transparent; border: 2px solid white; }
.headbutton:hover {background-color: white; color: #fa6146; cursor: pointer;}

.footerbox{position:relative; height: 100px; width: 100%; background-color: white;}
.footerbox #copy{position:absolute; top: 50px; text-align: center; right:20px; font-size: 15px; opacity: 80%; color: #fa6146;}
.footerbox  #logo{position:absolute; width:80px; height: 90px;  left: 15px; opacity: 60%; }
.footerbox #logotextbox{position:absolute; top:10px; left: 110px; line-height:25px; width: 500px; }
.footerbox #logotext{font-family: Verdana; font-weight: bold; color: #fa6146; }
.footerbox .linemenubox{width: 150px; height: 20px; cursor: pointer; float: right; margin:10px; font-weight: bold; color: #fa6146; text-align: center;}

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
<jsp:include page="/admin/paging/paging.jsp">
<jsp:param name="command" value="fooba.do?command=memberQnalist"/>
</jsp:include>	
<br><br><br><br><br><br><br><br><br><br><br><br>
<%@ include file="../footer.jsp"%>