<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<div id="realjenche2">
        <div id="jenche2">
            <div id="gumae">구매하기</div>
            
            <div id="juso">
                <div class="juso" id="jusotabb" onclick="jusomove(-1);">주소</div>
                <div class="newjuso" id="newjusotabb" onclick="jusomove(1);">배송지 변경</div>
            </div>
            <div id="tul2">
                <div id="juso1">
                    <a class="grayy2">우편번호</a>
                    &nbsp; ${mvo.zip_num }<br>
                    <a class="grayy2">주소</a>
                    &nbsp;${mvo.address1 }<br>
                    <a class="grayy2">상세주소</a>
                    &nbsp;${mvo.address2 }

                    <br>
                    <a class="grayy2">전화번호</a>&nbsp; ${mvo.phone }
    
                </div>
                <div id="juso2">
                    <input type="text" class="gumaeinput_text" style="width: 490px;" name="userzip_num" placeholder="우편번호" readonly/>
                    <input type="button" id="id_btn" value="우편번호 검색" onclick="post_zip()"> 
                    <input type="text" class="gumaeinput_text" name="useraddress1" placeholder="주소" readonly/>
                    <input type="text" class="gumaeinput_text" name="useraddress2" placeholder="상세 주소"/>
                    <input type="text" class="gumaeinput_text" name="phone" placeholder="전화번호"/>

                </div>    
            </div>
            
        </div>
        
        <div id="xxxx">
        	<div class="toggle1">
				배달/포장 
				<input type="radio" id="toggle1-1" name="rideryn" value="0" checked>
				<label for="toggle1-1">배달</label>
				<input type="radio" id="toggle1-2" name="rideryn" value="1">
				<label for="toggle1-2">포장</label>
			</div>
		
			<div class="toggle2">
				일회용품
				<input type="radio" id="toggle2-1" name="plasticyn" value="0" checked>
				<label for="toggle2-1">사용</label>
				<input type="radio" id="toggle2-2" name="plasticyn" value="1">
				<label for="toggle2-2">미사용</label>
			</div>  
		
			<div class="toggle3">
				카드/현금
				<input type="radio" id="toggle3-1" name="payment" value="0" checked>
				<label for="toggle3-1">카드</label>
				<input type="radio" id="toggle3-2" name="payment" value="1">
				<label for="toggle3-2">현금</label>
			</div>
	
            <a class="grayy2">&nbsp;&nbsp;배달/포장</a>
            <input type="radio" value="0" name="rideryn" >배달
            <input type="radio" value="1"name="rideryn" >포장

            <br>
            <a class="grayy2">&nbsp;&nbsp;일회용품 사용</a>
            <input type="checkbox" value="1" name="plasticyn">
            
            <br>
            <a class="grayy2">&nbsp;&nbsp;결제 방법</a>
            <input type="checkbox" value="0" name="payment" checked onclick='checkOnlyOne2(this)'>카드
            <input type="checkbox" value="1"name="payment" onclick='checkOnlyOne2(this)'>현금
        </div>

        <div id="jangbagunitul2">
            <div id="jbtitle2">주문표</div>
            <c:forEach items="${clist }" var="CartVO">
            <div class="jbitem2" id="jb">
                <a class="jbitemname">${CartVO.cfname} x ${CartVO.quantity }&nbsp;&nbsp;&nbsp;</a><a class="jbitemsub">${CartVO.sideyn1}&nbsp;&nbsp; ${CartVO.sideyn2} &nbsp;&nbsp;${CartVO.sideyn3}</a><br>
                <div class="jbitemprice">
                   ${CartVO.cprice} 원&nbsp;
                </div>
            </div>
            </c:forEach>
            
            <div class="baedaltip">배달요금 : 1000원 별도&nbsp;&nbsp;&nbsp;</div>
            <div class="jbtotal">합계 : <input type="text" value="${carttotalprice }" id="jbtotalprice" name="totalprice">원&nbsp;&nbsp;</div>
            <input type="button" value="결제" class="jbwanryo2">

        </div>
    </div>


<%@ include file="../footer.jsp"%>