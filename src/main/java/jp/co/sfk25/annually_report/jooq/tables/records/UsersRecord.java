/*
 * This file is generated by jOOQ.
*/
package jp.co.sfk25.annually_report.jooq.tables.records;


import java.sql.Timestamp;

import javax.annotation.Generated;

import jp.co.sfk25.annually_report.jooq.tables.Users;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
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
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record12<Integer, String, String, String, Integer, Timestamp, Integer, Integer, Timestamp, String, Timestamp, Timestamp> {

    private static final long serialVersionUID = 773461913;

    /**
     * Setter for <code>sfk25.users.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>sfk25.users.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>sfk25.users.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>sfk25.users.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>sfk25.users.email</code>.
     */
    public void setEmail(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>sfk25.users.email</code>.
     */
    public String getEmail() {
        return (String) get(2);
    }

    /**
     * Setter for <code>sfk25.users.password</code>.
     */
    public void setPassword(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>sfk25.users.password</code>.
     */
    public String getPassword() {
        return (String) get(3);
    }

    /**
     * Setter for <code>sfk25.users.group_id</code>.
     */
    public void setGroupId(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>sfk25.users.group_id</code>.
     */
    public Integer getGroupId() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>sfk25.users.entering_company_date</code>.
     */
    public void setEnteringCompanyDate(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>sfk25.users.entering_company_date</code>.
     */
    public Timestamp getEnteringCompanyDate() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>sfk25.users.sex</code>.
     */
    public void setSex(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>sfk25.users.sex</code>.
     */
    public Integer getSex() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>sfk25.users.blood_type</code>.
     */
    public void setBloodType(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>sfk25.users.blood_type</code>.
     */
    public Integer getBloodType() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>sfk25.users.birthday</code>.
     */
    public void setBirthday(Timestamp value) {
        set(8, value);
    }

    /**
     * Getter for <code>sfk25.users.birthday</code>.
     */
    public Timestamp getBirthday() {
        return (Timestamp) get(8);
    }

    /**
     * Setter for <code>sfk25.users.self_introduction</code>.
     */
    public void setSelfIntroduction(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>sfk25.users.self_introduction</code>.
     */
    public String getSelfIntroduction() {
        return (String) get(9);
    }

    /**
     * Setter for <code>sfk25.users.created_at</code>.
     */
    public void setCreatedAt(Timestamp value) {
        set(10, value);
    }

    /**
     * Getter for <code>sfk25.users.created_at</code>.
     */
    public Timestamp getCreatedAt() {
        return (Timestamp) get(10);
    }

    /**
     * Setter for <code>sfk25.users.updated_at</code>.
     */
    public void setUpdatedAt(Timestamp value) {
        set(11, value);
    }

    /**
     * Getter for <code>sfk25.users.updated_at</code>.
     */
    public Timestamp getUpdatedAt() {
        return (Timestamp) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<Integer, String, String, String, Integer, Timestamp, Integer, Integer, Timestamp, String, Timestamp, Timestamp> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row12<Integer, String, String, String, Integer, Timestamp, Integer, Integer, Timestamp, String, Timestamp, Timestamp> valuesRow() {
        return (Row12) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Users.USERS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Users.USERS.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Users.USERS.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Users.USERS.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Users.USERS.GROUP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Users.USERS.ENTERING_COMPANY_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Users.USERS.SEX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Users.USERS.BLOOD_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field9() {
        return Users.USERS.BIRTHDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Users.USERS.SELF_INTRODUCTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field11() {
        return Users.USERS.CREATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field12() {
        return Users.USERS.UPDATED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getGroupId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getEnteringCompanyDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getSex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getBloodType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component9() {
        return getBirthday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getSelfIntroduction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component11() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component12() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getGroupId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getEnteringCompanyDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getSex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getBloodType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value9() {
        return getBirthday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getSelfIntroduction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value11() {
        return getCreatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value12() {
        return getUpdatedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value3(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value4(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value5(Integer value) {
        setGroupId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value6(Timestamp value) {
        setEnteringCompanyDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value7(Integer value) {
        setSex(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value8(Integer value) {
        setBloodType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value9(Timestamp value) {
        setBirthday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value10(String value) {
        setSelfIntroduction(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value11(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value12(Timestamp value) {
        setUpdatedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord values(Integer value1, String value2, String value3, String value4, Integer value5, Timestamp value6, Integer value7, Integer value8, Timestamp value9, String value10, Timestamp value11, Timestamp value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(Integer id, String name, String email, String password, Integer groupId, Timestamp enteringCompanyDate, Integer sex, Integer bloodType, Timestamp birthday, String selfIntroduction, Timestamp createdAt, Timestamp updatedAt) {
        super(Users.USERS);

        set(0, id);
        set(1, name);
        set(2, email);
        set(3, password);
        set(4, groupId);
        set(5, enteringCompanyDate);
        set(6, sex);
        set(7, bloodType);
        set(8, birthday);
        set(9, selfIntroduction);
        set(10, createdAt);
        set(11, updatedAt);
    }
}
