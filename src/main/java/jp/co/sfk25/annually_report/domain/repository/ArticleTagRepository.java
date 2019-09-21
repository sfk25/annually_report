package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.domain.entity.ArticleTag;
import jp.co.sfk25.annually_report.jooq.tables.records.ArticlesTagsRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jp.co.sfk25.annually_report.jooq.tables.ArticlesTags.ARTICLES_TAGS;

/**
 * ArticleTagリポジトリ
 */
@Repository
@RequiredArgsConstructor
public class ArticleTagRepository {

    private final DSLContext dslContext;

    public ArticleTag findOne(int id) {
        return dslContext.selectFrom(ARTICLES_TAGS).where(ARTICLES_TAGS.ARTICLE_ID.eq(id)).fetchOne(this::toEntity);
    }

    public List<ArticleTag> findAll() {
        return dslContext.selectFrom(ARTICLES_TAGS).fetch(this::toEntity);
    }

    private ArticleTag toEntity(ArticlesTagsRecord record) {
        return ArticleTag.of(
                record.getArticleId(),
                record.getTagId());
    }

    public Integer insert(Integer articleId, Integer tagId) {
        return dslContext.insertInto(ARTICLES_TAGS, ARTICLES_TAGS.ARTICLE_ID, ARTICLES_TAGS.TAG_ID)
                .values(articleId, tagId)
                .execute();
    }

    public void update(Integer articleId, Integer tagId) {
        // TODO updateの方法
        delete(articleId);
        insert(articleId,tagId);
    }

    public void delete(Integer articleId) {
        dslContext
                .delete(ARTICLES_TAGS)
                .where(ARTICLES_TAGS.ARTICLE_ID.equal(articleId))
                .execute();
    }

}
