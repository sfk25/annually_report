package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.jooq.tables.*;
import jp.co.sfk25.annually_report.jooq.tables.records.ArticlesRecord;
import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.form.ArticleConds;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

import org.jooq.*;

import static jp.co.sfk25.annually_report.jooq.tables.Articles.ARTICLES;
import static jp.co.sfk25.annually_report.jooq.tables.Groups.GROUPS;
import static jp.co.sfk25.annually_report.jooq.tables.Users.USERS;
import static jp.co.sfk25.annually_report.jooq.tables.ArticlesTags.ARTICLES_TAGS;
import static jp.co.sfk25.annually_report.jooq.tables.ArticlesProcesses.ARTICLES_PROCESSES;
import static jp.co.sfk25.annually_report.jooq.tables.Tags.TAGS;
import static jp.co.sfk25.annually_report.jooq.tables.Processes.PROCESSES;

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
                record.getCreatedYear(),
                record.getCreatedAt().toLocalDateTime(),
                record.getUpdatedAt().toLocalDateTime());
    }

    public Result<Record8<Integer, String, String, String, Object, Object, Integer, Timestamp>> findByConds(ArticleConds articleConds) {
        Articles a = ARTICLES.as("a");
        Users b = USERS.as("b");
        Groups c = GROUPS.as("c");
        ArticlesTags d = ARTICLES_TAGS.as("d");
        ArticlesProcesses e = ARTICLES_PROCESSES.as("e");

        /**
         * 記事に紐づく技術の名前を結合したテーブル
         * [
         *   {
         *     article_id: 1,
         *     tags: Java,PHP,git
         *   },,,
         * ]
         */
        Table f =  dslContext.select(d.ARTICLE_ID, DSL.field("GROUP_CONCAT(tags.value SEPARATOR ',')").as("tags")).from(d)
                .join(TAGS).on(d.TAG_ID.eq(TAGS.ID))
                .groupBy(d.ARTICLE_ID)
                .asTable("f");
        /**
         * 記事に紐づく工程の名前を結合したテーブル
         * [
         *   {
         *     article_id: 1,
         *     processes: 要件定義,設計,実装
         *   },,,
         * ]
         */
        Table g =  dslContext.select(e.ARTICLE_ID, DSL.field("GROUP_CONCAT(processes.value SEPARATOR ',')").as("processes")).from(e)
                .join(PROCESSES).on(e.PROCESS_ID.eq(PROCESSES.ID))
                .groupBy(e.ARTICLE_ID)
                .asTable("g");

        // 結合
        SelectQuery<Record8<Integer, String, String, String, Object, Object, Integer, Timestamp>> query =
                dslContext.select(a.ID, a.TITLE, b.NAME, c.VALUE, DSL.field("tags"), DSL.field("processes"), a.CREATED_YEAR, a.CREATED_AT)
                        .from(a)
                        .join(b).on(a.USER_ID.eq(b.ID))
                        .join(c).on(b.GROUP_ID.eq(c.ID))
                        .join(f).on(a.ID.eq(f.field("article_id")))
                        .join(g).on(a.ID.eq(g.field("article_id")))
                        .groupBy(a.ID)
                        .getQuery();

        // タイトル
        if(!StringUtils.isEmpty(articleConds.getTitle())){
            Condition condition = a.TITLE.like("%" + articleConds.getTitle() + "%");
            query.addConditions(Operator.AND, condition);
        }

        // グループID
        if(articleConds.getGroupId() > 0){
            Condition condition = c.ID.eq(articleConds.getGroupId());
            query.addConditions(Operator.AND, condition);
        }

        // ユーザー名
        if(!StringUtils.isEmpty(articleConds.getUserName())){
            Condition condition = b.NAME.eq(articleConds.getUserName());
            query.addConditions(Operator.AND, condition);
        }

        // 使用した技術
        if(!StringUtils.isEmpty(articleConds.getTag())){
            Table table =  dslContext.select().from(d)
                    .join(TAGS).on(d.TAG_ID.eq(TAGS.ID))
                    .where(TAGS.VALUE.eq(articleConds.getTag()))
                    .asTable();

            query.addJoin(table, JoinType.RIGHT_OUTER_JOIN, table.field("article_id").eq(a.ID));
        }

        // 担当した工程
        if(articleConds.getProcessId() > 0){
            Table table =  dslContext.select().from(e)
                    .where(e.PROCESS_ID.eq(articleConds.getProcessId()))
                    .asTable();

            query.addJoin(table, JoinType.RIGHT_OUTER_JOIN, table.field("article_id").eq(a.ID));
        }

        // 実行
        return query.fetch();
    }
}
