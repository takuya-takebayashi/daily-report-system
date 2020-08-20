<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name = "content">
        <h2>履歴確認画面</h2>
        <table id="timecard_list">
            <tbody>
                <tr>
                    <th class="timecard_date">日付</th>
                    <th class="timecard_start">出勤時間</th>
                    <th class="timecard_finish">退勤時間</th>
                </tr>
                <c:forEach var="timecards" items="${timecards}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="timecard_date"><fmt:formatDate value='${timecards.timecard_date}' pattern='yyyy-MM-dd' /></td>
                        <td class="timecard_start"><fmt:formatDate value='${timecards.started_at}' pattern='HH:mm:ss' /></td>
                        <td class="timecard_finish"><fmt:formatDate value='${timecards.finished_at}' pattern='HH:mm:ss' /></td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </c:param>
</c:import>