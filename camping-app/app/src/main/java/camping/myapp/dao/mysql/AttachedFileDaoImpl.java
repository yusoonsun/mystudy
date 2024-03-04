package camping.myapp.dao.mysql;

import camping.myapp.dao.AttachedFileDao;
import camping.myapp.dao.DaoException;
import camping.myapp.vo.AttachedFile;
import camping.util.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class AttachedFileDaoImpl implements AttachedFileDao {

  DBConnectionPool connectionPool;

  public AttachedFileDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(AttachedFile file) {
    try (Connection con = connectionPool.getConnection();
         PreparedStatement pstmt = con.prepareStatement(
                 "insert into reservation_files(file_path,reservation_no) values(?,?)")) {
      pstmt.setString(1, file.getFilePath());
      pstmt.setInt(2, file.getBoardNo());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int addAll(List<AttachedFile> files) {
    try (Connection con = connectionPool.getConnection();
         PreparedStatement pstmt = con.prepareStatement(
                 "insert into reservation_files(file_path,reservation_no) values(?,?)")) {
      for (AttachedFile file : files) {
        pstmt.setString(1, file.getFilePath());
        pstmt.setInt(2, file.getBoardNo());
        pstmt.executeUpdate();
      }

      return files.size();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    return 0;
  }

  @Override
  public int deleteAll(int boardNo) {
    return 0;
  }

  @Override
  public List<AttachedFile> findAllByBoardNo(int boardNo) {
    return null;
  }

  @Override
  public AttachedFile findByNo(int no) {
    return null;
  }
}
