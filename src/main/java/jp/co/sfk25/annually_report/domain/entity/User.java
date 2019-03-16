package jp.co.sfk25.annually_report.domain.entity;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Value
@RequiredArgsConstructor(staticName = "of")
public class User {

  private final Integer id;

  @NonNull
  private final String name;

  @NonNull
  private final String password;

  @NonNull
  private final Integer group_id;

  @NonNull
  private final LocalDateTime created_at;

  @NonNull
  private final LocalDateTime updated_at;

  public static User create(String name, String password, int groupId) {
    LocalDateTime now = LocalDateTime.now();
    return User.of(null, name, password, groupId, now, now);
  }
}
