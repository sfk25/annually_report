/*
 * This file is generated by jOOQ.
*/
package jp.co.sfk25.annually_report.jooq.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jp.co.sfk25.annually_report.jooq.Indexes;
import jp.co.sfk25.annually_report.jooq.Keys;
import jp.co.sfk25.annually_report.jooq.Sfk25;
import jp.co.sfk25.annually_report.jooq.tables.records.ArticlesRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Articles extends TableImpl<ArticlesRecord> {

    private static final long serialVersionUID = -255719866;

    /**
     * The reference instance of <code>sfk25.articles</code>
     */
    public static final Articles ARTICLES = new Articles();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ArticlesRecord> getRecordType() {
        return ArticlesRecord.class;
    }

    /**
     * The column <code>sfk25.articles.id</code>.
     */
    public final TableField<ArticlesRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>sfk25.articles.user_id</code>.
     */
    public final TableField<ArticlesRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>sfk25.articles.tag_ids</code>.
     */
    public final TableField<ArticlesRecord, String> TAG_IDS = createField("tag_ids", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>sfk25.articles.title</code>.
     */
    public final TableField<ArticlesRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>sfk25.articles.value</code>.
     */
    public final TableField<ArticlesRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>sfk25.articles.created_at</code>.
     */
    public final TableField<ArticlesRecord, Timestamp> CREATED_AT = createField("created_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>sfk25.articles.updated_at</code>.
     */
    public final TableField<ArticlesRecord, Timestamp> UPDATED_AT = createField("updated_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * Create a <code>sfk25.articles</code> table reference
     */
    public Articles() {
        this(DSL.name("articles"), null);
    }

    /**
     * Create an aliased <code>sfk25.articles</code> table reference
     */
    public Articles(String alias) {
        this(DSL.name(alias), ARTICLES);
    }

    /**
     * Create an aliased <code>sfk25.articles</code> table reference
     */
    public Articles(Name alias) {
        this(alias, ARTICLES);
    }

    private Articles(Name alias, Table<ArticlesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Articles(Name alias, Table<ArticlesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Sfk25.SFK25;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ARTICLES_IDX_ARTICLE, Indexes.ARTICLES_IDX_ARTICLE_VALUE, Indexes.ARTICLES_PRIMARY, Indexes.ARTICLES_USER_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ArticlesRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ARTICLES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ArticlesRecord> getPrimaryKey() {
        return Keys.KEY_ARTICLES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ArticlesRecord>> getKeys() {
        return Arrays.<UniqueKey<ArticlesRecord>>asList(Keys.KEY_ARTICLES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ArticlesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ArticlesRecord, ?>>asList(Keys.ARTICLES_IBFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Articles as(String alias) {
        return new Articles(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Articles as(Name alias) {
        return new Articles(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Articles rename(String name) {
        return new Articles(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Articles rename(Name name) {
        return new Articles(name, null);
    }
}
