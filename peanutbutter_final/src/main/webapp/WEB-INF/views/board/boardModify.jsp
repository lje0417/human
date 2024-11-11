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
        font-size: 18px;
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
                <img src="/peanutbutter/image/board.png" style="width: 30px;">
                <span>게시글 수정</span>
            </div>
        </div>
        <div class="reg_container">
            <form method="post" action="modify">
                <div>
                    <span style="font-size: 17px; color: red;">공지사항으로 등록</span>
                    <input type="checkbox" id="checkbox" name="notice"><br>
                </div>
                <div style="margin-top: 10px;">
                    <span>제목</span><input class="inputText" type="text" id="title"  name="title" value="${boardDTO.title}">
                    <span style="margin-left: 30px;">작성자</span><input class="inputText" type="text" id="writer" name="ename"
                        value="${boardDTO.ename}">
                </div>
                <br>
                <div style="margin-top: 10px;">
                    <span>내용</span><textarea class="inputText" id="content" name="content">${boardDTO.content}</textarea>
                </div>
                <div class="Btn_div">
                    <button type="reset" class="Btn_css">초기화</button>
                    <input type="hidden" name="bno" value="${boardDTO.bno}">
                    <input type="submit" value="수정" class="Btn_css">
<!--                     <button type="button" class="Btn_css" onclick="submitForm()">등록하기</button> -->
                </div>
            </form>
        </div>

    </div>
</body>

<!--  
<script>
    function submitForm() {

        let now = new Date(); // 현재 날짜와 시간 객체 생성
        let year = now.getFullYear(); // 연도
        let month = (now.getMonth() + 1).toString().padStart(2, '0'); // 월 (0부터 시작하므로 +1)
        let day = now.getDate().toString().padStart(2, '0'); // 일

        // 연, 월, 일을 YYYY-MM-DD 형식으로 포맷
        let regDate = `${year}-${month}-${day}`;

        let title = document.querySelector('#title').value;
        let content = document.querySelector('#content').value;
        let writer = document.querySelector('#writer').value;
        let isChecked = document.querySelector('#checkbox').checked; // 공지사항으로 등록하는 체크박스 상태 확인


        if (title === '') {
            alert('제목을 입력해주세요');
            return;
        }
        if (content === '') {
            alert('내용을 입력해주세요');
            return;
        }

        

        // 기존 게시글 배열 가져오기
        let posts = JSON.parse(sessionStorage.getItem('posts')) || [];

        // 게시글을 구분하기 위한 인덱스
        let index = posts.length+1+4; //+4를 한 이유는 가라데이터 4개를 이미 넣어놨기 때문

        //제목, 내용, 작성자 등의 데이터를 세션에 저장
        posts.push({
            index:index,
            title: title,
            content: content,
            writer: writer,
            regDate: regDate,
            isChecked: isChecked
        });


        // 세션 스토리지에 게시글 배열 저장
        sessionStorage.setItem('posts', JSON.stringify(posts));



        if (isChecked) {
            alert(`공지사항이 등록되었습니다.\n등록일 : ${regDate}`)
        } else {
            alert(`게시글이 등록되었습니다.\n등록일 : ${regDate}`)
        }

        window.location.href ="board.jsp";
    }
</script>
 -->
</html>