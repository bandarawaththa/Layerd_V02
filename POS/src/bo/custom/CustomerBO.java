package bo.custom;

import dto.CustomerDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    public boolean save (CustomerDTO customer) throws SQLException;
    public boolean update (CustomerDTO customer) throws SQLException;
    public boolean delete (String id) throws SQLException;
    public ArrayList<CustomerDTO> getAll () throws SQLException;
    public ArrayList<CustomerDTO> searchAll (String sql) throws SQLException;
}