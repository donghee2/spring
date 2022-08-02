<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.result {
		margin:50px auto;
		width:1200px;
	}
	.result > table{
		width:100%;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$(".btnUpdate").click(function(){
			var arr = $(this).parent().parent().find("input");
			var d = "";
			$.each(arr,function(i,obj){
				d += $(obj).attr("name") + "=" + $(obj).val() + "&";
			});
			$.ajax({
				url:"memberUpdate.do",
				data : d,
				type: "post",
				success:function(r){
					if(r == 1)
						alert("회원 정보 수정 완료");
					else 
						alert("회원 정보 수정 실패");
					location.reload();
				}
			});
		});
		$(".btnDelete").click(function(){
			var d = "id="+ $(this).parent().parent().find("input[name=id]").val();
			$.ajax({
				url:"memberDelete.do",
				data : d,
				type: "post",
				success:function(r){
					if(r == 1)
						alert("회원 정보 삭제 완료");
					else 
						alert("회원 정보 삭제 실패");
					location.reload();
				}
			});
		});
	});
</script>
</head>
<body>
	<jsp:include page="template/header.jsp" flush="false"></jsp:include>
	<div class="result">
	<table>
	<tr>
		<th>아이디</th>
		<th>암호</th>
		<th>이름</th>
		<th>닉네임</th>
		<th>등급</th>
		<th>비고</th>
	</tr>
	<!-- 전체 회원 목록을 출력 -->
	<c:forEach var="obj" items="${requestScope.list }">
		<tr>
		<td><input type="text" name="id" value="${obj.id }" readonly></td>
		<td><input type="text" name="passwd" value="${obj.passwd }"></td>
		<td><input type="text" name="name" value="${obj.name }"></td>
		<td><input type="text" name="nick" value="${obj.nick }"></td>
		<td><input type="text" name="grade" value="${obj.gradeNo }"></td>
		<td><button type="button" class="btnUpdate">수정</button>
		<button type="button" class="btnDelete">삭제</button>
		<!-- 삭제 및 수정 처리 Ajax로 삭제 처리 -->
		</td>
		</tr>
		
	</c:forEach>
	</table>
	</div>
	<jsp:include page="template/footer.jsp" flush="false"></jsp:include>
</body>
</html>