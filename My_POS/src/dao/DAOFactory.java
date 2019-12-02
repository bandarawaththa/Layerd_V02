package dao;

public class DAOFactory {
    private static DAOFactory factory;

    public static DAOFactory getInstance() {
        return ((null == factory) ? (factory = new DAOFactory()) : factory);
    }

    public SuperDAO getDAO(DAOTypes type) {
        switch (type) {
            case CUSTOMER:
                return null;
            default:
                return null;
        }
    }
}