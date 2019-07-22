package jp.co.sfk25.annually_report.domain.entity;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.lang.NonNull;

@Value
@RequiredArgsConstructor(staticName = "of")
public class ArticleTag {

  private final Integer articleId;

  @NonNull
  private final Integer tagId;

  public static ArticleTag create(Integer articleId, Integer tagId) {
    return ArticleTag.of(articleId, tagId);
  }
}
