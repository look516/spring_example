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
		
		<form method="post" action="/lesson06/ex01/add_user">
		<!-- AJAX에서는 name 필요없고 브라우저가 자동으로 보내주던 것을 스스로 해야 한다. -->
			<div class="form-group">
				<label for="name"><b>이름</b></label>
				<input type="text" id="name" name="name" class="form-control col-3" placeholder="이름을 입력하세요">
			</div>
			
			<div class="form-group">
				<label for="yyyymmdd"><b>생년월일</b></label>
				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control col-3" placeholder="예) 19961108">
			</div>
			
			<div class="form-group">
				<label for="email"><b>이메일</b></label>
				<input type="text" id="email" name="email" class="form-control col-3" placeholder="이메일을 입력해주세요">
			</div>
			
			<div class="form-group">
				<label for="introduce"><b>자기소개</b></label>
				<textarea id="introduce" name="introduce" class="form-control col-3"></textarea>
			</div>
			<!-- AJAX 통신으로 호출할 때는 반드시 버튼을 button 타입으로 지정한다.(form 3종세트 동작 안하게, form 태그 자체를 없애도 된다.) -->
			<!-- <input type="submit" class="btn btn-info" value="회원가입"> -->
			<input type="button" id="joinBtn" class="btn btn-info" value="회원가입">
		</form>
	</div>
	
<script>
	$(document).ready(function() {
/* 		// 1) form 태그 - submit
		// 저장 버튼 클릭 후 가로채서 함수가 수행되고 다음 페이지로 넘어가도록
		// 버튼이 클릭될 때, submit이 일어날 때 이벤트로 잡을 수 있음
		// form이 하나라서 'form'가능
		// 이벤트 객체 e e.preventDefault~ 등 사용 가능
		// 웹페이지 - 검사를 띄워서 자바스크립트 에러 찾자
		$('form').on('submit', function(e) {
			//e.preventDefault(); // submit되는 것을 막는다(화면 유지)
			//alert("서브밋 버튼 클릭");
			
			// validation
			let name = $('#name').val().trim();
			if (name == '') {
				alert("이름을 입력하세요");
				//return; // 안 먹힘
				return false; // submit 안함, submit event일 때 return false
			}
			
			let yyyymmdd = $('#yyyymmdd').val().trim();
			//if (yyyymmdd.length < 1) 로 대신 써도 됨
			if (!yyyymmdd) {
				alert("생년월일을 입력하세요");
				return false; // submit 안함
			}
			
			// 여기까지 도달하면 submit 수행
			alert("서브밋 수행");
		}); */
		
		// 2) jquery의 AJAX 통신 이용하기
		$('#joinBtn').on('click', function() {
			//alert("클릭");
			// validation
			let name = $('#name').val().trim();
			if (name == '') {
				alert("이름을 입력하세요");
				
				return; 
			}
			
			let yyyymmdd = $('#yyyymmdd').val().trim();
			if (!yyyymmdd) {
				alert("생년월일을 입력하세요");
				return;
			}
			
			let email = $('input[name=email]').val().trim();
			let introduce = $('#introduce').val();
			
			console.log(name);
			console.log(yyyymmdd);
			console.log(email);
			console.log(introduce);
			
			// 서버 전송 - AJAX 통신
			$.ajax({
				// request
				// 키(type, url...)는 대문자로 작성불가
				type:"POST"
				, url:"/lesson06/ex01/add_user" // view 페이지 절대 안 넣을 것!!!
				, data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce} // json // "request parameter의 명" : 내가 보내려는 변수값
				
				
				// 이 사이에 서버(controller)쪽으로 가서 수행되고 돌아온다.
				
				// callback 함수
				// ajax는 다른 페이지로 안 넘어가고 그 자리에 머물러있는다. (내가 화면 이동 제어해야 함)
				// response
				, success:function(data) { // data param: response의 결과 응답
				// 위 data:파라미터에 키를 보냄 / 이 data:응답이 들어왔다
					//alert(data); // data는 responseBody에 뜬 값
					if(data == "성공") {
						location.href = "/lesson06/ex01/after_add_user_view";
					} else {
						alert("회원가입 처리에 실패했습니다.");
					}
				}
				, complete:function(data) {
					alert("성공이든 실패든 완료되면 띄워진다.");
				}
				, error:function(request, status, error) {
					alert(request);
					alert(status);
					alert(error);
				}
			});
		});
	});
</script>
</body>
</html>