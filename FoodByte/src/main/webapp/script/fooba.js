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
		} else {
			document.member_join_send_form.submit();
		}
}