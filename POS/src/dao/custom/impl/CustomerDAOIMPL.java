package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import dbHandler.DBConnection;
import entity.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOIMPL implements CustomerDAO {

    @Override
    public boolean save(Customer customer) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        return CrudUtil.execute("INSERT INTO Customer VALUES(?,?,?,?)", connection, customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        return CrudUtil.execute("UPDATE Customer SET name = ?, address = ?, salary = ? WHERE id = ?", connection, customer.getName(), customer.getAddress(), customer.getSalary(), customer.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        return CrudUtil.execute("DELETE FROM Customer WHERE id = ?", connection, id);
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer", connection);
        ArrayList<Customer> list = new ArrayList<>();
        while (rst.next()){
            list.add(new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary")));
        }
        return list;
    }

    @Override
    public ArrayList<Customer> searchAll(String sql) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer WHERE id like ? || name like ? || address like ? || salary like ?", connection, sql, sql, sql, sql);
        ArrayList<Customer> list = new ArrayList<>();
        while (rst.next()){
            list.add(new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary")));
        }
        return list;
    }
}