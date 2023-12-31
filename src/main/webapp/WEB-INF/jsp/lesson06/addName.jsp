<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<%-- AJAX를 사용하려면 jquery 원본 필요 jquery cdn검색 후 사이트에서 3.x uncommpressed 복사 후 슬림 cdn대체하기 --%>
<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원가입</h1>
		
		<div class="form-group">
			<label for="name"><b>이름</b></label>
			<div class="d-flex">
				<input type="text" id="name" class="form-control col-3" placeholder="이름을 입력하세요">
				<button type="button" class="btn btn-warning" id="nameCheckBtn">중복확인</button>
			</div>
			<small id="nameStatusArea"></small>
		</div>
			
		<input type="button" id="joinBtn" class="btn btn-info" value="회원가입">
	</div>
	
	<script>
		$(document).ready(function() {
			// 중복확인 버튼 클릭
			$('#nameCheckBtn').on('click', function() {
				// append 무한 막기 + 이름이 비어있습니다 문구 사라지게 하기
				
				// nameStatusArea의 하위 태그들을 초기화(append 무한 막음)
				$('#nameStatusArea').empty(); // 자식태그들을 모두 비움
				
				let name = $('#name').val().trim();
				
				//validation
				//이름이 입력됐는지 확인
				if(!name) {
					$('#nameStatusArea').append('<span class="text-danger">이름이 비어있습니다.</span>');
					return;
				}
				
				// 이름 중복확인 AJAX 통신(DB 확인)
				$.ajax({
					// request
					type:"get" // get일 때는 생략 가능
					, url:"/lesson06/ex02/is_duplication"
					, data:{"name":name}
					
					// response
					, success: function(data) {
						//alert(data);
						if (data.isDuplication) { // 중복
							$("#nameStatusArea").append('<span class="text-danger">중복된 이름입니다.</span>');
						}
					}
					
					, error:function(request, status, error) {
						alert("중복 확인에 실패했습니다.");
					}
				});
			});
			
			
			
			
			
			
			
			
			
			
			// 회원가입 버튼 클릭
			$("#joinBtn").on('click', function() {
				console.log($('#nameStatusArea').children().length);
				
				// 만약 nameStatusArea에 아무 자식 노드가 없다면 회원가입을 한다.
				// 비어있어도 안 되고 중복이어도 안 된다
				if($('#nameStatusArea').children().length == 0) {
					alert("가입 가능");
				} else {
					alert("가입 불가");
				}
			});
			
		});
	</script>
</body>
</html>