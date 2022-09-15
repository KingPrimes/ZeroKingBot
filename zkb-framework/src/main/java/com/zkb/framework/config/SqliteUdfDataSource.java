package com.zkb.framework.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Component;
import org.sqlite.Function;
import org.sqlite.SQLiteConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Pattern;

@Component
public class SqliteUdfDataSource extends SimpleDriverDataSource {

    @Override
    public @NotNull Connection getConnection() throws SQLException {
        Connection conn = super.getConnection();
        addAllUdf((SQLiteConnection) conn);
        return conn;
    }

    @Override
    public @NotNull Connection getConnection(@NotNull String username, @NotNull String password) throws SQLException {
        Connection conn = super.getConnection(username, password);
        addAllUdf((SQLiteConnection) conn);
        return conn;
    }

    private void addAllUdf(SQLiteConnection conn) throws SQLException {
        createUdfRegexp(conn);
    }

    private void createUdfRegexp(SQLiteConnection conn) throws SQLException {
        Function.create(conn, "REGEXP", new Function() {
            @Override
            protected void xFunc() throws SQLException {
                String expression = value_text(0);
                String value = value_text(1);
                if (value == null)
                    value = "";

                Pattern pattern = Pattern.compile(expression);
                result(pattern.matcher(value).find() ? 1 : 0);
            }
        });
    }

}
