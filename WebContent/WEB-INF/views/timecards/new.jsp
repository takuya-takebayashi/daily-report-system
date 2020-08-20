<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name = "content">
        <h2>打刻画面</h2>
        <span id="view_clock"></span>

<script type="text/javascript">
timerID = setInterval('clock()',500); //0.5秒毎にclock()を実行

function clock() {
    document.getElementById("view_clock").innerHTML = getNow();
}

function getNow() {
    var now = new Date();
    var year = now.getFullYear();
    var mon = now.getMonth()+1; //１を足すこと
    var day = now.getDate();
    var hour = now.getHours();
    var min = now.getMinutes();
    var sec = now.getSeconds();

    //出力用
    var s = year + "年" + mon + "月" + day + "日" + hour + "時" + min + "分" + sec + "秒";
    return s;
}
</script><br/>

        <form method="POST" action="<c:url value='/timecards/start' />">
            <button type="submit">出勤</button>
        </form><br/>

        <form method="POST" action="<c:url value='/timecards/finish' />">
            <button type="submit">退勤</button>
        </form>


    </c:param>

</c:import>