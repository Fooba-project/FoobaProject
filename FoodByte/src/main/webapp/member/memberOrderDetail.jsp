<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <style type="text/css">

#review_from fieldset{
    display: inline-block;
    direction: rtl;
    border:0;
}
#review_from fieldset legend{
    text-align: right;
}
#review_from input[type=radio]{
    display: none;
}
#review_from label{
    font-size: 3em;
    color: transparent;
    text-shadow: 0 0 0 #f0f0f0;
}
#review_from label:hover{
    text-shadow: 0 0 0 rgba(255, 111, 44);
}
#review_from label:hover ~ label{
    text-shadow: 0 0 0 rgba(255, 111, 44);
}
#review_from input[type=radio]:checked ~ label{
    text-shadow: 0 0 0 rgba(255, 111, 44);
}

#star_box{width: 100%; border: 1px solid black;
}

#reviewContents {
    width: 100%;
    height: 150px;
    padding: 10px;
    box-sizing: border-box;
    border: solid 1.5px #D3D3D3;
    border-radius: 5px;
    font-size: 16px;
    resize: none;
}

#star_text{padding-right:36px;;}
    </style>
</head>
<body>
    <form class="review" name="review_form" id="review_from" method="post">
   <fieldset>
       <span class="star_text" id="star_text">별점을 선택해주세요
       </span>

       <div id="star_box">
            <input type="radio" name="reviewStar" value="5" id="rate1">
            <label for="rate1">★</label>

            <input type="radio" name="reviewStar" value="4" id="rate2">
            <label for="rate2">★</label>
            
            <input type="radio" name="reviewStar" value="3" id="rate3">
            <label for="rate3">★</label>
            
            <input type="radio" name="reviewStar" value="2" id="rate4">
            <label for="rate4">★</label>

            <input type="radio" name="reviewStar" value="1" id="rate5">
            <label for="rate5">★</label>
        </div>
   </fieldset>
   <div>
       <textarea class="review" type="text" id="reviewContents"
        placeholder="음식에 대한 솔직한 리뷰를 남겨주세요!"></textarea>
   </div>
</form>								
</body>
</html>