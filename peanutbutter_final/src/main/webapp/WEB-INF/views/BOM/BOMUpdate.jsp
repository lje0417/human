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



    .section {
        margin: 0 100px;
        height: 70vh;
        display: flex;
        /* sideBarDiv와 tableDiv를 가로로 정렬 */
    }

    .sideBarDiv {
        background-color: #D7D7D7;
        width: 200px;
        /* 고정너비 설정 */
        padding: 10px;
    }

    .tableDiv {
        flex: 1;
        /* 남은공간 모두 차지 */
        background-color: white;
    }

    .table {
        border-collapse: collapse;
        /* 테두리가 겹치지 않도록 설정 */
        width: 100%;
    }

    th {
        background-color: #b6b6b6;
        border-right: 1px solid white;
    }

    td {
        text-align: center;
    }

    .tbody tr {
        border-bottom: 1px solid lightgray;
    }

    tr th,
    tr td {
        padding: 5px 0px;
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
        width: 10%;
    }
    .thead th:nth-child(5) {
        width: 10%;
    }
    .thead th:nth-child(6) {
        width: 5%;
    }
    .thead th:nth-child(7) {
        width: 10%;
    }
    .thead th:nth-child(8) {
        width: 10%;
    }

    .Btn_css {
        display: inline-block;
        /* span에 padding을 적용했을 때 부모 div 밖으로 벗어나는것을 막기위해서 */
        padding: 10px;
        background-color: #3F3B3B;
        color: white;
        border-radius: 5px;
        cursor: pointer;
        margin-top: 5px;
    }

    input[type="text"] {
        text-align: center;
    }

    .mainMenu {
        font-weight: bold;
        color: gray;
    }

    .tableTopDiv {
        height: 50px;
        padding: 0px 10px;
        background-color: white;
    }

    .regBtn {
        margin: 0 100px;
        text-align: right;
        margin-top: 30px;
    }

    .inputText {
        height: 25px;
    }
    
    .text_fit {
    	width: 80%;
    }
</style>

<body>
    <div class="container">
        <div class="top">
            <div class="title">
                <img src="image/BOM.png" style="width: 30px;">
                <span>BOM 등록(부품)</span>
            </div>
        </div>
        <div class="section">
            <div class="tableDiv">
            <form method="post" action="insert_bom">
                <div class="tableTopDiv">
                    <span style="font-weight: bold;">제품명</span> 
                    <select class="제품select" name="product_name" onchange="take_pm(this)">
                        <option value="-----">-----</option>
                        <c:forEach var="PM" items="${list}">
                        <option value="${PM.product_name}"
                    
                     data-code = "${PM.product_code}"
                     >${PM.product_name} (${PM.product_code})</option>
                     </c:forEach>
                    </select>
                    <span style="margin-left: 20px; font-weight: bold;">제품코드</span>
                    <div id ="제품코드" style="display:inline-block; width: 200px;">
                    	<input id="product_code" type="text" name="product_code" readonly>
                    </div>
                    <span class="Btn_css" style="margin-left: 50px;" onclick="addRow()">행 추가</span>
                    <span class="Btn_css" style="margin-left: 20px;" onclick="deleteSelectedRow()">행 삭제</span>
                </div>
                <table class="table">
                    <thead class="thead">
                        <tr>
                            <th> </th>
                            <th>부품명</th>
                            <th>모델명</th>
                            <th>부품코드</th>
                            <th>규격</th>
                            <th>단위</th>
                            <th>수량</th>
                            <th>거래처</th>
                        </tr>
                    </thead>
                    <tbody class="tbody">
                        <tr>
                            <td><input type="checkbox" class="delete-checkbox"></td>
                            <td><select class="제품select" name="part_name" onchange="take_part(this)">
                        			<option value="-----">-----</option>
                        			<c:forEach var="PT" items="${list_pt}">
                        			<option value="${PT.part_name}"
                 
                     				data-code = "${PT.part_code}"
                     				data-modelname = "${PT.part_modelname}"
                     				data-unit = "${PT.part_unit}"
                     				data-standard = "${PT.part_standard}"
                     				data-vendor1 = "${PT.part_vendor1}"
                     				data-vendor2 = "${PT.part_vendor2}"
                     				>${PT.part_name} (${PT.part_code})</option>
                     				</c:forEach>
                    			</select></td>
                            <td><input class="text_fit" id="part_modelname" type="text" name="part_modelname"></td>
                            <td><input class="text_fit" id="part_code" type="text" name="part_code"></td>
                            <td><input class="text_fit" id="part_standard" type="text" name="part_standard"></td>
                            <td><input class="text_fit" id="part_unit" type="text" name="part_unit"></td>
                            <td><input id="part_amount" type="text" name="part_amount_str" style="width: 30%;"></td>
                            <td><input class="text_fit" id="part_vendors" type="text" name="part_vendors"></td>
                        </tr>
                    </tbody>
                </table>
        				<div style="text-align: end";>
            				<input type="submit" id="reg" value="BOM 등록" class="Btn_css">
       					</div>
                </form>
            </div>
        </div>
    </div>
