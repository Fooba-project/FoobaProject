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
<script src="javascript/fooba.js"></script>
 <style type="text/css">
    body {margin: 0;}
    #head {position:absolute; width: 100%; height: 110px; background-color: #fa6146;}
    #mainlogo {position: relative; text-align: center; width: 150px; height: 100px; margin: 0 auto;}
    #logo {position: absolute; left: 5px; top: -25px; width: 145px; height: 145px;}
 </style>
</head>
<body>

<div>
    <div id="head">
        <div id="mainlogo">
            <img src="/src/main/webapp/images/mainlogo1.png" id="logo";>
        </div>
    </div>