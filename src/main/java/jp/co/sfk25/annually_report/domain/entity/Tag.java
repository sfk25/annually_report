package jp.co.sfk25.annually_report.domain.entity;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;

@Value
@RequiredArgsConstructor(staticName = "of")
public class Tag {

  private final Integer id;

  @NonNull
  private final String value;

  public static Tag create(Integer id, String value) {
    return Tag.of(id, value);
  }
}
