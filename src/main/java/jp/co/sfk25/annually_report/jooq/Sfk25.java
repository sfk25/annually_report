/*
 * This file is generated by jOOQ.
*/
package jp.co.sfk25.annually_report.jooq;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jp.co.sfk25.annually_report.jooq.tables.Articles;
import jp.co.sfk25.annually_report.jooq.tables.ArticlesTags;
import jp.co.sfk25.annually_report.jooq.tables.Comments;
import jp.co.sfk25.annually_report.jooq.tables.FlywaySchemaHistory;
import jp.co.sfk25.annually_report.jooq.tables.Likes;
import jp.co.sfk25.annually_report.jooq.tables.Tags;
import jp.co.sfk25.annually_report.jooq.tables.Users;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sfk25 extends SchemaImpl {

    private static final long serialVersionUID = -1389880605;

    /**
     * The reference instance of <code>sfk25</code>
     */
    public static final Sfk25 SFK25 = new Sfk25();

    /**
     * The table <code>sfk25.articles</code>.
     */
    public final Articles ARTICLES = jp.co.sfk25.annually_report.jooq.tables.Articles.ARTICLES;

    /**
     * The table <code>sfk25.articles_tags</code>.
     */
    public final ArticlesTags ARTICLES_TAGS = jp.co.sfk25.annually_report.jooq.tables.ArticlesTags.ARTICLES_TAGS;

    /**
     * The table <code>sfk25.comments</code>.
     */
    public final Comments COMMENTS = jp.co.sfk25.annually_report.jooq.tables.Comments.COMMENTS;

    /**
     * The table <code>sfk25.flyway_schema_history</code>.
     */
    public final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = jp.co.sfk25.annually_report.jooq.tables.FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>sfk25.likes</code>.
     */
    public final Likes LIKES = jp.co.sfk25.annually_report.jooq.tables.Likes.LIKES;

    /**
     * The table <code>sfk25.tags</code>.
     */
    public final Tags TAGS = jp.co.sfk25.annually_report.jooq.tables.Tags.TAGS;

    /**
     * The table <code>sfk25.users</code>.
     */
    public final Users USERS = jp.co.sfk25.annually_report.jooq.tables.Users.USERS;

    /**
     * No further instances allowed
     */
    private Sfk25() {
        super("sfk25", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Articles.ARTICLES,
            ArticlesTags.ARTICLES_TAGS,
            Comments.COMMENTS,
            FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
            Likes.LIKES,
            Tags.TAGS,
            Users.USERS);
    }
}