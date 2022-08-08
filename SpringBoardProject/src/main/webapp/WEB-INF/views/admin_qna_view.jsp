<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="template/header.jsp"></jsp:include>
	<h3 class="qna_title">
		<ul>
			<li>제목 : ${requestScope.dto.title }</li>
			<li>작성자 : ${requestScope.dto.writer }</li>
			<li>작성일 : ${requestScope.dto.wdate }</li>
			<c:choose>
				<c:when test="${requestScope.dto.status == 0 }"><li>안읽음</li></c:when>
				<c:when test="${requestScope.dto.status == 1 }"><li>읽음</li></c:when>
				<c:otherwise><li>답변완료</li></c:otherwise>
			</c:choose>
		</ul>
	</h3>
	<div>
		<p>문의내용</p>
		<p class="qna_content">${requestScope.dto.content }</p>
	</div>
	<hr>
	<div class="qna_form">
		<form action="answer.do">
			<input type="hidden" name="qno" value="${requestScope.dto.qne }">
			<table>
				<tr>
					<td>
						<textarea name="response" placeholder="답변 내용을 입력해주세요">${requestScope.dto.response }</textarea>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>