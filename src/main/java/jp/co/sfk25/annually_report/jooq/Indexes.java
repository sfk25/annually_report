/*
 * This file is generated by jOOQ.
*/
package jp.co.sfk25.annually_report.jooq;


import javax.annotation.Generated;

import jp.co.sfk25.annually_report.jooq.tables.Articles;
import jp.co.sfk25.annually_report.jooq.tables.ArticlesProcesses;
import jp.co.sfk25.annually_report.jooq.tables.ArticlesTags;
import jp.co.sfk25.annually_report.jooq.tables.Comments;
import jp.co.sfk25.annually_report.jooq.tables.FlywaySchemaHistory;
import jp.co.sfk25.annually_report.jooq.tables.Groups;
import jp.co.sfk25.annually_report.jooq.tables.Likes;
import jp.co.sfk25.annually_report.jooq.tables.Processes;
import jp.co.sfk25.annually_report.jooq.tables.Tags;
import jp.co.sfk25.annually_report.jooq.tables.Users;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>sfk25</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index ARTICLES_IDX_ARTICLE = Indexes0.ARTICLES_IDX_ARTICLE;
    public static final Index ARTICLES_IDX_ARTICLE_VALUE = Indexes0.ARTICLES_IDX_ARTICLE_VALUE;
    public static final Index ARTICLES_PRIMARY = Indexes0.ARTICLES_PRIMARY;
    public static final Index ARTICLES_USER_ID = Indexes0.ARTICLES_USER_ID;
    public static final Index ARTICLES_PROCESSES_PRIMARY = Indexes0.ARTICLES_PROCESSES_PRIMARY;
    public static final Index ARTICLES_TAGS_PRIMARY = Indexes0.ARTICLES_TAGS_PRIMARY;
    public static final Index COMMENTS_PRIMARY = Indexes0.COMMENTS_PRIMARY;
    public static final Index FLYWAY_SCHEMA_HISTORY_FLYWAY_SCHEMA_HISTORY_S_IDX = Indexes0.FLYWAY_SCHEMA_HISTORY_FLYWAY_SCHEMA_HISTORY_S_IDX;
    public static final Index FLYWAY_SCHEMA_HISTORY_PRIMARY = Indexes0.FLYWAY_SCHEMA_HISTORY_PRIMARY;
    public static final Index GROUPS_PRIMARY = Indexes0.GROUPS_PRIMARY;
    public static final Index LIKES_PRIMARY = Indexes0.LIKES_PRIMARY;
    public static final Index PROCESSES_PRIMARY = Indexes0.PROCESSES_PRIMARY;
    public static final Index TAGS_PRIMARY = Indexes0.TAGS_PRIMARY;
    public static final Index USERS_IDX_USERNAME = Indexes0.USERS_IDX_USERNAME;
    public static final Index USERS_PRIMARY = Indexes0.USERS_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index ARTICLES_IDX_ARTICLE = Internal.createIndex("idx_article", Articles.ARTICLES, new OrderField[] { Articles.ARTICLES.TITLE }, false);
        public static Index ARTICLES_IDX_ARTICLE_VALUE = Internal.createIndex("idx_article_value", Articles.ARTICLES, new OrderField[] { Articles.ARTICLES.VALUE }, false);
        public static Index ARTICLES_PRIMARY = Internal.createIndex("PRIMARY", Articles.ARTICLES, new OrderField[] { Articles.ARTICLES.ID }, true);
        public static Index ARTICLES_USER_ID = Internal.createIndex("user_id", Articles.ARTICLES, new OrderField[] { Articles.ARTICLES.USER_ID }, false);
        public static Index ARTICLES_PROCESSES_PRIMARY = Internal.createIndex("PRIMARY", ArticlesProcesses.ARTICLES_PROCESSES, new OrderField[] { ArticlesProcesses.ARTICLES_PROCESSES.ARTICLE_ID, ArticlesProcesses.ARTICLES_PROCESSES.PROCESS_ID }, true);
        public static Index ARTICLES_TAGS_PRIMARY = Internal.createIndex("PRIMARY", ArticlesTags.ARTICLES_TAGS, new OrderField[] { ArticlesTags.ARTICLES_TAGS.ARTICLE_ID, ArticlesTags.ARTICLES_TAGS.TAG_ID }, true);
        public static Index COMMENTS_PRIMARY = Internal.createIndex("PRIMARY", Comments.COMMENTS, new OrderField[] { Comments.COMMENTS.ID }, true);
        public static Index FLYWAY_SCHEMA_HISTORY_FLYWAY_SCHEMA_HISTORY_S_IDX = Internal.createIndex("flyway_schema_history_s_idx", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.SUCCESS }, false);
        public static Index FLYWAY_SCHEMA_HISTORY_PRIMARY = Internal.createIndex("PRIMARY", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, new OrderField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
        public static Index GROUPS_PRIMARY = Internal.createIndex("PRIMARY", Groups.GROUPS, new OrderField[] { Groups.GROUPS.ID }, true);
        public static Index LIKES_PRIMARY = Internal.createIndex("PRIMARY", Likes.LIKES, new OrderField[] { Likes.LIKES.ARTICLE_ID, Likes.LIKES.USER_ID }, true);
        public static Index PROCESSES_PRIMARY = Internal.createIndex("PRIMARY", Processes.PROCESSES, new OrderField[] { Processes.PROCESSES.ID }, true);
        public static Index TAGS_PRIMARY = Internal.createIndex("PRIMARY", Tags.TAGS, new OrderField[] { Tags.TAGS.ID }, true);
        public static Index USERS_IDX_USERNAME = Internal.createIndex("idx_username", Users.USERS, new OrderField[] { Users.USERS.NAME }, false);
        public static Index USERS_PRIMARY = Internal.createIndex("PRIMARY", Users.USERS, new OrderField[] { Users.USERS.ID }, true);
    }
}
