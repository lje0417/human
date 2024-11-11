document.addEventListener("DOMContentLoaded", function() {
    const itemsPerPage = 5;
    let allItems = Array.from(document.querySelectorAll('.page-item'));
    let items = [...allItems];
    const paginationContainer = document.querySelector('.mnum');
    
    function showPage(page, itemsToShow) {
        itemsToShow.forEach((item, index) => {
            item.style.display = 'none';
            if (index >= (page - 1) * itemsPerPage && index < page * itemsPerPage) {
                item.style.display = 'flex';
            }
        });
    }

    function updatePagination(totalItems) {
        const totalPages = Math.ceil(totalItems / itemsPerPage);
        paginationContainer.innerHTML = ''; // 이전 페이지네이션 버튼 제거

        for (let i = 1; i <= totalPages; i++) {
            const button = document.createElement('button');
            button.className = 'mbox';
            button.setAttribute('data-page', i);
            button.textContent = i;
            if (i === 1) button.classList.add('active');
            button.addEventListener('click', function() {
                const page = parseInt(this.getAttribute('data-page'));
                showPage(page, items);
            });
            paginationContainer.appendChild(button);
        }
    }

    function handlePaginationClick(e) {
        if (e.target.classList.contains('mbox')) {
            const page = parseInt(e.target.getAttribute('data-page'));
            showPage(page, items);
        }
    }

    paginationContainer.addEventListener('click', handlePaginationClick);

    // 초기 페이지 표시 및 페이지네이션 업데이트
    updatePagination(items.length);
    showPage(1, items);

    // 검색 기능
    const searchInput = document.getElementById('search-input');
    const searchButton = document.getElementById('search-button');
    const resetButton = document.getElementById('reset-button');

    searchButton.addEventListener('click', function() {
        const query = searchInput.value.toLowerCase();
        const filteredItems = allItems.filter(item => {
            const text = item.textContent.toLowerCase();
            return text.includes(query);
        });

        items.forEach(item => {
            item.style.display = 'none';
        });

        filteredItems.forEach(item => {
            item.style.display = 'flex';
        });

        items = filteredItems;
        updatePagination(items.length);
        showPage(1, items);
    });

    resetButton.addEventListener('click', function() {
        items.forEach(item => {
            item.style.display = 'flex';
        });

        items = [...allItems];
        updatePagination(items.length);
        showPage(1, items);
    });
});