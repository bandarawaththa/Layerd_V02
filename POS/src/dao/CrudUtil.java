package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    // -------------- Type Inference --------------
    public static <T>T execute (String sql, Connection connection, Object ... params) throws SQLException {
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++){
            pstm.setObject((i+1), params[i]);
        }

        return (sql.startsWith("SELECT")) ? ((T) pstm.executeQuery()) : ((T) ((Boolean)(pstm.executeUpdate() > 0)));
    }
}