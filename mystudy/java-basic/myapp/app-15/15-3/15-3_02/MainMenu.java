package bitcamp.myapp;

public class MainMenu {

  static final String ANSI_CLEAR = "\033[0m";
  static final String ANSI_BOLD_RED = "\033[1;31m";
  static final String ANSI_RED = "\033[0;31m";
  static final String APP_TITLE = ANSI_BOLD_RED + "[과제관리 시스템]" + ANSI_CLEAR;
  static final String[] MENUS = {
      "1. 과제",
      "2. 게시글",
      "3. 회원",
      "4. 가입인사",
      "5. 도움말",
      ANSI_RED + "0. 종료" + ANSI_CLEAR
  };

  Prompt prompt;

  public MainMenu(Prompt prompt) {
    this.prompt = prompt;
  }

  static void printMenu() {
    System.out.println(APP_TITLE);
    System.out.println();
    for (String menu : MENUS) {
      System.out.println(menu);
    }
  }

  void execute() {

    BoardMenu boardMenu = new BoardMenu("게시글", this.prompt);
    BoardMenu greetingMenu = new BoardMenu("가입인사", this.prompt);
    AssignmentMenu assignmentMenu = new AssignmentMenu("과제", this.prompt);
    MemberMenu memberMenu = new MemberMenu("회원", this.prompt);

    printMenu();

    while (true) {
      String input = this.prompt.input("메인> ");

      switch (input) {
        case "1":
          assignmentMenu.execute();
          break;
        case "2":
          boardMenu.execute();
          break;
        case "3":
          memberMenu.execute();
          break;
        case "4":
          greetingMenu.execute();
          break;
        case "5":
          System.out.println("도움말입니다.");
          break;
        case "0":
          System.out.println("종료합니다.");
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    }
  }
}
