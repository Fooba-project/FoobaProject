<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script type="text/javascript" src="//code.jquery.com/jquery-2.1.3.min.js"></script>
    <script src = "script/jquery-3.6.1.js"></script>
    <script type="text/javascript">
        
        function autoHypenPhone(str){
            str = str.replace(/[^0-9]/g, '');
            var tmp = '';
            if( str.length < 4){
                return str;
            }else if(str.length < 7){
                tmp += str.substr(0, 3);
                tmp += '-';
                tmp += str.substr(3);
                return tmp;
            }else if(str.length < 11){
                tmp += str.substr(0, 3);
                tmp += '-';
                tmp += str.substr(3, 3);
                tmp += '-';
                tmp += str.substr(6);
                return tmp;
            }else{              
                tmp += str.substr(0, 3);
                tmp += '-';
                tmp += str.substr(3, 4);
                tmp += '-';
                tmp += str.substr(7);
                return tmp;
            }
            return str;
        }

        function chkIdCode(event) {
            const regExp = /[^0-9a-zA-Z]/g;
            if (regExp.test(event.target.value)) {
                event.target.value = event.target.value.replace(regExp, '');
            }
        }

        function chkPhoneCode(event){
            const regExp1 = /[^0-9a-zA-Z]/g;
            if (regExp1.test(event.target.value)) {
                event.target.value = event.target.value.replace(regExp1, '');
            }

            const regExp2 = /[0-9]/g;
            if (regExp2.test(event.target.value)) {
                var _val =  event.target.value.trim();
                event.target.value = autoHypenPhone(_val);
            }

            const regExp3 = /^[a-zA-Z]*$/;
            if (regExp3.test(event.target.value)) {
                event.target.value = event.target.value.replace(regExp3, '');
            }
        }
     
        
        $( function(){
            $("#userpwdchk").keyup( function(event){
                event.target.value = event.target.value.trim();
                let pass1 = $("#userpwd").val();
                let pass2 = $("#userpwdchk").val();
                if (pass1 != "" || pass2 != ""){
                    if (pass1 == pass2){
                        $("#error1").html('');
                    } else {
                        $("#error1").html('비밀번호가 일치하지 않습니다.');
                        $("#error1").css('color','red');
                    }
                }
            })

            $("#userpwd").keyup( function(event){
                event.target.value = event.target.value.trim();
                let pass1 = $("#userpwd").val();
                let pass2 = $("#userpwdchk").val();
                if (pass1 != '' && pass2 != ''){
                    if (pass1 == pass2){
                        $("#error1").html('');
                    } else {
                        $("#error1").html('비밀번호가 일치하지 않습니다.');
                        $("#error1").css('color','red');
                    }
                }
            })
 
            $("#useremail").keyup( function(event){
                const regExp = /[ㄱ-ㅎㅏ-ㅣ가-힣]/g;
                event.target.value = event.target.value.trim();
                if (regExp.test(event.target.value)) {
                    event.target.value = event.target.value.replace(regExp, '');
                }
                let email = $("#useremail").val();
                var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
                if (!reg_email.test(email)){
                    $("#error2").html('이메일 형식이 잘못되었습니다.');
                    $("#error2").css('color','red');
                } else {
                    $("#error2").html('');
                }
            })
        } )

    </script>
        

   <style type="text/css">
        .member_join {width: 700px; overflow: hidden;}
        #input_warp { margin: 0; width: 700px;}
        .join_list { position: relative; height: 44px; padding: 0; margin: 0; overflow: hidden; border-radius: 3px; margin: 10px;}

        .member_join_title { text-align: left; font-size: 26px;font-weight: bold; }

        .error_text { font-family: Verdana, Geneva, Tahoma, sans-serif; margin: 0; margin-left: 20px; font-size: 60%; padding: 0;}

        .input_text {overflow: hidden;position: relative;display: block; width: 100%;padding: 10px 13px; background: #ffffff;box-sizing: border-box;-moz-box-sizing: border-box;-webkit-box-sizing: border-box;font-size: 15px;color: #616161;font-weight: 900;-webkit-transition: all .3s;transition: all .3s;border-radius: 3px;-webkit-border-radius: 3px; border: 1px solid #BCBCBC;}
        
        .join_list #id_btn {  position: absolute;  width: 180px;  height: 45px;  top: 0px; right: 0;  border: 0; border-radius: 3px;}
        .join_list #id_btn:hover { outline: 0px solid #9191dfab; background-color: rgb(125, 114, 245);}

        #join_btn {margin-left: 200px;}
        #join_btn .join_btn {width: 150px; height: 50px; border-radius: 5px; text-decoration: none; font-weight: bold; font-size: 100%; font-family: Verdana, Geneva, Tahoma, sans-serif; background-color: #fa6146; line-height: 40px; color:#fff; border: 1px solid white; text-align: center;}
        #join_btn .join_btn:hover {background-color: white; color: #fa6146; cursor: pointer; border:2px solid #fa6146}

        #join_agree_text {width: 680px; height: 120px; overflow-y: auto; border: 1px solid #ccc;  margin: 10px;}
        #join_agree_btn {margin:10px;}
   </style>
</head>
<body>
    <div class="member_join">
        <div class="member_join_title">회원가입</div>
        <div style="border-top: 2px solid #fa6146; margin-top:15px;"></div>
        <form name="member_join_send_form" id="member_join_send_form" method="post" action="#">
            <table class="member_join_table">
                <div id="input_warp"><br>

                    <div class="join_list">
                        <input type="text" class="input_text" style="width: 490px;" name="userid" placeholder="아이디" onkeyup="chkIdCode(event)"/>
                        <input type="hidden" name="userreid" value=""/>
                        <button id="id_btn">중복 확인</button>
                    </div>

                    <div class="join_list">
                        <input type="password" class="input_text" name="userpwd" 
                        id="userpwd"
                        placeholder="비밀번호"/>
                    </div>

                    <div class="join_list">
                        <input type="password" class="input_text" name="userpwdchk" id="userpwdchk" placeholder="비밀번호 확인"/>
                    </div>

                    <p class="error_text" id="error1"></p>
        
                    <div class="join_list">
                        <input type="text" class="input_text" name="username" placeholder="이름"/>
                    </div>

                    <div class="join_list">
                        <input type="text" id="userphone" class="input_text" name="userphone" maxlength="13" placeholder="전화번호" onkeyup="chkPhoneCode(event)"/>
                    </div>

                    <div class="join_list">
                        <input type="text" class="input_text" name="useremail"
                        id="useremail"
                        placeholder="이메일"/>
                    </div>

                    <p class="error_text" id="error2"></p>

                    <div class="join_list">
                        <input type="text" class="input_text" style="width: 490px;" name="userzip_num" placeholder="우편번호" readonly/>
                        <button id="id_btn">우편번호 검색</button>
                    </div>

                    <div class="join_list">
                        <input type="text" class="input_text" name="useraddress1" placeholder="주소" readonly/>
                    </div>

                    <div class="join_list">
                        <input type="text" class="input_text" name="useraddress2" placeholder="상세 주소"/>
                    </div>

                    <div class="join_list" margin="20px">
                        <input type="text" class="input_text" name="usernick" placeholder="닉네임(별명)"/>
                    </div>

                    <p class="error_text">* 입력하지 않을 시 이름으로 사용됩니다.</p>

                    <br>
                    <div id="join_agree_btn">
                        <input type="checkbox" name="useragree" id="join_agree" value="Y">
                        <label for="join_agree">이용약관</label>
                    </div>
                    <div id="join_agree_text">
                        <h3 style="text-align: center;">제1장 총칙</hr>
                        <h5>제1조 [목 적]</h5>
                        <p>본 서비스 약관은 주식회사 푸바에서 제공하는 서비스의 이용에 관련하여 회원과 푸바 간의 권리, 의무, 책임 및 기타 필요한 사항을 규정함을 목적으로 합니다.</p>
                    </div>
                    
                </span>
            </table>
            <br><br>
            <div id="join_btn">
                <input class="join_btn" type="submit" name="join" value="가입" onclick="">
                <input class="join_btn" type="button" name="gohome" value="홈으로" onclick="">
            </div>
        </form>
    </div>
</body>
</html>