package bitcamp.myapp;

import java.io.InputStream;
import java.util.Scanner;

public class Prompt {

  Scanner keyIn;

  public Prompt(InputStream in) {
    keyIn = new Scanner(in);
  }

  String input(String title, Object... args) {
    System.out.printf(String.format(title, args));
    return this.keyIn.nextLine();
  }

  void close() {
    this.keyIn.close();
  }
}
