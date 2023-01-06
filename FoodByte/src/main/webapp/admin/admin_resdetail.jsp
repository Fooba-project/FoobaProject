<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="admin_header.jsp"%>
    
<div class="res_join">
    <div class="res_join_title">레스토랑 정보</div>
    <div style="border-top: 2px solid rgb(23,55,94); margin-top:15px;"></div>
    <form name="res_join_send_form" id="res_join_send_form" method="post" action="fooba.do?command=res_join" enctype="multipart/form-data">
        <table class="member_join_table">
            <div class="join_list">
                <input type="text" class="input_text" value=" 아이디 : ${rvo.rid}" readonly/>            
            </div> 
            <div class="join_list">
                <input type="text" class="input_text" value="사장님 이름 : ${rvo.ownername}" readonly/> 
            </div>
            <div class="join_list">
                <input type="text" class="input_text" value="가게 번호 : ${rvo.rphone}" readonly/> 
            </div>
            <div class="join_list">
                <input type="text" id="rbiznum" class="input_text" value="사업자 번호 : ${rvo.rbiznum}" readonly/>
            </div>			
			<div class="join_list">
                <input type="text" class="input_text" value="사업장 주소 : ${rvo.raddress}" readonly/>
            </div>
            <div class="join_list">
                <input type="text" class="input_text" value="사업장 업종 : ${rvo.rkind}" readonly/>
            </div>
            <div class="join_list">
                <input type="text" class="input_text" value="사업장 소개글 : ${rvo.content}" readonly/>
            </div>
            <div class="join_list">
                <input type="text" class="input_text" value="배달료 : ${rvo.rtip}" readonly/>
            </div>
            <div class="join_list">
                <input type="text" class="input_text" value="해시태그 : ${rvo.hash}" readonly/>
            </div>      

        </table>
            <br><br>
            <div id="join_btn">
                <input style="margin-left:80px; background-color:rgb(23,55,94)" class="join_btn" type="button" value="목록" onclick="location.href='fooba.do?command=admin_restaurantList'">
            </div>
    </form>
</div>

<%@ include file="admin_footer.jsp"%>