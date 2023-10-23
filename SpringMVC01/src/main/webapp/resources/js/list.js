
// id값과 함수명과는 겹치면 안된다

const boardSearch = () => {

	// 검색어 변수명
	const search = $("#search").val()

	// 1) input태그에 작성된 내용을 가지고, 비동기 요청
	$.ajax({
		url: "search",
		type: "get",
		data: {
			"search": search
		},
		success: update,

		error: function(e) {
			console.log(e)
		}
	})
};


// 2) 파라미터 수집, 해당 검색어를 포함하는 게시글만을 조회해서 결과를 응답

// 3) 테이블 내용 수정


function update(res) {
	console.log(res)

	// 1. 테이블 내용 초기화
	const tbody = $('tbody');
	// .html() : 형태 태그 안에있는 코드 리턴
	// .html("text") : 해당 태그 안에 있는 코드 덮어쓰기
	tbody.html("");

	for (var i = 0; i < res.length; i++) {
		let item = res[i];

		let aa = `
		<tr>
			<td>${item.idx}</td>
			<td><a href="detail?idx=${item.idx}">${item.title}</a></td>
			<td>${item.writer}</td>
			<td>${item.indate}</td>
			<td>${item.count}</td>
			<td><a class="btn btn-primary" href="delete?idx=${item.idx}">삭제</a></td>
		</tr>
		
		`
		//.append("text")
		tbody.append(aa);
	}

	/*res.forEach(item => {
		tbody.innerHTML += `
			<tr>
				<td>${item.idx}</td>
				<td><a href="detail?idx=${item.idx}">${item.title}</a></td>
				<td>${item.writer}</td>
				<td>${item.indate}</td>
				<td>${item.count}</td>
				<td><a class="btn btn-primary" href="delete?idx=${item.idx}">삭제</a></td>
			</tr>
			`
	})*/
}


// 1. 검색버튼 클릭시
const searchBtn = $("#searchBtn");
searchBtn.on("click", boardSearch)

//=========================================================


$("#chartBtn").on("click", open);

function open() {
	const div = $("#chartDiv");

	// .css("속성명");---> 해당속성의 속성값 리턴
	// .css("display","속성값");----->해당 속성의 값을 수정
	// 만약 div가 보이지 않는 상태 --> block
	//			보이는 상태 --> none

	/*if(div.css("display")=="none"){
		div.css("display","block")
	}else{
		div.css("display","none")
	}*/
	div.slideToggle();

	// 1) 차트를 그리기 위한 데이터를 가져오기(비동기 통신)
	$.ajax({
		url: "chart",
		type: "get",
		success: drawChart,
	})
}
	function drawChart(res) {
		// 2) 만약 데이터를 잘 가져왔다면, 차트 그려주기

		console.log(res);
		const div = $("#chartDiv").children("div");

		div.html("");	//차트를 그리기 위해 초기화

		div.append("<canvas id='myChart'></canvas>") // 새로운 canvas태그 생성

		// chart.js를 이용한
		const ctx = document.getElementById('myChart');
		
		//JSON 데이터를 이용할 수 있게끔 옮겨담기
		let writer = [];	// labels,x축
		let count =[]		// data, y축
		
		for(let i=0; i<res.length; i++){
			writer.push(res[i].writer);
			count.push(res[i].count);
		}

		new Chart(ctx, {
			type: 'bar',	//차트 종류
			data: {
				labels: writer,	//X축 데이터 이름[]배열형식으로
				datasets: [{
					label: '# of View',	//차트의 의미
					data: count,		//차트의 데이터
					borderWidth: 1,
					backgroundColor : ['red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange']	//배경색 지정
				}]
			},
			options: {
				scales: {
					y: {
						beginAtZero: true
					}
				}
			}
		});
	}


























