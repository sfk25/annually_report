package jp.co.sfk25.annually_report.domain.entity;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;

@Value
@RequiredArgsConstructor(staticName = "of")
public class ArticleProcess {

  private final Integer articleId;

  @NonNull
  private final Integer processId;

  public static ArticleProcess create(Integer articleId, Integer processId) {
    return ArticleProcess.of(articleId, processId);
  }
}
