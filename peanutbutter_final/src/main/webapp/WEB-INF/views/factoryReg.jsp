<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.Map, java.util.Set, java.util.Map.Entry" %>
<%@ page import="java.util.List" %>
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
        margin: 0px 50px;
        color: #676767;
        font-size: 24px;
        font-weight: bold;
        height: 50px;
        display: flex;
        align-items: center;
    }

    .section {
        margin: 0 20px;
        height: 78vh;
        background-color: #E9E4DC;
        overflow: auto;
        padding: 30px;
    }

    .span,
    .spanMargin {
        font-size: 20px;
        display: inline-block;
        width: 100px;
    }

    .inputText {
        height: 30px;
        margin-left: 10px;
        border-radius: 5px;
    }

    .spanMargin {
        margin-left: 50px;
    }

    .select {
        height: 30px;
        border-radius: 5px;
        margin-left: 70px;
    }

    .select2 {
        height: 30px;
        border-radius: 5px;
        margin-left: 35px;
    }

    .div {
        margin-top: 10px;
    }

    .tableDiv {
        margin-top: 10px;
    }

    table {
        border-collapse: collapse;
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

    .thead th:nth-child(1) {
        width: 5%;
    }

    .thead th:nth-child(2) {
        width: 5%;
    }

    .thead th:nth-child(3) {
        width: 15%;
    }

    .thead th:nth-child(4) {
        width: 15%;
    }

    .thead th:nth-child(5) {
        width: 10%;
    }

    .thead th:nth-child(6) {
        width: 50%;
    }

    .rowSpan {
        padding: 5px;
        background-color: #3F3B3B;
        border-radius: 5px;
        color: white;
        margin-left: 20px;
    }
    .btnDiv{
        margin:5px 20px;
        display: flex;
        justify-content: end;
    }
    .Btn_css {
        padding: 15px;
        background-color: #3F3B3B;
        color: white;
        border-radius: 5px;
        cursor: pointer;
        margin-right: 20px;
    }
</style>
<body>
<form action='/peanutbutter/Process' method="post" enctype="multipart/form-data" accept-charset="utf-8">
    <div class="container">
        <div class="top">
            <img src="/peanutbutter/image/directory.png" style="width: 30px;">
            <span>공정 등록</span>
        </div>
        <div class="section">
            <div style="margin-left: 150px;">
                <div>
                    <span class="span">공정코드</span><input id="processCode" name="processCode" class="inputText" type="text">
                    <span class="spanMargin">공정명</span><input id="processName" name="processName" class="inputText" type="text">
                </div>
                <div class="div">
                    <span class="span">공정분류</span><input id="processCategory" name="processCategory"class="inputText" type="text">
                    <span class="spanMargin">사용여부</span>
                    <select id="isUsed" name="isUsed" class="select">
                        <option>Y</option>
                        <option>N</option>
                    </select>
                </div>
                <div class="div">
                    <span class="span">사이클타임</span><input id="cycleTime" name="cycleTime" class="inputText" type="text">
                    <span class="spanMargin">제품코드</span>
          <select id="productCode" name="productCode" class="select2">
                <option value="">-----</option>
                <% 
                    List<String> productCodes = (List<String>) request.getAttribute("productCodes");
                    if (productCodes != null) {
                        for (String code : productCodes) {
                %>
                    <option value="<%= code %>"><%= code %></option>
                <% 
                        }
                    }
                %>
            </select>               
                </div>
            </div>
            <div style="margin-top: 10px; display: flex; justify-content: end;">
                <span class="rowSpan" onclick="addRow()">행추가</span>
                <span class="rowSpan" onclick="deleteSelectedRows()">행삭제</span>
            </div>
            <div class="tableDiv">
                <table class="table">
                    <thead class="thead">
                        <tr>
                            <th></th>
                            <th></th>
                            <th>하위공정코드</th>
                            <th>공정명</th>
                            <th>이미지</th>
                            <th>공정내용</th>
                        </tr>
                    </thead>
                    <tbody class="tbody">
                        <tr>
                           <td><input type="checkbox" class="delete-checkbox"></td>
                            <td></td>
                            <td><input id="underprocess" name="underprocess" type="text" style="width: 90%;"></td>
                            <td><input id="processname2" name="processname2" type="text" style="width: 90%;"></td>
                            <td><input id="image" name="image" type="file" multiple="multiple"></td>
                            <td><input id="productcontent" name="productcontent" type="text" style="width: 90%;text-align: center;" ></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="btnDiv">
            <span class="Btn_css" onclick="commitReg()">등록</span>
        </div>
    </div>
    </form>
</body>
<script>
let tbody = document.querySelector('.tbody');
let rowCount = tbody.querySelectorAll('tr').length + 1;
function commitReg() {
    let processCode2 = document.getElementById('processCode').value.trim();
    let processName2 = document.getElementById('processName').value.trim();
    let processCategory2 = document.getElementById('processCategory').value.trim();
    let isUsed2 = document.getElementById('isUsed').value.trim();
    let cycleTime2 = document.getElementById('cycleTime').value.trim();
    let productCode2 = document.getElementById('productCode').value.trim();

    if (!processCode2) {
        alert("공정코드를 입력해 주세요.");
        return; 
    }
    if (!processName2) {
        alert("공정명을 입력해 주세요.");
        return;
    }
    if (!processCategory2) {
        alert("공정분류를 입력해 주세요.");
        return; 
    }
    if (!isUsed2) {
        alert("사용여부를 선택해 주세요.");
        return; 
    }
    if (!cycleTime2) {
        alert("사이클타임을 입력해 주세요.");
        return; 
    }
    if (!productCode2) {
        alert("제품코드를 선택해 주세요.");
        return; 
    }

    // 하위 공정 데이터 검증
    let underProcessData = [];
    let processNameData = [];
    let productContentData = [];
    let imageData = [];
    let processCodeData = [];
    let imageFiles = [];

    
    let rows = document.querySelectorAll('.tbody tr'); // 테이블의 모든 행을 선택합니다.

    for (let row of rows) {
        let underprocess = row.querySelector('input[name="underprocess"]').value.trim();
        let processname3 = row.querySelector('input[name="processname2"]').value.trim();
        let productcontent2 = row.querySelector('input[name="productcontent"]').value.trim();
        // 이미지 데이터 처리
        let imageInput = row.querySelector('input[name="image"]');
        if (imageInput && imageInput.files.length > 0) {
            let imageFile = imageInput.files[0];
            imageFiles.push(imageFile); // 이미지 파일을 배열에 추가
        }

        if (!underprocess) {
            alert("하위공정코드를 입력해 주세요.");
            return; 
        }
        if (!processname3) {
            alert("공정명을 입력해 주세요.");
            return; 
        }
        if (!productcontent2) {
            alert("공정내용을 입력해 주세요.");
            return; 
        }

        underProcessData.push(underprocess);
        processNameData.push(processname3);
        productContentData.push(productcontent2);
        imageData.push(image);
        processCodeData.push(processCode2); // 모든 행에 대해 같은 공정 코드를 추가
    }

    // 폼 생성
    let form = document.createElement('form');
    form.method = 'POST';
    form.enctype="multipart/form-data"
    form.action = '/peanutbutter/Process'; // 변경할 URL을 설정

    // 필드 추가
    let fields = {
        processCode: processCode2,
        processName: processName2,
        processCategory: processCategory2,
        isUsed: isUsed2,
        cycleTime: cycleTime2,
        productCode: productCode2,
        underProcessData: JSON.stringify(underProcessData), // 배열을 JSON 문자열로 변환
        processNameData: JSON.stringify(processNameData),
        productContentData: JSON.stringify(productContentData),
        imageData: JSON.stringify(imageData),
        processCodeData: JSON.stringify(processCodeData)
    };

    for (let key in fields) {
        let input = document.createElement('input');
        input.type = 'hidden';
        input.name = key;
        input.value = fields[key];
        form.appendChild(input);
    }
    for (let i = 0; i < imageFiles.length; i++) {
        let fileInput = document.createElement('input');
        fileInput.type = 'file';
        fileInput.name = 'image'; // 이 이름을 컨트롤러에서 가져옵니다.
        fileInput.files = imageFiles[i].files;
        if (imageFiles[i] && imageFiles[i].size > 0) { // 파일이 존재하고 크기가 0보다 클 경우
            // DataTransfer 객체 생성
            const dataTransfer = new DataTransfer();
            dataTransfer.items.add(imageFiles[i]); // 파일 추가

            fileInput.files = dataTransfer.files; // fileInput에 FileList 할당
            form.appendChild(fileInput);
        } else {
            console.warn(`파일이 존재하지 않거나 크기가 0입니다: ${i}`);
        }
    }
      
    document.body.appendChild(form);
    form.submit(); // 한 번에 제출
    alert("등록완료");
}

    function addRow() {
    
       let tbody = document.querySelector('.tbody');

        let newRow = document.createElement('tr');
         newRow.innerHTML = `
            <td><input type="checkbox" class="delete-checkbox"></td>
            <td></td>
            <td><input name="underprocess" type="text" style="width: 90%;"></td>
            <td><input name="processname2" type="text" style="width: 90%;"></td>
            <td><input name="image" type="file" multiple="multiple"></td>
            <td><input name="productcontent" type="text" style="width: 90%; text-align: center;"></td>`;
            rowCount++;
        tbody.appendChild(newRow);
  
   }
    
    function deleteSelectedRows() { 
        let checkboxes = document.querySelectorAll('.delete-checkbox');
        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                checkbox.closest('tr').remove(); 
                rowCount--;
            }
        });
        resetRowNumbers();
    }

    function resetRowNumbers() {
       let rows = document.querySelectorAll('.tbody tr'); 
       rows.forEach(row => {
        let cells = row.querySelectorAll('td');
        cells[1].textContent = rowCount++; 
       });
   }
    function updateProductDescription() {
        const selectElement = document.getElementById("productCode");
        const selectedCode = selectElement.value;
    }

    

</script>