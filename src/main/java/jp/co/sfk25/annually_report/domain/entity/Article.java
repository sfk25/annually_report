package jp.co.sfk25.annually_report.domain.entity;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Value
@RequiredArgsConstructor(staticName = "of")
public class Article {

  private final Integer id;

  @NonNull
  private final Integer userId;

  @NonNull
  private final String title;

  @NonNull
  private final String value;

  @NonNull
  private final Integer createdYear;

  @NonNull
  private final LocalDateTime createdAt;

  @NonNull
  private final LocalDateTime updatedAt;

  public static Article create(Integer id, Integer userId, String title, String value, int createdYear) {
    LocalDateTime now = LocalDateTime.now();
    return Article.of(id, userId, title, value, createdYear, now, now);
  }
}
