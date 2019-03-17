package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.jooq.tables.records.GroupsRecord;
import jp.co.sfk25.annually_report.domain.entity.Group;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import java.util.List;

import static jp.co.sfk25.annually_report.jooq.tables.Groups.GROUPS;

/**
 * Groupsリポジトリ
 */
@Repository
@RequiredArgsConstructor
public class GroupRepository {

    private final DSLContext dslContext;

    public Group findOne(int id) {
        return dslContext.selectFrom(GROUPS).where(GROUPS.ID.eq(id)).fetchOne(this::toEntity);
    }

    public List<Group> findAll() {
        return dslContext.selectFrom(GROUPS).fetch(this::toEntity);
    }

    private Group toEntity(GroupsRecord record) {
        return Group.of(
                record.getId(),
                record.getValue());
    }
}
