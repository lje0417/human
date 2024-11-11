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
        height: 10vh;
    }

    .title {
        padding-top: 10px;
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

    .section_div {
        display: flex;
        align-items: center;
        margin: 0 100px;
        height: 50px;
        background-color: #E9E4DC;
    }

    .section {
        margin: 10px 20px;
    }

    .btn_div {
        height: 20px;
        margin: 10px 100px;
    }

    .span {
        margin-left: 20px;
    }

    .inputText {
        height: 30px;
        font-size: 20px;
        width: 150px;
    }

    .row_add_delete_btn {
        padding: 3px 10px;
        background-color: #3F3B3B;
        color: white;
        border-radius: 5px;
        cursor: pointer;
    }

    .table_div {
        margin: 10px 100px;
        background-color: white;
        overflow-y: auto;
        /*행추가로 인해 범위를 벗어나면 스크롤 활성화시킴*/
    }

    .table {
        border-collapse: collapse;
        /* 테두리가 겹치지 않도록 설정 */
        width: 100%;
    }

    .thead {
        position: sticky;
        /* 스크롤이 활성화 되어도 회색바는 상단에 고정 */
        top: 0;
        width: 100%;
        height: 10%;
        background-color: #848484;

    }


    th {
        background-color: #848484;
        border-right: 1px solid white;
        color: white;
    }

    td {
        text-align: center;
    }

    .tbody tr {
        border-bottom: 1px solid lightgray;
    }

    tr th {
        padding: 5px 0px;
    }

    tr td {
        padding: 10px 0px;
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
        width: 30%;
    }

    .thead th:nth-child(6) {
        width: 10%;
    }

    .pagination {
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
<body>
    <div class="container">
        <div class="top">
            <div class="title">
                <img src="image/directory.png" style="width: 30px;">
                <span>하판조립</span>
            </div>
        </div>

        <div class="table_div">
            <table class="table">
                <thead class="thead">
                    <tr>
                        <th>순서</th>
                        <th>공정명</th>
                        <th>공정No</th>
                        <th>이미지</th>
                        <th>방법</th>
                        <th>생산 수량</th>
                    </tr>
                </thead>
                <tbody class="tbody">
                <c:forEach var="FL" items="${map.list }" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${FL.processname2}</td>
                        <td>${FL.underprocess}</td>
                        <td><img src="/peanutbutter${FL.image}" height="100px" width="150px"></td>
                        <td style="font-size: 15px;">
                            ${FL.productcontent}
                        </td>
                        <td>16</td>
                    </tr>
                 </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
<script>

</script>
</html>