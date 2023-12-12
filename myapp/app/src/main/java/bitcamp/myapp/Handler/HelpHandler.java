package bitcamp.myapp.Handler;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.util.AnsiEscape;

// 메뉴 객체의 사용 규칙에 따라 클래스를 정의한다.
//
public class HelpHandler implements MenuHandler {

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    System.out.println("도움말입니다.");
  }
}
