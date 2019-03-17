/*
 * This file is generated by jOOQ.
*/
package jp.co.sfk25.annually_report.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import jp.co.sfk25.annually_report.jooq.Indexes;
import jp.co.sfk25.annually_report.jooq.Keys;
import jp.co.sfk25.annually_report.jooq.Sfk25;
import jp.co.sfk25.annually_report.jooq.tables.records.ArticlesProcessesRecord;

import org.jooq.Field;
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
public class ArticlesProcesses extends TableImpl<ArticlesProcessesRecord> {

    private static final long serialVersionUID = -1992835451;

    /**
     * The reference instance of <code>sfk25.articles_processes</code>
     */
    public static final ArticlesProcesses ARTICLES_PROCESSES = new ArticlesProcesses();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ArticlesProcessesRecord> getRecordType() {
        return ArticlesProcessesRecord.class;
    }

    /**
     * The column <code>sfk25.articles_processes.article_id</code>.
     */
    public final TableField<ArticlesProcessesRecord, Integer> ARTICLE_ID = createField("article_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>sfk25.articles_processes.process_id</code>.
     */
    public final TableField<ArticlesProcessesRecord, Integer> PROCESS_ID = createField("process_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>sfk25.articles_processes</code> table reference
     */
    public ArticlesProcesses() {
        this(DSL.name("articles_processes"), null);
    }

    /**
     * Create an aliased <code>sfk25.articles_processes</code> table reference
     */
    public ArticlesProcesses(String alias) {
        this(DSL.name(alias), ARTICLES_PROCESSES);
    }

    /**
     * Create an aliased <code>sfk25.articles_processes</code> table reference
     */
    public ArticlesProcesses(Name alias) {
        this(alias, ARTICLES_PROCESSES);
    }

    private ArticlesProcesses(Name alias, Table<ArticlesProcessesRecord> aliased) {
        this(alias, aliased, null);
    }

    private ArticlesProcesses(Name alias, Table<ArticlesProcessesRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.ARTICLES_PROCESSES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ArticlesProcessesRecord> getPrimaryKey() {
        return Keys.KEY_ARTICLES_PROCESSES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ArticlesProcessesRecord>> getKeys() {
        return Arrays.<UniqueKey<ArticlesProcessesRecord>>asList(Keys.KEY_ARTICLES_PROCESSES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticlesProcesses as(String alias) {
        return new ArticlesProcesses(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArticlesProcesses as(Name alias) {
        return new ArticlesProcesses(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ArticlesProcesses rename(String name) {
        return new ArticlesProcesses(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ArticlesProcesses rename(Name name) {
        return new ArticlesProcesses(name, null);
    }
}