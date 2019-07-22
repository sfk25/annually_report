package jp.co.sfk25.annually_report.domain.repository;

import jp.co.sfk25.annually_report.controller.model.UserModel;
import jp.co.sfk25.annually_report.domain.entity.User;
import jp.co.sfk25.annually_report.hoge.BloodTypeEnum;
import jp.co.sfk25.annually_report.hoge.SexEnum;
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
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());

        Timestamp enteringCompanyDate = userModel.getEnteringCompanyDate() != null
                ? Timestamp.valueOf(userModel.getEnteringCompanyDate())
                : null;

        Timestamp birthday = userModel.getBirthday() != null
                ? Timestamp.valueOf(userModel.getBirthday())
                : null;

        dslContext.insertInto(USERS, USERS.NAME, USERS.EMAIL, USERS.PASSWORD, USERS.GROUP_ID,
                USERS.ENTERING_COMPANY_DATE, USERS.SEX, USERS.BLOOD_TYPE, USERS.BIRTHDAY,
                USERS.SELF_INTRODUCTION, USERS.CREATED_AT, USERS.UPDATED_AT)
                .values(userModel.getName(), userModel.getEmail(), userModel.getPassword(), userModel.getGroupId(),
                        enteringCompanyDate, SexEnum.getCodeByValue(userModel.getSex()).getCode(),
                        BloodTypeEnum.getCodeByValue(userModel.getBloodType()).getCode(), birthday,
                        userModel.getSelfIntroduction(), timestamp, timestamp)
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
