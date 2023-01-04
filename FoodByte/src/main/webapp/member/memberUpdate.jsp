<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

    <div class="member_join">
        <div class="member_join_title">회원정보수정</div>
        <div style="border-top: 2px solid #fa6146; margin-top:15px;"></div>
        <form name="member_update_form" id="member_join_send_form" method="post" action="fooba.do?command=join">
            <table class="member_join_table">
                <div class="join_list">
                    <input type="text" class="input_text" name="userid" value="${loginUser.id}" readonly/>
                </div>

                <div class="join_list">
                    <input type="password" class="input_text" name="userpwd" 
                    id="userpwd" placeholder="비밀번호" style="color:red;"/>
                </div>
				<div class="join_list">
                  <input type="password" class="input_text" name="userpwdchk" id="userpwdchk" placeholder="비밀번호 확인" style="color:red;"/>
                </div>
				
                <p class="error_text" id="error1"></p>
    
                <div class="join_list">
                    <input type="text" class="input_text" name="username" placeholder="${loginUser.name}" style="color:red;" readonly/>
                </div>

                <div class="join_list">
                    <input type="text" id="userphone" class="input_text" name="userphone" maxlength="13" placeholder="${loginUser.phone}" onkeyup="chkPhoneCode(event)" style="color:red;"/>
                </div>

                <div class="join_list">
                    <input type="text" class="input_text" name="useremail"
                    id="useremail"
                    placeholder="${loginUser.email}" style="color:red;"/>
                </div>

                <p class="error_text" id="error2"></p>

                <div class="join_list">
                    <input type="text" class="input_text" style="width: 490px; color:red;" name="userzip_num"  placeholder="${loginUser.zip_num}" readonly />
                    <input type="button" id="id_btn" value="우편번호 검색" onclick="post_zip()"> 
                </div>

                <div class="join_list">
                    <input type="text" class="input_text" name="useraddress1" placeholder="${loginUser.address1}" style="color:red;"/>
                </div>

                <div class="join_list">
                    <input type="text" class="input_text" name="useraddress2" placeholder="${loginUser.address2}" style="color:red;"/>
                </div>

                <div class="join_list" margin="20px">
                    <input type="text" class="input_text" name="usernick" placeholder="${loginUser.nick}" style="color:red;"/>
                </div>

                <p class="error_text">* 입력하지 않을 시 이름으로 사용됩니다.</p>

                <br>
                
            </table>
            <br><br>
            <div id="join_btn">
            <input class="join_btn" type="button" value="정보수정" class="submit" onclick="go_update();"> 
			<input class="join_btn" type="reset" value="취소" class="cancel" onclick="location.href='fooba.do?command=index'"></div>
            </div>
        </form>
    </div>
<%@ include file="../footer.jsp"%>