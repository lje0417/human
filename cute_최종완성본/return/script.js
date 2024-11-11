// 메인 카테고리
document.querySelectorAll(".category-link").forEach(function (link) {
  link.addEventListener("click", function (e) {
    e.preventDefault(); // 링크의 기본 동작 방지

    // URL에 따른 내용 출력
    const url = this.getAttribute("data-url");

    fetch(url)
      .then((response) => response.text())
      .then((data) => {
        document.getElementById("content-display").innerHTML = data;
      })
      .catch((error) => console.error("Error:", error));
  });
});

// 메인 카테고리 색 사이드바 open
document.querySelectorAll(".category-link").forEach(function (item) {
  item.addEventListener("click", function () {
    // 전에 클릭한 카테고리가 있을 수 있기 때문에 active 클래스를 모두 삭제 후
    document.querySelectorAll(".category-link").forEach(function (e) {
      e.classList.remove("active");
    });

    // 클릭한 카테고리에 active 클래스를 추가해서 구분을 해준다.
    this.classList.add("active");

    // 사이드바를 표시
    const sidebar = document.querySelector(".sidebar");
    sidebar.style.display = "block"; // 항상 사이드바 표시
  });
});

// 사이드바 내용 초기화 및 하위 항목 추가 함수
function updateSidebar(subCategoryLinks) {
  const sidebarContent = document.getElementById("sidebar-content");
  sidebarContent.innerHTML = ""; // 사이드바 내용 초기화

  subCategoryLinks.forEach(function (subItem) {
    // 각 하위 항목을 사이드바에 추가
    const listItem = document.createElement("li");
    listItem.textContent = subItem.textContent; // 항목의 텍스트를 가져와 리스트 아이템으로 추가
    listItem.setAttribute("data-url", subItem.getAttribute("data-url")); // data-url 속성 추가

    // 클릭 이벤트 추가
    listItem.addEventListener("click", function (e) {
      e.preventDefault();
      activateSidebarLink(this); // 클릭된 항목 활성화

      // 클릭된 사이드바 항목의 data-url에 따라 내용 출력
      const url = this.getAttribute("data-url");
      fetch(url)
        .then((response) => response.text())
        .then((data) => {
          document.getElementById("content-display").innerHTML = data; // 내용 표시
        })
        .catch((error) => console.error("Error:", error));
    });

    sidebarContent.appendChild(listItem);
  });
}

// 사이드바 항목 클릭 시 활성화 함수
function activateSidebarLink(link) {
  // 기존 활성화된 사이드바 링크의 스타일을 초기화하고 클릭된 링크에 스타일 추가
  const sidebarLinks = document.querySelectorAll("#sidebar-content li");
  sidebarLinks.forEach(function (item) {
    item.classList.remove("active"); // 기존 active 클래스 제거
  });
  link.classList.add("active"); // 클릭된 링크에 active 클래스 추가

  // 카테고리 링크에서도 활성화
  const categoryLinks = document.querySelectorAll(".category-link");
  categoryLinks.forEach(function (categoryLink) {
    if (categoryLink.textContent === link.textContent) {
      activateLink(categoryLink); // 카테고리 링크도 활성화
    }
  });
}

// 카테고리 링크 클릭 이벤트
document.querySelectorAll(".category-link").forEach(function (item) {
  item.addEventListener("click", function (event) {
    event.preventDefault(); // 링크 클릭 시 페이지 이동 방지

    // 클릭된 항목 활성화
    activateLink(this); // 클릭된 카테고리 항목 활성화

    // 클릭한 항목이 제목인지 확인
    if (this.classList.contains("title")) {
      // 제목이면 하위 항목 가져오기
      const subCategoryLinks = this.nextElementSibling.querySelectorAll(".category-link");
      updateSidebar(subCategoryLinks); // 사이드바 업데이트

      // 사이드바의 첫 번째 항목 활성화
      const firstSidebarLink = document.querySelector("#sidebar-content li");
      if (firstSidebarLink) {
        activateSidebarLink(firstSidebarLink); // 첫 번째 항목 활성화
      }
    } else {
      // 제목이 아니면 부모 카테고리에서 하위 항목 가져오기
      const parentCategory = this.closest(".category-item");
      if (parentCategory) {
        const allSubCategoryLinks = parentCategory.querySelectorAll("._category .category-link");
        updateSidebar(allSubCategoryLinks); // 사이드바 업데이트
      }
    }

    // 클릭된 카테고리와 같은 카테고리 이름을 가진 사이드바 항목 활성화
    const categoryName = this.textContent;
    const sidebarLinks = document.querySelectorAll("#sidebar-content li");
    sidebarLinks.forEach(function (sidebarLink) {
      if (sidebarLink.textContent === categoryName) {
        sidebarLink.classList.add("active"); // 사이드바 링크도 활성화
      }
    });
  });
});

// activateLink 함수 정의
function activateLink(link) {
  // 기존 활성화된 링크의 스타일을 초기화하고 클릭된 링크에 스타일 추가
  document.querySelectorAll(".category-link").forEach(function (item) {
    item.classList.remove("active"); // 기존 active 클래스 제거
  });
  link.classList.add("active"); // 클릭된 링크에 active 클래스 추가

  // 제목도 활성화
  const title = link.closest('.category-item').querySelector('.title');
  if (title) {
    title.classList.add("active"); // 제목에 active 클래스 추가
  }
}






// Ajax 연결..... javascript 연결
document.addEventListener('DOMContentLoaded', () => {
  const links = document.querySelectorAll('.category-link[data-url]');
  
  links.forEach(link => {
      link.addEventListener('click', (event) => {
          event.preventDefault(); // 기본 링크 동작 방지
          const url = link.getAttribute('data-url'); // data-url 속성에서 URL 가져오기
          
          // AJAX 요청
          fetch(url)
              .then(response => {
                  if (!response.ok) {
                      throw new Error('네트워크 응답이 좋지 않습니다.');
                  }
                  return response.text(); // 응답을 텍스트로 변환
              })
              .then(data => {
                  document.getElementById('content-display').innerHTML = data; // 콘텐츠 영역에 로드

                  // 동적으로 JavaScript 파일 로드
                  const scriptUrl = link.getAttribute('data-script'); // data-script 속성에서 스크립트 URL 가져오기
                  if (scriptUrl) {
                      const scriptElement = document.createElement('script');
                      scriptElement.src = scriptUrl;
                      document.body.appendChild(scriptElement); // 스크립트 추가
                  }
              })
              .catch(error => {
                  document.getElementById('content-display').innerHTML = '페이지를 불러오는 데 오류가 발생했습니다.❌';
                  console.error('페이지 로드 오류:', error);
              });
      });
  });
});
