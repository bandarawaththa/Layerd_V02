package bo.custom.impl;

import bo.custom.CustomerBO;
import dto.CustomerDTO;

import java.util.ArrayList;

public class CustomerBOIMPL implements CustomerBO {
    @Override
    public boolean addCustomer(CustomerDTO customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        return null;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) {
        return false;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> searchAllCustomers(String sql) {
        return null;
    }
}