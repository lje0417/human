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
</head>

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

    .search_item {
        margin: 10px 100px;
        height: 60vh;
        background-color: white;
/*         overflow-y: auto; */
    }

    .search_input {
        height: 40px;
        font-size: 20px;
        border-radius: 5px;
        padding: 5px;
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

    td {
        text-align: center;
        padding: 5px;
        border-bottom: 1px solid rgb(218, 218, 218);
    }

    .notice td:nth-child(1) {
        /* notice 아래에 있는 td 중 두번째 자식요소를 선택함. 여기서는 공지사항의 제목임 */
        color: red;
        font-weight: bold;
    }

    .notice td:nth-child(3),
    .notice td:nth-child(2) {
        font-weight: bold;
    }

    .regBtn {
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

    .select {
        margin-right: 20px;
        height: 40px;
        font-size: 20px;
        border-radius: 5px;
    }

    #regDate {
        cursor: pointer;
    }

    .thead {
        /* thead는 스크롤이 생겨도 상단에 고정 */
        position: sticky;
        top: 0;
    }

    .tbody td {
        padding: 9px 0px;
    }
    
    .boardPage {
    	text-align: center;
    }
</style>

<body>
    <div class="container">
        <div class="top">
            <div class="title">
                <img src="image/board.png" style="width: 30px;">
                <span>게시판</span>
            </div>
        </div>
        <div class="search_container">
            <select class="select">
                <option>-----</option>
                <option>제목</option>
                <option>작성자</option>
            </select>
            <input class="search_input" type="text" placeholder="검색어를 입력해주세요">
            <img style="margin-left: 30px;margin-right: 30px;" src="image/search.png" onclick="searchTable()">
        </div>
        <div class="search_item">
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th id="regDate" onclick="sortByRegDate()">작성일</th>
                    </tr>
                </thead>
                <tbody class="tbody">
                    <c:forEach var="boardDTO" items="${map.list}">
                    	<tr>
                   
                    		<td>
                    		<c:if test="${boardDTO.notice eq 'false'}">
									공지사항
								</c:if>
								<c:if test="${boardDTO.notice eq 'true'}">
									${boardDTO.bno}
								</c:if>
								</td>
                    		
                    		<td><a href="board/detail?bno=${boardDTO.bno}">${boardDTO.title}</a></td>
                    		<td>${boardDTO.ename}</td>
                    		<td>${boardDTO.crDate}</td>
                    	</tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
<%
	Map map = (Map)request.getAttribute("map");
	int totalCount = (int)map.get("totalCount");
	
	String str_countPerPage = (String)request.getAttribute("countPerPage");
	int countPerPage = Integer.parseInt(str_countPerPage);
	
	String str_pageNo = (String)request.getAttribute("page");
	int pageNo = Integer.parseInt(str_pageNo);
	
	int lastPage = (int)Math.ceil( (double)totalCount / countPerPage );
	
	// 한번에 보여줄 페이지의 개수
	int countPerSection = 3;
	// 페이지 섹션 위치
	int position = (int)Math.ceil((double)pageNo / countPerSection);
	int sec_first = ((position-1) * countPerSection) + 1;
	int sec_last = position * countPerSection;
	if(sec_last > lastPage){
		sec_last = lastPage;
	}
%>

<div class=boardPage>
<c:set var="lastPage2" value="<%= lastPage %>" scope="page" />
<c:if test="<%=sec_first == 1 %>">
	[이전]
</c:if>
<c:if test="<%=sec_first != 1 %>">
	[<a href="?page=<%=sec_first-1 %>">이전</a>]
</c:if>

<%-- <c:forEach var="i" begin="1" end="${lastPage2 }"> --%>
<c:forEach var="i" begin="<%=sec_first %>" end="<%=sec_last %>">
	<c:choose>
		<c:when test="${page != i }">
			[<a href="?page=${i }">${i }</a>]
		</c:when>
		<c:otherwise>
			[<a href="?page=${i }"><strong>${i }</strong></a>]
		</c:otherwise>
	</c:choose>
</c:forEach>

<c:if test="<%=sec_last == lastPage %>">
	[다음]
</c:if>
<c:if test="<%=sec_last != lastPage %>">
	[<a href="?page=<%=sec_last+1 %>">다음</a>]
</c:if>
</div>
        <div class="regBtn">
            <span class="Btn_css" id="regBtn" onclick="regBoard()">글쓰기</span>
        </div>
    </div>
    

    
</body>

<script>
    function searchTable() { // 돋보기 버튼을 클릭했을 때 동작하는 함수
        let selectValue = document.querySelector('.select').value; //제목 or 작성자
        console.log(selectValue)
        let input = document.querySelector('.search_input').value; //검색창에 적힌 텍스트
        let table = document.querySelector('.table');
        let rows = table.querySelectorAll('.tbody tr'); // 행
        if (selectValue === '제목') {
            rows.forEach(row => {
                if (row.classList.contains('notice')) {  //공지사항은 필터링에서 제외
                    row.style.display = '';
                    return;
                }
                let titleCell = row.querySelector('td:nth-child(2)'); //부모 요소 내에서 두 번째 자식 td 요소를 선택. 제목
                if (titleCell) {
                    let titleText = titleCell.innerText;
                    if (titleText.includes(input)) {
                        row.style.display = '';
                    } else {
                        row.style.display = 'none';
                    }
                }
            });
        } else if (selectValue === '작성자') {
            rows.forEach(row => {
                if (row.classList.contains('notice')) {  //공지사항은 필터링에서 제외
                    row.style.display = '';
                    return;
                }
                let writerCell = row.querySelector('td:nth-child(3)'); //부모 요소 내에서 세 번째 자식 td 요소를 선택. 작성자       
                if (writerCell) {
                    let writerText = writerCell.innerText;
                    if (writerText.includes(input)) {
                        row.style.display = '';
                    } else {
                        row.style.display = 'none';
                    }
                }
            });
        } else if (selectValue === '-----') {
            rows.forEach(row => {
                row.style.display = '';
            })
        }

    }

    function regBoard() { //글쓰기 버튼 클릭하면 글 작성 페이지로 이동
        window.location.href = 'board/reg'

    }

    let isSorted = false;
    function sortByRegDate() { // 작성일 클릭하면 작성일 기준 정렬 

        console.log('등록일 기준 정렬')
        let tbody = document.querySelector('.tbody')

        /*
            tbody.querySelectorAll('tr') : tbody 요소 내의 모든 <tr> 요소를 선택. NodeList 객체를 반환함. 배열과 유사하지만, 실제 배열은 아님
            Array.from() : 실제 배열로 변환
        */
        let rows = Array.from(tbody.querySelectorAll('tr')); //모든 행을 가져와서 배열에 저장

        //공지사항은 정렬안해도 되기때문에 일반게시글과 구분함
        let noticeRows = rows.filter(row => row.classList.contains('notice'));
        let boardRows = rows.filter(row => !row.classList.contains('notice'));

        // boardRows.sort((a, b) => {
        //     let dateA = new Date(a.children[3].innerText); //4번째 자식요소인 등록일을 가져와서 Date 객체로 변환
        //     let dateB = new Date(b.children[3].innerText);
        //     return isSorted ? dateA - dateB : dateB - dateA; //반환값이 음수이면 a가 b보다 먼저 온다. 반환값이 양수이면 a가 b보다 나중에 온다
        // });

        /*
         *  처음에는 등록일 기준으로 정렬하려고 했으나 등록일이 같은경우 정렬이 제대로 되지않아서 인덱스번호로 정렬하는 것으로 수정함!!!
         */
        boardRows.sort((a, b) => {
            let indexA = a.children[0].innerText;
            let indexB = b.children[0].innerText;
            return isSorted ? indexA - indexB : indexB - indexA;
        });

        isSorted = !isSorted; //클릭할 때 마다 작성일 기준 내림차순이면 오름차순으로, 오름차순이면 내림차순으로 변경

        tbody.innerHTML = '';  //tbody 초기화
        noticeRows.forEach(row => tbody.appendChild(row)); //공지사항 먼저 tbody에 자식요소로 추가
        boardRows.forEach(row => tbody.appendChild(row)); //초기화된 tbody에 정렬된 데이터를 자식요소로 추가

    }

</script>

</html>