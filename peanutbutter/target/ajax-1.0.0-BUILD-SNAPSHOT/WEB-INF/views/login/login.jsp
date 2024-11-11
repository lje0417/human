<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 및 회원가입</title>
<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }

    body {
        margin: 0;
        padding: 0;
        background-color: #C0B296;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        width: 100%;
        height: 100%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .top {
        display: flex;
        background-color: #444444;
        height: 50px;
        width: 100%;
    }

    .body {
        height: calc(100% - 50px);
        background-color: #C0B296;
        display: flex;
        align-items: center;
        justify-content: center;
        width: 100%;
    }

    .login_container {
        background-color: white;
        width: 400px;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.6);
        border-radius: 8px;
        text-align: center;
        position: relative;
    }

    .logo_div {
        width: 100%;
        margin-bottom: 20px;
    }

    img {
        max-width: 100%;
        height: 50px;
    }

    .form-group {
        margin-top: 10px;
    }

    .form-group input {
        width: calc(100% - 20px);
        height: 40px;
        font-size: 15px;
        border: 2px solid #ccc;
        border-radius: 4px;
        padding: 5px;
        transition: border-color 0.5s;
    }

    .form-group input:focus {
        border-color: black;
        outline: none;
    }

    .submit-btn {
        width: 150px;
        height: 40px;
        background-color: white;
        border: 2px solid #f4753b;
        color: #f4753b;
        font-weight: bold;
        font-size: 20px;
        margin-top: 30px;
        border-radius: 20px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .submit-btn:hover {
        background-color: #f4753b;
        color: white;
    }

    .login-btn {
        margin-top: 20px;
    }

    /* 회원가입 모달 */
    .signup_container {
        display: none; /* 처음에는 숨김 */
        position: fixed; /* 화면 전체에 띄움 */
        top: 50%; /* 화면 중간에 위치 */
        left: 50%;
        transform: translate(-50%, -50%); /* 화면 중앙으로 이동 */
        background-color: #fff;
        width: 400px;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        z-index: 1000; /* 로그인 폼보다 앞에 나오도록 설정 */
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #444;
    }

    .form-group {
        display: flex;
        flex-direction: column;
        margin-bottom: 15px;
    }

    label {
        margin-bottom: 5px;
        font-size: 14px;
    }

    input[type="text"], input[type="password"], input[type="email"] {
        padding: 8px;
        font-size: 14px;
        border: 2px solid #ccc;
        border-radius: 4px;
        width: 100%;
    }

    .submit-btn {
        background-color: #4CAF50; /* 가입하기 버튼 색상 */
        color: white;
        padding: 10px 0;
        width: 100%;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
    }

    .submit-btn:hover {
        background-color: #45a049;
    }
    
    /* 닫기(X) 버튼 */
    .close-btn {
        background: none;
        border: none;
        font-size: 24px;
        font-weight: bold;
        position: absolute;
        top: 10px;
        right: 10px;
        cursor: pointer;
    }

    .close-btn:hover {
        color: #f00;
    }

    /* 유효성 검사 메시지 */
    #password-message {
        color: red;
        font-size: 12px;
        display: none;
    }

    /* 설명 문구 스타일 */
    .input-hint {
        font-size: 12px;
        color: #555;
        margin-top: 5px;
    }
</style>

</head>
<body>
    <div class="container">
        <div class="top"></div>
        <div class="body">
            <!-- 로그인 폼 -->
            <div class="login_container">
                <div class="logo_div">
                    <img src="/peanutbutter/resources/image/darkLogo.png" alt="로고 이미지">
                </div>
                <h2>로그인</h2>
                <form method="post" action="${pageContext.request.contextPath}/login">
                    <div class="form-group">
                        <input id="id" type="text" name="id" placeholder="사번(아이디)" required>
                    </div>
                    <div class="form-group">
                        <input id="pw" type="password" name="pw" placeholder="비밀번호" required>
                    </div>
                    <button type="submit" class="submit-btn">로그인</button>
                </form>
                <button type="button" class="submit-btn login-btn" id="showJoin">회원가입</button>
            </div>

            <!-- 회원가입 폼 -->
            <div class="signup_container" id="signupModal" style="display: none;">
            <button type="button" id="closeModal" class="close-btn">&times;</button> <!-- 닫기 버튼 추가 -->
                <h2>회원가입</h2>
                <form id="signupForm" action="${pageContext.request.contextPath}/login/insert" method="post" onsubmit="return validateForm()">
                    <div class="form-group">
                        <input id="signup_id" type="text" name="id" placeholder="사번(아이디)" required>
                    </div>
                    <div class="form-group">
                        <input id="ename" type="text" name="ename" placeholder="이름" required>
                    </div>
                    <div class="form-group">
                        <input id="phone_num" type="text" name="phone_num" placeholder="전화번호" required>
                        <p class="input-hint">숫자만 입력</p> 
                    </div>
                    <div class="form-group">
                        <input id="email" type="email" name="email" placeholder="이메일" required>
                        <p class="input-hint">예시: user@example.com</p> 
                    </div>
                    <div class="form-group">
                        <input id="password" type="password" name="password" placeholder="비밀번호" required oninput="validatePassword()">
                        <p class="input-hint">비밀번호는 최소 8자, 대문자, 소문자, 숫자, 특수문자가 각각 하나 이상 포함되어야 합니다.</p>
                        <p id="password-message"></p>
                    </div>
                    <div class="form-group">
                        <input id="confirmPassword" type="password" name="confirmPassword" placeholder="비밀번호 확인" required>
                    </div>
                    <button type="submit" class="submit-btn">가입하기</button>
                </form>
            </div>
        </div>
    </div>

