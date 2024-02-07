package camping.myapp.handler.camp_info;

import camping.menu.AbstractMenuHandler;
import camping.myapp.dao.Camp_infoDao;
import camping.util.Prompt;
import camping.myapp.vo.Camp_info;

public class Camp_infoAddHandler extends AbstractMenuHandler {

  private Camp_infoDao camp_infoDao;


  public Camp_infoAddHandler(Camp_infoDao camp_infoDao, Prompt prompt) {
    super(prompt);
    this.camp_infoDao = camp_infoDao;
  }

  @Override
  protected void action() {
    try {
      Camp_info camp_info = new Camp_info();
      camp_info.setTitle(this.prompt.input("과제명? "));
      camp_info.setContent(this.prompt.input("내용? "));
      camp_info.setDeadline(this.prompt.inputDate("제출 마감일?(예: 2023-12-25) "));

      camp_infoDao.add(camp_info);

    } catch (Exception e) {
      System.out.println("과제 입력 중 오류 발생!");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
}
