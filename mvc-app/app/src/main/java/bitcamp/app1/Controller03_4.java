package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c03_4")
public class Controller03_4 {

  @PostMapping(consumes = "application/x-www-form-urlencoded")
  @ResponseBody
  public String handler1(String name, int age) {
      System.out.printf("%s : %d\n", name, age);
    return "handler1";
  }

  // 다음 메서드는 multipart/form-data 형식의 데이터를 소비한다.
  @PostMapping(consumes = "multipart/form-data")
  @ResponseBody
  public String handler2(String name, int age) {
    System.out.printf("%s : %d\n", name, age);
    return "handler2";
  }

  // 다음 메서드는 text/csv 형식의 데이터를 소비한다.
  @PostMapping(consumes = "text/csv")
  @ResponseBody
  public String handler3() {
    return "handler3";
  }

  // 다음 메서드는 application/json 형식의 데이터를 소비한다.
  @PostMapping(consumes = "application/json")
  @ResponseBody
  public String handler4() {
    return "handler4";
  }

  // 다음 메서드는 Content-Type 헤더가 없을 때 호출된다.
  @RequestMapping
  @ResponseBody
  public String handler5() {
    return "handler5";
  }
}
