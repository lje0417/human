

// 재료추가 버튼을 눌렀을때 onclick으로 동작하는 함수
function addIngredient() {
    const table = document.querySelector('.ingreInfo');
    const newRow = table.insertRow(-1); // 마지막에 새로운 행 추가
    const cell1 = newRow.insertCell(0);
    const cell2 = newRow.insertCell(1);
    const cell3 = newRow.insertCell(2);
    const cell4 = newRow.insertCell(3);
    const cell5 = newRow.insertCell(4);
    const cell6 = newRow.insertCell(5);

    cell1.innerHTML = '<input type="text">';
    cell2.innerHTML = '<input type="text">';
    cell3.innerHTML = '<input type="text">';
    cell4.innerHTML = '<input type="text">';
    cell5.innerHTML = '<input type="text">';
    cell6.innerHTML = '<img onclick="deleteRow(this)" src="/image/delete.png" class="imgstyle" title="삭제">';
}

// 삭제 버튼을 눌렀을때 onclick으로 동작하는 함수
function deleteRow(button) {
    const row = button.parentNode.parentNode; // 버튼의 부모의 부모 (행)을 찾음
    row.parentNode.removeChild(row); // 행 삭제
}

let save = document.querySelector(".save")
save.addEventListener("click", function () {
    let gogo = confirm("저장하시겠습니까?")
    if (gogo) {
        alert("저장되었습니다")
        window.location.href = "/HTML/BOM.html"
    } 
})
let back = document.querySelector(".back")
back.addEventListener("click", function () {
    let gogo = confirm("뒤로가시겠습니까?")
    if (gogo) {
        window.location.href = "/HTML/BOM.html"
    } 
})