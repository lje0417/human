let products = [
    {
        "품목코드": "000001", 
        "품목명": "비비고 왕교자", 
        "이미지코드": "/image/비비고왕교자.jpg", 
        "재고수량": 150, 
        "가용수량": 120,
        "재고위치":"A1창고"
    },
    {
        "품목코드": "000002", 
        "품목명": "비비고 새우만두", 
        "이미지코드": "/image/비비고새우만두.jpg", 
        "재고수량": 200, 
        "가용수량": 180,
        "재고위치":"B1창고"
    },
    {
        "품목코드": "000003", 
        "품목명": "비비고 군만두", 
        "이미지코드": "/image/비비고군만두.webp", 
        "재고수량": 100, 
        "가용수량": 75,
        "재고위치":"C1창고"
    },
    {
        "품목코드": "000004", 
        "품목명": "비비고 김치만두", 
        "이미지코드": "/image/비비고김치만두.webp", 
        "재고수량": 120, 
        "가용수량": 100,
        "재고위치":"L1창고"
    },
    {
        "품목코드": "000005", 
        "품목명": "비비고 고기만두", 
        "이미지코드": "/image/비비고고기만두.jpg", 
        "재고수량": 130, 
        "가용수량": 110,
        "재고위치":"Y1창고"
    },
    {
        "품목코드": "000006", 
        "품목명": "비비고 찐만두", 
        "이미지코드": "/image/비비고찐만두.jpg", 
        "재고수량": 90, 
        "가용수량": 70,
        "재고위치":"U1창고"
    },
    {
        "품목코드": "000007", 
        "품목명": "비비고 야채만두", 
        "이미지코드": "/image/비비고야채만두.webp", 
        "재고수량": 160, 
        "가용수량": 140,
        "재고위치":"Q1창고"
    },
    {
        "품목코드": "000008", 
        "품목명": "비비고 매운만두", 
        "이미지코드": "/image/비비고매운만두.webp", 
        "재고수량": 80, 
        "가용수량": 60,
        "재고위치":"R1창고"
    },
    {
        "품목코드": "000009", 
        "품목명": "비비고 해물만두", 
        "이미지코드": "/image/비비고해물만두.png", 
        "재고수량": 110, 
        "가용수량": 90,
        "재고위치":"I1창고"
    },
    {
        "품목코드": "000010", 
        "품목명": "비비고 고추만두", 
        "이미지코드": "/image/비비고고추만두.webp", 
        "재고수량": 70, 
        "가용수량": 50,
        "재고위치":"I1창고"
    },
    {
        "품목코드": "000011", 
        "품목명": "비비고 스프링롤", 
        "이미지코드": "/image/비비고스프링롤.png", 
        "재고수량": 140, 
        "가용수량": 120,
        "재고위치":"A1창고"
    },
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
    },
    {
        "품목코드": "000012", 
        "품목명": "비비고 두부만두", 
        "이미지코드": "/image/비비고두부만두.webp", 
        "재고수량": 75, 
        "가용수량": 50,
        "재고위치":"E1창고"
    },
    {
        "품목코드": "000014", 
        "품목명": "비비고 불고기만두", 
        "이미지코드": "/image/비비고불고기만두.webp", 
        "재고수량": 85, 
        "가용수량": 70,
        "재고위치":"K1창고"
    }
];

const itemsPerPage = 4;
let currentPage = 1;
const originalProducts = [...products]; // 원본 제품 목록 복사
let filteredProducts = [...originalProducts]; // 초기 필터링된 제품 배열

