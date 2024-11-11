// 실적마감.js

const ctxLine = document.getElementById('line-chart').getContext('2d');
const ctxDoughnut = document.getElementById('doughnut-chart').getContext('2d');

const lineChart = new Chart(ctxLine, {
    type: 'line',
    data: {
        labels: [1500, 1600, 1700, 1750, 1800, 1850, 1900, 1950, 1999, 2050],
        datasets: [{
            data: [86, 114, 106, 106, 107, 111, 133, 221, 783, 2478],
            label: "월요일",
            borderColor: "#3e95cd",
            fill: false
        }, {
            data: [282, 350, 411, 502, 635, 809, 947, 1402, 3700, 5267],
            label: "화요일",
            borderColor: "#8e5ea2",
            fill: false
        }, {
            data: [168, 170, 178, 190, 203, 276, 408, 547, 675, 734],
            label: "수요일",
            borderColor: "#3cba9f",
            fill: false
        }, {
            data: [40, 20, 10, 16, 24, 38, 74, 167, 508, 784],
            label: "목요일",
            borderColor: "#e8c3b9",
            fill: false
        }, {
            data: [6, 3, 2, 2, 7, 26, 82, 172, 312, 433],
            label: "금요일",
            borderColor: "#c45850",
            fill: false
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false, // 비율 유지 비활성화
        plugins: {
            legend: {
                position: 'top',
                labels: {
                    font: {
                        size: 12 // 범례 폰트 크기 조정
                    }
                }
            },
            title: {
                display: true,
                text: '주간 생산량'
            }
        }
    }
});

const doughnutChart = new Chart(ctxDoughnut, {
    type: 'doughnut',
    data: {
        labels: ["월요일", "화요일", "수요일", "목요일", "금요일"],
        datasets: [{
            label: "Population (millions)",
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
            data: [500, 600, 700, 600, 300]
        }]
    },
    options: {
        responsive: true,
        maintainAspectRatio: false, // 비율 유지 비활성화
        plugins: {
            legend: {
                position: 'top',
                labels: {
                    font: {
                        size: 12 // 범례 폰트 크기 조정
                    }
                }
            },
            title: {
                display: true,
                text: '주간 생산량'
            }
        }
    }
});

// 차트 데이터 업데이트 함수
function updateCharts(selectedValue) {
    // 주간 데이터
    const weeklyData = {
        line: {
            labels: [1500, 1600, 1700, 1750, 1800, 1850, 1900, 1950, 1999, 2050],
            datasets: [{
                data: [86, 114, 106, 106, 107, 111, 133, 221, 783, 2478],
                label: "월요일",
                borderColor: "#3e95cd",
                fill: false
            }, {
                data: [282, 350, 411, 502, 635, 809, 947, 1402, 3700, 5267],
                label: "화요일",
                borderColor: "#8e5ea2",
                fill: false
            }, {
                data: [168, 170, 178, 190, 203, 276, 408, 547, 675, 734],
                label: "수요일",
                borderColor: "#3cba9f",
                fill: false
            }, {
                data: [40, 20, 10, 16, 24, 38, 74, 167, 508, 784],
                label: "목요일",
                borderColor: "#e8c3b9",
                fill: false
            }, {
                data: [6, 3, 2, 2, 7, 26, 82, 172, 312, 433],
                label: "금요일",
                borderColor: "#c45850",
                fill: false
            }]
        },
        doughnut: {
            labels: ["월요일", "화요일", "수요일", "목요일", "금요일"],
            datasets: [{
                label: "Population (millions)",
                backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                data: [500, 600, 700, 600, 300]
            }]
        }
    };

    // 월간 데이터 (예시)
    const monthlyData = {
        line: {
            labels: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월"],
            datasets: [{
                data: [120, 150, 180, 160, 170, 190, 210, 220, 230, 240],
                label: "월별 생산량",
                borderColor: "#3e95cd",
                fill: false
            }]
        },
        doughnut: {
            labels: ["1월", "2월", "3월", "4월", "5월"],
            datasets: [{
                label: "Production (units)",
                backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9", "#c45850"],
                data: [120, 150, 180, 160, 170]
            }]
        }
    };

    // 분기별 데이터 (예시)
    const quarterlyData = {
        line: {
            labels: ["1분기", "2분기", "3분기", "4분기"],
            datasets: [{
                data: [500, 600, 700, 800],
                label: "분기별 생산량",
                borderColor: "#3e95cd",
                fill: false
            }]
        },
        doughnut: {
            labels: ["1분기", "2분기", "3분기", "4분기"],
            datasets: [{
                label: "Production (units)",
                backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f", "#e8c3b9"],
                data: [500, 600, 700, 800]
            }]
        }
    };

    // 선택된 값에 따라 데이터 업데이트
    if (selectedValue === 'monthly') {
        lineChart.data = monthlyData.line;
        doughnutChart.data = monthlyData.doughnut;
    } else if (selectedValue === 'quarterly') {
        lineChart.data = quarterlyData.line;
        doughnutChart.data = quarterlyData.doughnut;
    } else {
        lineChart.data = weeklyData.line;
        doughnutChart.data = weeklyData.doughnut;
    }

    lineChart.update();
    doughnutChart.update();
}

// 셀렉트 박스 변경 이벤트 리스너 추가
document.getElementById('chart-selector').addEventListener('change', function() {
    updateCharts(this.value);
});

// 초기 데이터 로드
updateCharts(document.getElementById('chart-selector').value);
