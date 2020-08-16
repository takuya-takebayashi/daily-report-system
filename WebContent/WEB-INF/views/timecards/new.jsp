<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name = "content">
        <h2>打刻画面</h2>
        <p>ここに現在の時刻表示をさせたい</p>

        <form method="POST" action="<c:url value='/timecards/start' />">
            <button type="submit">出勤</button>
        </form>

        <form method="POST" action="<c:url value='/timecards/finish' />">
            <button type="submit">退勤</button>
        </form>


    </c:param>

</c:import>