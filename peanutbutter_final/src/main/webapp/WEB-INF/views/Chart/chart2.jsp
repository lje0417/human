
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            text-align: center;
        }
        .chart-container {
            position: relative;
            margin: auto;
            height: 40vh;
            width: 80vw;
        }
    </style>
</head>
<body>
    <div class="chart-container">
        <canvas id="myChart1"></canvas>
    </div>
    <div class="chart-container">
        <canvas id="myChart2"></canvas>
    </div>
    <div class="chart-container">
        <canvas id="myChart3"></canvas>
    </div>
    <script src="js/graph.js"></script>
</body>
</html>

<script>
const ctx1 = document.getElementById('myChart1').getContext('2d');
const ctx2 = document.getElementById('myChart2').getContext('2d');
const ctx3 = document.getElementById('myChart3').getContext('2d');

const data1 = {
    labels: ['Monday', 'Tuesday', 'Wendnesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
    datasets: [
        {   
            type: 'line',
            label: '생산량',
            data: [0, 0, 0, 0, 0, 0, 0],//hardcoding data 이므로 실제 data 사용시 api나 parsing 해서 써야함
            borderColor: 'rgba(75, 192, 192, 1)',
            borderWidth: 2,
            fill: false
        },
        {
            type: 'bar',
            label: '생산 목표량',
            data: [0, 0, 0, 0, 0, 0, 0],
            backgroundColor: 'rgba(153, 102, 255, 0.2)',
            borderColor: 'rgba(153, 102, 255, 1)',
            borderWidth: 1,
            barPercentage: 0.5,
            categoryPercentage: 0.5
        },
        {
            type: 'bar',
            label: '불량률',
            data: [0, 0, 0, 0, 0, 0, 0],
            backgroundColor: 'rgba(133, 122, 15, 0.2)',
            borderColor: 'rgba(153, 102, 255, 1)',
            borderWidth: 1,
            barPercentage: 0.5,
            categoryPercentage: 0.5
        }
    ]
};

const data2 = {
    labels: ['Monday', 'Tuesday', 'Wendnesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'],
    datasets: [
        {
            type: 'line',
            label: '생산량',
            data: [16, 0, 0, 0, 0, 0, 0],
            borderColor: 'rgba(255, 99, 132, 1)',
            borderWidth: 2,
            fill: false
        },
        {
            type: 'bar',
            label: '생산 목표량',
            data: [16, 16, 16, 16, 16, 16, 16],
            backgroundColor: 'rgba(54, 162, 235, 0.2)',
            borderColor: 'rgba(54, 162, 235, 1)',
            borderWidth: 1,
            barPercentage: 0.5,
            categoryPercentage: 0.5
        },
        {
            type: 'bar',
            label: '불량률',
            data: [0, 0, 0, 0, 0, 0, 0],
            backgroundColor: 'rgba(133, 122, 15, 0.2)',
            borderColor: 'rgba(153, 102, 255, 1)',
            borderWidth: 1,
            barPercentage: 0.5,
            categoryPercentage: 0.5
        }
    ]
};


const options1 = {
    responsive: true,
    maintainAspectRatio: false,
    plugins: {
        title: {
            display: true,
            text: 'SAMSUNG',//기업 데이터를 갖고와서 text input 해야한다
            font: {
                size: 18
            },
            padding: {
                top: 10,
                bottom: 30
            }
        },
        legend: {
            position: 'top'
        }
    },
    scales: {
        y: {
            beginAtZero: true
        }
    }
};
const options2 = {
    responsive: true,
    maintainAspectRatio: false,
    plugins: {
        title: {
            display: true,
            text: 'LG',//기업 데이터를 갖고와서 text input 해야한다
            font: {
                size: 18
            },
            padding: {
                top: 10,
                bottom: 30
            }
        },
        legend: {
            position: 'top'
        }
    },
    scales: {
        y: {
            beginAtZero: true
        }
    }
};

const myChart1 = new Chart(ctx1, {
    type: 'bar',
    data: data1,
    options: options1
});

const myChart2 = new Chart(ctx2, {
    type: 'bar',
    data: data2,
    options: options2
});

</script>