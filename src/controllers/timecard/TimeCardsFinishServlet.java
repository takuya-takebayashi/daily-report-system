package controllers.timecard;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TimeCard;
import utils.DBUtil;

/**
 * Servlet implementation class TimeCardsFinishServlet
 */
@WebServlet("/timecards/finish")
public class TimeCardsFinishServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeCardsFinishServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 退勤時間を記録する
        EntityManager tc = DBUtil.createEntityManager();

        TimeCard m = new TimeCard();

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        m.setTimecard_date(currentTime);
        m.setFinished_at(currentTime);

        tc.getTransaction().begin();
        tc.persist(m);
        tc.getTransaction().commit();
        tc.close();

        // 記録したらnew.jspへ戻る
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/timecards/new.jsp");
        rd.forward(request, response);
        //打刻ができたメッセージのフラッシュを入れる
    }

}
