package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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
 * Servlet implementation class Register
 */
@WebServlet("/ap2_final/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
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
			PrintWriter out = response.getWriter();

			//タイトル・ページ名の記述
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>トレーニング強度記録</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>トレーニング強度記録</h1>");
			out.println("<h2>レコード登録画面</h2>");

			//データベースへの接続
			String driverUrl = "jdbc:derby:C:\\Users\\c0118128f5\\Documents\\JavaDB\\ap2_final;create=false";

			//コネクションの確立
			con = DriverManager.getConnection(driverUrl, "db", "db");

			//ステートメントの作成
			stmt = con.createStatement();

			//======新しいレコードを追加========

			//入力された値を取得
			String event = request.getParameter("event");

			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String date = year + "-" + month + "-" + day;

			String weight = request.getParameter("weight");
			String rep = request.getParameter("rep");
			float w = Float.parseFloat(weight);
			float r = Float.parseFloat(rep);
			String rm = String.valueOf(w*(1+(r/40)));

			//実行するSQL文を記述
			String sql = "insert into " + event + "(date,weight,rep,rm) values (?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setDate(1, Date.valueOf(date));
            ps.setFloat(2, Float.parseFloat(weight));
            ps.setInt(3, Integer.parseInt(rep));
            ps.setFloat(4, Float.parseFloat(rm));

            //SQL文を実行
			int count = ps.executeUpdate();

			//実行するSQL文を記述
			String sql2 = "select * from "+ event +" order by training_ID";

			//SQLを実行してResultSetの形式で結果を取得
			ResultSet rs = stmt.executeQuery(sql2);

			out.println("<h3>" + event + "</h3>");
			out.println("<table border=\"1\">");
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

			//メモリの開放
			rs.close();

			//各ページへのリンクを作成
			out.println("<h2>Index</h2>");
			out.println("<p><a href=\"top.html\">topへ戻る</a></p>");
			out.println("<p><a href=\"remove.html\">レコード削除画面</a></p>");
			out.println("<p><a href=\"Show\">全レコード確認画面</a></p>");
			out.println("<p><a href=\"search.html\">検索画面</a></p>");

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