</body>

<script>

    function addRow() { //행추가
        let tbody = document.querySelector('.tbody');

        let newRow = document.createElement('tr');
        newRow.innerHTML = `
        	<td><input type="checkbox" class="delete-checkbox"></td>
            <td><select class="제품select" name="part_name" onchange="take_part(this)">
        			<option value="-----">-----</option>
        			<c:forEach var="PT" items="${list_pt}">
        			<option value="${PT.part_name}"
 
     				data-code = "${PT.part_code}"
     				data-modelname = "${PT.part_modelname}"
     				data-unit = "${PT.part_unit}"
     				data-standard = "${PT.part_standard}"
     				data-vendor1 = "${PT.part_vendor1}"
     				data-vendor2 = "${PT.part_vendor2}"
     				>${PT.part_name} (${PT.part_code})</option>
     				</c:forEach>
    			</select></td>
            <td><input class="text_fit" id="part_modelname" type="text" name="part_modelname"></td>
            <td><input class="text_fit" id="part_code" type="text" name="part_code"></td>
            <td><input class="text_fit" id="part_standard" type="text" name="part_standard"></td>
            <td><input class="text_fit" id="part_unit" type="text" name="part_unit"></td>
            <td><input id="part_amount" type="text" name="part_amount_str" style="width: 30%;"></td>
            <td><input class="text_fit" id="part_vendors" type="text" name="part_vendors"></td>
            `;

        tbody.appendChild(newRow);

    }

    function deleteSelectedRow() { //행삭제
        let checkboxes = document.querySelectorAll('.delete-checkbox');
        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                checkbox.closest('tr').remove(); //closest : 특정 요소의 가장 가까운 조상 요소를 찾는 데 사용되는 DOM 메서드
            }
        });
    }
    
	function take_pm(selectElement) {
	    // 선택된 옵션의 값을 가져옴
	    const selectedValue = selectElement.value;
	    
	    // 선택된 옵션의 data 값을 가져옴
	    const selectedOption = selectElement.options[selectElement.selectedIndex];
	    const selectedCode = selectedOption.getAttribute('data-code');

	    // 선택된 코드 값을 input vlaue로 지정
	    const inputCode = document.getElementById('product_code');
	    inputCode.value = selectedCode;
	    
	    // 콘솔에 출력 (디버깅용)
	    console.log('선택된 코드:', selectedCode);
	}
	
	function take_part(selectElement) {
	    // 선택된 옵션의 값을 가져옴
	    const selectedValue = selectElement.value;
	    
	    // 선택된 옵션의 data 값을 가져옴
	    const selectedOption = selectElement.options[selectElement.selectedIndex];
	    const selectedModelname = selectedOption.getAttribute('data-modelname');
	    const selectedCode = selectedOption.getAttribute('data-code');
	    const selectedVendors = [
	        selectedOption.getAttribute('data-vendor1'),
	        selectedOption.getAttribute('data-vendor2')
	    ];
	    const selectedUnit = selectedOption.getAttribute('data-unit');
	    const selectedStandard = selectedOption.getAttribute('data-standard');
	    
	    const find_tr = selectElement.closest('tr');
	    
	    console.log(find_tr);
	    
	    // 선택된 코드 값을 input vlaue로 지정
	    const inputModelname = find_tr.querySelector('#part_modelname');
	    inputModelname.value = selectedModelname;
	    
	    const inputCode = find_tr.querySelector('#part_code');
	    inputCode.value = selectedCode;
	     
	    const inputUnit = find_tr.querySelector('#part_unit');
	    inputUnit.value = selectedUnit;
	    
	    const inputStandard = find_tr.querySelector('#part_standard');
	    inputStandard.value = selectedStandard;
	    
	    const inputPartner = find_tr.querySelector('#part_vendors');
	    inputPartner.value = selectedVendors;
	    
	}
    
    
</script>
</html>