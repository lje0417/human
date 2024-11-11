<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

.buttonGroup a, .deleteBtn {
	display: inline-block;
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

/* 수정, 저장 버튼 */
.commentEditBtn, .saveBtn {
	background-color: transparent; /* 배경 투명 */
	border: none; /* 테두리 없음 */
	color: #4CAF50; /* 초록색 */
	font-size: 14px; /* 글씨 크기 */
	cursor: pointer; /* 커서 포인터로 변경 */
	text-decoration: underline; /* 밑줄 추가 */
	padding: 0; /* 패딩 제거 */
	margin-left: 10px; /* 왼쪽에 약간의 간격 */
}

.commentEditBtn:hover, .saveBtn:hover {
	color: #2E8B57; /* 호버 시 더 진한 초록색 */
}

/* 취소 버튼 */
.cancelBtn {
	background-color: transparent; /* 배경 투명 */
	border: none; /* 테두리 없음 */
	color: #FF6347; /* 빨간색 (토마토 색상) */
	font-size: 14px; /* 글씨 크기 */
	cursor: pointer; /* 커서 포인터로 변경 */
	text-decoration: underline; /* 밑줄 추가 */
	padding: 0; /* 패딩 제거 */
	margin-left: 10px; /* 왼쪽에 약간의 간격 */
}

.cancelBtn:hover {
	color: #FF4500; /* 호버 시 더 진한 빨간색 */
}

/* 삭제 버튼 */
.commentDeleteBtn {
	background-color: transparent; /* 배경 투명 */
	border: none; /* 테두리 없음 */
	color: #FF6347; /* 빨간색 (토마토 색상) */
	font-size: 14px; /* 글씨 크기 */
	cursor: pointer; /* 커서 포인터로 변경 */
	text-decoration: underline; /* 밑줄 추가 */
	padding: 0; /* 패딩 제거 */
	margin-left: 10px; /* 왼쪽에 약간의 간격 */
}

.commentDeleteBtn:hover {
	color: #FF4500; /* 호버 시 더 진한 빨간색 */
}
</style>

<body>
	<div class="container">
		<div>
			<form method="get" action="detail">
				<div style="margin-top: 10px;">
					<span>제목</span><input class="inputText" type="text" id="title"
						name="title" value="${boardDTO.title}" readonly> <span
						style="margin-left: 30px;">작성자</span><input class="inputText"
						type="text" id="writer" name="name" value="${boardDTO.ename}"
						readonly>
				</div>
				<br>
				<div style="margin-top: 10px;">
					<span>내용</span>
					<textarea class="inputText" id="content" name="content" readonly>${boardDTO.content}</textarea>
				</div>
			</form>
			<div class="buttonGroup">

				<!-- 작성자와 세션에서 가져온 이름 비교 -->
				<c:if test="${boardDTO.ename == loginDTO.ename}">
					<form method="post" action="delete" style="display: inline-block">
						<input type="hidden" name="bno" value="${boardDTO.bno}"
							style="display: inline-block; margin: 0;"> <a
							href="modify?bno=${boardDTO.bno}" class="editBtn">수정</a> <input
							type="submit" value="삭제" class="deleteBtn"
							style="border: none; cursor: pointer;">
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
						<td class="comment">
							<!-- 기존 댓글 내용 --> <span
							id="commentText-${commentDTO.comments_id}">${commentDTO.reply}</span>

							<!-- 댓글 수정 폼 (기본적으로 숨김) -->
							<form id="editForm-${commentDTO.comments_id}"
								action="${pageContext.request.contextPath}/board/comment/edit"
								method="post" style="display: none;">
								<input type="hidden" name="comments_id"
									value="${commentDTO.comments_id}"> <input type="hidden"
									name="bno" value="${boardDTO.bno}">
								<textarea name="reply" rows="2" style="width: 80%;">${commentDTO.reply}</textarea>
								<input type="submit" value="저장" class="saveBtn">
								<button type="button" class="cancelBtn"
									onclick="cancelEdit(${commentDTO.comments_id})">취소</button>
							</form> <!-- 수정 및 삭제 버튼 추가 --> <c:if
								test="${commentDTO.ename == loginDTO.ename}">
								<div class="button-container">
									<!-- 수정 버튼 -->
									<button class="commentEditBtn" type="button"
										onclick="editComment(${commentDTO.comments_id})">수정</button>
									<!-- 삭제 버튼 -->
									<form method="post"
										action="${pageContext.request.contextPath}/board/comment/delete"
										style="display: inline-block;">
										<input type="hidden" name="comments_id"
											value="${commentDTO.comments_id}"> <input
											type="hidden" name="bno" value="${boardDTO.bno}"> <input
											type="submit" value="삭제" class="commentDeleteBtn"
											style="border: none; cursor: pointer;">
									</form>
								</div>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>



	<div class="commentRegSection">
		<form id="commentForm"
			action="${pageContext.request.contextPath}/board/comment"
			method="post">
			<div style="display: inline-block;">
				<input type="hidden" name="bno" value="${boardDTO.bno}"> <input
					type="hidden" name="ename" value="${loginDTO.ename}">
				<textarea class="commentReg" placeholder="댓글 입력 ..." name="reply"></textarea>
			</div>
			<div style="display: inline-block;">
				<input type="submit" value="작성" class="regBtn">
			</div>
		</form>
	</div>
</body>

<script>
function editComment(comments_id) {
    document.getElementById('commentText-' + comments_id).style.display = 'none';
    document.getElementById('editForm-' + comments_id).style.display = 'block';
}

function cancelEdit(comments_id) {
    document.getElementById('commentText-' + comments_id).style.display = 'block';
    document.getElementById('editForm-' + comments_id).style.display = 'none';
}

</script>

</html>
