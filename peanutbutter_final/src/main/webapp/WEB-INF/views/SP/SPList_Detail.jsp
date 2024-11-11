<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
        height: 15vh;
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
        margin: 0 100px;
        height: 10vh;
        background-color: #E9E4DC;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .search_input {
        height: 40px;
        font-size: 20px;
        border-radius: 5px;
        padding: 5px;
    }

    .select {
        margin-right: 20px;
        height: 40px;
        font-size: 20px;
        border-radius: 5px;
    }

    .search_item {
        margin: 10px 30px;
        height: 60vh;
        background-color: white;
        overflow-y: auto;
    }

    .inputTextHeight {
        height: 30px;
        font-size: 20px;
    }

    table {
        border-collapse: collapse;
        /* 테두리가 겹치지 않도록 설정 */
        width: 100%;

    }

    th {
        height: 30px;
        text-align: center;
        background-color: #848484;
        color: white;
    }

    .tbody td {
        text-align: center;
        padding: 5px;
        border-bottom: 1px solid rgb(218, 218, 218);
        padding: 10px 0px;
    }

    .thead th {
        border-left: 1px solid white;
    }

    .thead th:nth-child(1) {
        width: 5%;
    }

    .thead th:nth-child(2) {
        width: 10%;
    }

    .thead th:nth-child(3) {
        width: 15%;
    }

    .thead th:nth-child(4) {
        width: 5%;
    }

    .thead th:nth-child(5) {
        width: 10%;
    }

    .thead th:nth-child(6) {
        width: 10%;
    }

    .thead th:nth-child(7) {
        width: 10%;
    }

    .thead th:nth-child(8) {
        width: 10%;
    }
    .thead th:nth-child(9) {
        width: 10%;
    }
    .thead th:nth-child(10) {
        width: 10%;
    }

    .regBtn_div {
        margin: 0 100px;
        text-align: right;
        margin-top: 30px;
    }

    .Btn_css {
        padding: 15px;
        background-color: #3F3B3B;
        color: white;
        border-radius: 5px;
        cursor: pointer;
    }

    #select {
        width: 150px;
    }
</style>

<body>
    <div class="container">
        <div class="top">
            <div class="title">
                <img src="image/directory.png" style="width: 30px;">
                <span>${list[0].PRODUCT_NAME}</span>
            </div>
        </div>
        <div class="search_container">
        </div>
        <div class="search_item">
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th> </th>
                        <th>공정코드</th>
                        <th>내역</th>
                        <th>작업일</th>
                        <th>등록일</th>
                        <th>목표수량</th>
                        <th>상태</th>
                    </tr>
                </thead>
                <%
                	int totalAmount=0;
                %>
                <tbody class="tbody">
                	<c:forEach var="SP" items="${list}">
                    	<tr>
                        	<td><input type="checkbox" class="delete-checkbox" value="${SP.process_number}"></td>
                        	<td>${SP.PROCESS_CODE}</td>
                        	<td><a href="/peanutbutter/fl?process_code=${SP.PROCESS_CODE}">${SP.PROCESS_NAME}</a></td>
                        	<td><fmt:formatDate value="${SP.PLAN_START_DATE}" pattern="yyyy-MM-dd" /></td>
                        	<td><fmt:formatDate value="${SP.PLAN_REG_DATE}" pattern="yyyy-MM-dd" /></td>
                        	<td>${SP.PLAN_AMOUNT}</td>
                        	<td>
                        	<select id = select_status name="optionvalue_status" onchange="take(this, '${SP.PLAN_AMOUNT}')">
                                <option value="-----"
                                	<c:if test="${empty map.optionvalue || map.optionvalue == '-----'}">selected</c:if>>-------</option>
                                <option value="stay"
                                	<c:if test="${map.optionvalue == 'stay'}">selected</c:if>>대기</option>
                                <option value ="underway"
                                	<c:if test="${map.optionvalue == 'underway'}">selected</c:if>>진행중</option>
                                <option value ="complete"
                                	<c:if test="${map.optionvalue == 'complete'}">selected</c:if>>완료</option>
                            </select>
                        </td>
                    </tr>
                   </c:forEach>
                </tbody>
            </table>
        </div>

</body>

<script>

function searchTable() { // 돋보기 버튼을 클릭했을 때 동작하는 함수
	
	const form = document.getElementById('searchform');
	const searchInput = form.querySelector('input[name="search"]');
	const selectInput = form.querySelector('select[name="optionvalue"]');
	
	 if (selectInput.value === '-----') {
         // 선택된 옵션이 '-----'일 때는 검색을 수행하지 않도록
         alert('검색 옵션을 선택해주세요.');
         return;
     }
	
	 // 검색어가 없을때 searchTable()을 수행하지 않도록 
	if (searchInput && searchInput.value.trim() === ''){
		alert('검색어를 입력해주세요');
		return;
	}
	form.submit();
}

	function deleteRow() {
	let selects = [];
	document.querySelectorAll('.tbody input[type="checkbox"]:checked').forEach(checkbox => {
        selects.push(checkbox.value);
    });
	
	if(selects.length === 0) {
		alert('삭제할 항목을 선택하세요.');
		return;
	}

	let codesField = document.getElementById('process_numbers');
	codesField.value = selects.join(',');
	
    console.log('process_numbers :', codesField.value);
	
	document.getElementById('deleteone').submit();
}
    
    	a = '${map.optionvalue}';
    	b = '${map.search}';
    
    function searchpage(num){
    	    
        let url = "/peanutbutter/sp_detail?page=" + num;
        	
        	
        if(a != ''){    		
//         	location.href="/peanutbutter/sp_detail?optionvalue="+a+"&search="+b+"&page=num";
        	url += "&optionvalue=" + encodeURIComponent(a);
        }
        	
        if(b != '') {
        	url += "&search=" + encodeURIComponent(b);
        }
        	
        location.assign(url);
       }
    
    function take(selectElement, plan_amount) {
    	
    const selectedValue = selectElement.value;
    	
    	// 1. XMLHttpRequest객체 생성
        var httpRequest = new XMLHttpRequest(); 

        // 2. onreadystatechange 등록
        httpRequest.onreadystatechange = function() {
        	// XMLXttpRequest 객체의 현재 상태와 서버 상의 문서 존재 유무를 확인
            if (httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200 ) {
            	console.log(httpRequest.responseText); // 서버에 요청하여 응답으로 받은 데이터를 문자열로 반환
            }
        };

        // 3. PUT 방식으로 요청을 보내면서 데이터를 동시에 전달함
        httpRequest.open("put", "/peanutbutter/update_ap?specification_detail_status="+selectedValue+"&="+plan_amount, true);
     	
        // 4. 요청 헤더 설정 (필요에 따라 설정)
        httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        
        httpRequest.send();
    }
    
</script>
</html>