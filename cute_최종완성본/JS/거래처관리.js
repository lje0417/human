//mbtn11이라는 클래스의 등록버튼을 누르면 작성한 거래처 정보가 추가되도록
document.querySelector(".mbtn11").addEventListener("click", function (event) {
  let minfo1 = document.querySelector("#minfo1").value;
  let minfo2 = document.querySelector("#minfo2").value;
  let minfo3 = document.querySelector("#minfo3").value;
  let minfo4 = document.querySelector("#minfo4").value;
  let minfo5 = document.querySelector("#minfo5").value;
  let minfo6 = document.querySelector("#minfo6").value;
  let minfo7 = document.querySelector("#minfo7").value;
  if (minfo1 == '' || minfo2 == '' || minfo3 == '' || minfo4 == '' || minfo5 == '' || minfo6 == '' || minfo7 == '') {
    alert("빈칸을 채워주세요")
} else {

  let mcontent = '';
  mcontent += '<div class="flex round">'
  mcontent += `<div><input type="checkbox" class="chk"></div>`
  mcontent += `<div class="srEl" title="${minfo1}">`
  mcontent += `    <blue>${minfo1}</blue>`
  mcontent += '</div>'
  mcontent += `<div class="srEl" title="${minfo2}">${minfo2}</div>`
  mcontent += `<div class="srEl" title="${minfo3}">${minfo3}</div>`
  mcontent += `<div class="srEl" title="${minfo4}">${minfo4}</div>`
  mcontent += `<div class="srEl" title="${minfo5}">${minfo5}</div>`
  mcontent += `<div class="srEl" title="${minfo6}">${minfo6}</div>`
  mcontent += `<div class="srEl" title="${minfo7}">${minfo7}</div>`
  mcontent += '</div>'
  document.querySelector("#msg").innerHTML += mcontent;
}

 

  // 빈내용 추가 안되도록
  // @ 이메일에
  //대표명은 5글자까지
  //사업자 등록증은 숫자랑 -만 입력가능 
});

//선택삭제
let approval = document.querySelector(".delete-btn");

approval.addEventListener('click', function() {
  let checkboxes = document.querySelectorAll('.chk:checked');
  checkboxes.forEach(function(checkbox) {
      let parentDiv = checkbox.closest('.round');
      let yes=confirm("삭제하시겠습니까?")
      if (yes==true) {
          parentDiv.remove();
      }
  });
});