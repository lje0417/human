// 체크박스를 선택하고 승인버튼을 눌렀을 때,
// 선택하지 않았을 경우, 기본상태를 False로 두고
// 선택되어지면 True로 바꿔서
// False일 경우, "목록을 선택해주세요", True일 경우, "승인이 완료되었습니다"
let mchoice1 = document.querySelectorAll(".mchk");
let mchk = document.querySelectorAll(".mchk");
let mbtn1 = document.querySelector(".mbtn1");
mbtn1.addEventListener("click", function () {
    let isChecked = false;
    for(let i=0; i <mchk.length; i++){
        if(mchk[i].checked){
            isChecked = true;
        }
    }
    if(isChecked == true){
        alert("승인이 완료되었습니다");
    } else {
        alert("목록을 선택해주세요");
    }
})

// 승인이 완료될 경우, 즉 체크박스가 체크되었을 경우(== false),
// 체크박스의 부모를 지움 (한줄삭제)
mbtn1.addEventListener("click", function(event) {
    for(let i=0; i<mchk.length; i++){
    if(mchk[i].checked){
        mchk[i].parentNode.remove();
        mchk[i].checked = false;
    }}
});

// 취소버튼을 눌렀을때, 체크박스의 기본상태를 false로 두고
// 체크박스가 선택되지 않았을때, 즉 false일 경우에 취소버튼을 누르면
// "목록을 선택해주세요", 체크박스가 선택된 후, 취소버튼을 눌렀을때 즉 True일 경우,
// "정말 취소하시겠습니까?" 한번 더 확인 문구가 나온다음
// 선택된 체크박스의 부모요소를 지움(한줄삭제)
let mbtn2 = document.querySelector(".mbtn2");
mbtn2.addEventListener("click",function(){
let isOkay = false;
    for(let i=0; i<mchk.length; i++){
        if(mchk[i].checked){
            isOkay = true;
        }
    }
    if (isOkay == false){
        alert("목록을 선택해주세요");
    } else {
        let select=confirm("정말 취소하시겠습니까?");
            if(select){
                for(let i=0; i<mchk.length; i++){
                    if(mchk[i].checked){
                        mchk[i].parentNode.remove();
                        mchk[i].checked = false; // 초기화를 시킨다
                    }
                }
            } else{
                alert("목록을 확인해주세요");
            }
        }
})

// 승인, 취소 동일하게 계속 반복해서 승인/ 취소를 할 경우,
// 한번 반복하고(즉 승인 또는 취소를 한번 한 후) 초기화 -> 다시 반복하고 초기화 이런식으로
// 해서 alert창이 첫번째 실행할 때와 동일 할 수 있도록
// mchk[i].checked = false; -> 동일하게 승인, 취소에 초기화 진행



//mandoo-cate의 종류를 바꾸면 내용이 보이도록
// .value값을 다르게 줘서 display = none으로 가리고
// .value별로 block과 none을 줘서 바뀌도록 진행
document.querySelector('#mandoo-cate').addEventListener('change', function () {
    let m_all = document.querySelector('.m_all');
    let big = document.querySelector('.big');
    let sae = document.querySelector('.sae');
    let gun = document.querySelector('.gun');

    m_all.style.display = 'none';
    big.style.display = 'none';
    sae.style.display = 'none';
    sae.style.display = 'none';

    // 선택된 값에 따라 해당 div 보이기
    
    if (this.value === 'm_all') {
        m_all.style.display = 'block';
        big.style.display = 'none';
        sae.style.display = 'none';
        gun.style.display = 'none';
    }else if (this.value === 'big') {
        m_all.style.display = 'none';
        big.style.display = 'block';
        sae.style.display = 'none';
        gun.style.display = 'none';
    }else if (this.value === 'sae') {
        m_all.style.display = 'none';
        big.style.display = 'none';
        sae.style.display = 'block';
        gun.style.display = 'none';
    } else if (this.value === 'gun') {
        m_all.style.display = 'none';
        big.style.display = 'none';
        sae.style.display = 'none';
        gun.style.display = 'block';
    }
});

document.addEventListener("DOMContentLoaded", function() {
    const itemsPerPage = 2;
    const mandooCate = document.getElementById('mandoo-cate');
    const paginationDiv = document.querySelector('.m_pagination');
    
    // 카테고리에 따라 아이템 가져오기
    function getItems(category) {
        if (category === 'm_all') {
            return document.querySelectorAll('.m_all .flex.round');
        } else {
            return document.querySelectorAll(`.${category} .flex.round`);
        }
    }

    // 페이지 번호 버튼 생성
    function createPaginationButtons(items) {
        paginationDiv.innerHTML = '';
        const totalPages = Math.ceil(items.length / itemsPerPage);
        for (let i = 1; i <= totalPages; i++) {
            const pageButton = document.createElement('button');
            pageButton.textContent = i;
            pageButton.addEventListener('click', () => showPage(i, items));
            paginationDiv.appendChild(pageButton);
        }
    }

    // 특정 페이지의 항목만 표시하는 함수
    function showPage(page, items) {
        items.forEach((item, index) => {
            item.style.display = 'none';
            if (index >= (page - 1) * itemsPerPage && index < page * itemsPerPage) {
                item.style.display = 'flex';
            }
        });
    }

    // 초기 표시
    let currentCategory = mandooCate.value;
    let currentItems = getItems(currentCategory);
    createPaginationButtons(currentItems);
    showPage(1, currentItems);

    // 카테고리 변경 시 처리
    mandooCate.addEventListener('change', () => {
        currentCategory = mandooCate.value;
        currentItems = getItems(currentCategory);
        createPaginationButtons(currentItems);
        showPage(1, currentItems);
    });
});