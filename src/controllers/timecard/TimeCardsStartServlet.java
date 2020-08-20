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

import models.Employee;
import models.TimeCard;
import utils.DBUtil;

/**
 * Servlet implementation class TimeCardsStartServlet
 */
@WebServlet("/timecards/start")
public class TimeCardsStartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeCardsStartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 出勤ボタンを押したらその時刻を記録する
        EntityManager tc = DBUtil.createEntityManager();

        //ログインしている従業員情報を取得するコード
        Employee login_employee =(Employee)request.getSession().getAttribute("login_employee");

        TimeCard m = new TimeCard();

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        m.setEmployee(login_employee);

        m.setTimecard_date(currentTime);
        m.setStarted_at(currentTime);

        tc.getTransaction().begin();
        tc.persist(m);
        tc.getTransaction().commit();
        tc.close();

        //記録できたらnew.jspの画面へ戻る
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/timecards/new.jsp");
        rd.forward(request, response);
        //打刻ができたメッセージのフラッシュを入れる
        //今後実装予定
    }

}
