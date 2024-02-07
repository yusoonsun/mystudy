package camping.myapp.dao.mysql;

import camping.myapp.dao.Camp_infoDao;
import camping.myapp.dao.DaoException;
import camping.myapp.vo.Camp_info;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Camp_infoDaoImpl implements Camp_infoDao {

  Connection con;

  public Camp_infoDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Camp_info camp_info) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "insert into camp_infos(title,content,deadline) values(?,?,?)")) {

      pstmt.setString(1, camp_info.getTitle());
      pstmt.setString(2, camp_info.getContent());
      pstmt.setDate(3, camp_info.getDeadline());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "delete from camp_infos where camp_info_no=?")) {
      pstmt.setInt(1, no);

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Camp_info> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select camp_info_no, title, deadline from camp_infos order by camp_info_no desc");
        ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Camp_info> list = new ArrayList<>();

      while (rs.next()) {
        Camp_info camp_info = new Camp_info();
        camp_info.setNo(rs.getInt("assignment_no"));
        camp_info.setTitle(rs.getString("title"));
        camp_info.setDeadline(rs.getDate("deadline"));

        list.add(camp_info);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Camp_info findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select * from camp_infos where camp_info_no=?")) {

      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {

        if (rs.next()) {
          Camp_info camp_info = new Camp_info();
          camp_info.setNo(rs.getInt("assignment_no"));
          camp_info.setTitle(rs.getString("title"));
          camp_info.setContent(rs.getString("content"));
          camp_info.setDeadline(rs.getDate("deadline"));

          return camp_info;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }


  @Override
  public int update(Camp_info camp_info) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "update camp_infos set title=?, content=?, deadline=? where camp_info_no=?")) {

      pstmt.setString(1, camp_info.getTitle());
      pstmt.setString(2, camp_info.getContent());
      pstmt.setDate(3, camp_info.getDeadline());
      pstmt.setInt(4, camp_info.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
