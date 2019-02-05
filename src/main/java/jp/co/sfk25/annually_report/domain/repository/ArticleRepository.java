package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.jooq.tables.records.ArticlesRecord;
import jp.co.sfk25.annually_report.jooq.tables.records.UsersRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jp.co.sfk25.annually_report.jooq.tables.Articles.ARTICLES;

/**
 * Articleリポジトリ
 */
@Repository
@RequiredArgsConstructor
public class ArticleRepository {

    private final DSLContext dslContext;

    public Article findOne(int id) {
        return dslContext.selectFrom(ARTICLES).where(ARTICLES.ID.eq(id)).fetchOne(this::toEntity);
    }

    public List<Article> findAll() {
        return dslContext.selectFrom(ARTICLES).fetch(this::toEntity);
    }

    private Article toEntity(ArticlesRecord record) {
        return Article.of(
                record.getId(),
                record.getUserId(),
                record.getTitle(),
                record.getValue(),
                record.getCreatedAt().toLocalDateTime(),
                record.getUpdatedAt().toLocalDateTime());
    }
}
