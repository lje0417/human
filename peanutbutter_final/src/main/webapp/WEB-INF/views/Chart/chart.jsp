
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>종합 모니터링 대시보드</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels"></script>
    <!-- 도넛차트에서 그래프위에 숫자로 퍼센트를 표시하기위한 라이브러리 -->
    <style>
        * {
            box-sizing: border-box;

        }
    </style>
</head>
<body>
    <div style="width: 100%; margin-top: 50px;">
        <div style="width: 70%;display: inline-block;">
            <canvas id="combinedChart"></canvas>

        </div>
        <div style="width: 29%; display: inline-block; margin-bottom: 30px;">
            <canvas id="productSalesChart"></canvas>
        </div>
        <!-- <canvas id="inventoryChart"></canvas> -->
    </div>

    <script>
        const combinedCtx = document.getElementById('combinedChart').getContext('2d');
        const combinedChart = new Chart(combinedCtx, {
            type: 'bar', // 기본 차트의 타입을 'bar'로 설정
            data: {
                labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월'],
                datasets: [
                    {
                        type: 'bar', // 첫 번째 데이터셋의 타입은 'bar'
                        label: '목표 매출액',
                        data: [13000, 16000, 14000, 18000, 17000, 20000, 21000, 22000],
                        backgroundColor: 'rgba(153, 102, 255, 0.2)',
                        borderColor: 'rgba(153, 102, 255, 1)',
                        borderWidth: 1
                    },
                    {
                        type: 'bar', // 두 번째 데이터셋의 타입도 'bar'
                        label: '실제 매출액',
                        data: [12000, 15000, 13000, 17000, 16000, 18000, null, null],
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    },
                    {
                        type: 'line', // 세 번째 데이터셋의 타입은 'line'
                        label: '실적 매출액',
                        data: [12000, 15000, 13000, 17000, 16000, 18000, null, null],
                        borderColor: 'rgba(75, 192, 192, 1)',
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        fill: false
                    },
                    {
                        type: 'line', // 네 번째 데이터셋의 타입도 'line'
                        label: '예상 매출액',
                        data: [null, null, null, null, null, 18000, 20000, 21000],
                        borderColor: 'rgba(255, 99, 132, 1)',
                        backgroundColor: 'rgba(255, 99, 132, 0.2)',
                        fill: false,
                        borderDash: [5, 5]
                    }
                ]
            },
            options: {
                responsive: true,
                scales: {
                    x: {
                        display: true,
                        title: {
                            display: true,
                            text: '월'
                        }
                    },
                    y: {
                        display: true,
                        title: {
                            display: true,
                            text: '매출액 (단위: 만 원)'
                        }
                    }
                }
            }
        });


        //제품별/카테고리별 매출 분석
        const productSalesCtx = document.getElementById('productSalesChart').getContext('2d');
        const productSalesChart = new Chart(productSalesCtx, {
            type: 'doughnut',
            data: {
                labels: ['LG그램 14인치', 'LG그램 15인치', '삼성노트북'],
                datasets: [
                    {
                        label: '매출액',
                        data: [100, 0, 0],
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',

                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',

                        ],
                        borderWidth: 1
                    }
                ]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        display: true,
                        position: 'top',
                        labels: {
                            boxWidth: 10, // 범례의 막대 길이를 10px로 설정
                            font: {
                                size: 12 // 필요시 글꼴 크기 조정
                            }
                        }
                    },
                    datalabels: {
                        formatter: (value, context) => {
                            const total = context.chart.data.datasets[0].data.reduce((acc, val) => acc + val, 0);
                            const percentage = (value / total * 100).toFixed(2) + '%';
                            return percentage;
                        },
                        color: 'gray',
                        font: {
                            weight: 'bold',
                            size: '20px',
                        }
                    }
                }
            },
            plugins: [ChartDataLabels]
        });




        // const inventoryCtx = document.getElementById('inventoryChart').getContext('2d');
        // const inventoryChart = new Chart(inventoryCtx, {
        //     type: 'bar', // 기본 차트의 타입을 'bar'로 설정
        //     data: {
        //         labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월'],
        //         datasets: [
        //             {
        //                 type: 'bar', // 첫 번째 데이터셋의 타입은 'bar'
        //                 label: '사용된 재고',
        //                 data: [500, 600, 550, 700, 650, 720, 780, 800],
        //                 backgroundColor: 'rgba(255, 159, 64, 0.2)',
        //                 borderColor: 'rgba(255, 159, 64, 1)',
        //                 borderWidth: 1
        //             },
        //             {
        //                 type: 'bar', // 두 번째 데이터셋의 타입도 'bar'
        //                 label: '현재 남은 재고',
        //                 data: [1500, 1400, 1350, 1300, 1250, 1200, 1150, 1100],
        //                 backgroundColor: 'rgba(75, 192, 192, 0.2)',
        //                 borderColor: 'rgba(75, 192, 192, 1)',
        //                 borderWidth: 1
        //             },
        //             {
        //                 type: 'line', // 세 번째 데이터셋의 타입은 'line'
        //                 label: '예상 주문량',
        //                 data: [null, null, null, null, null, null, 800, 850],
        //                 borderColor: 'rgba(153, 102, 255, 1)',
        //                 backgroundColor: 'rgba(153, 102, 255, 0.2)',
        //                 fill: false,
        //                 borderDash: [5, 5]
        //             }
        //         ]
        //     },
        //     options: {
        //         responsive: true,
        //         scales: {
        //             x: {
        //                 display: true,
        //                 title: {
        //                     display: true,
        //                     text: '월'
        //                 }
        //             },
        //             y: {
        //                 display: true,
        //                 title: {
        //                     display: true,
        //                     text: '재고 수량'
        //                 }
        //             }
        //         }
        //     }
        // });

    </script>
</body>
</html>