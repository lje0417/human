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
        align-items: center; /* 수직 가운데 정렬 */
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
        height: 500px;
        margin: 0px 50px;
        overflow-y: scroll;
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
        position: sticky;
        top:0;
    }

    .tbody {
        background-color: white;
    }

   
    .thead th:nth-child(1) {
        width: 5%;
    }
    .thead th:nth-child(2) {
        width: 10%;
    }
    .thead th:nth-child(3) {
        width: 10%;
    }
    .thead th:nth-child(4) {
        width: 15%;
    }
    .thead th:nth-child(5) {
        width: 20%;
    }
    .thead th:nth-child(6) {
        width: 8%;
    }
    .thead th:nth-child(7) {
        width: 12%;
    }
    .thead th:nth-child(8) {
        width: 10%;
    }
    .thead th:nth-child(9) {
        width: 20%;
    }

    .tbody td {
        height: 80px;
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

    .pagination {
        margin-top: 10px;
        display: flex;
        justify-content: center;
        list-style-type: none;
        padding: 0;
    }

    .pagination li {
        margin: 0 5px;
    }

    .pagination a {
        display: block;
        padding: 8px 16px;
        text-decoration: none;
        color: #007bff;
    }

    .pagination a:hover {
        background-color: #ddd;
        border-radius: 5px;
    }

    .pagination .active a {
        color: white;
        background-color: #007bff;
        border-radius: 5px;
    }
</style>

</head>
<body>
    <div class="container">
        <div class="top">
            <img src="image/directory.png" style="width: 30px;"> <span>부품 관리</span>
        <form id="searchform" action="pt" method="get"> 
            <select class="select" name=optionvalue>
                <option value="-----" <c:if test="${empty map.optionvalue || map.optionvalue == '-----'}">selected</c:if>>-----</option>
                <option value="part_code" <c:if test="${map.optionvalue == 'part_code'}">selected</c:if>>부품코드</option>
                <option value="part_name" <c:if test="${map.optionvalue == 'part_name'}">selected</c:if>>모델명</option>
            </select>
            <input type="text" class="inputText" name="search" value = "${map.search}">
             <img src="image/search.png" style="margin-left: 10px;" onclick="searchTable()">
        </form>
            <span class="regBtn" onclick="commitReg()">등록</span>
            <span class="regBtn" onclick="deleteRow()">삭제</span>
        </div>
        <div class="section">
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th></th>
                        <th>부품코드</th>
                        <th>부품분류</th>
                        <th>모델</th>
                        <th>이미지</th>
                        <th>단위</th>
                        <th>규격</th>
                        <th>바코드</th>
                    </tr>
                </thead>
                <tbody class="tbody">
                <c:forEach var="PT" items="${map.list }">
                    <tr>
                        <td><input type="checkbox" class="delete-checkbox" value="${PT.part_code}"></td>
                        <td>${PT.part_code}</td>
                        <td>${PT.part_name}</td>
                        <td><a href="/peanutbutter/modify_pt?part_code=${PT.part_code}">${PT.part_modelname}</a></td>
                        <td><img src="${PT.part_image}"></td>
                        <td>${PT.part_unit}</td>
                        <td>${PT.part_standard}</td>
                        <td><img src="${PT.part_barcode}"></td>
                    </tr>
                </c:forEach>
             </tbody>
           </table>
       </div>
       
       <%
		
		Map map = (Map)request.getAttribute("map");
		
		System.out.println("1");
		int totalCount = (Integer) map.get("totalCount");
		System.out.println("2");
		String str_countPerPage = (String) request.getAttribute("countPerPage");
		int countPerPage = Integer.parseInt(str_countPerPage);
		System.out.println("3");
		String str_pageNo = (String) request.getAttribute("page");
		int pageNo = Integer.parseInt(str_pageNo);
		System.out.println("4");
		int lastPage = (int) Math.ceil((double) totalCount / countPerPage); // 전체개수 / 한페이당 개수를 하고 올림이 되도록 형변환을 해줌 (마지막 페이지가 나오게)
		
		
		// 한번에 보여줄 페이지의 개수
		int countPerSection = 3;
		// 페이지 섹션 위치
		int position = (int) Math.ceil((double) pageNo / countPerSection);
		int sec_first = ((position - 1) * countPerSection) + 1;
		int sec_last = position * countPerSection;
		if (sec_last > lastPage) {
			sec_last = lastPage;
		}
		%>
		<c:set var="lastPage2" value="<%=lastPage%>" scope="page" />
		<div style= "text-align: center;">
		<c:if test="<%=sec_first == 1%>">
				[이전]
		</c:if>

		<c:if test="<%=sec_first != 1%>">
			[<a href="javascript:void(0)" onclick="searchpage(<%=sec_first - 1%>)" >이전</a>]
		</c:if>

		<c:forEach var="i" begin="<%=sec_first%>" end="<%=sec_last%>">
			<c:choose>
				<c:when test="${page != i }">
			[<a href="javascript:void(0)" onclick="searchpage(${i})">${i}</a> ]
		</c:when>
				<c:otherwise>
			[<a href="javascript:void(0)" onclick="searchpage(${i})"><strong>${i}</strong></a> ]
		</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="<%=sec_last == lastPage%>">
				[다음]
		</c:if>

		<c:if test="<%=sec_last != lastPage%>">
			[<a href="javascript:void(0)" onclick="searchpage(<%=sec_last + 1%>)">다음</a>]
		</c:if>
		
		</div>
	
	</div>

	<form id="deleteone" action="delete_pt" method="post">
		<input type="hidden" name="part_codes" id="part_codes">
	</form>
       
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
    
    		let codesField = document.getElementById('part_codes');
    		codesField.value = selects.join(',');
    		
    		document.getElementById('deleteone').submit();
    }

    function commitReg(){
    	location.href="/peanutbutter/insert_pt";
    }
    	a = '${map.optionvalue}';
    	b = '${map.search}';
    	
    function searchpage(num){
    
    	let url = "/peanutbutter/pt?page=" + num;
    	
    	
    	if(a != ''){    		
//     		location.href="/peanutbutter/pl?optionvalue="+a+"&search="+b+"&page=num";
    		url += "&optionvalue=" + encodeURIComponent(a);
    	}
    	
    	if(b != '') {
    		url += "&search=" + encodeURIComponent(b);
    	}
    	
    	location.assign(url);
    }
</script>
</html>