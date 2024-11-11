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
<title>Insert title here</title>
</head>

<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }

    .container {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        padding: 0;
    }

    .top {
        display: flex;
        background-color: #444444;
        height: 50px;
    }

    .body {
        height: calc(100% - 50px);
        background-color: #C0B296;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .login_container {
        background-color: white;
        width: 400px;
        height: 300px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.6);
        border-radius: 8px;
    }

    .logo_div {
        width: 100%;
        height: 20%;
        margin-top: 10px;
    }

    img {
        max-width: 100%;
        /* 최대 너비를 컨테이너의 너비로 제한 */
        max-height: 100%;
        padding-left: 50px;
        margin-left: 40px;
    }

    .id_div, .pw_div{
        display: flex;
        align-items: center;
        justify-content: center;
        margin-top: 20px;
    }

    input {
        height: 40px;
        font-size: 15px;
        border: 2px solid #ccc;
        border-radius: 4px;
        transition: border-color 0.5s;
        padding:5px;
    }

    input:focus {
        border-color: black;
        outline: none;
    }

    .loginBtn {
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
    }
    
    .pb_join {
    	text-align: center;
    }

    .loginBtn:hover {
        background-color: #f4753b;
        color: white;
    }

   /* 모달 기본 스타일 */
.modal {
  display: none;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
  background-color: #fefefe;
  margin: 10% auto;
  padding: 20px;
  border: 1px solid #888;
  width: 350px;
  border-radius: 8px;
  box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
}

h2 {
  text-align: center;
  margin-bottom: 20px;
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

input[type="text"], input[type="password"] {
  padding: 8px;
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 4px;
  width: 100%;
}

.close {
  color: #aaa;
  font-size: 20px;
  font-weight: bold;
  float: right;
  cursor: pointer;
  margin-right: -10px;
}

.close:hover,
.close:focus {
  color: black;
}

.submit-btn {
  background-color: #4CAF50;
  color: white;
  padding: 10px 0;
  width: 100%;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.submit-btn:hover {
  background-color: #45a049;
}

</style>

<body>
    <div class="container">
        <div class="top"></div>
        <div class="body">
            <div class="login_container">
                <div class="logo_div"><img src="image/darkLogo.png"></div>
                <form method="post" action="login">
                	<div class="id_div"><input id="id" type="text" name="id" placeholder="아이디 또는 사번"></div>
                	<div class="pw_div"><input id="pw" type="password" name="pw" placeholder="비밀번호"></div>
                	<div class="pb_join">
                		<input type="submit" class="loginBtn" value="로그인">
                		<button type="button" class="loginBtn" id="showJoin">회원가입</button>
                	</div>
                </form>
            </div>
        </div>
    </div>
    
<!-- 회원가입 모달 -->
<div id="signupModal" class="modal">
  <div class="modal-content">
    <span class="close">&times;</span>
    <h2>회원가입</h2>
    <form id="signupForm" action="${pageContext.request.contextPath}/login/insert" method="post" onsubmit="return validateForm()">
      <div class="form-group">
        <label for="ename">이름:</label>
        <input type="text" id="ename" name="ename" required>
      </div>
      
      <div class="form-group">
        <label for="id">아이디 또는 사원번호:</label>
        <input type="text" id="id" name="id" required>
      </div>

      <div class="form-group">
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password" required>
      </div>

      <div class="form-group">
        <label for="confirmPassword">비밀번호 확인:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>
      </div>
      
      <button type="submit" class="submit-btn">가입하기</button>
    </form>
  </div>
</div>

<script>
    let loginBtn = document.querySelector('.loginBtn');

    loginBtn.addEventListener('click', function(e){
        let id = document.querySelector('#id').value;
        let pw = document.querySelector('#pw').value;
        if (id === 'admin' && pw === 'admin') {
            alert('관리자로 로그인');
        } else {
            alert('작업자로 로그인');
        }
    });

    // 모달 열기 및 닫기 스크립트
    var modal = document.getElementById("signupModal");
    var btn = document.getElementById("showJoin");
    var span = document.getElementsByClassName("close")[0];

    btn.onclick = function() {
      modal.style.display = "block";
    }

    span.onclick = function() {
      modal.style.display = "none";
    }

    window.onclick = function(event) {
      if (event.target == modal) {
        modal.style.display = "none";
      }
    }

    // 비밀번호 확인 유효성 검사
    function validateForm() {
        var password = document.getElementById("password").value;
        var confirmPassword = document.getElementById("confirmPassword").value;

        if (password !== confirmPassword) {
            alert("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
            return false;  // 제출을 중지
        }
        return true;  // 제출 진행
    }
    
 // 가입 완료 팝업 처리
    window.onload = function() {
        // 서버에서 success 플래그가 true일 경우에 팝업을 띄우는 로직
        let success = '<%= request.getAttribute("success") %>';
        if (success === 'true') {
            alert('가입이 완료되었습니다.');
        }
    }

    
</script>


</body>
</html>