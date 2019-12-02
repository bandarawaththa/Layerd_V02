package dao;

import dao.custom.impl.CustomerDAOIMPL;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return (null == factory) ? (factory = new DAOFactory()) : factory;
    }

    public <T>T getDAO (DAOTypes type) {
        switch (type){
            case CUSTOMER:
                return (T) new CustomerDAOIMPL();
            default:
                return null;
        }
    }
}