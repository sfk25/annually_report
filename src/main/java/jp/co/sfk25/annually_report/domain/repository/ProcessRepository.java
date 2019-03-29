package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.domain.entity.Process;
import jp.co.sfk25.annually_report.jooq.tables.records.ProcessesRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jp.co.sfk25.annually_report.jooq.tables.Processes.PROCESSES;

/**
 * Processesリポジトリ
 */
@Repository
@RequiredArgsConstructor
public class ProcessRepository {

    private final DSLContext dslContext;

    public Process findOne(int id) {
        return dslContext.selectFrom(PROCESSES).where(PROCESSES.ID.eq(id)).fetchOne(this::toEntity);
    }

    public List<Process> findAll() {
        return dslContext.selectFrom(PROCESSES).fetch(this::toEntity);
    }

    private Process toEntity(ProcessesRecord record) {
        return Process.of(
                record.getId(),
                record.getValue());
    }
}
