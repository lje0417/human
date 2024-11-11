document.addEventListener("DOMContentLoaded", () => {
    const posts = JSON.parse(sessionStorage.getItem("posts")) || [];
    const postsTableBody = document.querySelector("#posts-table tbody");

    // 최대 3개의 게시글만 표시
    const limitedPosts = posts.slice(-3);

    limitedPosts.forEach(post => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${post.id}</td>
            <td>${post.category}</td>
            <td class="board-title"><a href="/HTML/사내게시판상세페이지.html?postId=${post.id}">${post.title}</a></td>
            <td>${post.date}</td>
            <td>${post.author}</td>
        `;
        postsTableBody.appendChild(row);
    });
});

const monthYearElement = document.getElementById("month-year");
const daysElement = document.getElementById("days");
const prevButton = document.getElementById("prev");
const nextButton = document.getElementById("next");

let currentDate = new Date();

function renderCalendar() {
    const year = currentDate.getFullYear();
    const month = currentDate.getMonth();
    monthYearElement.textContent = `${year}년 ${month + 1}월`;

    // 첫번째 날의 요일
    const firstDayOfMonth = new Date(year, month, 1).getDay();
    // 마지막 날
    const lastDateOfMonth = new Date(year, month + 1, 0).getDate();

    // 날짜 셀 초기화
    daysElement.innerHTML = "";

    // 빈 칸 추가
    for (let i = 0; i < firstDayOfMonth; i++) {
        const emptyCell = document.createElement("div");
        daysElement.appendChild(emptyCell);
    }

    // 날짜 추가
    for (let date = 1; date <= lastDateOfMonth; date++) {
        const dateCell = document.createElement("div");
        dateCell.textContent = date;
        daysElement.appendChild(dateCell);
    }
}

// 이전 달로 이동
prevButton.addEventListener("click", () => {
    currentDate.setMonth(currentDate.getMonth() - 1);
    renderCalendar();
});

// 다음 달로 이동
nextButton.addEventListener("click", () => {
    currentDate.setMonth(currentDate.getMonth() + 1);
    renderCalendar();
});

// 초기 캘린더 렌더링
renderCalendar();

const memoInput = document.getElementById("memo-input");
const addMemoButton = document.getElementById("add-memo");
const memoOutput = document.getElementById("memo-output");

// 세션 스토리지에서 메모 불러오기
const loadMemos = () => {
    const memos = JSON.parse(sessionStorage.getItem("memos")) || [];
    memos.forEach(memo => addMemoToList(memo));
};

// 메모 추가 기능
addMemoButton.addEventListener("click", () => {
    const memoText = memoInput.value.trim();
    
    // 메모 글자 수 제한
    if (memoText.length > 20) {
        alert("메모는 최대 20글자까지 작성할 수 있습니다.");
        return;
    }

    // 메모 입력이 비어있는지 확인
    if (memoText === "") {
        alert("메모를 입력하세요.");
        return;
    }

    // 세션 스토리지에서 현재 메모 가져오기
    const memos = JSON.parse(sessionStorage.getItem("memos")) || [];

    // 메모 개수 제한
    if (memos.length >= 3) {
        alert("메모는 최대 3개까지 작성할 수 있습니다.");
        return;
    }

    // 메모 아이템 추가
    memos.push(memoText);
    sessionStorage.setItem("memos", JSON.stringify(memos));

    addMemoToList(memoText);
    memoInput.value = ""; // 입력 필드 초기화
});

// 메모 리스트에 추가하는 함수
const addMemoToList = (memoText) => {
    const memoItem = document.createElement("li");
    memoItem.textContent = memoText;

    // 삭제 버튼 추가
    const deleteButton = document.createElement("button");
    deleteButton.textContent = "X";
    deleteButton.style.marginLeft = "10px";
    
    // 삭제 기능
    deleteButton.addEventListener("click", () => {
        const memos = JSON.parse(sessionStorage.getItem("memos")) || [];
        const updatedMemos = memos.filter(memo => memo !== memoText);
        sessionStorage.setItem("memos", JSON.stringify(updatedMemos));
        memoOutput.removeChild(memoItem); // 리스트에서 메모 제거
    });

    memoItem.appendChild(deleteButton);
    memoOutput.appendChild(memoItem);
};

// 페이지 로드 시 메모 불러오기
loadMemos();
