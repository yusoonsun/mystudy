package bitcamp.myapp.Handler.Member;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Member;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

public class MemberAddHandler implements MenuHandler {

  MemberRepository memberRepository;
  Prompt prompt;

  public MemberAddHandler(MemberRepository memberRepository, Prompt prompt) {
    this.memberRepository = memberRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    Member member = new Member();
    member.email = this.prompt.input("이메일? ");
    member.name = this.prompt.input("이름? ");
    member.password = this.prompt.input("암호? ");
    member.createdDate = this.prompt.input("가입일? ");

    memberRepository.add(member);
  }
}
