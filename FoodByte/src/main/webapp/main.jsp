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
        	<a href="#" onclick="go_search('푸짐해요')">
        	<span class="hashtext">#푸짐해요</span>
        	</a>
        </div>
        
        <div class="hashbox">
	        <a href="#" onclick="go_search('매워요')">
	        <span class="hashtext">#매워요</span>
        	</a>
        </div>
        
        <div class="hashbox">
	        <a href="#" onclick="go_search('소울푸드')">
	        <span class="hashtext">#소울푸드</span>
	        </a>
        </div>
        <div class="hashbox">
        <a href="#" onclick="go_search('건강한맛집')">
        <span class="hashtext">#건강한맛집</span>
        </div>
        
        <div class="hashbox">
	        <a href="#" onclick="go_search('가성비')">
	        <span class="hashtext">#가성비</span>
	        </a>
        </div>
        
        <div class="hashbox">
	        <a href="#" onclick="go_search('나눠먹어요')">
	        <span class="hashtext">#나눠먹어요</span>
	        </a>
        </div>
        
    </div>
</div>

<div id="main">

    <form id="search" name="search" method="post">
        <input type="text" name="search" id="searchtext" placeholder="검색어를 입력하세요"
        size="30px" value="${search}"/>
        <div id="searchicon">
            <img src="images/search.png" onClick="go_search('serch')">
        </div>
    </form>

    <div id="kindboxes">
	        <a href="fooba.do?command=category&kind=1">
	            <div class="kindbox">
	                <span class="kindtext">한식</span><br>
	                <img src="images/korean.png">
	            </div>
			</a>
		    <a href="fooba.do?command=category&kind=2">
	            <div class="kindbox">
	                <span class="kindtext">중식</span><br>
	                <img src="images/china.png">
	            </div>
            </a>
            <a href="fooba.do?command=category&kind=3">
	            <div class="kindbox">
	                <span class="kindtext">양식</span><br>
	                <img src="images/western.png">
	            </div>
            </a>
            <a href="fooba.do?command=category&kind=4">
	            <div class="kindbox">
	                <span class="kindtext">일식</span><br>
	                <img src="images/japan.png">
	            </div>
            </a>
            <a href="fooba.do?command=category&kind=5">
	            <div class="kindbox">
	                <span class="kindtext">피자</span><br>
	                <img src="images/pizza.png">
	            </div>
            </a>
            <a href="fooba.do?command=category&kind=6">
	             <div class="kindbox">
	                   <span class="kindtext">치킨</span><br>
	                   <img src="images/chicken.png">
	             </div>
             </a> 
             <a href="fooba.do?command=category&kind=7">
	            <div class="kindbox">
	                <span class="kindtext">분식</span><br>
	                <img src="images/bunsic.png">
	            </div>
            </a>
            <a href="fooba.do?command=category&kind=8">
	            <div class="kindbox">
	                <span class="kindtext">디저트</span><br>
	                <img src="images/dessert.png">
	            </div>
            </a>
        </div>
</div>

<%@ include file="footer.jsp"%>