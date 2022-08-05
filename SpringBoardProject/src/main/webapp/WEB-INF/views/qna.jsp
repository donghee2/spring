<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	.container {
		width: 1200px;
		margin: 20px auto;
	}
	.qna_form {
		width: 650px;
		margin: 0 auto;
	}
	.qna_form table {
		border-collapse: collapse;
		box-sizing: border-box;
		width: 100%;
	}
	.qna_form td {
		padding: 5px;
	}
	.qna_form table tr td:first-child {
		width: 500px;
		height: 40px;
	}
	.qna_form table tr:nth-child(2) {
		height: 100px;
	}
	.qna_form input, .qna_form textarea {
		width: 100%;
		height: 100%;
		border-radius: 5px;
		box-sizing: border-box; 
	}
	.qna_form textarea {
		resize: none;
	}
	.qna_form button {
		width: 100%;
		height: 140px;
	}
	.myButton {
	box-shadow: 3px 4px 0px 0px #1564ad;
	background:linear-gradient(to bottom, #79bbff 5%, #378de5 100%);
	background-color:#79bbff;
	border-radius:5px;
	border:1px solid #337bc4;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:17px;
	font-weight:bold;
	padding:12px 44px;
	text-decoration:none;
	text-shadow:0px 1px 0px #528ecc;
	}
	.myButton:hover {
		background:linear-gradient(to bottom, #378de5 5%, #79bbff 100%);
		background-color:#378de5;
	}
	.myButton:active {
		position:relative;
		top:1px;
	}
</style>
</head>
<body>
	<jsp:include page="template/header.jsp" flush="false"></jsp:include>
	
	<div class="container">
		<div class="qna_form">
			<form action="sendQnA.do">
				<table>
					<tr>
						<td><input type="text" name="title" placeholder="문의글 제목 입력하세요"></td>
						<td rowspan="2"><button class="myButton">문의하기</button></td>
					</tr>
					<tr>
						<td><textarea name="content" placeholder="내용을 입력해주세요"></textarea></td>
					</tr>		
				</table>
			</form>
		</div>
		<hr>
	</div>
	
	<jsp:include page="template/footer.jsp" flush="false"></jsp:include>
</body>
</html>