<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/restaurant/res_header.jsp"%>

<div id="res_main">
        <div id="res_name">${RestaurantVO.rname}</div>        
            <div id="res_info">
                       <img class="res_logo"src="images/title/${RestaurantVO.rimage}" ></img>
             
                <div id="res_basic">
                <a class="basic">배달팁</a>&nbsp;&nbsp;  ${RestaurantVO.rtip}<br>
                <a class="basic">결제</a>&nbsp;&nbsp; 신용카드, 현금<br>            
                <a class="basic">해시태그</a>&nbsp;&nbsp; ${RestaurantVO.hash}<br>
                </div>
            </div>
            
            <br>
            <div id="res_tab">
                <div class="res_infotab" 
                onclick="location.href='fooba.do?command=res_review&page=1&search=&key='">
                전체답변</div>      
                <div class="res_infotab" 
                onclick="location.href='fooba.do?command=res_review&page=1&search=&key=&replyyn='+0">
                미답변</div>
            </div>
		<form action="fooba.do" method="post" name="frm">
			<input type="hidden" name="command" value="res_reviewReplyWrite"/>
	 		<input type="hidden" name="review_seq" value="${param.review_seq}"/>
            <div id="res_menuall_a" style="background-color: rgb(250, 248, 215);">
                <div id="res_menuinfo" >
                    <c:forEach items="${ReviewList}" var="ReviewVO">
                        <div id="res_review" >
                            <div id="res_rev_info" >
                                <div id="nick_img" > </div>
                                <div id="m_nick" >&nbsp;&nbsp;${ReviewVO.id}</div>
                                <div id="mrev_star" >&nbsp;&nbsp;
                                <c:choose>
			                    	<c:when test="${ReviewVO.star==1}">★ 1.0</c:when>
			                    	<c:when test="${ReviewVO.star==2}">★★ 2.0</c:when>
			                    	<c:when test="${ReviewVO.star==3}">★★★ 3.0</c:when>
			                    	<c:when test="${ReviewVO.star==4}">★★★★ 4.0</c:when>
			                    	<c:otherwise>★★★★★ 5.0</c:otherwise>
			                    </c:choose>
                                </div>
                                <div class="rev_indate" >&nbsp;&nbsp;
                                	<fmt:formatDate value="${ReviewVO.indate}" type="date" pattern="MM-dd" />
                                </div>
                            </div>
                            <div id="mrev_conbox" >
                            		
                                <div id="mrev_img" style="border-radius: 20px;">
                                	<img src="images/review/${ReviewVO.image}" style="width:350px; height:200px;">                               
                                </div>    
                                <div id="mrev_con" >&nbsp;&nbsp;&nbsp; ${ReviewVO.content}</div>   
                            </div>
                            <!-- if문을 이용한 사장님 답글 -->
                            
                            <div id="sa_reviewbox" >
                                <div id="sarev_info" >
                                <div id="nick_sa" ></div>
                                <div id="sanick" >&nbsp;&nbsp;사장님</div>                               
                                </div>
                                <c:if test="${ReviewVO.replyyn==0}">
                                 <div id="sa_thank">  
                                 <script type="text/javascript">
                                        function addReply(review_seq){
                                        	if( document.frm.reply.value=="" ){
                                        		alert("답글을 적어주세요");
                                        		document.frm.reply.focus();
                                        		return false;
                                        	}     
                                        	
                                        	document.frm.action = "fooba.do?command=res_reviewReplyWrite&review_seq="+review_seq;
                                        	document.frm.submit();
                                        	                                        
                                        }
                                        </script>                            
                                    <textarea id="sa_thank_text" name="reply" rows="5" cols="50" ></textarea><br>
                                    <input type="hidden" value="${ReviewVO.review_seq }" name="rv">
                                    <div id="rev_buttonbox" >
                                        <input type="button" value="답글 달기" id="rev_button" style="box-shadow: 2px 1px rgb(231, 231, 151);"  
                                        onclick="addReply(${param.review_seq})">   
                                        
                                    </div>
                                </div>
                                </c:if>    
                                <c:if test="${ReviewVO.replyyn==1}">
                                <div id="sa_thank" style=" margin-left:600px;">
                                	${ReviewVO.reply}
                                </div>
                                </c:if>                                            
                            </div>  
                        </div><br><hr>
                    </c:forEach>                   
            	</div>
        	</div>
        </form>
</div>
<%@ include file="/restaurant/res_footer.jsp"%>