package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.CrudDAO;
import dao.DAOFactory;
import dao.DAOTypes;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOIMPL implements CustomerBO {
    private CustomerDAO dao = DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);

    @Override
    public boolean save(CustomerDTO customer) throws SQLException {
        return dao.save(new Customer(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary()));
    }

    @Override
    public boolean update(CustomerDTO customer) throws SQLException {
        return dao.update(new Customer(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary()));
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return dao.delete(id);
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException {
        ArrayList<Customer> allEntities = dao.getAll();
        ArrayList<CustomerDTO> allDTOs = new ArrayList<>();
        for (Customer entity :
                allEntities) {
            allDTOs.add(new CustomerDTO(entity.getId(), entity.getName(), entity.getAddress(), entity.getSalary()));
        }
        return allDTOs;
    }

    @Override
    public ArrayList<CustomerDTO> searchAll(String sql) throws SQLException {
        ArrayList<Customer> allEntities = dao.searchAll(sql);
        ArrayList<CustomerDTO> allDTOs = new ArrayList<>();
        for (Customer entity :
                allEntities) {
            allDTOs.add(new CustomerDTO(entity.getId(), entity.getName(), entity.getAddress(), entity.getSalary()));
        }
        return allDTOs;
    }
}