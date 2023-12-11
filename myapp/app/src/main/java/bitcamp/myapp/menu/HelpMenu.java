package bitcamp.myapp.menu;

import bitcamp.menu.Menu;
import bitcamp.myapp.util.Prompt;

public class HelpMenu implements Menu {

    String title;
    Prompt prompt;

    public HelpMenu(String title, Prompt prompt) {
        this.title = title;
        this.prompt = prompt;
    }

    public void execute(Prompt prompt) {
        System.out.printf("[%s]\n", this.title);
        System.out.println("도움말입니다.");
    }

    @Override
    public String getTitle() {
        return null;
    }
}
