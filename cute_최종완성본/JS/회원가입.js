document.addEventListener("DOMContentLoaded", () => {
    const name = document.querySelector(".name");
    const id = document.querySelector(".id");
    const pwd = document.querySelector(".password");
    const pwdchk = document.querySelector(".password-check");
    const email = document.querySelector(".email");
    const join = document.querySelector(".join");

    join.addEventListener("click", () => {
        if (name.value === "") {
            alert("이름을 입력하세요.");
            name.focus();
            return;
        } else if (name.value.length > 5) {
            alert("이름은 5자리 이하로 입력하세요.");
            name.focus();
            return;
        }

        if (id.value === "") {
            alert("사원번호를 입력하세요.");
            id.focus();
            return;
        } else if (!/^\d+$/.test(id.value)) {
            alert("사원번호는 숫자만 입력 가능합니다.");
            id.focus();
            return;
        }

        if (pwd.value === "") {
            alert("비밀번호를 입력하세요.");
            pwd.focus();
            return;
        } else if (!/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{1,}$/.test(pwd.value)) {
            alert("비밀번호는 영어와 숫자를 포함해야 합니다.");
            pwd.focus();
            return;
        }

        if (pwdchk.value === "") {
            alert("비밀번호 확인을 입력하세요.");
            pwdchk.focus();
            return;
        } else if (pwd.value !== pwdchk.value) {
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            pwdchk.focus();
            return;
        }

        if (email.value === "") {
            alert("이메일을 입력하세요.");
            email.focus();
            return;
        } else if (!/@/.test(email.value)) {
            alert("유효한 이메일 주소를 입력하세요.");
            email.focus();
            return;
        }

        alert("회원가입이 완료되었습니다.");
        document.getElementById("joinModal").style.display = "none";
    });
});
