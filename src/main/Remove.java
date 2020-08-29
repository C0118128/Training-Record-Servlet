package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Remove
 */
@WebServlet("/main/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//コネクションとステートメントの宣言
        Connection con = null;
        Statement stmt = null;
        PreparedStatement ps = null;

		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();

			//タイトル・ページ名の記述
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<link rel=\"stylesheet\" href=\"stylesheet.css\">");
			out.println("<title>筋トレ記録WEBアプリケーション</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"top-wrapper\">");
			out.println("<div class=\"container\">");
			out.println("<h1>Training-Record</h1>");
			out.println("<h1>筋トレ記録WEBアプリケーション</h1>");
			out.println("<p>トレーニング種目ごとに記録管理を行えるWEBアプリケーションです。</p>");
			out.println("</div>");
			out.println("</div>");

			out.println("<div class=\"main-wrapper\">");
			out.println("<div class=\"container\">");
			out.println("<h2>レコード削除画面</h2>");

			//データベースへの接続
			String driverUrl = "jdbc:derby:C:\\Users\\c0118128f5\\Documents\\JavaDB\\TrainingRecord;create=false";

			//コネクションの確立
			con = DriverManager.getConnection(driverUrl, "db", "db");

			//ステートメントの作成
			stmt = con.createStatement();

			//入力された値を取得
			String event = request.getParameter("event");

			String training_ID = request.getParameter("training_ID");

			//実行するSQL文を記述
			String sql = "delete from " + event + " where training_ID=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(training_ID));

			//SQLを実行してレコードを削除
			int count = ps.executeUpdate();


			//実行するSQL文を記述
			String sql2 = "select * from " + event + " order by training_ID";

			//SQLを実行してResultSetの形式で結果を取得
			ResultSet rs = stmt.executeQuery(sql2);

			out.println("<div class=\"heading\">");
			out.println("<h3>" + event + "</h3>");
			out.println("</div>");
			out.println("<div class=\"table\">");
			out.println("<table border=\"1\" align=\"center\">");
			out.println("<tr>");
		    out.print("<td>" + "training_ID" + "</td>");
		    out.print("<td>" + "date" + "</td>");
		    out.print("<td>" + "weight" + "</td>");
		    out.print("<td>" + "rep" + "</td>");
		    out.print("<td>" + "rm" + "</td>");
		    out.println("</tr>");
			//取得したレコードを一つずつ処理
			while (rs.next()) {
			    out.println("<tr>");
			    out.print("<td>" + rs.getInt("training_ID") + "</td>");
			    out.print("<td>" + rs.getDate("date") + "</td>");
			    out.print("<td>" + rs.getFloat("weight") + "</td>");
			    out.print("<td>" + rs.getInt("rep") + "</td>");
			    out.print("<td>" + rs.getFloat("rm") + "</td>");
			    out.println("</tr>");
			}
			out.println("</table>");
			out.println("</div>");

			//メモリの開放
			rs.close();


			out.println("</form>");
			out.println("</div>");
			out.println("</div>");

			//各ページへのリンクを作成
			out.println("<div class=\"index-wrapper\">");
			out.println("<div class=\"container\">");
			out.println("<div class=\"heading\">");
			out.println("<h2>index</h2>");
			out.println("</div>");
			out.println("<div class=\"btn-wrapper\">");
			out.println("<a href=\"register.html\" class=\"btn\">レコード登録画面</a>");
			out.println("<a href=\"remove.html\" class=\"btn\">レコード削除画面</a>");
			out.println("<a href=\"Show\" class=\"btn\">全レコード確認画面</a>");
			out.println("<a href=\"search.html\" class=\"btn\">検索画面</a>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");

			out.println("<footer>");
			out.println("<div class=\"container\">");
			out.println("<p>Author: Ryoto</p>");
			out.println("</div>");
			out.println("</fotter>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
            //サーブレット内での例外をアプリケーションのエラーとして表示
            throw new ServletException(e);
        } finally {
            //例外が発生する・しないにかかわらず確実にデータベースから切断
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
            }
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
