/*
 * This file is generated by jOOQ.
 */
package com.astrokoala.database;


import com.astrokoala.database.tables.Users;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Playbooks extends SchemaImpl {

    private static final long serialVersionUID = -1700820620;

    /**
     * The reference instance of <code>Playbooks</code>
     */
    public static final Playbooks PLAYBOOKS = new Playbooks();

    /**
     * The table <code>Playbooks.Users</code>.
     */
    public final Users USERS = Users.USERS;

    /**
     * No further instances allowed
     */
    private Playbooks() {
        super("Playbooks", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Users.USERS);
    }
}