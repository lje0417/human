<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException, java.util.ArrayList, java.util.List" %>
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
<form action="/peanutbutter/updateProcess" method="post">
    <div class="container">
        <div class="top">
            <img src="/peanutbutter/resources/image/BOM.png" style="width: 30px;">
            <span>공정 수정</span>
        </div>
        <div class="section">
            <%
                String processCode5 = request.getParameter("processCode5");

                String processCode = "";
                String processName = "";
                String processCategory = "";
                String isUsed = "";
                String cycleTime = "";
                String productCode = "";
                List<String[]> underProcesses = new ArrayList<String[]>();

                if (processCode5 != null && !processCode5.isEmpty()) {
                    Connection conn = null;
                    PreparedStatement pstmt = null;
                    ResultSet rs = null;

                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        String jdbcURL = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
                        String jdbcUsername = "scott2_17";
                        String jdbcPassword = "tiger";
                        conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

                        
                        String sql = "SELECT * FROM process WHERE process_code = ?";
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, processCode5);
                        rs = pstmt.executeQuery();

                        if (rs.next()) {
                            processCode = rs.getString("process_code");
                            processName = rs.getString("process_name");
                            processCategory = rs.getString("process_category");
                            isUsed = rs.getString("is_used");
                            cycleTime = rs.getString("cycle_time");
                            productCode = rs.getString("product_code");
                        }

                       
                        String sql2 = "SELECT * FROM process2 WHERE process_code = ? ORDER BY sequence_number ASC";
                        pstmt = conn.prepareStatement(sql2);
                        pstmt.setString(1, processCode5);
                        rs = pstmt.executeQuery();

                        while (rs.next()) {
                            String underProcessCode = rs.getString("underprocess");
                            String underProcessName = rs.getString("processname2");
                            String underProcessImage = rs.getString("image");
                            String underProcessContent = rs.getString("productcontent");
                            underProcesses.add(new String[] {underProcessCode, underProcessName, underProcessImage, underProcessContent});
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (rs != null) rs.close();
                            if (pstmt != null) pstmt.close();
                            if (conn != null) conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            %>

            <div style="margin-left: 150px;">
                <input type="hidden" id="processCodeHidden" name="processCodeHidden" value="<%= processCode %>">
                <div>
                    <span class="span">공정코드</span><input id="processCode" name="processCode" class="inputText" type="text" value="<%= processCode %>" readonly><%--공정코드가 기본키설정 수정불가 --%>
                    <span class="spanMargin">공정명</span><input id="processName" name="processName" class="inputText" type="text" value="<%= processName %>">
                </div>
                <div class="div">
                    <span class="span">공정분류</span><input id="processCategory" name="processCategory" class="inputText" type="text" value="<%= processCategory %>">
                    <span class="spanMargin">사용여부</span>
                    <select id="isUsed" name="isUsed" class="select">
                        <option value="Y" <%= "Y".equals(isUsed) ? "selected" : "" %>>Y</option>
                        <option value="N" <%= "N".equals(isUsed) ? "selected" : "" %>>N</option>
                    </select>
                </div>
                <div class="div">
                    <span class="span">사이클타임</span><input id="cycleTime" name="cycleTime" class="inputText" type="text" value="<%= cycleTime %>">
                    <span class="spanMargin">제품코드</span>
 <select id="productCode" name="productCode" class="select2" onchange="updateProductDescription()">
        <option value="">-----</option>
        <% 
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            
            try {
                
                Class.forName("oracle.jdbc.driver.OracleDriver");

                
                String jdbcURL = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
                String jdbcUsername = "scott2_17";
                String jdbcPassword = "tiger";
                conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

                
                String sql = "SELECT product_code FROM TABLE_PM ORDER BY product_code ASC";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                
                while (rs.next()) {
                    String code = rs.getString("product_code");
        %>
                    <option value="<%= code %>"><%= code %></option>
        <%
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                
                if (rs != null) try { rs.close(); } catch (Exception e) { e.printStackTrace(); }
                if (pstmt != null) try { pstmt.close(); } catch (Exception e) { e.printStackTrace(); }
                if (conn != null) try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
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
                        <% 
                            for (String[] underProcess : underProcesses) {
                                String underProcessCode = underProcess[0];
                                String underProcessName = underProcess[1];
                                String underProcessImage = underProcess[2];
                                String underProcessContent = underProcess[3];
                        %>
                        <tr>
                            <td><input type="checkbox" class="delete-checkbox"></td>
                            <td></td>
                            <td><input name="underprocess" type="text" style="width: 90%;" value="<%= underProcessCode %>"></td>
                            <td><input name="processname2" type="text" style="width: 90%;" value="<%= underProcessName %>"></td>
                            <td><input name="image" type="file" style="width: 90%;" value="<%= underProcessImage %>"></td>
                            <td><input name="productcontent" type="text" style="width: 90%; text-align: center;" value="<%= underProcessContent %>"></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="btnDiv">
            <span class="Btn_css" onclick="commitReg()">수정</span>
        </div>
    </div>
</form>
</body>
<script>
let count = <%= underProcesses.size() + 1 %>;

function commitReg() {
    let processCode = document.getElementById('processCode').value.trim();
    let processName = document.getElementById('processName').value.trim();
    let processCategory = document.getElementById('processCategory').value.trim();
    let isUsed = document.getElementById('isUsed').value.trim();
    let cycleTime = document.getElementById('cycleTime').value.trim();
    let productCode = document.getElementById('productCode').value.trim();
    let processCodeHidden = document.getElementById('processCodeHidden').value.trim();

    if (!processCode || !processName || !processCategory || !isUsed || !cycleTime || !productCode) {
        alert("모든 필수 입력 필드를 채워주세요.");
        return;
    }

    let underProcessData = [];
    let processNameData = [];
    let productContentData = [];
    let imageData = [];
    let processCodeData = [];
	
    document.querySelectorAll('input[name="underprocess"]').forEach(input => {
        underProcessData.push(input.value.trim());
    });
    
    document.querySelectorAll('input[name="processname2"]').forEach(input => {
        processNameData.push(input.value.trim());
    });

    document.querySelectorAll('input[name="productcontent"]').forEach(input => {
        productContentData.push(input.value.trim());
    });

    document.querySelectorAll('input[name="image"]').forEach(input => {
        imageData.push(input.value.trim());
    });

    document.querySelectorAll('input[name="underprocess"]').forEach(() => {
        processCodeData.push(processCode);
    });

    // 폼 생성 및 데이터 추가
    let form = document.createElement('form');
    form.method = 'POST';
    form.action = '/peanutbutter/updateProcess';

    // 필드 데이터 추가
    let fields = {
        processCode, processName, processCategory, isUsed, cycleTime, productCode, processCodeHidden
    };
    for (let key in fields) {
        let input = document.createElement('input');
        input.type = 'hidden';
        input.name = key;
        input.value = fields[key];
        form.appendChild(input);
    }

    // 하위 공정 데이터 추가
    let dataFields = {
        underProcessData,
        processNameData,
        productContentData,
        imageData,
        processCodeData
    };
    for (let key in dataFields) {
        let input = document.createElement('input');
        input.type = 'hidden';
        input.name = key;
        input.value = JSON.stringify(dataFields[key]);  // 배열 데이터를 문자열로 변환
        form.appendChild(input);
    }

    document.body.appendChild(form);
    form.submit();

    alert("수정완료");
}


function addRow() {
    let tbody = document.querySelector('.tbody');
    let newRow = document.createElement('tr');
    newRow.innerHTML = `
        <td><input type="checkbox" class="delete-checkbox"></td>
        <td></td>
        <td><input name="underprocess" type="text" style="width: 90%;"></td>
        <td><input name="processname2" type="text" style="width: 90%;"></td>
        <td><input name="image" type="file" style="width: 90%;"></td>
        <td><input name="productcontent" type="text" style="width: 90%; text-align: center;"></td>`;
    tbody.appendChild(newRow);
   
}

function deleteSelectedRows() {
    let checkboxes = document.querySelectorAll('.delete-checkbox');
    checkboxes.forEach(checkbox => {
        if (checkbox.checked) {
            checkbox.closest('tr').remove();
        }
    });

}
function updateProductDescription() {
    const selectedCode = document.getElementById("productCode").value;
    console.log("Selected product code: " + selectedCode);
}

</script>