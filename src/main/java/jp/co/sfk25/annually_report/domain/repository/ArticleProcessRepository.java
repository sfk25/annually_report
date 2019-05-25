package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.domain.entity.ArticleProcess;
import jp.co.sfk25.annually_report.jooq.tables.records.ArticlesProcessesRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jp.co.sfk25.annually_report.jooq.tables.ArticlesProcesses.ARTICLES_PROCESSES;

/**
 * ArticleProcessリポジトリ
 */
@Repository
@RequiredArgsConstructor
public class ArticleProcessRepository {

    private final DSLContext dslContext;

    public ArticleProcess findOne(int id) {
        return dslContext.selectFrom(ARTICLES_PROCESSES).where(ARTICLES_PROCESSES.ARTICLE_ID.eq(id)).fetchOne(this::toEntity);
    }

    public List<ArticleProcess> findAll() {
        return dslContext.selectFrom(ARTICLES_PROCESSES).fetch(this::toEntity);
    }

    private ArticleProcess toEntity(ArticlesProcessesRecord record) {
        return ArticleProcess.of(
                record.getArticleId(),
                record.getProcessId());
    }

    public Integer insert(Integer articleId, Integer processId) {
        dslContext.insertInto(ARTICLES_PROCESSES, ARTICLES_PROCESSES.ARTICLE_ID, ARTICLES_PROCESSES.PROCESS_ID)
            .values(articleId, processId)
            .execute();

        return dslContext.lastID().intValue();
    }

}
