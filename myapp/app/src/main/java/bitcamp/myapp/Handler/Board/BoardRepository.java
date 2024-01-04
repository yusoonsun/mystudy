package bitcamp.myapp.handler.board;

import bitcamp.myapp.vo.Board;

public class BoardRepository {

  Board[] boards = new board[3];
  int length = 0;

  public void add(Board board) {
    if (this.length == this.boards.length) {
      int oldSize = this.boards.length;
      int newSize = oldSize + (oldSize >> 1);

      Board[] arr = new Board[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.boards[i];
      }

      this.boards = arr;
    }

    this.boards[this.length++] = Board;
  }

  public Board remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Board deleted = this.boards[index];

    for (int i = index; i < (this.length - 1); i++) {
      this.boards[i] = this.boards[i + 1];
    }
    this.boards[--this.length] = null;

    return deleted;
  }

  public Board[] toArray() {
    Board[] arr = new Board[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.boards[i];
    }
    return arr;
  }

  public Board get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    return this.boards[index];
  }

  public Board set(int index, Board board) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Board old = this.boards[index];
    this.boards[index] = board;

    return old;
  }
}
