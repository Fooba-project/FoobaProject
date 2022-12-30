<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<div id="maintextbox">
	<img src="images/background1.jpg">
    <span id="maintext">음식은 푸바, 
        배달은 푸바!
     </span>
</div>
    
<div id="hash">
    <div class="hashboxes">
        <div class="hashbox">
        <span class="hashtext">#푸짐해요</span>
        </div>
        <div class="hashbox">
        <span class="hashtext">#매워요</span>
        </div>
        <div class="hashbox">
        <span class="hashtext">#소울푸드</span>
        </div>
        <div class="hashbox">
        <span class="hashtext">#건강한맛집</span>
        </div>
        <div class="hashbox">
        <span class="hashtext">#가성비</span>
        </div>
        <div class="hashbox">
        <span class="hashtext">#나눠먹어요</span>
        </div>
    </div>
</div>

<div id="main">
    <div id="search">
        <input id="searchtext" placeholder="   검색어를 입력하세요"
        size="30px"/>
        <div id="searchicon">
            <img src="images/search.png">
        </div>
    </div>

    <div id="kindboxes">
    
        <div class="kindbox">
        	<a href="fooba.do?command=category&kind=1">
        	 	<span class="kindtext">한식</span><br>
            	<img src="images/korean.png">
            </a>
        </div>
        
        <div class="kindbox">
        <a href="fooba.do?command=category&kind=2">
            <span class="kindtext">중식</span><br>
            <img src="images/china.png">
        </a>
        </div>
        
        <div class="kindbox">
        <a href="fooba.do?command=category&kind=3">
            <span class="kindtext">양식</span><br>
            <img src="images/western.png">
        </a>
        </div>
        
        <div class="kindbox">
        <a href="fooba.do?command=category&kind=4">
            <span class="kindtext">일식</span><br>
            <img src="images/japan.png">
        </a>
        </div>
        
        <div class="kindbox">
        <a href="fooba.do?command=category&kind=5">
            <span class="kindtext">피자</span><br>
            <img src="images/pizza.png">
        </a>
        </div>
        
         <div class="kindbox">
         <a href="fooba.do?command=category&kind=6">
               <span class="kindtext">치킨</span><br>
               <img src="images/chicken.png">
         </a>
            </div>
            
        <div class="kindbox">
        <a href="fooba.do?command=category&kind=7">
            <span class="kindtext">분식</span><br>
            <img src="images/bunsic.png">
        </a>
        </div>
        
        <div class="kindbox">
        <a href="fooba.do?command=category&kind=8" style="text-decoration: none;">
            <span class="kindtext">디저트</span><br>
            <img src="images/dessert.png">
        </a>
        </div>
        
    </div>
</div>

<%@ include file="footer.jsp"%>