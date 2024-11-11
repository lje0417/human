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
            <img src="/peanutbutter/image/BOM.png" style="width: 30px;">
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
                List<String[]> underProcesses = new ArrayList<>();

                if (processCode5 != null && !processCode5.isEmpty()) {
                    Connection conn = null;
                    PreparedStatement pstmt = null;
                    ResultSet rs = null;

                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        String jdbcURL = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
                        String jdbcUsername = "scott2_9";
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
                    } catch (ClassNotFoundException | SQLException e) {
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
      <option value="<%=productCode %>"><%= productCode %></option>
        <% 
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            
            try {
                
                Class.forName("oracle.jdbc.driver.OracleDriver");

                
                String jdbcURL = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
                String jdbcUsername = "scott2_9";
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
                             <td><input name="image" multiple="multiple" type="file" style="width: 90%;" >
                     <a href="${pageContext.request.contextPath}<%= underProcessImage %>" target="_blank 통쨰로 써야댐"> 
                        이미지보기
                     </a>                         
                             </td>                            
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
function previewImage(event) {
    var imgElement = document.getElementById('currentImage');
    var file = event.target.files[0];
    
    if (file) {
        var reader = new FileReader();
        reader.onload = function(e) {
            imgElement.src = e.target.result; // 새 이미지로 업데이트
        }
        reader.readAsDataURL(file);
    }
}
let count = <%= underProcesses.size() + 1 %>;
function displayFileName() {
    var input = document.getElementById('image');
    var fileName = input.files[0] ? input.files[0].name : 'No file selected';
    console.log(fileName);
}
function commitReg(event) {
    let processCode2 = document.getElementById('processCode').value.trim();
    let processName2 = document.getElementById('processName').value.trim();
    let processCategory2 = document.getElementById('processCategory').value.trim();
    let isUsed2 = document.getElementById('isUsed').value.trim();
    let cycleTime2 = document.getElementById('cycleTime').value.trim();
    let productCode2 = document.getElementById('productCode').value.trim();
    let processCodeHidden = document.getElementById('processCodeHidden').value.trim(); // 항목 추가

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
		    imageData.push(imageFile.name); // 파일 이름을 추가
		} else {
		    alert('이미지 파일이 필요합니다.'); // 이미지 값이 없을 경우 알림
		    event.preventDefault(); // 이벤트 취소
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
        processCodeData.push(processCode2); // 모든 행에 대해 같은 공정 코드를 추가
    }

    // 폼 생성
    let form = document.createElement('form');
    form.method = 'POST';
    form.enctype = "multipart/form-data";
    form.action = '/peanutbutter/updateProcess'; // 변경할 URL을 설정

    // 필드 추가
    let fields = {
        processCode: processCode2,
        processName: processName2,
        processCategory: processCategory2,
        isUsed: isUsed2,
        cycleTime: cycleTime2,
        productCode: productCode2,
        processCodeHidden: processCodeHidden, // 추가된 항목
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