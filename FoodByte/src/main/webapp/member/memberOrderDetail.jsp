<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="mypage_sub.jsp"%>
<script type="text/javascript">
function setThumbnail(event) {
	var reader = new FileReader();
    reader.onload = function(event) {
    	document.review_form.image_container.empty();
    	var img = document.createElement("img");
     	img.setAttribute("src", event.target.result);
    	document.querySelector("div#image_container").appendChild(img);
    };
    reader.readAsDataURL(event.target.files[0]);
}
</script>
<div id="menuorderdetail">
    <div class="menuorderdetaildiv" id="menuorderdetaildiv1">
        <div id="menuorderdetaildiv1_1">
            <c:choose>
                <c:when test="${ovo.result==0}">
                    주문확인중
                </c:when>
                <c:when test="${ovo.result==1}">
                    배달중
                </c:when>
                <c:when test="${ovo.result==2}">
                    배달완료
                </c:when>
                <c:when test="${ovo.result==3}">
                    후기작성완료
                </c:when>
            </c:choose>
        </div>
        <div id="menuorderdetaildiv1_2">${ovo.rname}</div>
        <div id="menuorderdetaildiv1_3">주문번호 : ${ovo.oseq}</div>
        <div id="menuorderdetaildiv1_3">주문일시 : <fmt:formatDate value="${ovo.indate }" pattern="yyyy-MM-dd HH:mm:ss"/></div>
        <div id="menuorderdetaildiv1_3">총주문가격 : <fmt:formatNumber value="${ovo.totalprice}" pattern="#,###원"/></div>
        <div id="menuorderdetaildiv1_4">(음식가격 : <fmt:formatNumber value="${ovo.totalprice-ovList[0].rtip}" pattern="#,###원"/>, 배달팁 : <fmt:formatNumber value="${ovList[0].rtip}" pattern="#,###원"/>)
        </div>
    </div>
<br>
	<c:forEach  items="${ovList }" var="ovvo">
	    <div class="menuorderdetaildiv">
	        <div id="menuorderdetaildiv2_1">${ovvo.fname} <fmt:formatNumber value="${ovvo.fprice }" pattern="#,###원"/></div>
	        <div id="menuorderdetaildiv2_2">
	            <c:if test="${ovvo.sideyn1==1}">
	            	${ovvo.fside1} (+<fmt:formatNumber value="${ovvo.fsideprice1 }" pattern="#,###원"/>) 추가
	            </c:if>
	        </div>
	        <div id="menuorderdetaildiv2_2">
	            <c:if test="${ovvo.sideyn2==1}">
	            	${ovvo.fside2} (+<fmt:formatNumber value="${ovvo.fsideprice2 }" pattern="#,###원"/>) 추가
	            </c:if>
	        </div>
	        <div id="menuorderdetaildiv2_2">
	            <c:if test="${ovvo.sideyn3==1}">
	            	${ovvo.fside3} (+<fmt:formatNumber value="${ovvo.fsideprice3 }" pattern="#,###원"/>) 추가
	            </c:if>
	        </div>
	        <div id="menuorderdetaildiv2_2" style="font-size: 16px; font-weight: bold;">주문 수량 : ${ovvo.quantity}개</div>
	    </div>
	<br>
    </c:forEach>

    <div class="menuorderdetaildiv">
    	<div id="menuorderdetaildiv3">닉네임 : ${ovList[0].nick}</div>
        <div id="menuorderdetaildiv3">배달주소 : ${ovo.address1}&nbsp;${ovo.address2}</div>
        <div id="menuorderdetaildiv3">전화번호 : ${ovo.phone}</div>
        <div id="menuorderdetaildiv3">배달/포장여부 : 
            <c:if test="${ovo.rideryn==0}">
                포장
            </c:if>
            <c:if test="${ovo.rideryn==1}">
                배달 (배달료 : + ${ovList[0].rtip }원)
            </c:if>
        </div>
        <div id="menuorderdetaildiv3">일회용품 여부 : 
            <c:if test="${ovo.rideryn==0}">
                포함
            </c:if>
            <c:if test="${ovo.rideryn==1}">
                미포함
            </c:if>
        </div>
        <div id="menuorderdetaildiv3">결제방법 : 
            <c:if test="${ovo.rideryn==0}">
                현금결제
            </c:if>
            <c:if test="${ovo.rideryn==1}">
                카드결제
            </c:if>
        </div>
    </div>
<br>
    <c:if test="${ovo.result==2}">
        <form class="review" name="review_form" id="review_form" method="post">
            <fieldset>
                <span class="star_text" id="star_text">
                    별점을 선택해주세요
                </span>
                <div id="star_box">
                        <input type="radio" name="reviewStar" value="5" id="rate5">
                        <label for="rate5">★</label>
                        <input type="radio" name="reviewStar" value="4" id="rate4">
                        <label for="rate4">★</label>
                        <input type="radio" name="reviewStar" value="3" id="rate3">
                        <label for="rate3">★</label>
                        <input type="radio" name="reviewStar" value="2" id="rate2">
                        <label for="rate2">★</label>
                        <input type="radio" name="reviewStar" value="1" id="rate1">
                        <label for="rate1">★</label>
                    </div>
            </fieldset>
            <div id="review_img">
            	<label for="review_image" >리뷰 이미지 첨부</label>
            	<input type="file" id="review_image" onchange="setThumbnail(event);" value="리뷰 이미지 첨부" style="display:none;" accept="image/*" />
            </div>
    		<div id="image_container"></div>
            <div>
                <textarea class="review" type="text" id="reviewContent" name="reviewContent"
                    placeholder="음식에 대한 솔직한 리뷰를 남겨주세요!"></textarea>
            </div>
            <input type="submit" value="리뷰 작성" id="reviewWriteButton">
        </form>
    </c:if>

    <c:if test="${ovo.result==3}">
        <form class="review" name="review_form" id="review_form" method="post">
            <fieldset>
                <div id="star_box">
                	<label>
                		<c:if test="${ovList[0].star==1}">★</c:if>
                		<c:if test="${ovList[0].star==2}">★★</c:if>
                		<c:if test="${ovList[0].star==3}">★★★</c:if>
                		<c:if test="${ovList[0].star==4}">★★★★</c:if>
                		<c:if test="${ovList[0].star==5}">★★★★★</c:if>                        
                    </label>
                </div>
            </fieldset>
            <div>
                <textarea class="review" type="text" id="reviewContent" readonly>${ovo.rcontent }</textarea>
            </div>
        </form>
    </c:if>
</div>

<%@ include file="../footer.jsp"%>
