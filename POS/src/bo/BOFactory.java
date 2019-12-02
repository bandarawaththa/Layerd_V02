package bo;

import bo.custom.CustomerBO;
import bo.custom.impl.CustomerBOIMPL;

public class BOFactory {
    private static BOFactory factory;

    private BOFactory() {}

    public static BOFactory getInstance () {
        return (null == factory) ? (factory = new BOFactory()) : factory;
    }

    public CustomerBO getBO (BOTypes type) {
        switch (type){
            case CUSTOMER:
                return new CustomerBOIMPL();
            default:
                return null;
        }
    }
}