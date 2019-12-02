package dao.custom.impl;

import dao.custom.CustomerDAO;
import entity.Customer;

import java.util.ArrayList;

public class CustomerDAOIMPL implements CustomerDAO {
    @Override
    public boolean add(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public Customer search(String s) {
        return null;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public ArrayList<Customer> getAll() {
        return null;
    }

    @Override
    public ArrayList<Customer> searchAll(String sql) {
        return null;
    }
}