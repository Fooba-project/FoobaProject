<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="mypage_sub.jsp"%>

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
                    배달완료(후기를 작성해주세요)
                </c:when>
                <c:when test="${ovo.result==3}">
                    후기작성완료
                </c:when>
            </c:choose>
        </div>
        <div id="menuorderdetaildiv1_2">${ovo.rname}</div>
        <div id="menuorderdetaildiv1_3">주문번호 : ${ovo.oseq}</div>
        <div id="menuorderdetaildiv1_3">주문일시 : ${ovo.intime}</div>
        <div id="menuorderdetaildiv1_3">총주문가격 : ${ovo.totalprice}원(포매터)</div>
    </div>
<br>
    <div class="menuorderdetaildiv">
        <div id="menuorderdetaildiv2_1">${odvo.fname} ${odvo.quantity}개</div>
        <div id="menuorderdetaildiv2_2">${odvo.side} : 
            <c:if test=""></c:if>${odvo.sideyn}</div>
        <div id="menuorderdetaildiv2_2">2옵션 여부</div>
        <div id="menuorderdetaildiv2_2">3옵션 여부</div>
        <div id="menuorderdetaildiv2_3">가격</div>
    </div>
<br>
    <div class="menuorderdetaildiv">
        <div id="menuorderdetaildiv3">배달주소 : ${ovo.address} ${ovo.address2}</div>
        <div id="menuorderdetaildiv3">전화번호 : ${ovo.phone}</div>
        <div id="menuorderdetaildiv3">배달/포장여부 : 
            <c:if test="${ovo.rideryn==0}">
                포장
            </c:if>
            <c:if test="${ovo.rideryn==1}">
                배달
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
            <div>
                <textarea class="review" type="text" id="reviewContent" name="reviewContent"
                    placeholder="음식에 대한 솔직한 리뷰를 남겨주세요!"></textarea>
            </div>
            <input type="submit" value="확인" id="reviewWriteButton">
        </form>
    </c:if>

    <c:if test="${ovo.result==3}">
        <form class="review" name="review_form" id="review_form" method="post">
            <fieldset>
                <div id="star_box">
                        <label>★</label>
                </div>
            </fieldset>
            <div>
                <textarea class="review" type="text" id="reviewContent" readonly>${ovo.rcontent }</textarea>
            </div>
        </form>
    </c:if>
</div>

<%@ include file="../footer.jsp"%>
