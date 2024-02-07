package camping.myapp.dao.mysql;

import camping.myapp.dao.DaoException;
import camping.myapp.dao.MemberDao;
import camping.myapp.vo.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {

  Connection con;

  public MemberDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Member member) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "insert into members(name,gender,tel,email,password) values(?,?,?)")) {

      pstmt.setString(1, member.getName());
      pstmt.setString(2, member.getGender());
      pstmt.setInt(3, member.getTel());
      pstmt.setString(4, member.getEmail());
      pstmt.setString(5, member.getPassword());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "delete from members where member_no=?")) {

      pstmt.setInt(1, no);

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Member> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select member_no, name, gender, tel, email, created_date from members order by member_no desc");
        ResultSet rs = pstmt.executeQuery()){

      ArrayList<Member> list = new ArrayList<>();

      while (rs.next()) {
        Member member = new Member();
        member.setNo(rs.getInt("member_no"));
        member.setName(rs.getString("name"));
        member.setGender(rs.getString("gender"));
        member.setTel(rs.getInt("tel"));
        member.setEmail(rs.getString("email"));
        member.setCreatedDate(rs.getDate("created_date"));

        list.add(member);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Member findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select * from members where member_no =?")) {

      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {

        if (rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("member_no"));
          member.setName(rs.getString("name"));
          member.setGender(rs.getString("gender"));
          member.setTel(rs.getInt("tel"));
          member.setEmail(rs.getString("email"));
          member.setCreatedDate(rs.getDate("created_date"));

          return member;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Member member) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "update members set name=?, gender=?, tel=?, email=?, password=sha2(?,256) where member_no=?")) {

      pstmt.setString(1, member.getName());
      pstmt.setString(2, member.getGender());
      pstmt.setInt(3, member.getTel());
      pstmt.setString(4, member.getEmail());
      pstmt.setString(5, member.getPassword());
      pstmt.setInt(6, member.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
