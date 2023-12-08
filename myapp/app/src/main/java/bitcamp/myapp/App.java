package bitcamp.myapp;

import bitcamp.myapp.menu.MainMenu;
import bitcamp.myapp.util.Prompt;

public class App {

  public static void main(String[] args) {
    Prompt prompt = new Prompt(System.in);
    new MainMenu(prompt).execute();
    prompt.close();
  }
}
