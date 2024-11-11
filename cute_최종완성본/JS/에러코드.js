let count = 16; // 새로운 행의 ID를 위한 카운트 변수

        // 테이블 셀을 수정 가능하게 하는 함수
        function enableEditing(button) {
            let tableRow = button.parentNode.parentNode; // 현재 버튼이 속한 행(tr)을 가져옴
            let cells = tableRow.querySelectorAll('td'); // 행의 모든 셀(td)을 선택
            let currentCell = cells[1]; // 특정 열 선택 (예: 두 번째 열)

            let currentValue = currentCell.textContent; // 현재 셀의 값 가져오기

            // 현재 값을 가진 입력 필드 생성
            let inputField = document.createElement('input');
            inputField.type = 'text';
            inputField.value = currentValue;
            inputField.style.width = '450px';

            // 기존 콘텐츠를 지우고 입력 필드를 추가
            currentCell.textContent = '';
            currentCell.appendChild(inputField);

            // 저장 버튼 생성
            let saveButton = document.createElement('button');
            // saveButton.textContent = '저장';
            saveButton.innerHTML = '<img class="imgStyle" src="/image/save.webp" title="저장">';
            saveButton.className = 'saveButton';
            saveButton.addEventListener('click', function () {
                currentCell.textContent = inputField.value; // 입력 필드의 값을 셀에 저장
                let actionCell = cells[2];
                actionCell.innerHTML = ''; // 기존의 모든 버튼 제거
                adderroreditButton(actionCell); // 셀에 수정 버튼 다시 추가
            });

            // 기존 버튼 제거하고 저장 버튼 추가
            let actionCell = cells[2];
            actionCell.innerHTML = ''; // 기존의 모든 버튼 제거
            actionCell.appendChild(saveButton);
        };
        
        // 셀에 수정 버튼을 다시 추가하는 함수
        function adderroreditButton(cell) {
            let erroreditButton = document.createElement('button');
            erroreditButton.className = 'erroreditButton';
            erroreditButton.innerHTML = '<img class="imgStyle erroreditButton" src="/image/수정.png" title="수정">';
            erroreditButton.addEventListener('click', function () {
                enableEditing(erroreditButton); // 수정 버튼 클릭 시 enableEditing 함수 호출
            });

            cell.appendChild(erroreditButton); // 셀에 수정 버튼 추가
        };
        function adderrordelButton(cell) {
            let errordelButton = document.createElement('button');
            errordelButton.className = 'errordelButton';
            errordelButton.innerHTML = '<img class="imgStyle errordelButton" src="/image/삭제.png" title="삭제">';
            errordelButton.addEventListener('click', function () {
                errordelButton.parentNode.parentNode.remove(); // 삭제 버튼 클릭 시 해당 행 삭제
            });

            cell.appendChild(errordelButton); // 셀에 삭제 버튼 추가
        };
        
        // 새로운 행을 테이블에 추가하는 함수
        document.getElementById('addButton').addEventListener('click', function () {
            // 테이블 가져오기
            let table = document.getElementById('errorTable');

            // 새로운 행 생성
            let newRow = table.insertRow();

            // 새로운 셀 생성 및 내용 추가
            let cell1 = newRow.insertCell(0);
            let cell2 = newRow.insertCell(1);
            let cell3 = newRow.insertCell(2);
            let cell4 = newRow.insertCell(3);

            cell1.innerHTML = "E0" + count; // ID 생성
            cell2.innerHTML = ''; // 빈 내용 추가
            adderroreditButton(cell3); // 셀에 수정 버튼 추가
            adderrordelButton(cell4); // 셀에 삭제 버튼 추가

            // 셀에 입력 필드를 추가하여 내용을 입력할 수 있게 함
            enableEditing(cell3.querySelector('.erroreditButton'));
            // enableEditing(cell4.querySelector('.errordelButton'));

            count++; // 카운트 증가
        });

        // 초기 수정 버튼에 이벤트 리스너 추가
        document.querySelectorAll(".erroreditButton").forEach(function(button) {
            button.addEventListener('click', function () {
                enableEditing(button); // 수정 버튼 클릭 시 enableEditing 함수 호출
            });
        });

        //삭제 누르면 표 한줄이 삭제되도록 
        let del=document.querySelectorAll(".errordelButton")
        // let del=document.querySelectorAll(".del")
        for(let i=0;i<del.length;i++){
            del[i].addEventListener('click',function(event){
                event.currentTarget.parentNode.parentNode.remove();
            })
        };