package bitcamp.myapp.servlet.board;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {

  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardDeleteServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.boardDao = new BoardDaoImpl(connectionPool, 1);
    this.attachedFileDao = new AttachedFileDaoImpl(connectionPool);
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {



    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("<p>로그인하기시 바랍니다!</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Board board = boardDao.findBy(no);
      if (board == null) {
        out.println("<p>게시글 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      } else if (board.getWriter().getNo() != loginUser.getNo()) {
        out.println("<p>권한이 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      attachedFileDao.deleteAll(no);
      boardDao.delete(no);

      out.println("<script>");
      out.println("  location.href = '/board/list'");
      out.println("</script>");

      out.println("<p>게시글을 삭제했습니다.</p>");
    } catch (Exception e) {
      out.println("<p>삭제 오류!</p>");
      out.printf("<pre>");
      e.printStackTrace(out);
      out.printf("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}

/*
[조회]
번호? 7
번호: 7
제목: a2
내용: aa2
작성자: a
작성일: 2024-02-14 00:00:00
첨부파일:
  a1.gif
  a2.gif
  a3.gif
 */