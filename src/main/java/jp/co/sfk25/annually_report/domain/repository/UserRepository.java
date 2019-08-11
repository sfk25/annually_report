package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.controller.model.UserModel;
import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.jooq.tables.records.UsersRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    public User findByUserName(String userName) {
        return dslContext.selectFrom(USERS).where(USERS.NAME.eq(userName)).fetchOne(this::toEntity);
    }

    public User findByEmail(String email) {
        return dslContext.selectFrom(USERS).where(USERS.EMAIL.eq(email)).fetchOne(this::toEntity);
    }

    public void insert(UserModel userModel) {
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());

        dslContext.insertInto(USERS)
                .set(USERS.NAME, userModel.getName())
                .set(USERS.EMAIL, userModel.getEmail())
                .set(USERS.PASSWORD, userModel.getPassword())
                .set(USERS.GROUP_ID, userModel.getGroupId())
                .set(USERS.ENTERING_COMPANY_DATE, userModel.getEnteringCompanyDate())
                .set(USERS.SEX, userModel.getSex())
                .set(USERS.BLOOD_TYPE, userModel.getBloodType())
                .set(USERS.BIRTHDAY, userModel.getBirthday())
                .set(USERS.SELF_INTRODUCTION, userModel.getSelfIntroduction())
                .set(USERS.CREATED_AT, now)
                .set(USERS.UPDATED_AT, now)
                .execute();
    }

    public void update(UserModel userModel) {
        dslContext.update(USERS)
                .set(USERS.NAME, userModel.getName())
                .set(USERS.EMAIL, userModel.getEmail())
                .set(USERS.GROUP_ID, userModel.getGroupId())
                .set(USERS.ENTERING_COMPANY_DATE, userModel.getEnteringCompanyDate())
                .set(USERS.SEX, userModel.getSex())
                .set(USERS.BLOOD_TYPE, userModel.getBloodType())
                .set(USERS.BIRTHDAY, userModel.getBirthday())
                .set(USERS.SELF_INTRODUCTION, userModel.getSelfIntroduction())
                .set(USERS.UPDATED_AT, Timestamp.valueOf(LocalDateTime.now()))
                .where(USERS.ID.equal(userModel.getId()))
                .execute();
    }

    private User toEntity(UsersRecord record) {
        return User.of(
                record.getId(),
                record.getName(),
                record.getEmail(),
                // TODO パスワード復号化処理
                record.getPassword(),
                record.getGroupId(),
                record.getEnteringCompanyDate() != null
                        ? record.getEnteringCompanyDate().toLocalDateTime()
                        : null,
                record.getSex(),
                record.getBloodType(),
                record.getBirthday() != null
                        ? record.getBirthday().toLocalDateTime()
                        : null,
                record.getSelfIntroduction(),
                record.getCreatedAt().toLocalDateTime(),
                record.getUpdatedAt().toLocalDateTime());
    }
}
