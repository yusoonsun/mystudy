package camping.myapp.handler.camp_info;

import camping.menu.AbstractMenuHandler;
import camping.myapp.dao.Camp_infoDao;
import camping.myapp.vo.Camp_info;
import camping.util.Prompt;

public class Camp_infoModifyHandler extends AbstractMenuHandler {

  private Camp_infoDao camp_infoDao;

  public Camp_infoModifyHandler(Camp_infoDao camp_infoDao, Prompt prompt) {
    super(prompt);
    this.camp_infoDao = camp_infoDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");

      camping.myapp.vo.Camp_info old = camp_infoDao.findBy(no);
      if (old == null) {
        System.out.println("과제 번호가 유효하지 않습니다!");
        return;
      }

      Camp_info camp_info = new Camp_info();
      camp_info.setNo(old.getNo());
      camp_info.setTitle(this.prompt.input("과제명(%s)? ", old.getTitle()));
      camp_info.setContent(this.prompt.input("내용(%s)? ", old.getContent()));
      camp_info.setDeadline(this.prompt.inputDate("제출 마감일(%s)? ", old.getDeadline()));

      camp_infoDao.update(camp_info);
      System.out.println("과제를 변경했습니다.");

    } catch (NumberFormatException e) {
      System.out.println("숫자를 입력하세요!");

    } catch (IllegalArgumentException e) {
      System.out.println("과제 변경 오류!");
      System.out.println("다시 시도 하세요.");

    } catch (Exception e) {
      System.out.println("실행 오류!");
      e.printStackTrace();
    }

  }
}
