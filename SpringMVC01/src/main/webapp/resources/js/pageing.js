$(document).ready(async function async() {
   
	let data = "";
	const response = await $.ajax({	
		url:"page",
		type:"get",
		success:function(res){
			console.log(res)
		},
		error:function(e){
			console.log(e)
		}
	});
		data = response;

	 // 원본 게시물 리스트
    const boardList = data; // 여기에 서버에서 받아온 데이터를 할당해야 합니다.

    // 페이지당 표시할 항목 수
    const itemsPerPage = 5;

    // 총 페이지 수 계산
	// Math.ceil() : 숫자 이상의 가장 작은 정수를 반환
    const totalPages = Math.ceil(boardList.length / itemsPerPage);

    // 현재 페이지 초기화
    let currentPage = 1;

    // 페이징 버튼 생성
    function createPaginationButtons() {
        $("#pagination").empty(); // 이전 버튼들을 초기화

        for (let i = 1; i <= totalPages; i++) {
			//버튼이 새로 생성
            const button = $("<button>")
                .addClass("btn btn-outline-secondary")
                .text(i);

            button.click(function () {
                currentPage = i;
                updateTable();
            });

            $("#pagination").append(button);
        }
    }

    // 테이블 업데이트 함수
    function updateTable() {
        // 시작 인덱스와 끝 인덱스 계산
        const startIndex = (currentPage - 1) * itemsPerPage;
        const endIndex = startIndex + itemsPerPage;

        // 테이블 초기화
        const tbody = $('tbody');
        tbody.empty();

        // 페이지에 해당하는 항목 표시
        for (let i = startIndex; i < endIndex && i < boardList.length; i++) {
            const item = boardList[i];
            const row = `
                <tr>
                    <td>${item.idx}</td>
                    <td><a href="detail?idx=${item.idx}">${item.title}</a></td>
                    <td>${item.writer}</td>
                    <td>${item.indate}</td>
                    <td>${item.count}</td>
                    <td><a class="btn btn-primary" href="delete?idx=${item.idx}">삭제</a></td>
                </tr>
            `;
            tbody.append(row);
        }

        createPaginationButtons(); // 페이징 버튼 업데이트
    }

    // 초기 테이블 업데이트
    updateTable();
});