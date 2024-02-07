package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.vo.Board;
import java.sql.Connection;
import java.sql.ResultSet;
<<<<<<< HEAD
=======
import java.sql.SQLOutput;
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDao {

  int category;
  Connection con;

  public BoardDaoImpl(Connection con, int category) {
    this.con = con;
    this.category = category;
  }

  @Override
  public void add(Board board) {
    try {
<<<<<<< HEAD
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into boards(title,content,writer,category) values('%s','%s','%s',%d)",
          board.getTitle(), board.getContent(), board.getWriter(), this.category));
=======
      Statement stmt = con.createStatement(); // SQL을 DBMS에 전달해줄 객체 생성
      stmt.executeUpdate(String.format(
              "insert into boards(title,content,writer,category) values('%s','%s','%s',%d)",
              board.getTitle(), board.getContent(), board.getWriter(), this.category));
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
<<<<<<< HEAD
      return stmt.executeUpdate(String.format("delete from boards where board_no=%d", no));

=======
      return stmt.executeUpdate(String.format(
              "delete from boards where board_no=%d", no));
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d
    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Board> findAll() {
    try {
      Statement stmt = con.createStatement();
<<<<<<< HEAD
      ResultSet rs = stmt.executeQuery("select * from boards where category=" + this.category);
=======
      ResultSet rs = stmt.executeQuery("select * from boards"); // SQL을 DBMS에 전달
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d

      ArrayList<Board> list = new ArrayList<>();

      while (rs.next()) {
<<<<<<< HEAD
        Board board = new Board();
        board.setNo(rs.getInt("board_no"));
=======
        // select 실행 결과 데이터 중 한 개의 데이터(record=tuple=row)를 서버에서 가져오기
        Board board = new Board();
        board.setNo(rs.getInt("board_no")); // 서버에서 가져온 레코드에서 컬럼 값 꺼내기
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setWriter(rs.getString("writer"));
        board.setCreatedDate(rs.getDate("created_date"));

        list.add(board);
      }
      return list;
<<<<<<< HEAD

=======
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Board findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from boards where board_no = " + no);

      if (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_no"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setWriter(rs.getString("writer"));
        board.setCreatedDate(rs.getDate("created_date"));

        return board;
      }
      return null;
<<<<<<< HEAD

=======
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Board board) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
<<<<<<< HEAD
          "update boards set title='%s', content='%s', writer='%s' where board_no=%d",
          board.getTitle(), board.getContent(), board.getWriter(), board.getNo()));

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
=======
              "update boards set title='%s', content='%s', writer='%s' where board_no=%d",
              board.getTitle(), board.getContent(), board.getWriter(), board.getNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}
>>>>>>> 532c703ff5ba30a7402a5eb323c74b833439de7d
