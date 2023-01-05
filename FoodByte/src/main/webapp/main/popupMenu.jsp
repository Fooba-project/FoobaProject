<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="popup">
      <div class="popupheader">메뉴상세</div>
      <div class="popupcontext">
        <img class="popupimgg"
          src="/images/Chicken\bbq\23000_72606988a4ff18e71f4f7f82d5ef75b31615794552.jpg"
        />
        <div id="contextsub">
          <h2 class="contextsub2">bbq 황금올리브</h2>
          <p>
            맛있는 치킨입니다. 맛있는 치킨입니다. 맛있는 치킨입니다. 맛있는
            치킨입니다. 맛있는 치킨입니다. 맛있는 치킨입니다. 맛있는 치킨입니다.
            맛있는 치킨입니다. 맛있는 치킨.
          </p>
        </div>
        <div class="contextprice">
          <div class="contextprice1">&nbsp; 가격</div>
          <div class="contextprice2">20000원 &nbsp;</div>
        </div>
        <div class="contextoption">
          <div class="optionnn">&nbsp; 옵션&nbsp;(추가선택 가능)</div>
          <div class="popupchecks">
            <input type="checkbox" id="option1" />
            <label for="option1"
              >소스1
              <div class="optionprice">+500원 &nbsp;</div></label
            >
          </div>
          <div class="popupchecks">
            <input type="checkbox" id="option2" />
            <label for="option2"
              >소스2
              <div class="optionprice">+500원 &nbsp;</div></label
            >
          </div>
          <div class="popupchecks">
            <input type="checkbox" id="option3" />
            <label for="option3"
              >소스3
              <div class="optionprice">+500원 &nbsp;</div></label
            >
          </div>
        </div>

        <div class="popupquantity">
          <div class="pquantity">&nbsp; 수량</div>
          <div class="pbox">
            <input
              class="pbox_button"
              value="-"
              count_range="m"
              type="button"
            />
            <input class="pcount" value="1" maxlength="2" readonly />
            <!--읽기전용으로 readonly 표시-->
            <input
              class="pbox_button"
              value="+"
              count_range="p"
              type="button"
            />
          </div>
        </div>

        <div class="popuptotal">
          <div class="ptotal">&nbsp; 총 주문금액</div>
          <div class="pwon">20000원 &nbsp;</div>
        </div>
      </div>

      <div class="popupbutton">
        <button id="plbutton">주문표에 추가</button>
        <button id="prbutton">주문하기</button>
      </div>
    </div>

</body>
</html>