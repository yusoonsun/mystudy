package com.eomcs.web.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서블릿 클래스를 만들 때 HTTP 프로토콜을 쉽게 다룰 수 있도록
// service(HttpServletRequest,HttpServletResponse) 메서드를 추가하였다.
// 따라서 GenericServlet을 상속 받아 서블릿을 만들기 보다
// 이 클래스를 상속 받아 서블릿을 만든다면,
// 훨씬 편하게 service()를 구현할 수 있다.
//

public abstract class MyHttpServlet2 extends GenericServlet {

  @Override
  public void service(ServletRequest servletRequest, ServletResponse servletResponse)
      throws ServletException, IOException {
    service((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
    }
    // 서블릿 컨테이너가 이 메서드를 호출하면

    // => 파라미터 값을 원래의 타입으로 변환한다.
//    HttpServletRequest request = (HttpServletRequest) req;
//    HttpServletResponse response = (HttpServletResponse) res;

    // => 오버로딩한 service()를 호출한다.
//    this.service(request, response);

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getMethod().equals("GET")) {
      doGet(request, response);
    } else if (request.getMethod().equals("POST")) {
      doPost(request, response);
    } else {
      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("해당 메서드를 지원하지 않습니다. ");
    }
    // 웹브라우저가 요청하면
    // => 서블릿 컨테이너가 service(ServletRequest,ServletResponse)를 호출한다.
    // => service(ServletRequest,ServletResponse)는
    //    다시 오버로딩한 이 메서드를 호출한다.
    //    현재 이 메서드는 아무런 일을 하지 않는다.
    //    이 클래스를 상속 받는 서브 클래스 쪽에서 이 메서드를 오버라이딩 하면 된다.
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException  {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("아직 구현하지 않았습니다. ");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException  {
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("아직 구현하지 않았습니다. ");
  }

}

