// 1. 사용자가 해당 페이지에 들어왔을 때

// 1) 비동기 방식을 이용해서 요청 보내기

// 2) 해당 게시글의 조회수를 1올리기
//	  조회수 올리기 성공 실ㄹ패 여부를 응답

// 3) 만약 성공했다면, js console에 "조회수 올리기 성공!" 출력
//	      실패했따면,				"조회수 올리기 실패!"

$(document).ready(function(){
	
	 let count = Number($("#count").val());
	$.ajax({
		url:"count",
		type:"get",
		data:{
			// 태그이름[속성명=속성값]
			"idx": $('input[name="idx"]').val(),
			"count": count +1
		},
		success:function(res){
			console.log(res)
			
		},
		erro:function(e){
			
		}
	});
});