package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public boolean addCustomer(CustomerDTO customer);

    public boolean deleteCustomer(String id);

    public CustomerDTO searchCustomer(String id);

    public boolean updateCustomer(CustomerDTO customer);

    public ArrayList<CustomerDTO> getAllCustomers();

    public ArrayList<CustomerDTO> searchAllCustomers(String sql);
}