<script>
// 비밀번호 확인 및 유효성 검사
function validateForm() {
    var password = document.getElementById("password").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var phoneNum = document.getElementById("phone_num").value;
    var email = document.getElementById("email").value;

    if (password !== confirmPassword) {
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }

    // 전화번호 형식 검사
    var phoneRegex = /^[0-9]{10,11}$/;
    if (!phoneRegex.test(phoneNum)) {
        alert("전화번호 형식이 올바르지 않습니다.");
        return false;
    }

    // 이메일 형식 검사
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert("유효한 이메일 주소를 입력하세요.");
        return false;
    }

    return true;
}

// 비밀번호 유효성 검사
function validatePassword() {
    const password = document.getElementById("password").value;
    const messageElement = document.getElementById("password-message");

    const minLength = 8;
    const hasUpperCase = /[A-Z]/;
    const hasLowerCase = /[a-z]/;
    const hasNumber = /[0-9]/;
    const hasSpecialChar = /[!@#$%^&*(),.?":{}|<>]/;

    if (password.length < minLength) {
        messageElement.textContent = "비밀번호는 최소 8자리여야 합니다.";
        messageElement.style.display = "block";
        return;
    }

    if (!hasUpperCase.test(password)) {
        messageElement.textContent = "비밀번호에 대문자가 하나 이상 포함되어야 합니다.";
        messageElement.style.display = "block";
        return;
    }

    if (!hasLowerCase.test(password)) {
        messageElement.textContent = "비밀번호에 소문자가 하나 이상 포함되어야 합니다.";
        messageElement.style.display = "block";
        return;
    }

    if (!hasNumber.test(password)) {
        messageElement.textContent = "비밀번호에 숫자가 하나 이상 포함되어야 합니다.";
        messageElement.style.display = "block";
        return;
    }

    if (!hasSpecialChar.test(password)) {
        messageElement.textContent = "비밀번호에 특수문자가 하나 이상 포함되어야 합니다.";
        messageElement.style.display = "block";
        return;
    }

    messageElement.style.display = "none";
}

// 중복 체크 상태 플래그
let alertDisplayed = false;

// 아이디 중복 체크 비동기 요청
document.getElementById("signup_id").addEventListener("blur", function () {
    var id = document.getElementById("signup_id").value;
    fetch('${pageContext.request.contextPath}/login/checkId?id=' + id)
        .then(response => response.json())
        .then(data => {
            if (!data.available && !alertDisplayed) {
                alertDisplayed = true; // 알림 표시 상태 변경
                alert("이미 사용 중인 아이디입니다.");
                document.getElementById("signup_id").focus();
            } else {
                alertDisplayed = false; // 알림 상태 초기화
            }
        });
});

// 전화번호 중복 체크 비동기 요청
document.getElementById("phone_num").addEventListener("blur", function () {
    var phoneNum = document.getElementById("phone_num").value;
    fetch('${pageContext.request.contextPath}/login/checkPhoneNum?phone_num=' + phoneNum)
        .then(response => response.json())
        .then(data => {
            if (!data.available && !alertDisplayed) {
                alertDisplayed = true; // 알림 표시 상태 변경
                alert("이미 사용 중인 전화번호입니다.");
                document.getElementById("phone_num").focus();
            } else {
                alertDisplayed = false; // 알림 상태 초기화
            }
        });
});

// 이메일 중복 체크 비동기 요청
document.getElementById("email").addEventListener("blur", function () {
    var email = document.getElementById("email").value;
    fetch('${pageContext.request.contextPath}/login/checkEmail?email=' + email)
        .then(response => response.json())
        .then(data => {
            if (!data.available && !alertDisplayed) {
                alertDisplayed = true; // 알림 표시 상태 변경
                alert("이미 사용 중인 이메일입니다.");
                document.getElementById("email").focus();
            } else {
                alertDisplayed = false; // 알림 상태 초기화
            }
        });
});



// 모달 열기
document.getElementById("showJoin").addEventListener("click", function() {
    document.getElementById("signupModal").style.display = "block";
});

// 모달 닫기
document.getElementById("closeModal").addEventListener("click", function() {
    document.getElementById("signupModal").style.display = "none";
});

</script>

</body>
</html>
