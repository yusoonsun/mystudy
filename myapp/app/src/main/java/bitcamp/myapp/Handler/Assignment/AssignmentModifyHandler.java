package bitcamp.myapp.Handler.Assignment;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class AssignmentModifyHandler implements MenuHandler {

  AssignmentRepository assignmentRepository;
  Prompt prompt;

  public AssignmentModifyHandler(AssignmentRepository assignmentRepository, Prompt prompt) {
    this.assignmentRepository = assignmentRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    int index = this.prompt.inputInt("번호? ");
    Assignment oldAssignment = this.assignmentRepository.get(index);
    if (oldAssignment == null) {
      System.out.println("과제 번호가 유효하지 않습니다.");
      return;
    }

    Assignment assignment = new Assignment();
    assignment.title = this.prompt.input("과제명(%s)? ", oldAssignment.title);
    assignment.content = this.prompt.input("내용(%s)? ", oldAssignment.content);
    assignment.deadline = this.prompt.input("제출 마감일(%s)? ", oldAssignment.deadline);

    this.assignmentRepository.set(index, oldAssignment);
  }
}
