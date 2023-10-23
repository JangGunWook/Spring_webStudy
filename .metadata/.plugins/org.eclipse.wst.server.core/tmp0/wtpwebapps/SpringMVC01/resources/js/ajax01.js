/**
 * 
 */
// 1. HTML DOM 객체 가져오기(jQuery ver)

const reqBtn = $("#reqBtn");

// 2. 이벤트 달아주기
//.on("이벤트 종류", function)
reqBtn.on("click", function() {
	let num1 = $("#num1").val();
	let num2 = $("#num2").val();
	console.log(num1)
	console.log(num2)
	// 3. 이벤트 내용
	console.log("클릭됨!");

	// 비동기 통신을 사용해서 요청하기
	$.ajax({
		url: "ajax01",
		type: "get",
		data: {
			// key:value
			// 보내고 싶은 데이터
			"num1": num1,
			"num2": num2
		},
		success: function(res) {
			// 요청-응답이 성공했을 때, 실행되는 함수
			console.log(res)
		},
		erro: function(e) { }
		// 요청-응답이 실패했을 때, 싱행되는 함수
	});

});

//======================================================================================================
// 참고 : js파일 수정냉ㅇ이 적용이 안되면
//		chrome에서 ctrl + shift + delete -> 인터넷 사용기록 삭제
// 1. 사용자가 input태그에 두수를 입력

// 2. 계산하기 버튼을 누르면 
//		1) 비동기 통ㅅ힌을 이용해서, 두수ㅡㄹ 서버로 전송

//		2) 서버에서 두 수를 수집하고, 두 수의 곱을 계산해서 응답

//		3) 응답받은 데이터를 javascript의 console창에 출력


const calBtn = $("#calBtn");
// 1. 덧셈
calBtn.on("click", function() {

	let num1 = $("#num1").val();
	console.log(num1)
	let num2 = $("#num2").val();

	$.ajax({
		url: "ajax01",
		type: "get",
		data: {
			"num1": num1,
			"num2": num2
		},
		success: function(res) {
			console.log(res)
		},
		erro: function(e) {
			console.log(e)
		}
	})
})

const mulBtn = $("#mulBtn");
// 2. 곱셈
mulBtn.on("click", function() {

	let num1 = $("#num1").val();
	console.log(num1)
	let num2 = $("#num2").val();

	$.ajax({
		url: "multi",
		type: "get",
		data: {
			"num1": num1,
			"num2": num2
		},
		success: function(res) {
			console.log(res)
		},
		erro: function(e) {
			console.log(e)
		}
	})
})














