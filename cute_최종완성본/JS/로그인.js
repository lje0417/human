document.addEventListener("DOMContentLoaded", function () {
    // 모달을 처음에는 보이지 않도록 설정
    const joinModal = document.getElementById("joinModal");
    joinModal.style.display = "none";

    // 회원가입 버튼 클릭 시 모달 표시
    document.getElementById("showJoin").addEventListener("click", function () {
        joinModal.style.display = "flex";
    });

    // 모달 닫기 버튼 클릭 시 모달 숨김
    document.querySelector(".modal .close").addEventListener("click", function () {
        joinModal.style.display = "none";
    });

    // 모달 외부 클릭 시 모달 숨김
    window.onclick = function (event) {
        if (event.target === joinModal) {
            joinModal.style.display = "none";
        }
    };

    // 회원가입 폼 HTML을 가져와서 모달에 삽입
    fetch("/HTML/회원가입.html")
        .then((response) => response.text())
        .then((data) => {
            document.getElementById("joinFormContainer").innerHTML = data;
            // 동적으로 추가된 스크립트 실행
            let script = document.createElement("script");
            script.src = "/JS/회원가입.js";
            document.body.appendChild(script);
        })
        .catch((error) => console.error("회원가입 폼 로드 실패:", error));
});

const accounts = [
    { id: "admin", pwd: "admin", name: "관리자" },
    { id: "worker", pwd: "worker", name: "작업자" },
];

document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("login-form");

    loginForm.addEventListener("submit", (event) => {
        event.preventDefault();

        const username = document.getElementById("id").value;
        const password = document.getElementById("password").value;

        // 사용자 인증 로직
        const account = accounts.find(acc => acc.id === username && acc.pwd === password);

        if (account) {
            const userInfo = {
                username: account.name, // 이름을 userInfo에 저장
                loginTime: new Date().toLocaleString()
            };
            alert("로그인 성공");
            sessionStorage.setItem("userInfo", JSON.stringify(userInfo));

            // 로그인 후 이동할 페이지로 이동
            if (account.id === "worker") {
                window.location.href = "indexEmp.html";
            } else {
                window.location.href = "index.html";
            }
        } else {
            alert("로그인 실패: 사용자 이름 또는 비밀번호가 잘못되었습니다.");
        }
    });
});
