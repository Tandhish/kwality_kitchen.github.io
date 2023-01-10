package com.techorzo.kwality.kitchen.misc;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
SQL lite Handle - But same syntax, so meh ¯\_(ツ)_/¯

Example connection url  : jdbc:sqlite:D:\Projects\kwality_kitchen\src\main\resources\test.db

TODO: Add validation (Actually nvm, it worked, keeping it here just in case
TODO:  Add comments and stuff
 */
public class SqlHandler {
    private volatile Connection connection = null;

    public synchronized int connectDB(String url) {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(url);
                System.out.println(url);

            } catch (SQLException sqlException) {
                System.out.println("Error :: " + sqlException.getMessage());

                return -1; // Couldn't connect
            }
        } else {
            System.out.println("Warning :: Handler is already connected to a Database");
            System.out.println("Disconnect from current database to initiate new connection");

            return 1; // Existing connection
        }

        return 0; // Connection successful
    }

    public synchronized int disconnectDB() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            System.out.println("Error :: Could not close the connection");
            System.out.println(sqlException.getMessage());

            return -1; // Disconnection error
        }

        connection = null;
        return 0; // Disconnected and the reference was nullified
    }

    public synchronized List<List<String>> executeQuery(String query, Object ...values) {
        List<List<String>> result = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement = setValues(statement, values);
            ResultSet resultSet;

            try {
                resultSet = statement.executeQuery();
            } catch (SQLException sqlException) {
                System.out.println("Warning :: No Results returned");
                return null;
            }

            if(resultSet.isBeforeFirst()) {
                StringBuilder builder = new StringBuilder();
                ResultSetMetaData metaData = resultSet.getMetaData();

                while(resultSet.next()) {
                    List<String> r = new ArrayList<>();

                    for(int i = 1; i <= metaData.getColumnCount(); i++) {
                        r.add(i-1, resultSet.getString(i));
                    }
                    result.add(r);
                }
                return result;
            }
        } catch (SQLException sqlException) {
            System.out.println("Error :: " + sqlException.getMessage());

            return null;
        }
        return result;
    }

    public synchronized int executeUpdate(String query, Object ...values) {
        int rows_affected;

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement = setValues(statement, values);
            rows_affected = statement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Error :: " + sqlException.getMessage());
            return -1;
        }
        return rows_affected;
    }

    public synchronized boolean isConnectedDB() {
        try {
            if(connection.isClosed() || connection == null)
                return false;
        } catch (SQLException sqlException) {
            System.out.println("Error :: " + sqlException.getMessage());
            System.out.println("Suggestion :: Try reconnecting to database");
        }

        return true;
    }

    private PreparedStatement setValues(PreparedStatement preparedStatement, Object[] values) throws SQLException{
        if(values != null) {
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setString(i + 1, values[i].toString());
            }
        }
        return preparedStatement;
    }

    private SqlHandler() {
        //Does nothing for now
    }

    public synchronized static SqlHandler getInstance() {
        return _HOLDER._Instance;
    }

    private static final class _HOLDER {
        private static final SqlHandler _Instance = new SqlHandler();
    }
}
