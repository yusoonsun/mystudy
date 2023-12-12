package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.Handler.Assignment.*;
import bitcamp.myapp.Handler.Board.*;
import bitcamp.myapp.Handler.HelpHandler;
import bitcamp.myapp.Handler.Member.*;
import bitcamp.util.ObjectRepository;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) throws Exception {
    Prompt prompt = new Prompt(System.in);
    //new MainMenu(prompt).execute();

    AssignmentRepository assignmentRepository = new AssignmentRepository();
    ObjectRepository boardRepository = new ObjectRepository();
    ObjectRepository greetingRepository = new ObjectRepository();
    MemberRepository memberRepository = new MemberRepository();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup assignmentMenu = new MenuGroup("과제");
    assignmentMenu.add(new MenuItem("등록", new AssignmentAddHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("조회", new AssignmentViewHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("변경", new AssignmentModifyHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("삭제", new AssignmentDeleteHandler(assignmentRepository, prompt)));
    assignmentMenu.add(new MenuItem("목록", new AssignmentListHandler(assignmentRepository)));
    mainMenu.add(assignmentMenu);

    MenuGroup boardMenu = new MenuGroup("게시글");
    boardMenu.add(new MenuItem("등록", new BoardAddHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("조회", new BoardViewHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("변경", new BoardModifyHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("삭제", new BoardDeleteHandler(boardRepository, prompt)));
    boardMenu.add(new MenuItem("목록", new BoardListHandler(boardRepository)));
    mainMenu.add(boardMenu);

    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem("등록", new MemberAddHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("조회", new MemberViewHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("변경", new MemberModifyHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("삭제", new MemberDeleteHandler(memberRepository, prompt)));
    memberMenu.add(new MenuItem("목록", new MemberListHandler(memberRepository)));
    mainMenu.add(memberMenu);

    MenuGroup greetingMenu = new MenuGroup("가입인사");
    greetingMenu.add(new MenuItem("등록", new BoardAddHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("조회", new BoardViewHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("변경", new BoardModifyHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("삭제", new BoardDeleteHandler(greetingRepository, prompt)));
    greetingMenu.add(new MenuItem("목록", new BoardListHandler(greetingRepository)));
    mainMenu.add(greetingMenu);

    mainMenu.add(new MenuItem("도움말", new HelpHandler()));

    mainMenu.execute(prompt);

    prompt.close();
  }
}
