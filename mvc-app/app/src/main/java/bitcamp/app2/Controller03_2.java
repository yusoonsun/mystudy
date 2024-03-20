package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/c03_2")
@SessionAttributes({"name2", "age2"})
public class Controller03_2 {
  @GetMapping(value = "h1", produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String handler1(Model model) {

    // Model 객체에 값을 담으면 프론트 컨트롤러는 ServletRequest 보관소에 값을 옮긴다.
    // 만약 @SessionAttributes 에서 지정한 이름의 값이라면
    // HttpSession 객체에도 보관된다.
    model.addAttribute("name2", "임꺽정");
    model.addAttribute("age2", "30");

    // @SessionAttributes에 등록되지 않은 이름의 값은 세션에 보관되지 않는다.
    model.addAttribute("tel2", "1111-2222");

    return "세션에 값 보관했음!";

  }

  @GetMapping(value = "h2", produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2(HttpSession session) {
    return String.format("name=%s, age=%s, name2=%s, age2=%s, tel2=%s",
        session.getAttribute("name"),
        session.getAttribute("age"),
        session.getAttribute("name2"),
        session.getAttribute("age2"),
        session.getAttribute("tel2"));
  }

  @GetMapping(value = "h3", produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String handler3(HttpSession session) {
    session.invalidate();
    return "세션 무효화되었음!";
  }

  @GetMapping(value = "h4", produces = "text/plain;charset=UTF-8")
  @ResponseBody
  public String handler4(
      // 세션에는 보관되어 있지만,
      // 현재 페이지 컨트롤러의 @SessionAttributes에 지정되지 않은 값 꺼내기
      @ModelAttribute("name") String name,
      @ModelAttribute("age") String age,

      // 세션에 보관되어 있고,
      // 현재 페이지 컨트롤러의 @SessionAttributes에 지정된 값 꺼내기
      @ModelAttribute("name2") String name2,
      @ModelAttribute("age2") String age2,

      // 세션에 보관되어 있지 않고,
      // 현재 페이지 컨트롤러의 @SessionAttributes에 지정되지 않은 값 꺼내기
      @ModelAttribute("tel2") String tel2) {

    // @ModelAttribute
    // 1. @SessionAttributes에 지정된 이름인 경우,
    //   1) 무조건 HttpSession 객체에서 값을 꺼내 넘긴다.
    ///     만약 없다면, 예외 발생!
    // 2. @SessionAttributes에 지정된 이름이 아닌 경우,
    //   2) 요청 파라미터의 값을 꺼내 넘긴다.
    //   3) 없으면, 빈 문자열을 넘긴다.

    return String.format("name=%s, age=%s, name2=%s, age2=%s, tel2=%s",
        name, age, name2, age2, tel2);
  }
}
