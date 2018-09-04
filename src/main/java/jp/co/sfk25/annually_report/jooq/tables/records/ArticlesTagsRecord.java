/*
 * This file is generated by jOOQ.
*/
package jp.co.sfk25.annually_report.jooq.tables.records;


import javax.annotation.Generated;

import jp.co.sfk25.annually_report.jooq.tables.ArticlesTags;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ArticlesTagsRecord extends UpdatableRecordImpl<ArticlesTagsRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = -707186180;

    /**
     * Setter for <code>sfk25.articles_tags.article_id</code>.
     */
    public void setArticleId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>sfk25.articles_tags.article_id</code>.
     */
    public Integer getArticleId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>sfk25.articles_tags.tag_id</code>.
     */
    public void setTagId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>sfk25.articles_tags.tag_id</code>.
     */
    public Integer getTagId() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return ArticlesTags.ARTICLES_TAGS.ARTICLE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return ArticlesTags.ARTICLES_TAGS.TAG_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getArticleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getTagId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getArticleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getTagId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticlesTagsRecord value1(Integer value) {
        setArticleId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticlesTagsRecord value2(Integer value) {
        setTagId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticlesTagsRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ArticlesTagsRecord
     */
    public ArticlesTagsRecord() {
        super(ArticlesTags.ARTICLES_TAGS);
    }

    /**
     * Create a detached, initialised ArticlesTagsRecord
     */
    public ArticlesTagsRecord(Integer articleId, Integer tagId) {
        super(ArticlesTags.ARTICLES_TAGS);

        set(0, articleId);
        set(1, tagId);
    }
}
