document.addEventListener('DOMContentLoaded', function() {
    const data = [
        { method: '전수', item: '김치만두', sample: 5000, ok: 4900, nok: 100, result: '합격' },
        { method: '전수', item: '고기만두', sample: 5000, ok: 4950, nok: 50, result: '합격' },
        { method: '샘플링', item: '만두피', sample: 100, ok: 90, nok: 10, result: '합격' },
        { method: '샘플링', item: '만두소', sample: 100, ok: 95, nok: 5, result: '합격' },
        { method: '외관 검사', item: '김치만두', sample: 500, ok: 490, nok: 10, result: '합격' },
        { method: '중량 검사', item: '고기만두', sample: 500, ok: 500, nok: 0, result: '합격' },
        { method: '유통기한 검사', item: '김치만두', sample: 1000, ok: 990, nok: 10, result: '합격' }
    ];

    const tbody = document.querySelector('#qualityInspectionTable tbody');

    data.forEach(row => {
        const tr = document.createElement('tr');
        
        Object.values(row).forEach(text => {
            const td = document.createElement('td');
            td.textContent = text;
            tr.appendChild(td);
        });
        
        tbody.appendChild(tr);
    });
});