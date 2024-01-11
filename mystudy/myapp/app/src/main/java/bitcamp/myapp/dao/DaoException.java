package bitcamp.myapp.dao;

public class DaoException extends RuntimeException {

  public DaoException() {

  }

  public DaoException(String message) {
    super(message);
  }

  public DaoException(String s, Exception e) {
  }

  public DaoException(Throwable cause) {
    super(cause);
  }

  public DaoException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
