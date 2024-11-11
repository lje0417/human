document.addEventListener('DOMContentLoaded', function() {
    const data = [
        { errordate: '2024.07.01', errorcode: '<spanme title="재료 부족">E001</spanme>', worknumber: '2024-051', production: 5000, defect: '<a href="품질검사현황.html">50</a>' },
        { errordate: '2024.07.02', errorcode: '<spanme title="재료 부족">E001</spanme>', worknumber: '2024-053', production: 4000, defect: '<a href="품질검사현황.html">40</a>' },
        { errordate: '2024.07.01', errorcode: '<spanme title="만두 포장 오류">E002</spanme>', worknumber: '2024-062', production: 3000, defect: '<a href="품질검사현황.html">30</a>' },
        { errordate: '2024.07.02', errorcode: '<spanme title="만두 포장 오류">E002</spanme>', worknumber: '2024-088', production: 2000, defect: '<a href="품질검사현황.html">20</a>' },
        { errordate: '2024.07.02', errorcode: '<spanme title="찜기 고장">E003</spanme>', worknumber: '2024-102', production: 1000, defect: '<a href="품질검사현황.html">10</a>' },
        { errordate: '2024.07.03', errorcode: '<spanme title="온도 설정 오류">E004</spanme>', worknumber: '2024-999', production: 1500, defect: '<a href="품질검사현황.html">15</a>' }
    ];

    const tbody = document.querySelector('#defectReportTable tbody');
    let totalDefect = 0;

    data.forEach(row => {
        const tr = document.createElement('tr');
        Object.values(row).forEach(text => {
            const td = document.createElement('td');
            td.innerHTML = text;
            tr.appendChild(td);
        });
        
        // 불량 수량에서 숫자만 추출하여 총계 계산
        const defectValue = parseInt(row.defect.match(/\d+/)[0]);
        totalDefect += defectValue;

        tbody.appendChild(tr);
    });

    // 총계 행 추가
    const totalProduction = data.reduce((sum, row) => sum + row.production, 0);
    const summaryRow = document.createElement('tr');
    summaryRow.classList.add('defect-summary-row');
    summaryRow.innerHTML = `
        <td>총계</td>
        <td></td>
        <td></td>
        <td><strong>${totalProduction}</strong></td>
        <td><strong>${totalDefect}</strong></td>
    `;
    tbody.appendChild(summaryRow);
});