document.addEventListener('DOMContentLoaded', function () {
    // 선택된 값에 따라 해당 div 보이기
    document.getElementById('recipeSelect').addEventListener('change', function () {
        let kimchiDiv = document.querySelector('.kimchi');
        let meatDiv = document.querySelector('.meat');

        if (this.value === 'kimchi') {
            meatDiv.style.display = 'none';
            kimchiDiv.style.display = 'table';
        } else if (this.value === 'meat') {
            kimchiDiv.style.display = 'none';
            meatDiv.style.display = 'table';
        }
    });

    
    // (개별) 삭제 이벤트 설정
    function setupDeleteEvent(button) {
        button.addEventListener('click', function (event) {
            event.currentTarget.closest('tr').remove();
        });
    }

    // 수정 이벤트 설정
    function setupEditEvent(button) {
        button.addEventListener('click', function (event) {
            let tableRow = event.currentTarget.closest('tr');
            let cells = tableRow.querySelectorAll('td');
            let isEditing = button.classList.contains('editing');

            if (isEditing) {
                for (let i = 1; i < cells.length - 2; i++) {
                    let inputField = cells[i].querySelector('input');
                    if (inputField) {
                        cells[i].textContent = inputField.value;
                    }
                }
                button.src = '/image/edit.png';
                button.classList.remove('editing');
            } else {
                for (let i = 1; i < cells.length - 2; i++) {
                    let currentCell = cells[i];
                    let currentValue = currentCell.textContent;
                    let inputField = document.createElement('input');
                    inputField.type = 'text';
                    inputField.value = currentValue;
                    currentCell.textContent = '';
                    currentCell.appendChild(inputField);
                }
                button.src = '/image/save.webp';
                button.classList.add('editing');
            }
        });
    }

    // 초기 이벤트 설정 (기존 테이블에서 수정, 편집 기능)
    function setupInitialEvents() {
        document.querySelectorAll(".delButton").forEach(setupDeleteEvent);
        document.querySelectorAll(".editButton").forEach(setupEditEvent);
    }

    setupInitialEvents();

    // 추가 이미지 addBtn 버튼 누르면 한 줄씩 추가됨
    document.querySelector('.addBtn').addEventListener('click', function () {
        let code = document.querySelector('.code').value;
        let name = document.querySelector('.name').value;
        let amount = document.querySelector('.amount').value;
        let unit = document.querySelector('.unit').value;
        let etc = document.querySelector('.etc').value;

        let tables = document.querySelectorAll('#table');
        let newRowKimchi = tables[0].insertRow();
        let newRowMeat = tables[1].insertRow();

        // 플러스 이미지 버튼 눌렀을 때 김치만두 테이블 맨 아래쪽에 추가되는 한 줄
        newRowKimchi.insertCell(0).innerHTML = `<input type="checkbox" class="chk">`;
        newRowKimchi.insertCell(1).innerHTML = code;
        newRowKimchi.insertCell(2).innerHTML = name;
        newRowKimchi.insertCell(3).innerHTML = amount;
        newRowKimchi.insertCell(4).innerHTML = unit;
        newRowKimchi.insertCell(5).innerHTML = etc;
        newRowKimchi.insertCell(6).innerHTML = `<img class="pen editButton" src="/image/edit.png" title="수정">`;
        newRowKimchi.insertCell(7).innerHTML = `<img class="bin delButton" src="/image/delete.png" title="삭제">`;

        // 플러스 이미지 버튼 눌렀을 때 고기만두 테이블 맨 아래쪽에 추가되는 한 줄
        newRowMeat.insertCell(0).innerHTML = `<input type="checkbox" class="chk">`;
        newRowMeat.insertCell(1).innerHTML = code;
        newRowMeat.insertCell(2).innerHTML = name;
        newRowMeat.insertCell(3).innerHTML = amount;
        newRowMeat.insertCell(4).innerHTML = unit;
        newRowMeat.insertCell(5).innerHTML = etc;
        newRowMeat.insertCell(6).innerHTML = `<img class="pen editButton" src="/image/edit.png" title="수정">`;
        newRowMeat.insertCell(7).innerHTML = `<img class="bin delButton" src="/image/delete.png" title="삭제">`;

        document.getElementById('srForm').reset();

        // 추가된 라인 새로운 버튼에도 이벤트 리스너 추가
        setupDeleteEvent(newRowKimchi.querySelector('.delButton'));
        setupDeleteEvent(newRowMeat.querySelector('.delButton'));

        setupEditEvent(newRowKimchi.querySelector('.editButton'));
        setupEditEvent(newRowMeat.querySelector('.editButton'));
    });

    // 선택삭제 버튼 클릭 시 체크된 항목 삭제
    document.querySelector(".delete-btn").addEventListener('click', function (event) {
        event.preventDefault(); // 기본 동작 방지
        let checkboxes = document.querySelectorAll('.chk:checked');
        checkboxes.forEach(function (checkbox) {
            let parentRow = checkbox.closest('tr');
            let yes=confirm("삭제하시겠습니까?")
            if (yes==true) {
                parentRow.remove();
            }
        });
    });
});