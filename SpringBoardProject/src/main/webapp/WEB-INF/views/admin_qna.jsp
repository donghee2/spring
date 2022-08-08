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
	<h2>문의 내역</h2>
	<table>
		<tr>
			<th>순번</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="obj" items="${requestScope.list }">
			<tr>
				<td>${obj.qno }</td>
				<td>${obj.title }</td>
				<td>${obj.writer }</td>
				<td>${obj.wdate }</td>
				<td>
					<c:choose>
						<c:when test="${obj.status == 0 }"><li>안읽음</li></c:when>
						<c:when test="${obj.status == 1 }"><li>읽음</li></c:when>
						<c:otherwise><li>답변완료</li></c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
				<c:if test="${requestScope.page.previousPageGroup }">
					<a href="qnaAdminView.do?pageNo=${requestScope.page.startPageOfPageGroup - 1 }">◀</a>
				</c:if>
				<c:forEach var="i" begin="${requestScope.page.startPageOfPageGroup}" end="${requestScope.page.endPageOfPageGroup}" >
					<a href="qnaAdminView.do?pageNo=${i }">${i }</a>
				</c:forEach>
				<c:if test="${requestScope.page.nextPageGroup }">
					<a href="qnaAdminView.do?pageNo=${requestScope.page.endPageOfPageGroup + 1 }">▶</a>
				</c:if>
				
			</td>
		</tr>
	</table>
	
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>