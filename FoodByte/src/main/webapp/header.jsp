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
 
 <style type="text/css">

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
        top:60px;left:0;bottom:0;right:0;
        margin:0px; padding:0px; }

        #hash{position: absolute; width:100%; height:70px; background-color: white;
        z-index: 100; margin-top:490px; left: 0;}

        .hashbox{position: relative; width: 100px; height: 70px; left:400px; cursor: pointer; float: left;
        margin: 2px; margin-left:150px;}

        .hashbox span{position: absolute; line-height:70px; color: #fa6146; font-weight: bold; font-family: Verdana; left: 25px; font-size:120%;}

        #maintextbox{position: absolute; width:auto; height: auto; z-index: 100; right: 190px; top: 300px;}

        #maintextbox span{position: relative;
        font-size:200%; font-weight: bold; color: #fa6146; white-space:pre;} 
   </style>
        
   <style type="text/css">
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

    </style>
</head>
<body>

<div>
    <div id="head">
        <div id="mainlogo">
            <img src="images/mainlogo1.png" id="logo";>
        </div>
    </div>