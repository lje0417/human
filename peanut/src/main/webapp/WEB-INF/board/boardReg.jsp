<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
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

    .reg_container {
        margin: 0 100px;
        height: 70vh;
        background-color: #E9E4DC;
        padding: 20px 100px;
    }

    span {
        font-size: 20px;
        font-weight: bold;
    }

    .inputText {
        margin-left: 20px;
        font-size: 20px;
        border-radius: 5px;
        padding-left: 5px;
        vertical-align: top;
    }

    textarea {
        width: 90%;
        height: 60%;
        padding: 10px;
    }

    input[type="checkbox"] {
        transform: scale(1.5);
        /* 체크박스 크기 크게 */
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
        display: inline-block;
        /* 다른 div영역과 겹치지 않게 */
        border: none;
    }

    .Btn_div {
        margin-top: 30px;
        text-align: right;
    }
</style>

<body>
    <div class="container">
        <div class="top">
            <div class="title">
                <img src="/peanut/image/board.png" style="width: 30px;">
                <span>게시글 작성</span>
            </div>
        </div>
        <div class="reg_container">
            <form method="post" action="reg">
                <div>
                    <span style="font-size: 17px; color: red;">공지사항으로 등록</span>
                    <input type="checkbox" id="checkbox" name="notice" value="공지"><br>
                </div>
                <div style="margin-top: 10px;">
                    <span>제목</span><input class="inputText" type="text" id="title"  name="title" placeholder="제목을 입력해주세요">
                    <span style="margin-left: 30px;">작성자</span><input class="inputText" type="text" id="writer" name="ename"
                        value="${loginDTO.ename}">
                </div>
                <br>
                <div style="margin-top: 10px;">
                    <span>내용</span><textarea class="inputText" placeholder="내용을 입력해주세요" id="content" name="content"></textarea>
                </div>
                <div class="Btn_div">
                    <button type="reset" class="Btn_css">초기화</button>
                    <input type="submit" value="등록" class="Btn_css">
<!--                     <button type="button" class="Btn_css" onclick="submitForm()">등록하기</button> -->
                </div>
            </form>
        </div>

    </div>
</body>

</html>