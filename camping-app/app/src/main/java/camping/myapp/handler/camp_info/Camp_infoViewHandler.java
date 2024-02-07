package camping.myapp.handler.camp_info;

import camping.menu.AbstractMenuHandler;
import camping.myapp.dao.Camp_infoDao;
import camping.util.Prompt;

public class Camp_infoViewHandler extends AbstractMenuHandler {

  private Camp_infoDao camp_infoDao;

  public Camp_infoViewHandler(Camp_infoDao camp_infoDao, Prompt prompt) {
    super(prompt);
    this.camp_infoDao = camp_infoDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("번호? ");
      camping.myapp.vo.Camp_info camp_info = camp_infoDao.findBy(no);
      if (camp_info == null) {
        System.out.println("과제 번호가 유효하지 않습니다!");
        return;
      }

      System.out.printf("번호: %s\n", camp_info.getNo());
      System.out.printf("과제명: %s\n", camp_info.getTitle());
      System.out.printf("내용: %s\n", camp_info.getContent());
      System.out.printf("제출 마감일: %s\n", camp_info.getDeadline());

    } catch (Exception e) {
      System.out.println("조회 오류!");
    }
  }

}
