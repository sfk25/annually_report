package jp.co.sfk25.annually_report.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Value
@RequiredArgsConstructor(staticName = "of")
public class User {

  private int id;

  @NonNull
  private String name;

  @NonNull
  private String password;

  @NonNull
  private LocalDateTime created_at;

  @NonNull
  private LocalDateTime updated_at;

  public static User create(int id, String name, String password) {
    LocalDateTime now = LocalDateTime.now();
    return new User(id, name, password, now, now);
  }
}
