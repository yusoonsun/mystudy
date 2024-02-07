package camping.myapp.handler;

import camping.menu.AbstractMenuHandler;
import camping.util.Prompt;


public class HelpHandler extends AbstractMenuHandler {

  public HelpHandler(Prompt prompt) {
    super(prompt);
  }

  @Override
  protected void action() {
    System.out.println("도움말입니다.");
  }
}
