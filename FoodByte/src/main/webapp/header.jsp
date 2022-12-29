<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<fmt:setLocale value="ko_KR"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fooba</title>
<link href="css/fooba.css" rel="stylesheet">
<script type="text/javascript" src="//code.jquery.com/jquery-2.1.3.min.js"></script>
<script src = "script/jquery-3.6.1.js"></script>
<script src="javascript/fooba.js"></script>
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
    body {margin: 0;}
    #head1 {position:absolute; width: 100%; height: 110px; background-color: #fa6146; margin: 0 auto;}
    #mainlogo1 {position: relative; text-align: center; width: 150px; height: 100px; margin: 0 auto;}
    #logo1 {position: absolute; left: 5px; top: -5px; width: 145px; height: 145px;}

        #main{position:absolute; width:100%; height: 420px; background-color: #fa6146;left:0; bottom: 0px;}   

        #search{margin-top: 50px; text-align: center; 
        }

        #searchtext{width:400px; height:35px; border-radius: 10px; border:none;
        }

        #searchicon{position: relative; top: -30px; width:40px; left:1115px; cursor: pointer; opacity:50%;}

        .kindbox {position:relative; border: 1px solid white; width: 130px; height:130px; float: left; border-radius: 10px; margin: 20px; cursor: pointer; left: 350px; margin-top: 10px;}
        .kindbox span {position:absolute; color: white; top:10px; font-family: Verdana; left: 40PX; }
        .kindbox img {position:absolute; top: 40px; width:63.5px; height:60px; margin-left: 30px; }

        #background{ position:absolute; width:100%; height:600px;
        background-repeat: no-repeat;
        top:50px;left:0;bottom:0;right:0;
        margin:0px; padding:0px; }

        #hash{position: absolute; width:100%; height:70px; background-color: white;
        z-index: 100; margin-top:490px; left: 0;}

        .hashbox{position: relative; width: 100px; height: 70px; left:400px; cursor: pointer; float: left;
        margin: 2px; margin-left:150px;}

        .hashbox span{position: absolute; line-height:70px; color: #fa6146; font-weight: bold; font-family: Verdana; left: 25px; font-size:120%;}

        #maintextbox{position: absolute; width:auto; height: auto; z-index: 100; right: 190px; top: 300px;}

        #maintextbox span{position: relative;
        font-size:200%; font-weight: bold; color: #fa6146; white-space:pre;} 
   
    #footerbox{position: absolute;  height: 100px; width: 100%; background-color: white; margin-top:861px; left: 0px;
        right:0px; 
    }
    #copy{position: absolute; top: 10px; text-align: center; right:0px; font-size: 15px; opacity: 80%; color: #fa6146;}

    #logo{position:absolute; z-index: 100; width:80px; height: 90px;
    left: 20px; opacity: 60%;}

    #logotextbox{position: absolute; left: 100px;
    line-height:25px; width: 500px;}
   
    #logotext{white-space:pre; font-family: Verdana; font-weight: bold; opacity: 80%; color: #fa6146;}

    .linemenubox{position: relative;
    width: 150px; height: 20px; cursor: pointer; float: right;  right:0px; margin:1px; 
    top:60px; font-weight: bold;
    color: #fa6146; text-align: center;}

    
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

    <div id="head1">
        <div id="mainlogo1">
            <img src="images/mainlogo1.png" id="logo";>
        </div>
    </div>