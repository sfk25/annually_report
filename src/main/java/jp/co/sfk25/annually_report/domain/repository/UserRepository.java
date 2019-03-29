package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.jooq.tables.records.UsersRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jp.co.sfk25.annually_report.jooq.tables.Users.USERS;

/**
 * Usersリポジトリ
 */
@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final DSLContext dslContext;

    public User findOne(int id) {
        return dslContext.selectFrom(USERS).where(USERS.ID.eq(id)).fetchOne(this::toEntity);
    }

    public List<User> findAll() {
        return dslContext.selectFrom(USERS).fetch(this::toEntity);
    }

    private User toEntity(UsersRecord record) {
        return User.of(
                record.getId(),
                record.getName(),
                // TODO パスワード復号化処理
                record.getPassword(),
                record.getGroupId(),
                record.getCreatedAt().toLocalDateTime(),
                record.getUpdatedAt().toLocalDateTime());
    }
}
