package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.domain.entity.Group;
import jp.co.sfk25.annually_report.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static jp.co.sfk25.annually_report.jooq.tables.Groups.GROUPS;
import static jp.co.sfk25.annually_report.jooq.tables.Users.USERS;

/**
 * Groupsリポジトリ
 */
@Repository
@RequiredArgsConstructor
public class GroupRepository {

    private final DSLContext dslContext;

    public Group findOne(int id) {
        return dslContext
                .select()
                .from(GROUPS)
                .leftJoin(USERS)
                .on(GROUPS.ID.eq(USERS.GROUP_ID))
                .where(GROUPS.ID.eq(id))
                .fetchGroups(GROUPS.ID).values().stream()
                .map(this::toEntity)
                .findFirst().get();
    }

    public List<Group> findAll() {
        return dslContext
                .select()
                .from(GROUPS)
                .leftJoin(USERS)
                .on(GROUPS.ID.eq(USERS.GROUP_ID))
                .fetchGroups(GROUPS.ID).values().stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    private Group toEntity(List<Record> records) {
        if (records.get(0).get(USERS.ID) == null) {
            return Group.of(records.get(0).get(GROUPS.ID), records.get(0).get(GROUPS.VALUE), null);
        }

        List<User> members = records.stream()
                .map(r -> User.of(
                        r.get(USERS.ID),
                        r.get(USERS.NAME),
                        r.get(USERS.EMAIL),
                        null,
                        r.get(USERS.GROUP_ID),
                        r.get(USERS.ENTERING_COMPANY_DATE) != null
                                ? r.get(USERS.ENTERING_COMPANY_DATE).toLocalDateTime()
                                : null,
                        r.get(USERS.SEX),
                        r.get(USERS.BLOOD_TYPE),
                        r.get(USERS.BIRTHDAY) != null ? r.get(USERS.BIRTHDAY).toLocalDateTime() : null,
                        r.get(USERS.SELF_INTRODUCTION),
                        r.get(USERS.CREATED_AT).toLocalDateTime(),
                        r.get(USERS.UPDATED_AT).toLocalDateTime()))
                .collect(Collectors.toList());

        return Group.of(records.get(0).get(GROUPS.ID), records.get(0).get(GROUPS.VALUE), members);
    }
}
