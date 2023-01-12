package bo;

import bo.custom.CustomerBO;
import bo.custom.impl.CustomerBOImpl;
import db.DBConnection;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }

    public static BOFactory getBoFactory(){
        if (boFactory==null){
            boFactory=new BOFactory();
        }
       return boFactory;
    }

    public CustomerBO getCustomerBO(){
        return new CustomerBOImpl();
    }



}
