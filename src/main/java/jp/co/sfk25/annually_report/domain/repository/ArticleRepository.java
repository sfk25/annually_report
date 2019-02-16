package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.jooq.tables.Articles;
import jp.co.sfk25.annually_report.jooq.tables.Users;
import jp.co.sfk25.annually_report.jooq.tables.records.ArticlesRecord;
import jp.co.sfk25.annually_report.domain.entity.Article;
import jp.co.sfk25.annually_report.controller.Conds;
import jp.co.sfk25.annually_report.jooq.tables.records.UsersRecord;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import lombok.RequiredArgsConstructor;
import java.util.List;
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



    public List<Article> findByConds(Conds conds) {
        Articles a = ARTICLES.as("a");
        // TODO group追加
        Users c = USERS.as("c");
        // TODO targetYear追加
        // TODO tagId追加
        // TODO processId追加


        SelectQuery<ArticlesRecord> query = dslContext.selectFrom(a).getQuery();

        // title
        if(!StringUtils.isEmpty(conds.getTitle())){
            Condition condition = a.TITLE.like("%" + conds.getTitle() + "%");
            query.addConditions(Operator.AND, condition);
        }

        // groupId

        // userName
        if(!StringUtils.isEmpty(conds.getUserName())) {
//            query.addJoin(c, a.USER_ID.eq(c.ID));
            Table<Record> g = a.join(c).on(c.ID.eq(a.USER_ID)).as("g");
            Condition condition = g.field("user_id").eq(conds.getUserName());
            query.addConditions(Operator.AND, condition);

//            Table<UsersRecord> subQuery =
//                    dslContext.selectFrom(c).where(c.NAME.like("%" + conds.getUserName() + "%")).asTable("subQuery");

//            System.out.println("=================================");
////            System.out.println();
//
//            Condition condition = a.join(subQuery).on(a.USER_ID.equal(subQuery.field("id")));
//            query.addConditions(Operator.AND, condition);

//            query.addJoin(subQuery, c.ID.equal(a.USER_ID));
//            query.addJoin(subQuery, subQuery.field("id").equal(a.USER_ID);
        }



        // targetYear

        // tagId

        // processId

        return query.fetch(this::toEntity);
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
