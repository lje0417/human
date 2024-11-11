<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
    body {
        margin: 0;
        padding: 0;
        background-color: #E9E4DC;
    }

    .container {
        margin: 0 100px;
        background-color: #E9E4DC;
        padding: 20px 100px;
    }

    span {
        font-size: 20px;
        font-weight: bold;
    }

    .inputText {
        margin-left: 20px;
        font-size: 18px;
        border-radius: 5px;
        vertical-align: top;
        padding-left: 10px;
    }

    textarea {
        width: 90%;
        height: 150px;
        padding: 0px;
    }

    .commentSection {
        height: 180px;
        margin: 0px 100px;
        padding: 10px;
        overflow-y: auto;
        background-color: white;
    }

    .left {
        width: 150px;
        display: inline-block;
        text-align: center;
        font-weight: bold;
        padding: 5px 0px;
    }

    .right {
        width: 650px;
        display: inline-block;
        padding: 5px 0px;
    }

    .table {
        width: 100%;
    }

    .tbody td:nth-child(1) {
        width: 16%;
        text-align: center;
        padding: 5px 0px;
    }

    .tbody td:nth-child(2) {
        width: 85%;
        padding-left: 10px;
    }

    .commentRegSection {
        height: 70px;
        margin: 0 100px;
        padding: 5px;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .commentReg {
        height: 100%;
        width: 600px;
        align-items: center;
        padding: 10px;
    }

    .regBtn {
        margin-left: 20px;
        padding: 10px;
        background-color: rgb(169, 169, 169);
        border-radius: 5px;
        color: white;
        cursor: pointer;
    }

    .comment {
        border-left: 2px solid gray;
    }

    .buttonGroup {
        margin-top: 20px;
        text-align: right;
    }
    .buttonGroup a, .deleteBtn{
       display : inline-block;
    }

    .btn {
        padding: 10px 20px;
        margin-left: 10px;
        border-radius: 5px;
        color: white;
        cursor: pointer;
    }

    .editBtn {
        background-color: #4CAF50;
        padding: 10px 20px;
        margin-left: 10px;
        border-radius: 5px;
        color: white;
        cursor: pointer;
        display: inline-block;
        text-decoration: underline;
        text-decoration-color: #4CAF50;
    }

    .deleteBtn {
        background-color: #f44336;
        padding: 10px 20px;
        margin-left: 10px;
        border-radius: 5px;
        color: white;
        cursor: pointer;
        display: inline-block;
        font-size: 16px;
    }

    .button-container {
        display: inline-block; /* 또는 flex를 사용해도 됩니다 */
    }
</style>

<body>
    <div class="container">
        <div>
            <form method="get" action="detail">
                <div style="margin-top: 10px;">
                    <span>제목</span><input class="inputText" type="text" id="title" name="title" value="${boardDTO.title}" readonly>
                    <span style="margin-left: 30px;">작성자</span><input class="inputText" type="text" id="writer" name="name" value="${boardDTO.ename}" readonly>
                </div>
                <br>
                <div style="margin-top: 10px;">
                    <span>내용</span><textarea class="inputText" id="content" name="content" readonly>${boardDTO.content}</textarea>
                </div>
            </form>
            <div class="buttonGroup">

                <!-- 작성자와 세션에서 가져온 이름 비교 -->
                <c:if test="${boardDTO.ename == loginDTO.ename}">
                    <form method="post" action="delete" style="display:inline-block">
                        <input type="hidden" name="bno" value="${boardDTO.bno}" style="display: inline-block; margin: 0;">
                <a href="modify?bno=${boardDTO.bno}" class="editBtn">수정</a>
                        <input type="submit" value="삭제" class="deleteBtn" style="border: none; cursor: pointer;">
                    </form>
                </c:if>
            </div>
        </div>
    </div>

    <div class="commentSection">
        <table class="table">
            <tbody class="tbody">
                <c:forEach var="commentDTO" items="${commentList}">
                    <tr>
                        <td>${commentDTO.ename}</td>
                        <td class="comment">${commentDTO.reply}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="commentRegSection">
        <form id="commentForm" action="${pageContext.request.contextPath}/board/comment" method="post">
           <div style="display: inline-block;">
               <input type="hidden" name="bno" value="${boardDTO.bno}">
               <input type="hidden" name="ename" value="${loginDTO.ename}">
               <textarea class="commentReg" placeholder="댓글 입력 ..." name="reply"></textarea>
           </div>
           <div style="display: inline-block;">
               <input type="submit" value="작성" class="regBtn">
           </div>
        </form>
    </div>
</body>

<script>
    // 기존 스크립트 코드
    function editPost() {
        alert('게시글을 수정합니다.');
        // 수정 로직을 여기에 추가
    }

    function deletePost() {
        if (confirm('정말 삭제하시겠습니까?')) {
            alert('게시글이 삭제되었습니다.');
            // 삭제 로직을 여기에 추가
        }
    }
</script>

</html>
