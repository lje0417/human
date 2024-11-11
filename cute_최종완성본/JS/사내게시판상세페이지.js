document.getElementById('back-button').addEventListener('click', function () {
    window.history.back();
});

document.addEventListener("DOMContentLoaded", () => {
    const params = new URLSearchParams(window.location.search);
    const postId = params.get('postId');

    const posts = JSON.parse(sessionStorage.getItem("posts")) || [];
    const post = posts.find(p => p.id == Number(postId));

    const userInfo = JSON.parse(sessionStorage.getItem("userInfo"));

    if (post) {
        document.getElementById('post-title').textContent = post.title;
        document.getElementById('post-category').textContent = post.category;
        document.getElementById('post-author').textContent = post.author;
        document.getElementById('post-date').textContent = post.date;
        document.getElementById('post-content').innerHTML = post.content; // 게시글 내용
    } else {
        document.getElementById('post-details').innerHTML = '<p>게시글을 찾을 수 없습니다.</p>';
    }

    // 댓글 배열을 sessionStorage에서 가져오기
    let comments = JSON.parse(sessionStorage.getItem('comments')) || [];

    // 댓글 추가
    const commentForm = document.getElementById('comment-form');
    const commentList = document.getElementById('comment-list');
    const commentId = document.getElementById('comment-id');

    commentId.innerHTML = `${userInfo.username}님`;

    // 댓글 목록 불러오기
    comments.forEach(comment => addCommentToList(comment));
    

    commentForm.addEventListener('submit', function (event) {
        event.preventDefault();
        const content = document.getElementById('comment-content').value;

        // 댓글 객체 생성
        const comment = {
            author: userInfo.username,
            content: content,
            replies: []
        };

        // 댓글 목록에 추가
        comments.push(comment); // 배열에 댓글 추가
        sessionStorage.setItem('comments', JSON.stringify(comments)); // sessionStorage에 저장
        addCommentToList(comment);
        commentForm.reset();
    });

    function addCommentToList(comment) {
        const commentItem = document.createElement('div');
        commentItem.classList.add('comment-item');

        commentItem.innerHTML = `
            <strong>${comment.author}</strong>
            <p>${comment.content}</p>
            <button class="reply-button">댓글</button>
            <div class="reply-form" style="display: none;">
                <p>${userInfo.username}님</p>
                <textarea class="reply-content" placeholder="댓글을 입력하세요." required></textarea>
                <button class="submit-reply">답글 달기</button>
            </div>
            <div class="reply-list"></div>
        `;

        // 대댓글 버튼 클릭 시 대댓글 폼 표시
        const replyButton = commentItem.querySelector('.reply-button');
        const replyForm = commentItem.querySelector('.reply-form');
        replyButton.addEventListener('click', () => {
            replyForm.style.display = replyForm.style.display === 'none' ? 'block' : 'none';
        });

        // 대댓글 추가
        const submitReplyButton = commentItem.querySelector('.submit-reply');
        submitReplyButton.addEventListener('click', function () {
            const replyContent = commentItem.querySelector('.reply-content').value;

            const reply = {
                author: userInfo.username,
                content: replyContent
            };

            comment.replies.push(reply); // 댓글 객체에 대댓글 추가
            sessionStorage.setItem('comments', JSON.stringify(comments)); // 업데이트된 댓글 저장
            addReplyToList(reply, commentItem.querySelector('.reply-list'));
            commentItem.querySelector('.reply-author').value = '';
            commentItem.querySelector('.reply-content').value = '';
            replyForm.style.display = 'none'; // 대댓글 폼 숨기기
        });

        commentList.appendChild(commentItem);
    }

    function addReplyToList(reply, replyList) {
        const replyItem = document.createElement('div');
        replyItem.classList.add('reply-item');
        replyItem.innerHTML = `<strong>${reply.author}</strong><p>${reply.content}</p>`;
        replyList.appendChild(replyItem);
    }
});