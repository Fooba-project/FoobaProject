<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<style type="text/css">
#review_form {text-align: center;}
#review_form fieldset{border:0; display: inline-block; direction: rtl; text-align: center;}
#review_form input[type=radio]{display: none;} 
#review_form label{font-size: 3em;color: transparent;text-shadow: 0 0 0 #d1d1d1;}
#review_form label:hover{text-shadow: 0 0 0 rgba(255, 111, 44); cursor: pointer;}
#review_form label:hover ~ label{text-shadow: 0 0 0 rgba(255, 111, 44);}
#review_form input[type=radio]:checked ~ label{text-shadow: 0 0 0 rgba(255, 111, 44);}
#star_box{width: 100%;}
#reviewContent {width: 100%; height: 150px;padding: 10px; box-sizing: border-box; border: solid 1.5px #D3D3D3; border-radius: 5px; font-size: 16px; resize: none;}

#menuorderdetail {width: 75%;}
.menuorderdetaildiv {background-color: #f0f0f0; padding:10px;}
#menuorderdetaildiv1_1 {color:#ffae7f; font-size: 20px; font-weight: bold; margin-bottom: 10px;}
#menuorderdetaildiv1_2 {font-size: 25px; font-weight: bold; margin-bottom: 10px;}
#menuorderdetaildiv1_3 {font-size: 16px; font-weight: bold; margin-bottom: 5px;}
#menuorderdetaildiv3 {margin-bottom: 5px;}
#reviewWriteButton {width: 100%; height: 50px; font-size: 150%; border: 0; background-color: #fd6913; cursor: pointer; color: white;}
</style>
</head>
<body>
<form name="orderForm" method="post" action="fooba.do?command=memberJoin">
<div id="menuorderdetail">
    <div class="menuorderdetaildiv" id="menuorderdetaildiv1">
        <div id="menuorderdetaildiv1_2">${ovo.rname}</div>
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
        <div id="menuorderdetaildiv1_3">
            총주문가격 : ${ovo.totalprice}원(포매터)
        </div>
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
</div>
</form>					   
</body>
</html>