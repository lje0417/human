<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*" %>
    
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

    .search-box1 {
        position: relative;
        width: 280px;
        margin-right: 20px;
    }

    .search-box1 input[type="text"] {
        width: 100%;
        padding: 10px;
        padding-right: 40px;
        /* Make space for the button */
        font-size: 16px;
        box-sizing: border-box;
    }

    .search-box input[type="text"] {
        width: 100%;
        padding: 10px;
        padding-right: 40px;
        /* Make space for the button */
        font-size: 16px;
        box-sizing: border-box;
    }

    .search-box1 button {
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

    .search-box1 button:active {
        transform: scale(0.95);
    }

    .제품select {
        position: relative;
        width: 300px;
        margin-right: 20px;
    }

    #reg {
        margin-right: 50px;
        padding: 10px;
        background-color: #3F3B3B;
        border-radius: 5px;
        color: white;
    }

    .caution {
        width: 100%;
        height: 100%;
        display: none;

    }

    .cautionDiv {
        position: absolute;
        width: 100px;
        height: 100px;
        top: 100px;
        right: 100px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
        display: none;
    }


    /* 모달 스타일 */
    .modal {
        display: none;
        /* 기본적으로 숨김 */
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0, 0, 0, 0.4);
        /* 반투명 배경 */
    }

    .modal-content {
        background-color: #fefefe;
        margin: 5% auto;
        padding: 20px;
        border: 1px solid #888;
        width: 90%;
        /* max-width: 500px; */
    }
    .modal-content iframe {
            width: 90%;
            height: 90%;
            border: none;
            box-sizing: border-box;
        }

</style>

<body>
    <div class="container">
        <div class="top">
            <div class="title">
                <img src="image/BOM.png" style="width: 30px;">
                <span>발주 등록</span>
            </div>
        </div>
        <div class="search_container">
			<form method="post" action="insert_po">
            <div class="searchcon">
                <div style="padding-right:15px;">품목명(*)</div>
                <select style="height: 40px;" class="제품select" name="part_modelname" onchange="take(this)">
                    <option value="-----">-----</option>
                	<c:forEach var="PT" items="${list}">
                    <option value="${PT.part_modelname}"
                    
                     data-code = "${PT.part_code}"
                     data-vendor1 = "${PT.part_vendor1}"
                     data-vendor2 = "${PT.part_vendor2}"
                     data-receving_warehouse = "${PT.receving_warehouse}"
                     >${PT.part_modelname}(${PT.part_code})</option>
                    
                    </c:forEach>
                </select>
                <div style="padding-right:15px;">부품코드(*)</div>
                <div class="search-box">
                    <input id="part_code" type="text" name="part_code" readonly>
                </div>
            </div>
            <div class="searchcon">
                <div style="padding-right:48px;">통화</div>
                <div class="search-box">
                    <select style="height: 40px;" class="제품select" name="purchase_order_currency">
                    <option value="-----">-----</option>                    
                    <option value="KRW">대한민국 원(KRW)</option>
                    <option value="USD">미국달러(USD)</option>
                    <option value="JPY">일본 엔(JPY)</option>
                    <option value="EUR">유럽연합 유로(EUR)</option>
                    <option value="CNY">중국 위안(CNY)</option>
                </select>
                </div>
                발주 일자
                <input style="height: 30px; font-size: 20px; margin-left: 11px;" type="date" id="date" max="2025-06-20"
                    min="2001-06-05" value="2024-10-17" name="purchase_order_date" >
            </div>
            <div class="searchcon">

                <div style="padding-right:17px;">발주수량</div>
                <div class="search-box">
                    <input type="text" id="count" name="purchase_order_amount">
                </div>
                입고 예정일
                <input style="height: 30px; font-size: 20px; margin-left: 11px;" type="date" id="date" max="2025-06-20"
                    min="2001-06-05" value="2024-10-17" name="warehousing_duedate" >
            
            </div>
            <div class="searchcon">
                <div style="padding-right:17px;">거래처</div>
                <div class="search-box">
                <input type="text" id="purchase_order_partner" name="purchase_order_partner">
                </div>
                <div style="padding-right:15px;">입고창고</div>
                <div class="search-box">
                    <input id="purchase_order_warehouse" type="text" name="purchase_order_warehouse">
                </div>
            </div>
            <div style="text-align: end;">
                <input type="submit" id="reg" value="등록">
            </div>
            </form>
            <div class="cautionDiv" onclick="showModal()">
                <img src="image/caution.png" class="caution" alt="경고 이미지">
            </div>
        </div>
        <!-- 모달 -->
        <div id="myModal" class="modal">
            <div class="modal-content">
                <iframe src=></iframe>
            </div>
        </div>

    </div>


</body>
<script>
	
	function take(selectElement) {
    // 선택된 옵션의 값을 가져옴
    const selectedValue = selectElement.value;
    
    // 선택된 옵션의 data 값을 가져옴
    const selectedOption = selectElement.options[selectElement.selectedIndex];
    const selectedCode = selectedOption.getAttribute('data-code');
    const selectedVendors = [
        selectedOption.getAttribute('data-vendor1'),
        selectedOption.getAttribute('data-vendor2')
    ];
    const selectedreceving_warehouse = selectedOption.getAttribute('data-receving_warehouse');

    // 선택된 코드 값을 input vlaue로 지정
    const inputCode = document.getElementById('part_code');
    inputCode.value = selectedCode;
    
    const inputPartner = document.getElementById('purchase_order_partner');
    inputPartner.value = selectedVendors;
    
    const inputWarehouse = document.getElementById('purchase_order_warehouse');
    inputWarehouse.value = selectedreceving_warehouse;
    
    // 콘솔에 출력 (디버깅용)
    console.log('선택된 값:', selectedValue);
    console.log('선택된 코드:', selectedCode);
}

    function caution(element) {
        let count = document.querySelector('#count')
        let countNum = parseFloat(count.value);
        let code = document.querySelector('#부품코드').value;
        console.log(code)
        let cautionDiv = document.querySelector('.caution');
        let cautionDiv2 = document.querySelector('.cautionDiv');

        if (code === "GRAM-001" && countNum > 99) {
            cautionDiv.style.display = 'block'
            cautionDiv2.style.display = 'block'
        }
    }

    function showModal() {
        document.querySelector("#myModal").style.display = "block";
    }
    function closeModal() {
        document.querySelector("#myModal").style.display = "none";
    }

    window.onclick = function (event) {
        if (event.target == document.querySelector("#myModal")) {
            closeModal();
        }
    }

</script>
</html>