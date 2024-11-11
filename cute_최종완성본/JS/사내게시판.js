document.getElementById('write-button').addEventListener('click', function() {
    window.location.href = '사내게시판등록.html';
});


// 게시판목록
document.addEventListener("DOMContentLoaded", () => {
    const postsTableBody = document.querySelector("#posts-table tbody");

    function loadPosts() {
        const posts = JSON.parse(sessionStorage.getItem("posts")) || [];
        posts.forEach(post => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${post.id}</td>
            <td>${post.category}</td>
            <td><a href="/HTML/사내게시판상세페이지.html?postId=${post.id}">${post.title}</a></td>
            <td>${post.date}</td>
            <td>${post.author}</td>
        `;
        postsTableBody.appendChild(row);
        });
    }

    loadPosts();
});


document.addEventListener("DOMContentLoaded", () => {
    const userInfo = JSON.parse(sessionStorage.getItem("userInfo"));
    const id = document.getElementById("id");

    if (userInfo) {
        console.log(`로그인 사용자: ${userInfo.username}`);
        // 사용자 이름을 페이지의 적절한 위치에 표시할 수 있습니다.
        id.innerText = `${userInfo.username}님`;
    } else {
        console.log("사용자가 로그인하지 않았습니다.");
    }

});
