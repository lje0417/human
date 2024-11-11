let mbtn11 = document.querySelector(".mbtn11");
mbtn11.addEventListener("click", function(event) {
    let minfo1 = document.querySelector("#minfo1").value;
    let minfo3 = document.querySelector("#minfo3").value;
    let minfo4 = document.querySelector("#minfo4").value;
    let minfo5 = document.querySelector("#minfo5").value;
    let minfo6 = document.querySelector("#minfo6").value;
    let minfo7 = document.querySelector("#minfo7").value;
    let mcontent = '';

    if (minfo1 == '' || minfo3 == '' || minfo4 == '' || minfo5 == '' || minfo6 == '' || minfo7 == '') {
        alert("빈칸을 채워주세요");
    } else if (isNaN(minfo6)) {
        alert("수량은 숫자만 가능합니다");
    } else if (minfo7.length >= 5) {
        alert("이름을 다시 한번 확인해주세요");
    } else {
        mcontent += '<div class="flex round" style="border: 0">';
        mcontent += '<div>';
        mcontent += `    <blu class="mho">${minfo1}</blu>`;
        mcontent += '</div>';
        mcontent += `<div>${minfo3}</div>`;
        mcontent += `<div>${minfo4}</div>`;
        mcontent += `<div>${minfo5}</div>`;
        mcontent += `<div>${minfo6}BOX</div>`;
        mcontent += `<div>${minfo7}</div>`;
        mcontent += `<div><a href="/html/작업지시서.html"><img class="add" src ="/image/첨부파일이모티콘.png"></a></div>`
        mcontent += '</div>';
        document.querySelector("#msg").innerHTML += mcontent;
    }
});