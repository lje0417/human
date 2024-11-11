<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }

    .container {
        background-color: #F0F0E8;
        width: 100%;
        height: 100%;
        box-sizing: border-box;
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

    .title img {
        vertical-align: middle;
    }

    .title span {
        vertical-align: middle;
    }

    .section {
        height: 500px;
        margin: 0px 50px;
    }

    .table {
        width: 100%;
        border-collapse: collapse;
    }

    input[type="checkbox"] {
        transform: scale(1.5);
    }

    .thead {
        background-color: rgb(176, 176, 176);
        height: 40px;
    }

    .tbody {
        background-color: white;
    }

   
    .thead th:nth-child(1) {
        width: 5%;
    }
    .thead th:nth-child(2) {
        width: 15%;
    }
    .thead th:nth-child(3) {
        width: 15%;
    }
    .thead th:nth-child(4) {
        width: 15%;
    }
    .thead th:nth-child(5) {
        width: 15%;
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
    .tbody td {
        height: 92px;
        text-align: center;
        border-bottom: 1px solid lightgray;
    }

    .thead th {
        border-left: 1px solid white;

    }

    td span {
        padding: 5px;
        border: 1px solid #676767;
        background-color: #cfcfcf;
        border-radius: 5px;
        cursor: pointer;
    }

    .tbody img {
        width: 80px;
        height: 80px;
    }

    .select {
        width: 100px;
        height: 30px;
        font-size: 20px;
        margin-left: 180px;
    }
    .inputText {
        height: 30px;
        font-size: 20px;
        margin-left: 10px;
    }
    .regBtn{
        background-color: #676767;
        padding:3px 5px;
        color:white;
        border-radius: 5px;
        margin-left: 30px;
        font-size: 17px;
        cursor: pointer;
    }
</style>

<body>
    <div class="container">
        <div class="top">
            <img src="image/directory.png" style="width: 30px;">
            <span>공정 관리</span>
            <select class="select">
                <option value="-----">-----</option>
                <option value="code">공정코드</option>
                <option value="name">공정명</option>
            </select>
            <input type="text" class="inputText">
            <img src="image/search.png" style="margin-left: 10px;" onclick="searchTable()">
            <span class="regBtn" onclick="commitReg()">등록</span>
            <span class="regBtn" onclick="deleteSelectedRows()">삭제</span>
        </div>
        <div class="section">
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th></th>
                        <th>공정코드</th>
                        <th>공정명</th>
                        <th>공정분류</th>
                        <th>제품코드</th>
                        <th>사용여부</th>
                    </tr>
                </thead>
                <tbody class="tbody">
  <%
        List<human.class1.ajax.dto.FmDTO> processList = (List<human.class1.ajax.dto.FmDTO>) request.getAttribute("processList");
        for (human.class1.ajax.dto.FmDTO process : processList) {
    %>
        <tr>
            <td><input type="checkbox" class="delete-checkbox"></td>
            <td><a href="factory_Detail?processCode5=<%= process.getProcessCode() %>"><%= process.getProcessCode() %></a></td>
            <td><%= process.getProcessName() %></td>
            <td><%= process.getProcessType() %></td>
            <td><%= process.getProductCode() %></td>
            <td><%= process.getUseYn() %></td>
        </tr>
    <%
        }
    %>
                </tbody>
            </table>
        </div>
    </div>
</body>

<script>

function sendProcessCode(processCode) {
    console.log(`Navigating to: ProcessServlet3?processCode=${processCode}`);
    window.location.href = `ProcessServlet3?processCode=${processCode}`;
}
    function searchTable() { 
        let selectValue = document.querySelector('.select').value; 
        let searchText = document.querySelector('.inputText').value; 
        let table = document.querySelector('.table');

        console.log(selectValue)
        console.log(searchText);
        let rows = table.querySelectorAll('.tbody tr'); 
        if (selectValue === 'code') {
            rows.forEach(row => {
                
                let code = row.querySelector('td:nth-child(2)'); 
                if (code) {
                    let codeText = code.innerText;
                    if (codeText.includes(searchText)) {
                        row.style.display = '';
                    } else {
                        row.style.display = 'none';
                    }
                }
            });
        } else if (selectValue === 'name') {
            rows.forEach(row => {
                let name = row.querySelector('td:nth-child(3)');    
                if (name) {
                    let nameText = name.innerText;
                    if (nameText.includes(searchText)) {
                        row.style.display = '';
                    } else {
                        row.style.display = 'none';
                    }
                }
            });
        }else if (selectValue === '-----') {
            rows.forEach(row => {
                row.style.display = '';
            })
        }
    }
    
    function deleteSelectedRows() {
        let checkedBoxes = document.querySelectorAll('.delete-checkbox:checked');

        if (checkedBoxes.length > 0) {
            let form = document.createElement('form');
            form.method = 'POST';
            form.action = 'DeleteProcess';

            checkedBoxes.forEach(box => {
                let row = box.closest('tr');
                let processCode = row.querySelector('td:nth-child(2)').innerText;
                let input = document.createElement('input');
                input.type = 'hidden';
                input.name = 'processCode'; 
                input.value = processCode;
                form.appendChild(input);
            });

            document.body.appendChild(form);
            form.submit();
        } else {
            alert('삭제할 항목을 선택하세요.');
        }
    }
    function commitReg(){
        window.location.href="product/list";
    }
</script>