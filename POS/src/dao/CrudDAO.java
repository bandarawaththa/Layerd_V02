package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T, ID> {
    public boolean save (T t) throws SQLException;
    public boolean update (T T) throws SQLException;
    public boolean delete (ID id) throws SQLException;
    public ArrayList<T> getAll () throws SQLException;
    public ArrayList<T> searchAll (ID sql) throws SQLException;
}