function displayTablePage(page) {
    const tableBody = document.getElementById("product-table-body");
    tableBody.innerHTML = "";

    const start = (page - 1) * itemsPerPage;
    const end = start + itemsPerPage;
    const paginatedItems = filteredProducts.slice(start, end); // 필터링된 제품 배열 사용

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
            <td style="width:100px">${product.재고위치}</td>
            <td style="width:100px"><img class="ad1 edit" src="/image/수정.png"></td>
            <td style="width:100px"><img class="ad2 del" src="/image/삭제.png"></td>`;
        tableBody.appendChild(row);
    });
}

function setupPagination() {
    const pagination = document.querySelector(".pagination");
    const pageCount = Math.ceil(filteredProducts.length / itemsPerPage); // 필터링된 제품 수 기준으로 페이지 수 계산

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

// 검색 기능 추가
document.getElementById("search-button").addEventListener("click", function () {
    const searchInput = document.getElementById("search-input").value.toLowerCase();
    
    if (searchInput.value === "") {
        // 검색 입력이 비어있으면 원래 목록으로 복원
        filteredProducts = [...originalProducts]; // 원본 목록으로 복원
        currentPage = 1; // 첫 페이지로 이동
    } else {
        // 검색어가 입력되었을 때
        filteredProducts = originalProducts.filter(product => 
            product.품목명.toLowerCase().includes(searchInput) || 
            product.품목코드.toLowerCase().includes(searchInput)
        );

        if (filteredProducts.length === 0) {
            alert("결과가 없습니다."); // 결과가 없을 때 경고 메시지
        }
    }

    displayTablePage(currentPage);
    setupPagination(); // 페이지 설정
});

// 상품 추가 함수
document.getElementById("add-item").addEventListener("click", function () {
    const code = document.getElementById("item-code").value;
    const name = document.getElementById("item-name").value;
    const image = document.getElementById("item-image").value;
    const stock = parseInt(document.getElementById("item-stock").value);
    const available = parseInt(document.getElementById("item-available").value);

    // 입력값 검증
    if (!code || !name || !image || isNaN(stock) || isNaN(available)) {
        alert("모든 필드를 올바르게 입력해주세요.");
        return;
    }

    // 새로운 품목 객체 생성
    const newProduct = {
        "품목코드": code,
        "품목명": name,
        "이미지코드": image,
        "재고수량": stock,
        "가용수량": available
    };

    // 제품 배열에 추가
    products.push(newProduct);
    filteredProducts.push(newProduct); // 필터링된 배열에도 추가

    // 테이블과 페이지네이션 업데이트
    setupPagination();
    displayTablePage(currentPage);

    // 입력 필드 초기화
    document.getElementById("item-code").value = "";
    document.getElementById("item-name").value = "";
    document.getElementById("item-image").value = "";
    document.getElementById("item-stock").value = "";
    document.getElementById("item-available").value = "";
});

// 삭제 버튼 클릭 이벤트 처리
document.body.addEventListener("click", function (event) {
    if (event.target.classList.contains("del")) {
        const row = event.target.closest("tr");
        if (row) {
            // 사용자에게 삭제 확인 메시지 표시
            const confirmDelete = confirm("정말 삭제하시겠습니까?");
            if (confirmDelete) {
                // 삭제할 제품을 products 배열에서 제거
                const productCode = row.cells[0].innerText; // 품목코드를 가져옴
                products = products.filter(product => product.품목코드 !== productCode);
                filteredProducts = filteredProducts.filter(product => product.품목코드 !== productCode); // 필터링된 배열에서도 제거
                
                row.remove(); // 확인 시 행 삭제
                setupPagination(); // 페이지네이션 업데이트
                displayTablePage(currentPage); // 현재 페이지 다시 표시
            }
        }
    }
});

// 수정 버튼 클릭 이벤트 처리
document.body.addEventListener("click", function (event) {
    if (event.target.classList.contains("edit")) {
        const row = event.target.closest("tr");
        if (row) {
            const cells = row.querySelectorAll("td");
            cells.forEach((cell, index) => {
                // 이미지 셀(세 번째 셀)과 버튼 셀들은 수정 대상에서 제외
                if (index !== 2 && index < 6) {
                    const currentValue = cell.innerText;
                    const input = document.createElement("input");
                    input.type = "text";
                    input.value = currentValue;
                    input.style.width = "90%"; // 입력 필드의 폭을 셀 폭의 90%로 설정
                    cell.innerHTML = "";
                    cell.appendChild(input);
                } else if (index === 2) { // 이미지 셀을 수정할 경우
                    cell.innerHTML = ""; // 기존 내용 삭제
                    const inputFile = document.createElement("input");
                    inputFile.type = "file";
                    inputFile.accept = "image/*"; // 이미지 파일만 선택 가능
                    cell.appendChild(inputFile); // 파일 입력 추가
                }
            });
            event.target.innerHTML = `<img class="ad1 save" src="/image/저장.png">`;
            event.target.classList.remove("edit");
            event.target.classList.add("save");
        }
    } else if (event.target.classList.contains("save")) {
        const row = event.target.closest("tr");
        if (row) {
            const inputs = row.querySelectorAll("td input");
            inputs.forEach((input, index) => {
                const cell = input.parentElement;
                if (input.type === "file") {
                    const file = input.files[0];
                    if (file) {
                        const reader = new FileReader();
                        reader.onload = function (e) {
                            const img = document.createElement("img");
                            img.src = e.target.result;
                            img.style.width = "50px"; // 새로운 이미지 크기 설정
                            img.style.height = "50px";
                            cell.innerHTML = ""; // 기존 내용을 지우고
                            cell.appendChild(img); // 새로운 이미지를 추가
                        };
                        reader.readAsDataURL(file); // 파일을 읽어 Data URL로 변환
                    } else {
                        // 파일이 선택되지 않은 경우 기존 내용을 유지
                        const existingImg = cell.querySelector("img");
                        if (existingImg) {
                            cell.innerHTML = ""; // 기존 내용을 지우고
                            cell.appendChild(existingImg); // 기존 이미지를 다시 추가
                        }
                    }
                } else {
                    cell.innerText = input.value; // 텍스트 입력 처리
                }
            });
            event.target.innerHTML = `<img class="ad1 edit" src="/image/수정.png">`;
            event.target.classList.remove("save");
            event.target.classList.add("edit");
        }
    }
});



setupPagination();
displayTablePage(currentPage);

// 검색 초기화 버튼 클릭 이벤트 처리
document.getElementById("reset-button").addEventListener("click", function () {
    // 검색 입력 필드 초기화
    document.getElementById("search-input").value = "";
    
    // 필터링된 제품 목록을 원본 목록으로 복원
    filteredProducts = [...originalProducts];
    currentPage = 1; // 첫 페이지로 이동

    // 테이블과 페이지네이션 업데이트
    displayTablePage(currentPage);
    setupPagination();
});

document.getElementById("open-popup").addEventListener("click", function () {
    document.getElementById("popup-overlay").style.display = "flex";
});

document.getElementById("close-popup").addEventListener("click", function () {
    document.getElementById("popup-overlay").style.display = "none";
});

document.getElementById("add-item").addEventListener("click", function () {
    const code = document.getElementById("item-code").value;
    const name = document.getElementById("item-name").value;
    const image = document.getElementById("item-image").value;
    const stock = parseInt(document.getElementById("item-stock").value);
    const available = parseInt(document.getElementById("item-available").value);

    // 입력값 검증
    if (!code || !name || !image || isNaN(stock) || isNaN(available)) {
        alert("모든 필드를 올바르게 입력해주세요.");
        return;
    }

    // 새로운 품목 객체 생성
    const newProduct = {
        "품목코드": code,
        "품목명": name,
        "이미지코드": image,
        "재고수량": stock,
        "가용수량": available
    };

    // 제품 배열에 추가
    products.push(newProduct);
    filteredProducts.push(newProduct); // 필터링된 배열에도 추가

    // 테이블과 페이지네이션 업데이트
    setupPagination();
    displayTablePage(currentPage);

    // 팝업창 닫기
    document.getElementById("popup-overlay").style.display = "none";

    // 입력 필드 초기화
    document.getElementById("item-code").value = "";
    document.getElementById("item-name").value = "";
    document.getElementById("item-image").value = "";
    document.getElementById("item-stock").value = "";
    document.getElementById("item-available").value = "";
});
