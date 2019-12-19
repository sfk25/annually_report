package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.controller.model.ArticleRegisterModel;
import jp.co.sfk25.annually_report.jooq.tables.*;
import jp.co.sfk25.annually_report.jooq.tables.records.ArticlesRecord;
import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.form.ArticleConds;

import org.jooq.*;
import org.jooq.impl.DSL;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.List;

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

    private Articles a = ARTICLES;
    private Users u = USERS;
    private Groups g = GROUPS;
    private ArticlesTags at = ARTICLES_TAGS;
    private ArticlesProcesses ap = ARTICLES_PROCESSES;


    public Record findOne(int id) {
        // 結合
        SelectQuery<Record> query = joinTable();

        // 条件
        ArticleConds articleConds = new ArticleConds();
        articleConds.setId(id);
        addConds(query, articleConds);

        return query.fetchOne();
    }

    public List<Article> findAll() {
        return dslContext.selectFrom(a).fetch(this::toEntity);
    }

    public Result<Record> findByConds(ArticleConds articleConds) {
        // 結合
        SelectQuery<Record> query = joinTable();

        // 条件
        addConds(query, articleConds);

        return query.fetch();
    }

    public Article insert(Article article) {
        return toEntity(dslContext.insertInto(a)
                .set(toRecord(article))
                .returning()
                .fetchOne());
    }

    public void update(ArticleRegisterModel articleRegisterModel) {
        dslContext.update(a)
                .set(a.TITLE, articleRegisterModel.getTitle())
                .set(a.CREATED_YEAR, articleRegisterModel.getCreatedYear())
                .set(a.VALUE, articleRegisterModel.getValue())
                .set(a.UPDATED_AT, articleRegisterModel.getUpdatedAt())
                .where(a.ID.equal(articleRegisterModel.getId()))
                .execute();
    }

    private SelectQuery<Record> joinTable() {
        Table atv = getTagsTable();
        Table apv = getProcessesTable();

        return dslContext.select().from(a)
                .join(u).on(a.USER_ID.eq(u.ID))
                .join(g).on(u.GROUP_ID.eq(g.ID))
                .leftJoin(apv).on(a.ID.eq(apv.field("article_id")))
                .leftJoin(atv).on(a.ID.eq(atv.field("article_id")))
                .getQuery();
    }

    private Table getProcessesTable() {
        /**
         * 記事に紐づく工程の名前を結合したテーブル
         * .ex)
         * +------------+----------------+
         * |  article_id|       processes|
         * +------------+----------------+
         * |           1| 要件定義,設計,実装|
         * +------------+----------------+
         */
        return dslContext.select(ap.ARTICLE_ID, DSL.field("GROUP_CONCAT(processes.id SEPARATOR ',')").as("processes"))
                .from(ap)
                .join(PROCESSES).on(ap.PROCESS_ID.eq(PROCESSES.ID))
                .groupBy(ap.ARTICLE_ID)
                .asTable("articles_processes_value");
    }

    private Table getTagsTable() {
        /**
         * 記事に紐づく技術の名前を結合したテーブル
         * .ex)
         * +------------+-------------+
         * |  article_id|         tags|
         * +------------+-------------+
         * |           1| Java,PHP,git|
         * +------------+-------------+
         */
        return dslContext.select(at.ARTICLE_ID, DSL.field("GROUP_CONCAT(tags.value SEPARATOR ',')").as("tags"))
                .from(at)
                .join(TAGS).on(at.TAG_ID.eq(TAGS.ID))
                .groupBy(at.ARTICLE_ID)
                .asTable("articles_tags_value");
    }

    private void addConds(SelectQuery<Record> query, ArticleConds articleConds) {
        // ID
        if(articleConds.getId() != null && articleConds.getId() > 0){
            Condition condition = a.ID.equal(articleConds.getId());
            query.addConditions(Operator.AND, condition);
        }

        // タイトル
        if(!StringUtils.isEmpty(articleConds.getTitle())){
            Condition condition = a.TITLE.contains(articleConds.getTitle());
            query.addConditions(Operator.AND, condition);
        }

        // グループID
        if(articleConds.getGroupId() > 0){
            Condition condition = g.ID.eq(articleConds.getGroupId());
            query.addConditions(Operator.AND, condition);
        }

        // ユーザー名
        if(!StringUtils.isEmpty(articleConds.getUserName())){
            Condition condition = u.NAME.contains(articleConds.getUserName());
            query.addConditions(Operator.AND, condition);
        }

        // 対象年度
        if(!StringUtils.isEmpty(articleConds.getTargetYear())){
            Condition condition = a.CREATED_YEAR.eq(Integer.parseInt(articleConds.getTargetYear()));
            query.addConditions(Operator.AND, condition);
        }

        // 使用した技術
        if(!StringUtils.isEmpty(articleConds.getTag())){
            Table table =  dslContext.select().from(at)
                    .join(TAGS).on(at.TAG_ID.eq(TAGS.ID))
                    .where(TAGS.VALUE.eq(articleConds.getTag()))
                    .asTable();

            query.addJoin(table, JoinType.JOIN, table.field("article_id").eq(a.ID));
        }

        // 担当した工程
        if(articleConds.getProcessId() > 0){
            Table table =  dslContext.select().from(ap)
                    .where(ap.PROCESS_ID.eq(articleConds.getProcessId()))
                    .asTable();

            query.addJoin(table, JoinType.JOIN, table.field("article_id").eq(a.ID));
        }
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

    private ArticlesRecord toRecord(Article article) {
        return new ArticlesRecord(
                article.getId(),
                article.getUserId(),
                article.getTitle(),
                article.getValue(),
                Timestamp.valueOf(article.getCreatedAt()),
                Timestamp.valueOf(article.getUpdatedAt()),
                article.getCreatedYear());
    }

}
