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
        
        
 function joincheck() {
		if(document.member_join_send_form.userid.value.length==0){
			alert("아이디를 입력하세요");
			document.member_join_send_form.userid.focus();
		}
		else if(document.member_join_send_form.userreid.value.length==0){
			alert("아이디 중복확인을 하지 않았습니다.");
			document.member_join_send_form.userid.focus();		
		}
		else if(document.member_join_send_form.userreid.value != document.member_join_send_form.userid.value){
			alert("아이디 중복확인을 하지 않았습니다.");
			document.member_join_send_form.userid.focus();	
		}
		else if(document.member_join_send_form.userpwd.value.length==0){
			alert("비밀번호를 입력하세요.");
			document.member_join_send_form.userpwd.focus();
		}
		else if(document.member_join_send_form.userpwd.value != document.member_join_send_form.userpwdchk.value){
			alert("비밀번호 확인이 일치하지 않습니다.");
			document.member_join_send_form.userpwdchk.focus();
		}
		else if(document.member_join_send_form.username.length==0){
			alert("이름을 입력하세요.");
			document.member_join_send_form.username.focus();
		}
		else if(document.member_join_send_form.userphone.value.length==0){
			alert("전화번호를 입력하세요.");
			document.member_join_send_form.userphone.focus();
		} 
		else if(document.member_join_send_form.useremail.value.length==0){
			alert("이메일을 입력하세요.");
			document.member_join_send_form.useremail.focus();
		}
		else if(document.member_join_send_form.useraddress1.value.length==0){
			alert("주소를 입력하세요.");
			post_zip();
		}
		else if(document.member_join_send_form.useraddress2.value.length==0){
			alert("주소를 입력하세요.");
			document.member_join_send_form.useraddress2.focus();
		}
		else if( document.member_join_send_form.useragree.checked==false){
			alert("약관에 동의하셔야 회원가입이 가능합니다.");
			document.member_join_send_form.useragree.focus();
		}
		else {
			document.member_join_send_form.submit();
		}
}

function idcheck(){
	if( document.member_join_send_form.userid.value=="" ){
		alert("아이디를 입력하고 중복체크를 진행하세요" );
		documnet.member_join_send_form.userid.focus();
		return;
	}
	var url = "fooba.do?command=idCheckForm&userid=" + document.member_join_send_form.userid.value;
	var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250, scrollbars=no";
	window.open(url, "IdCheck", opt);	
}


function loginCheck(){
	if(document.loginFrm.id.value==""){
		alert("아이디는 필수입력사항입니다");
		document.userloginFrm.userid.focus();
		return false;
	}else if(document.loginFrm.pwd.value==""){
		alert("비밀번호는 필수입력사항입니다");
		document.userloginFrm.userpwd.focus();
		return false;
	}else{
		return true;	
	}	
}

function idok( userid ){
	opener.member_join_send_form.userid.value = userid;
	opener.member_join_send_form.userreid.value = userid;
	self.close();
}



function post_zip(){
	var url = "fooba.do?command=findZipNum";
	var opt = "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=550, height=300, top=300, left=300";
	window.open( url, "우편번호 찾기", opt);
}




function result( zip_num, sido, gugun, dong){
	//  함수 호출 형태 - result( '123-123', '서울시', '서대문구',  '대현동')
	opener.document.member_join_send_form.userzip_num.value=zip_num;
	opener.document.member_join_send_form.useraddress1.value=sido+" "+gugun+" "+dong;
	self.close();
}


function go_update(){
	if ((document.member_update_form.pwd.value != document.member_update_form.pwdCheck.value)) {
	    alert("비밀번호가 일치하지 않습니다.");
	    document.member_update_form.pwd.focus();
	}else if (document.member_update_form.name.value == "") {
	    alert("이름을 입력해 주세요.");
	    document.member_update_form.name.focus();
	} else if (document.member_update_form.phone.value == "") {
	    alert("전화번호를 입력해 주세요.");
	    document.member_update_form.email.focus();
	}else {
	    document.member_update_form.action = "fooba.do";
	    document.member_update_form.submit();
	}
}