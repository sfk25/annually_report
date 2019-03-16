package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.jooq.tables.Articles;
import jp.co.sfk25.annually_report.jooq.tables.Users;
import jp.co.sfk25.annually_report.jooq.tables.records.ArticlesRecord;
import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.form.ArticleConds;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

import org.jooq.*;

import static jp.co.sfk25.annually_report.jooq.tables.Articles.ARTICLES;
import static jp.co.sfk25.annually_report.jooq.tables.Users.USERS;

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


    // TODO 他のテーブルの情報も取得してえ
    public List<Article> findByConds(ArticleConds articleConds) {
        Articles a = ARTICLES.as("a");
        // TODO group追加
        Users c = USERS.as("c");
        // TODO targetYear追加
        // TODO tagId追加
        // TODO processId追加


        SelectQuery<Record> query = dslContext.select(a.fields()).from(a).getQuery();
//        SelectQuery<?> query = dslContext.select(a.ID, a.TITLE, a.USER_ID, a.VALUE, c.NAME).from(a).getQuery();
//        query.addJoin(c, a.USER_ID.eq(c.ID));
//        SelectQuery<Record> query = dslContext.select(Record2<"","">).from(a).getQuery();
//        SelectQuery<ArticlesRecord> query = dslContext.selectFrom(a).getQuery();

        // title
        if(!StringUtils.isEmpty(articleConds.getTitle())){
            Condition condition = a.TITLE.like("%" + articleConds.getTitle() + "%");
            query.addConditions(Operator.AND, condition);
        }

        // groupId

        // userName
        if(!StringUtils.isEmpty(articleConds.getUserName())) {
            Condition condition = c.NAME.eq(articleConds.getUserName());
            query.addConditions(Operator.AND, condition);
        }

        // targetYear

        // tagId

        // processId

//        System.out.println(query.getSQL());
//
//
//        Result<?> hoge = query.fetch();
//
//        System.out.println(hoge.getClass());
//        System.out.println(hoge.toArray());

//        return query.fetch(this::toEntity);
        return query.fetchInto(ArticlesRecord.class).stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
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
}
