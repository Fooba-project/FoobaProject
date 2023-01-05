<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ include file="res_header.jsp"%>
<div class="res_join">
    <div class="res_join_title">사업자 회원가입</div>
    <div style="border-top: 2px solid  rgb(255,204,0); margin-top:15px;"></div>
    <form name="res_join_send_form" id="res_join_send_form" method="post" action="fooba.do?command=res_join" enctype="multipart/form-data">
        <table class="member_join_table">
            <div class="join_list">
                <input type="text" class="input_text" style="width: 490px;" name="rid" placeholder="아이디" onkeyup="chkIdCode(event)"/>
                <input type="hidden" name="reid" value=""/>
                <input type="button" id="id_btn" value="중복 확인" onclick="res_idcheck()">
            </div>

            <div class="join_list">
                <input type="password" class="input_text" name="rpwd" 
                id="rpwd"
                placeholder="비밀번호"/>
            </div>

            <div class="join_list">
                <input type="password" class="input_text" name="respwdchk" id="respwdchk" placeholder="비밀번호 확인"/>
            </div>

            <p class="error_text" id="error1"></p>
    
            <div class="join_list">
                <input type="text" class="input_text" name="ownername" placeholder="사업자 이름"/>
            </div>

            <div class="join_list">
                <input type="text" class="input_text" name="rname" placeholder="가게 이름"/>
            </div>

            <div class="join_list">
                <input type="text" id="rbiznum" class="input_text" name="rbiznum" maxlength="15" placeholder="사업자 등록번호" onkeyup="chkPhoneCode(event)"/>
            </div>

            <div class="join_list">
                <input type="text" class="input_text" name="rphone"
                id="rphone"
                 placeholder="가게 전화번호"/>
            </div>

            <p class="error_text" id="error2"></p>

            <div class="join_list">
                <input type="text" class="input_text" style="width: 490px;" name="zip_num" placeholder="우편번호" readonly/>
                <input type="button" id="id_btn" value="우편번호 검색" onclick="res_post_zip()"> 
            </div>
			
			<div class="join_list">
                <input type="text" class="input_text" name="raddress1"
                id="raddress"
                 placeholder="사업장 주소" readonly/>
            </div>
            
			<div class="join_list">
                <input type="text" class="input_text" name="raddress2"
                id="raddress"
                 placeholder="상세 주소"/>
            </div>
 
            <div class="member_join">
                <div class="member_join_title">
                    사업장 정보 입력
                </div>
                <div style="border-top:2px solid  rgb(255,204,0); margin-top:15px;">
                </div>
                
            
                <div class="res_text_boxs">
                     가게 대표이미지
                </div> 
                <div class="join_list">
                    <div id="images_upload_box">
                         <input type="file" class="input_text" name="rimage">
                    </div>
                </div>
                   
                <div class="res_text_boxs">
                    사업장 업종 분류
                </div>
                <div id="res_select_box">
                    <select style="width:60px;" name="kind">
                        <option value="1">한식</option>
                        <option value="2">중식</option>
                        <option value="3">양식</option>
                        <option value="4">일식</option>
                        <option value="5">피자</option>
                        <option value="6">치킨</option>
                        <option value="7">분식</option>
                        <option value="8">디저트</option>
                    </select>
                </div>
                 
                <div id="textarea_box">
                    <textarea placeholder="사업장 소개글을 작성해주세요" name="content"></textarea>
                </div>
                <div class="join_list">
                    <input type="text" class="input_text" name="rtip" placeholder="기본배달료를 입력하세요">
                </div>
                <div class="join_list">
                    <input type="text" class="input_text" name="hash" placeholder="해시태그">
                </div>
                <div class="res_text_boxs">
                    <span style="line-height:0px; ">예시) &nbsp; 국물음식, 건강한, 가성비
                    </span>
                </div>
 
                <br>
                <div id="join_agree_btn">
                    <input type="checkbox" name="useragree" id="join_agree" value="Y">
                    <label for="join_agree">이용약관</label>
                </div>
                <div id="join_agree_text">
                     <h3 style="text-align: center;">제1장 총칙</h3>
                    <h5>제1조 [목 적]</h5>
                    <p>본 서비스 약관은 주식회사 푸바에서 제공하는 서비스의 이용에 관련하여 회원과 푸바 간의 권리, 의무, 책임 및 기타 필요한 사항을 규정함을 목적으로 합니다.</p>
                </div>
            </div>
        </table>
            <br><br>
            <div id="join_btn">
                <input class="join_btn" type="button" value="가입" onclick="joincheck()">
                <input class="join_btn" type="button" value="홈으로" onclick="location.href='fooba.do?command=res_login'">
            </div>
    </form>
</div>
<%@ include file="res_footer.jsp"%>