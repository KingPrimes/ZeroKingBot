package com.zkb.framework.config;

import org.hibernate.ScrollMode;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.relational.SqlStringGenerationContext;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.pagination.AbstractLimitHandler;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.dialect.pagination.LimitHelper;
import org.hibernate.dialect.unique.DefaultUniqueDelegate;
import org.hibernate.dialect.unique.UniqueDelegate;
import org.hibernate.engine.spi.RowSelection;
import org.hibernate.exception.DataException;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.exception.LockAcquisitionException;
import org.hibernate.exception.spi.SQLExceptionConversionDelegate;
import org.hibernate.exception.spi.TemplatedViolatedConstraintNameExtracter;
import org.hibernate.exception.spi.ViolatedConstraintNameExtracter;
import org.hibernate.internal.util.JdbcExceptionHelper;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.UniqueKey;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;

//springboot和sqlite 集成，由于是Hibernate5，不能用现成的com.enigmabridge hibernate4-sqlite-dialect方言包
public class SQLiteDialect extends Dialect {

    private final UniqueDelegate uniqueDelegate;

    public SQLiteDialect() {
        registerColumnType(Types.BIT, "integer");
        registerColumnType(Types.TINYINT, "integer");
        registerColumnType(Types.SMALLINT, "integer");
        registerColumnType(Types.INTEGER, "integer");
        registerColumnType(Types.BIGINT, "integer");
        registerColumnType(Types.FLOAT, "real");
        registerColumnType(Types.REAL, "real");
        registerColumnType(Types.DOUBLE, "double");
        registerColumnType(Types.NUMERIC, "integer");
        registerColumnType(Types.DECIMAL, "decimal");
        registerColumnType(Types.CHAR, "text");
        registerColumnType(Types.VARCHAR, "text");
        registerColumnType(Types.LONGVARCHAR, "text");
        registerColumnType(Types.DATE, "numeric");
        registerColumnType(Types.TIME, "text");
        registerColumnType(Types.TIMESTAMP, "text");
        registerColumnType(Types.BINARY, "blob");
        registerColumnType(Types.VARBINARY, "blob");
        registerColumnType(Types.LONGVARBINARY, "blob");
        // registerColumnType(Types.NULL, "null");
        registerColumnType(Types.BLOB, "blob");
        registerColumnType(Types.CLOB, "text");
        registerColumnType(Types.BOOLEAN, "integer");

        registerFunction( "concat", new VarArgsSQLFunction(StringType.INSTANCE, "", "||", "") );
        registerFunction( "mod", new SQLFunctionTemplate( IntegerType.INSTANCE, "?1 % ?2" ) );
        registerFunction( "substr", new StandardSQLFunction("substr", StringType.INSTANCE) );
        registerFunction( "substring", new StandardSQLFunction( "substr", StringType.INSTANCE) );
        uniqueDelegate = new SQLiteUniqueDelegate(this);
    }

    @Override
    public UniqueDelegate getUniqueDelegate() {
        return uniqueDelegate;
    }

