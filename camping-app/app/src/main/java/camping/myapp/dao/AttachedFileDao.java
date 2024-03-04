package camping.myapp.dao;

import camping.myapp.vo.AttachedFile;

import java.util.List;

public interface AttachedFileDao {

  void add(AttachedFile file);

  int addAll(List<AttachedFile> files);

  int delete(int no);

  int deleteAll(int boardNo);

  List<AttachedFile> findAllByBoardNo(int boardNo);

  AttachedFile findByNo(int no);
}
