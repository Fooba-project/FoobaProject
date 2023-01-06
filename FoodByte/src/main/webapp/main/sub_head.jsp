<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    
	<div id="mainlist">
	
    	<form id="search" name="search" method="post">
    	<c:if test="${search!=null && search!=''}">
        	<input type="text" name="searchtext" id="searchtext" placeholder="${search }" size="30px"/>
        </c:if>
        <c:if test="${search==null || search==''}">
        	<input type="text" name="searchtext" id="searchtext" placeholder="검색어를 입력하세요" size="30px"/>
        </c:if>
        <div id="searchicon">
            <img src="images/search.png" onClick="go_search2()">
        </div>
    	</form>
    	
    	
        <div id="kindboxeslist">
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