    private static final SQLiteDialectIdentityColumnSupport IDENTITY_COLUMN_SUPPORT = new
            SQLiteDialectIdentityColumnSupport(new SQLiteDialect());


    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return IDENTITY_COLUMN_SUPPORT;
    }

    // limit/offset support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private static final AbstractLimitHandler LIMIT_HANDLER = new AbstractLimitHandler() {
        @Override
        public String processSql(String sql, RowSelection selection) {
            final boolean hasOffset = LimitHelper.hasFirstRow(selection);
            return sql + (hasOffset ? " limit ? offset ?" : " limit ?");
        }

        @Override
        public boolean supportsLimit() {
            return true;
        }

        @Override
        public boolean bindLimitParametersInReverseOrder() {
            return true;
        }
    };

    @Override
    public LimitHandler getLimitHandler() {
        return LIMIT_HANDLER;
    }

    // lock acquisition support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Override
    public boolean supportsLockTimeouts() {
        // may be http://sqlite.org/c3ref/db_mutex.html ?
        return false;
    }

    @Override
    public String getForUpdateString() {
        return "";
    }

    @Override
    public boolean supportsOuterJoinForUpdate() {
        return false;
    }

    // current timestamp support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public boolean supportsCurrentTimestampSelection() {
        return true;
    }

    @Override
    public boolean isCurrentTimestampSelectStringCallable() {
        return false;
    }

    @Override
    public String getCurrentTimestampSelectString() {
        return "select current_timestamp";
    }

    // SQLException support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    private static final int SQLITE_BUSY = 5;
    private static final int SQLITE_LOCKED = 6;
    private static final int SQLITE_IOERR = 10;
    private static final int SQLITE_CORRUPT = 11;
    private static final int SQLITE_NOTFOUND = 12;
    private static final int SQLITE_FULL = 13;
    private static final int SQLITE_CANTOPEN = 14;
    private static final int SQLITE_PROTOCOL = 15;
    private static final int SQLITE_TOOBIG = 18;
    private static final int SQLITE_CONSTRAINT = 19;
    private static final int SQLITE_MISMATCH = 20;
    private static final int SQLITE_NOTADB = 26;

    @Override
    public SQLExceptionConversionDelegate buildSQLExceptionConversionDelegate() {
        return (sqlException, message, sql) -> {
            final int errorCode = JdbcExceptionHelper.extractErrorCode(sqlException) & 0xFF;
            if (errorCode == SQLITE_TOOBIG || errorCode == SQLITE_MISMATCH) {
                return new DataException(message, sqlException, sql);
            } else if (errorCode == SQLITE_BUSY || errorCode == SQLITE_LOCKED) {
                return new LockAcquisitionException(message, sqlException, sql);
            } else if ((errorCode >= SQLITE_IOERR && errorCode <= SQLITE_PROTOCOL) || errorCode == SQLITE_NOTADB) {
                return new JDBCConnectionException(message, sqlException, sql);
            }
            // returning null allows other delegates to operate
            return null;
        };
    }

    @Override
    public ViolatedConstraintNameExtracter getViolatedConstraintNameExtracter() {
        return EXTRACTER;
    }

    private static final ViolatedConstraintNameExtracter EXTRACTER = new TemplatedViolatedConstraintNameExtracter() {
        @Override
        protected String doExtractConstraintName(SQLException sqle) throws NumberFormatException {
            final int errorCode = JdbcExceptionHelper.extractErrorCode(sqle) & 0xFF;
            if (errorCode == SQLITE_CONSTRAINT) {
                return extractUsingTemplate("constraint ", " failed", sqle.getMessage());
            }
            return null;
        }
    };

    // union subclass support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public boolean supportsUnionAll() {
        return true;
    }

    // DDL support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Override
    public boolean canCreateSchema() {
        return false;
    }

    @Override
    public boolean hasAlterTable() {
        // As specified in NHibernate dialect
        return false;
    }

    @Override
    public boolean dropConstraints() {
        return false;
    }

    @Override
    public boolean qualifyIndexName() {
        return false;
    }

    @Override
    public String getAddColumnString() {
        return "add column";
    }

    @Override
    public String getDropForeignKeyString() {
        throw new UnsupportedOperationException("No drop foreign key syntax supported by SQLiteDialect");
    }

    @Override
    public String getAddForeignKeyConstraintString(String constraintName,
                                                   String[] foreignKey, String referencedTable, String[] primaryKey,
                                                   boolean referencesPrimaryKey) {
        throw new UnsupportedOperationException("No add foreign key syntax supported by SQLiteDialect");
    }

    @Override
    public String getAddPrimaryKeyConstraintString(String constraintName) {
        throw new UnsupportedOperationException("No add primary key syntax supported by SQLiteDialect");
    }

    @Override
    public boolean supportsCommentOn() {
        return true;
    }

    @Override
    public boolean supportsIfExistsBeforeTableName() {
        return true;
    }

  /* not case insensitive for unicode characters by default (ICU extension needed)
    public boolean supportsCaseInsensitiveLike() {
    return true;
  }
  */

    @Override
    public boolean doesReadCommittedCauseWritersToBlockReaders() {
        // TODO Validate (WAL mode...)
        return true;
    }

    @Override
    public boolean doesRepeatableReadCauseReadersToBlockWriters() {
        return true;
    }

    @Override
    public boolean supportsTupleDistinctCounts() {
        return false;
    }

    @Override
    public int getInExpressionCountLimit() {
        // Compile/runtime time option: http://sqlite.org/limits.html#max_variable_number
        return 1000;
    }

    @Override
    public String getSelectGUIDString() {
        return "select hex(randomblob(16))";
    }

    @Override
    public ScrollMode defaultScrollMode() {
        return ScrollMode.FORWARD_ONLY;
    }


    public boolean supportsLimit() {
        return true;
    }

    protected String getLimitString(String query, boolean hasOffset) {
        return new StringBuffer(query.length()+20).
                append(query).
                append(hasOffset ? " limit ? offset ?" : " limit ?").
                toString();
    }

    public boolean supportsTemporaryTables() {
        return true;
    }

    public String getCreateTemporaryTableString() {
        return "create temporary table if not exists";
    }

    public boolean dropTemporaryTableAfterUse() {
        return false;
    }

    public boolean supportsCascadeDelete() {
        return false;
    }


    //自定义 唯一索引语句
    private static class SQLiteUniqueDelegate extends DefaultUniqueDelegate{

        public SQLiteUniqueDelegate(Dialect dialect) {
            super(dialect);
        }

        @Override
        public String getAlterTableToAddUniqueKeyCommand(UniqueKey uniqueKey, Metadata metadata, SqlStringGenerationContext context) {
            String tableName = context.format(uniqueKey.getTable().getQualifiedTableName());
            String constraintName = this.dialect.quote(uniqueKey.getName());
            return "CREATE UNIQUE INDEX " + constraintName + " on " + tableName + " " + this.uniqueConstraintSql(uniqueKey);

        }


        @Override
        protected String uniqueConstraintSql(UniqueKey uniqueKey) {
            StringBuilder sb = new StringBuilder();
            sb.append(" (");
            Iterator<Column> columnIterator = uniqueKey.columnIterator();

            while (columnIterator.hasNext()) {
                Column column = columnIterator.next();
                sb.append(column.getQuotedName(this.dialect));
                if (uniqueKey.getColumnOrderMap().containsKey(column)) {
                    sb.append(" ").append(uniqueKey.getColumnOrderMap().get(column));
                }

                if (columnIterator.hasNext()) {
                    sb.append(", ");
                }
            }

            return sb.append(')').toString();
        }

        @Override
        public String getColumnDefinitionUniquenessFragment(Column column) {
            return " unique";
        }

    }
}