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
            <div class="res_infotab" onclick="location.href='fooba.do?command=res_order'">진행중인 주문 현황</div>      
            <div class="res_infotab" onclick="location.href='fooba.do?command=res_orderAll'">총 주문현황</div>
        </div>
        
        <form id="res_menuall" name="rfm" method="post" >
                    <div id="res_orderlistitems">
                    <c:forEach items="${res_OrderList}" var="ovo">
                        <div class="res_order_list">
                            <div>
                                주문번호 : ${ovo.oseq}
                            </div>
                            <div>
                                주문일시 : <fmt:formatDate value="${ovo.indate}" type="date" pattern="yyyy-MM-dd (a)hh:mm:ss" />
                            </div>
                            <div id="wnanssodur">
                                <div id="wnanssodurwpahr">주문내역 : </div><div id="wnanssodursodyd">${ovo.oname}</div> 
                            </div>
                            <div>
                                주문금액 : <fmt:formatNumber value="${ovo.totalprice }" pattern="#,###원"/>
                            </div>
                        </div>
                        
                        <div class="menuorderdetaildiv">
                            <div id="menuorderdetaildiv3">닉네임 : ${ovo.nick}</div>
                            <div id="menuorderdetaildiv3">배달주소 : ${ovo.address1}&nbsp;${ovo.address2}</div>
                            <div id="menuorderdetaildiv3">전화번호 : ${ovo.phone}</div>
                            <div id="menuorderdetaildiv3">배달/포장여부 : 
                                <c:if test="${ovo.rideryn==0}">
                                    배달${ovo.rideryn }
                                </c:if>
                                <c:if test="${ovo.rideryn==1}">
                                    포장${ovo.rideryn }
                                </c:if>
                            </div>
                            <div id="menuorderdetaildiv3">일회용품 여부 : 
                                <c:if test="${ovo.plasticyn==0}">
                                    사용${ovo.plasticyn }
                                </c:if>
                                <c:if test="${ovo.plasticyn==1}">
                                    미사용${ovo.plasticyn }
                                </c:if>
                            </div>
                            <div id="menuorderdetaildiv3">결제방법 : 
                                <c:if test="${ovo.payment==0}">
                                    카드결제${ovo.payment}
                                </c:if>
                                <c:if test="${ovo.payment==1}">
                                    현금결제${ovo.payment}
                                </c:if>
                            </div>
                        </div>  
                      <br><hr>
	                </c:forEach>
                    </div>
                </form>
 </div>

<%@ include file="/restaurant/res_footer.jsp"%>