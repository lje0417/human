<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .container {
        /* 스크롤 조금 생기는거 없애려고 */
        box-sizing: border-box;
    }

    body {
        /* 스크롤 조금 생기는거 없애려고 */
        margin: 0;
        padding: 0;
    }


    .top {
        display: flex;
        background-color: #444444;
        height: 50px;
    }

    .item {
        /* border: 1px solid blue; */
        padding: 10px;
    }

    .top2 {
        display: flex;
        height: 60px;
    }

    .top_menu_container {
        background-color: #C0B296;
        flex-grow: 5;
        display: flex;
        justify-content: space-between;
    }

    .top_menu {
        display: flex;
        flex-grow: 1;
        /* 남은 공간을 나눠가짐 */
        justify-content: center;
        /* 가로 방향으로 중앙 정렬 */
        align-items: center;
        /* 세로 방향으로 중앙 정렬 */
        color: white;
        font-size: 20px;
        font-weight: bold;
        cursor: pointer;
    }

    .sideBar {
        background-color: #AF9D8D;
        flex-grow: 1;
    }

    .sideBar_container {
        background-color: #AF9D8D;
        width: 18vw;
        display: flex;
        height: 100%;
    }

    .side_menu {
        padding: 10px;
        height: 30px;
        display: flex;
        flex-grow: 1;
        justify-content: center;
        align-items: center;
        color: #505050;
        font-size: 16px;
        font-weight: bold;
    }

    .side_menu1,
    .side_menu2,
    .side_menu3,
    .side_menu4 {
        display: none;
        /* 기본적으로 숨기기 */
    }

    .selected {
        background-color: #784E40;
        color: white;
        font-weight: bold;

    }

    .section {
        width: 100vw;
        /* border: 1px solid blue; */
        height: calc(100vh - 110px);
        display: flex;
    }

    .test {
        display: inline-block;
        width: 82vw;
    }

    iframe {
        width: 100%;
        height: 100%;
        border: none;
        /* 프레임 테두리 제거 */
    }

    img {
        max-width: 100%;
        /* 최대 너비를 컨테이너의 너비로 제한 */
        max-height: 100%;
        padding-left: 50px;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="header">
            <div class="top">
                <div class="item" style="flex-grow: 1"><img src="image/logo.png"></div>
                <div class="item" style="flex-grow: 4"></div>
                <div class="item" style="flex-grow: 1;"><img src="image/person.png"><span
                        style="color: #D5D5D5;font-weight: bold;position: relative;top: -5px;right: -5px;">${loginDTO.ename} 님</span>
                </div>
                <div class="item" style="flex-grow: 1;"><img src="image/offBtn.png"></div>
            </div>
            <div class="top2">
                <div style="background-color: #AE9476; width: 18vw;;"></div>
                <div class="top_menu_container">
                    <div class="top_menu" data-menu="생산">생산</div>
                    <div class="top_menu" data-menu="재고">재고</div>
                    <div class="top_menu" data-menu="모니터링">모니터링</div>
                    <div class="top_menu" data-menu="게시판">게시판</div>
                </div>
            </div>
        </div>
        <div class="section">
            <div class="sideBar_container">
                <div class="sideBar">
                    <div class="side_menu side_menu1" data-page="/peanutbutter/pl">생산계획관리</div>
                    <div class="side_menu side_menu1" data-page="/peanutbutter/ap">생산실적</div>
                    <div class="side_menu side_menu1" data-page="/peanutbutter/sp">작업지시서</div>
                    <div class="side_menu side_menu1" data-page="/peanutbutter/bom">BOM 관리</div>
                    <div class="side_menu side_menu1" data-page="/peanutbutter/pm">제품 관리</div>
                    <div class="side_menu side_menu1" data-page="/peanutbutter/pt">부품 관리</div>
                    <div class="side_menu side_menu1" data-page="/peanutbutter/factory_Management">공정 관리</div>

                    <div class="side_menu side_menu2" data-page="/peanutbutter/pt_stock">부품 재고 관리</div>
                    <div class="side_menu side_menu2" data-page="/peanutbutter/pm_stock">완제품 재고 관리</div>
                    <div class="side_menu side_menu2" data-page="/peanutbutter/po">발주 관리</div>
                    <div class="side_menu side_menu2" data-page="/peanutbutter/st">입고 관리</div>
                    <div class="side_menu side_menu2" data-page="/peanutbutter/sh">출고 관리</div>
                    <div class="side_menu side_menu2" data-page="/peanutbutter/rb">반품 관리</div>

                    <div class="side_menu side_menu3" data-page="/peanutbutter/chart">실적 모니터링</div>
                    <div class="side_menu side_menu3" data-page="/peanutbutter/chart2">라인별 현황</div>

                    <div class="side_menu side_menu4">게시판</div> <!-- 지금은 사용되지 않지만 사이드 메뉴가 2개이상이 되면 사용해야 함 -->
                </div>
            </div>
            <div class="test">
                <iframe id="contentFrame" src=""></iframe>
            </div>

        </div>
</body>

<script>
    let topMenus = document.querySelectorAll('.top_menu');
    let sideMenu1s = document.querySelectorAll('.side_menu1');
    let sideMenu2s = document.querySelectorAll('.side_menu2');
    let sideMenu3s = document.querySelectorAll('.side_menu3');
    let sideMenu4s = document.querySelectorAll('.side_menu4');

    topMenus.forEach(menu => {
        menu.addEventListener('click', () => {
            let menuType = menu.getAttribute('data-menu');

            sideMenu1s.forEach(item => item.classList.remove('selected'));
            sideMenu2s.forEach(item => item.classList.remove('selected'));
            sideMenu3s.forEach(item => item.classList.remove('selected'));
            sideMenu4s.forEach(item => item.classList.remove('selected'));

            if (menuType === '생산') {
                let iframe = document.getElementById('contentFrame');
                iframe.src = '/peanutbutter/pl';
                sideMenu1s[0].classList.add('selected'); //사이드바 메뉴의 가장 위에있는 메뉴를 seleted로 설정함

                sideMenu1s.forEach(item => {
                    item.style.display = 'flex'; // 메뉴들을 다시 보이게 함
                    item.addEventListener('click', () => {
                        sideMenu1s.forEach(s => s.classList.remove('selected')); //어떤 사이드메뉴를 클릭하면 모든 사이드메뉴의 selected 클래스를 전부 삭제함
                        item.classList.add('selected'); // 그리고 클릭한 메뉴에 selected클래스를 추가
                    });
                });
                sideMenu2s.forEach(item => item.style.display = 'none'); //다른 메뉴들은 안보이게 함
                sideMenu3s.forEach(item => item.style.display = 'none');
                sideMenu4s.forEach(item => item.style.display = 'none');
            } else if (menuType === '재고') {
                let iframe = document.getElementById('contentFrame');
                iframe.src = '/peanutbutter/pt_stock';
                sideMenu2s[0].classList.add('selected');

                sideMenu2s.forEach(item => {
                    item.style.display = 'flex';
                    item.addEventListener('click', () => {
                        sideMenu2s.forEach(s => s.classList.remove('selected'));
                        item.classList.add('selected');
                    });
                });
                sideMenu1s.forEach(item => item.style.display = 'none');
                sideMenu3s.forEach(item => item.style.display = 'none');
                sideMenu4s.forEach(item => item.style.display = 'none');
            } else if (menuType === '모니터링') {
                let iframe = document.getElementById('contentFrame');
                iframe.src = '/peanutbutter/chart';
                sideMenu3s[0].classList.add('selected');


                sideMenu3s.forEach(item => {
                    item.style.display = 'flex';
                    item.addEventListener('click', () => {
                        sideMenu3s.forEach(s => s.classList.remove('selected'));
                        item.classList.add('selected');
                    });
                });
                sideMenu1s.forEach(item => item.style.display = 'none');
                sideMenu2s.forEach(item => item.style.display = 'none');
                sideMenu4s.forEach(item => item.style.display = 'none');
            } else if (menuType === '게시판') {
                let iframe = document.getElementById('contentFrame');
                iframe.src = '/peanutbutter/board';
                // sideMenu4s.forEach(item => {
                //     item.style.display = 'flex';
                //     item.addEventListener('click', () => {
                //         sideMenu4s.forEach(s => s.classList.remove('selected'));
                //         item.classList.add('selected');
                //     });
                // });
                sideMenu1s.forEach(item => item.style.display = 'none');
                sideMenu2s.forEach(item => item.style.display = 'none');
                sideMenu3s.forEach(item => item.style.display = 'none');
            }
            else {
                sideMenu1s.forEach(item => item.style.display = 'none');
                sideMenu2s.forEach(item => item.style.display = 'none');
                sideMenu3s.forEach(item => item.style.display = 'none');
                sideMenu4s.forEach(item => item.style.display = 'none');
            }
        });
    });


    let sideMenus = document.querySelectorAll('.side_menu');

    // 각 side_menu에 클릭 이벤트 리스너 추가
    sideMenus.forEach(menu => {
        menu.addEventListener('click', (event) => {
            // 클릭된 메뉴 요소의 data-page 속성 값 가져오기
            let page = event.target.getAttribute('data-page');
            // iframe 요소 선택
            let iframe = document.getElementById('contentFrame');
            // iframe의 src 속성 변경
            iframe.src = page;
        });
    });

    window.onload = function () {
        let iframe = document.getElementById('contentFrame');
        iframe.src = "/peanutbutter/chart";
        sideMenu3s[0].classList.add('selected');


        sideMenu3s.forEach(item => {
            item.style.display = 'flex';
            item.addEventListener('click', () => {
                sideMenu3s.forEach(s => s.classList.remove('selected'));
                item.classList.add('selected');
            });
        });
        sideMenu1s.forEach(item => item.style.display = 'none');
        sideMenu2s.forEach(item => item.style.display = 'none');
        sideMenu4s.forEach(item => item.style.display = 'none');
    }
</script>
</html>