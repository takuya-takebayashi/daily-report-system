<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name = "content">
        <h2>勤怠管理画面</h2>
        <div>
            <p><a href="<c:url value='/timecards/new' />">打刻する</a></p>
            <p><a href="<c:url value='/timecards/show' />">履歴を確認する</a></p>
        </div>

    </c:param>
</c:import>