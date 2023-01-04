function resCheck(){
	  if(document.loginForm.resid.value==""){
	      	alert("아이디를 입력하세요.");
	      	return false;
	  }else if(document.loginForm.respw.value==""){
	     	alert("비밀번호를 입력하세요.");
	      	return false;
	  }
	  return true;  
}