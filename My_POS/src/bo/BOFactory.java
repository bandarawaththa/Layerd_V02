package bo;

import bo.custom.impl.CustomerBOIMPL;

public class BOFactory {
    private static BOFactory factory;

    public static BOFactory getInstance() {
        return ((null == factory) ? (factory = new BOFactory()) : factory);
    }

    public SuperBO getBO(BOTypes type) {
        switch (type) {
            case CUSTOMER:
                return new CustomerBOIMPL();
            default:
                return null;
        }
    }
}