package controllers.timecard;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class TimeCardsShowServlet
 */
@WebServlet("/timecards/show")
public class TimeCardsShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeCardsShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 勤怠の打刻履歴を確認する画面を表示する
        EntityManager tc = DBUtil.createEntityManager();

        //データベースへ問い合わせ、結果をリスト形式で取得するコード
        List<TimeCard> timecards = tc.createNamedQuery("getAllTimeCards", TimeCard.class).getResultList();

        //問い合わせを閉じるコード
        tc.close();

        //リクエストスコープに取得したリストを渡すコード
        request.setAttribute("timecards", timecards);


        //画面を遷移させる
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/timecards/show.jsp");
        rd.forward(request, response);
    }

}
