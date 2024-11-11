<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    * {
        box-sizing: border-box;

    }

    .container {
        background-color: #F0F0E8;
        width: 100%;
        height: 100%;
        box-sizing: border-box;
    }

    body {
        margin: 0;
        padding: 0;
    }

    .top {
        color: #676767;
        font-size: 24px;
        font-weight: bold;
        height: 12vh;
    }

    .title {
        padding-top: 30px;
        margin-left: 100px;
    }

    .title img {
        vertical-align: middle;
        /* 이미지와 텍스트의 높낮이를 맞추기 위해 추가 */
    }

    .title span {
        vertical-align: middle;
        /* 이미지와 텍스트의 높낮이를 맞추기 위해 추가 */
    }

    .search_container {
        margin: 0 20px;
        height: 81vh;
        background-color: #E9E4DC;
        overflow: auto;
    }

    .btn:active {
        transform: scale(0.95);
    }

    .btn2:active {
        transform: scale(0.95);
    }

    .btn {
        background-color: #A2A2A2;
        color: #FFFFFF;
    }

    .btn2 {
        margin: 10px 10px 0 0;
        padding: 10px;
        background-color: #A2A2A2;
        color: #FFFFFF;
    }

    .searchcon {
        display: flex;
        justify-content: left;
        align-items: center;
        margin: 20px 0 0 40px;
    }

    .search-box {
        position: relative;
        width: 300px;
        margin-right: 20px;
    }

    .search-box input[type="text"] {
        width: 100%;
        padding: 10px;
        padding-right: 40px;
        /* Make space for the button */
        font-size: 16px;
        box-sizing: border-box;
    }

    .search-box button {
        position: absolute;
        right: 0;
        top: 0;
        height: 100%;
        width: 95px;
        background-color: #D3CEC9;
        color: black;
        border: none;
        cursor: pointer;
    }

    .search-box button:active {
        transform: scale(0.95);
    }

    #reg {
        margin-right: 50px;
        padding: 10px;
        background-color: #3F3B3B;
        border-radius: 5px;
        color: white;
    }
    
    .qrcode {
    	margin-right: auto;
    	display: block;
    	
    	width:100px;
    	hegith: 100px;
    	    
    	}
</style>

</head>
<body>
    <div class="container">
        <div class="top">
            <div class="title">
                <img src="image/BOM.png" style="width: 30px;">
                <span>${dto.part_modelname} </span>
            </div>
        </div>
        <div class="search_container">
        	<form method="post" action="modify_pt">
            <div class="searchcon">
                <div style="padding-right:15px;">부품명(*)</div>
                <div class="search-box">
                    <input type="text" name="pt_name" value="${dto.part_name}">
                </div>
                <div style="padding-right:15px;">부품코드(*)</div>
                <div class="search-box">
                    <input type="text" name="pt_code" value="${dto.part_code}" readonly>
                </div>
            </div>
            <div class="searchcon">
                <div style="padding-right:48px;">단위</div>
                <div class="search-box">
                    <input type="text" name="pt_unit" value="${dto.part_unit}">
                </div>
                <div style="padding-right:63px;">규격</div>
                <div class="search-box">
                    <input type="text" name= "pt_standard" value="${dto.part_standard}">
                </div>
            </div>
            <div class="searchcon">
                <div style="padding-right:48px;">모델</div>
                <div class="search-box">
                    <input type="text" name="pt_modelname" value="${dto.part_modelname}">
                </div>
                <div style="padding-right:63px;">분류</div>
                <div class="search-box">
                    <input type="text" name="pt_sort" value="${dto.part_sort}">
                </div>
                
            </div>
            <div class="searchcon">
                <div style="padding-right: 18px;">거래처 1</div>
                <div class="search-box">
                    <input type="text" name="vendor1" value = "${dto.part_vendor1}">
                </div>
                <div style="padding-right:32px;">거래처 2</div>
                <div class="search-box">
                    <input type="text" name="vendor2" value="${dto.part_vendor2}">
                </div>
                
            </div>

          

           <div class="searchcon">
                <div style="padding-right:17px;">입고창고</div>
                <div class="search-box">
                    <input type="text" name="recwarehouse" value="${dto.receving_warehouse}">
                </div>
                <div style="padding-right:32px;">바코드</div>
                <div class="search-box">
                    <input type="text" name="pt_barcode" value="${dto.part_barcode}">
                </div>
            </div>
              <div class="searchcon">
           
                <div style="padding-right:17px;">부품(이미지)</div>
                <div class="search-box">
                    <input type="text" name="pt_image" value="${dto.part_image}">
                </div>
            </div>
            <div style="text-align: end;">
                <input type="submit" id="reg" value="수정">
            </div>
            <img class="qrcode" src="${dto.part_barcode}">
            </form>
        </div>

    </div>


</body>

<script>
  
</script>
</html>