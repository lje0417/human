document.addEventListener('DOMContentLoaded', function () {
    const addButton = document.getElementById('add-button');
    const editButton = document.getElementById('edit-button');
    const deleteButton = document.getElementById('delete-button');
    const searchButton = document.getElementById('search-button');
    const cancelButton = document.getElementById('cancel-button');
    const popup = document.getElementById('popup');
    const closePopup = document.getElementById('close-popup');
    const registrationForm = document.getElementById('registration-form');
    const selectAllCheckbox = document.getElementById('select-all');
    const itemCheckboxes = document.querySelectorAll('.item-checkbox');
    const dataContainer = document.getElementById('data-container');

    // 팝업창 열기
    addButton.addEventListener('click', function () {
        popup.style.display = 'flex';
    });

    // 팝업창 닫기
    closePopup.addEventListener('click', function () {
        popup.style.display = 'none';
    });

    // 팝업창 등록 버튼
    registrationForm.addEventListener('submit', function (event) {
        event.preventDefault();
        
        // 입력 값 가져오기
        const planNumber = document.getElementById('plan-number').value;
        const itemName = document.getElementById('item-name').value;
        const planDate = document.getElementById('plan-date').value;
        const productionQuantity = document.getElementById('production-quantity').value;
        const status = document.getElementById('status').value;

        // 새로운 데이터 항목 생성
        const newItem = document.createElement('div');
        newItem.className = 'flex round';
        newItem.innerHTML = `
            <div><input type="checkbox" class="item-checkbox"></div>
            <div><a class="mho" href="/html/생산계획상세.html">${planNumber}</a></div>
            <div>${itemName}</div>
            <div>${planDate}</div>
            <div>${productionQuantity}</div>
            <div>${status}</div>
        `;
        
        // 데이터 컨테이너에 추가
        dataContainer.appendChild(newItem);

        alert('생산계획이 등록되었습니다.');
        popup.style.display = 'none';

        // 폼 초기화
        registrationForm.reset();
    });

    // 전체 선택 체크박스
    selectAllCheckbox.addEventListener('change', function () {
        itemCheckboxes.forEach(checkbox => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    });

    // 수정 버튼
    editButton.addEventListener('click', function () {
        let selectedItems = Array.from(itemCheckboxes).filter(checkbox => checkbox.checked);
        if (selectedItems.length === 1) {
            alert('수정 되었습니다.');
        } else if (selectedItems.length === 0) {
            alert('수정할 항목을 선택하세요.');
        } else {
            alert('한 번에 하나의 항목만 수정할 수 있습니다.');
        }
    });

    // 삭제 버튼
    deleteButton.addEventListener('click', function () {
        let selectedItems = Array.from(itemCheckboxes).filter(checkbox => checkbox.checked);
        if (selectedItems.length > 0) {
            if (confirm('선택한 항목을 삭제하시겠습니까?')) {
                alert('삭제 되었습니다.');
                selectedItems.forEach(checkbox => {
                    checkbox.closest('.round').remove();
                });
            }
        } else {
            alert('삭제할 항목을 선택하세요.');
        }
    });

    // 검색 버튼
    searchButton.addEventListener('click', function () {
        const searchQuery = document.getElementById('search-input').value.toLowerCase();
        document.querySelectorAll('.flex.round').forEach(row => {
            const text = row.textContent.toLowerCase();
            row.style.display = text.includes(searchQuery) ? 'flex' : 'none';
        });
    });

    // 검색 취소 버튼
    cancelButton.addEventListener('click', function () {
        document.getElementById('search-input').value = '';
        document.querySelectorAll('.flex.round').forEach(row => {
            row.style.display = 'flex';
        });
    });
});