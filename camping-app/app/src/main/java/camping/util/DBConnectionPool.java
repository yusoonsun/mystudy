package camping.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool implements ConnectionPool {

  private static final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

  ArrayList<Connection> connections = new ArrayList<>();
  private String jdbcUrl;
  private String username;
  private String password;

  public DBConnectionPool(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  public Connection getConnection() throws Exception {

    Connection con = connectionThreadLocal.get();

    if (con == null) {

      if (connections.size() > 0) {

        con = connections.remove(0);
        System.out.printf("%s: DB 커넥션풀에서 꺼냄\n", Thread.currentThread().getName());

      } else {

        con = new ConnectionProxy(DriverManager.getConnection(jdbcUrl, username, password), this);
        System.out.printf("%s: DB 커넥션 생성\n", Thread.currentThread().getName());
      }


      connectionThreadLocal.set(con);

    } else {
      System.out.printf("%s: 스레드에 보관된 DB 커넥션 리턴\n", Thread.currentThread().getName());
    }

    return con;
  }

  public void returnConnection(Connection con) {

    connectionThreadLocal.remove();

    connections.add(con);

    System.out.printf("%s: DB 커넥션을 커넥션풀에 반환\n", Thread.currentThread().getName());
  }

  public void closeAll() {
    for (Connection con : connections) {
      ((ConnectionProxy) con).realClose();
    }
  }
}
