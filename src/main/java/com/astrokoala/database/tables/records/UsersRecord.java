/*
 * This file is generated by jOOQ.
 */
package com.astrokoala.database.tables.records;


import com.astrokoala.database.tables.Users;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record5<Integer, String, String, String, LocalDateTime> {

    private static final long serialVersionUID = -1245374929;

    /**
     * Setter for <code>Playbooks.Users.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>Playbooks.Users.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Playbooks.Users.email</code>.
     */
    public void setEmail(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>Playbooks.Users.email</code>.
     */
    public String getEmail() {
        return (String) get(1);
    }

    /**
     * Setter for <code>Playbooks.Users.username</code>.
     */
    public void setUsername(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>Playbooks.Users.username</code>.
     */
    public String getUsername() {
        return (String) get(2);
    }

    /**
     * Setter for <code>Playbooks.Users.pass</code>.
     */
    public void setPass(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>Playbooks.Users.pass</code>.
     */
    public String getPass() {
        return (String) get(3);
    }

    /**
     * Setter for <code>Playbooks.Users.create_time</code>.
     */
    public void setCreateTime(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>Playbooks.Users.create_time</code>.
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, String, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, String, String, LocalDateTime> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Users.USERS.ID;
    }

    @Override
    public Field<String> field2() {
        return Users.USERS.EMAIL;
    }

    @Override
    public Field<String> field3() {
        return Users.USERS.USERNAME;
    }

    @Override
    public Field<String> field4() {
        return Users.USERS.PASS;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Users.USERS.CREATE_TIME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getEmail();
    }

    @Override
    public String component3() {
        return getUsername();
    }

    @Override
    public String component4() {
        return getPass();
    }

    @Override
    public LocalDateTime component5() {
        return getCreateTime();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getEmail();
    }

    @Override
    public String value3() {
        return getUsername();
    }

    @Override
    public String value4() {
        return getPass();
    }

    @Override
    public LocalDateTime value5() {
        return getCreateTime();
    }

    @Override
    public UsersRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public UsersRecord value2(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UsersRecord value3(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UsersRecord value4(String value) {
        setPass(value);
        return this;
    }

    @Override
    public UsersRecord value5(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    @Override
    public UsersRecord values(Integer value1, String value2, String value3, String value4, LocalDateTime value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
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
    public UsersRecord(Integer id, String email, String username, String pass, LocalDateTime createTime) {
        super(Users.USERS);

        set(0, id);
        set(1, email);
        set(2, username);
        set(3, pass);
        set(4, createTime);
    }
}
