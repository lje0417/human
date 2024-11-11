function updateProgressBars() {
    const selectedValue = document.getElementById('progress-select').value;
    const progressBars = document.querySelectorAll('.probar');

    if (selectedValue === 'all') {
        progressBars.forEach(bar => bar.style.display = 'block');
    } else {
        progressBars.forEach(bar => {
            if (bar.id === selectedValue) {
                bar.style.display = 'block';
            } else {
                bar.style.display = 'none';
            }
        });
    }
    // 추가: 선택된 프로그레스 바가 보이도록 스크롤 위치 조정
    const visibleBar = document.querySelector('.probar[style*="block"]');
    if (visibleBar) {
        visibleBar.scrollIntoView({ behavior: 'smooth', block: 'center' });
    }
}

// 초기화 시 '전체' 상태로 설정
document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('progress-select').value = 'all';
    updateProgressBars();
});

// 옵션 변경 시 업데이트
document.getElementById('progress-select').addEventListener('change', updateProgressBars);
