const products = [
    {
        "품목코드": "M001",
        "품목명": "밀가루",
        "이미지코드": "/image/flour.jpg",
        "재고수량": 500,
        "가용수량": 450,
        "재고위치": "A1창고"
    },
    {
        "품목코드": "M002",
        "품목명": "물",
        "이미지코드": "/image/water.jpg",
        "재고수량": 1000,
        "가용수량": 980,
        "재고위치": "B1창고"
    },
    {
        "품목코드": "M003",
        "품목명": "소금",
        "이미지코드": "/image/salt.webp",
        "재고수량": 300,
        "가용수량": 280,
        "재고위치": "C1창고"
    },
    {
        "품목코드": "M004",
        "품목명": "다진 돼지고기",
        "이미지코드": "/image/mince.jfif",
        "재고수량": 700,
        "가용수량": 690,
        "재고위치": "D1창고"
    },
    {
        "품목코드": "M005",
        "품목명": "다진 양파",
        "이미지코드": "/image/onion.jpg",
        "재고수량": 600,
        "가용수량": 590,
        "재고위치": "L1창고"
    },
    {
        "품목코드": "M006",
        "품목명": "대파",
        "이미지코드": "/image/greenonion.jpg",
        "재고수량": 400,
        "가용수량": 390,
        "재고위치": "P1창고"
    },
    {
        "품목코드": "M007",
        "품목명": "간장",
        "이미지코드": "/image/soysauce.png",
        "재고수량": 800,
        "가용수량": 780,
        "재고위치": "G1창고"
    },
    {
        "품목코드": "M008",
        "품목명": "참기름",
        "이미지코드": "/image/sesameoil.jpg",
        "재고수량": 200,
        "가용수량": 190,
        "재고위치": "P1창고"
    },
    {
        "품목코드": "M009",
        "품목명": "후추",
        "이미지코드": "/image/pepper.jpg",
        "재고수량": 500,
        "가용수량": 490,
        "재고위치": "K1창고"
    },
    {
        "품목코드": "M010",
        "품목명": "마늘",
        "이미지코드": "/image/garlic.jpg",
        "재고수량": 300,
        "가용수량": 290,
        "재고위치": "E1창고"
    },
    {
        "품목코드": "M015",
        "품목명": "김치",
        "이미지코드": "/image/kimchi.webp",
        "재고수량": 100,
        "가용수량": 90,
        "재고위치": "Q1창고"
    }
];

const itemsPerPage = 4;
let currentPage = 1;

function displayTablePage(page) {
    const tableBody = document.getElementById("product-table-body");
    tableBody.innerHTML = "";

    const start = (page - 1) * itemsPerPage;
    const end = start + itemsPerPage;
    const paginatedItems = products.slice(start, end);

    // 자바스크립트로 품목별 내용 표로 가져오기
    paginatedItems.forEach(product => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td style="width:100px">${product.품목코드}</td>
            <td style="width:150px;">${product.품목명}</td>
            <td style="width:100px; height:80px">
                ${product.이미지코드 ? `<img class="imgg" src="${product.이미지코드}" alt="${product.품목명}" style="width: 90px; height: 80px;">` : '이미지가 없습니다'}
            </td>
            <td style="width:100px">${product.재고수량}</td>
            <td style="width:100px">${product.가용수량}</td>
            <td style="width:100px">${product.재고위치}</td>`;
        tableBody.appendChild(row);
    });
}

// 페이지 버튼을 눌렀을때 페이지가 넘어가고 내용별로(배열)로 끊어서
// 페이지에 들어갈 내용을 알아서 맞춰서 넘어가도록
// 자바스크립트 구성
function setupPagination() {
    const pagination = document.querySelector(".pagination");
    const pageCount = Math.ceil(products.length / itemsPerPage);

    pagination.innerHTML = ""; // 기존 페이지 번호 초기화

    for (let i = 1; i <= pageCount; i++) {
        const span = document.createElement("span");
        span.innerText = i;
        span.addEventListener("click", function () {
            currentPage = i;
            displayTablePage(currentPage);

            const allButtons = pagination.querySelectorAll("span");
            allButtons.forEach(button => {
                button.classList.remove("active");
            });

            span.classList.add("active");
        });
        pagination.appendChild(span);
    }
}

setupPagination();
displayTablePage(currentPage);
