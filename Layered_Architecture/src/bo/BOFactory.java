package bo;

import bo.custom.CustomerBO;
import bo.custom.ItemBO;
import bo.custom.PurchaseOrderBO;
import bo.custom.impl.CustomerBOImpl;
import bo.custom.impl.ItemBOImpl;
import bo.custom.impl.PurchaseOrderBOImpl;
import db.DBConnection;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }
    //Object creation logic for CustomerBO
//    public CustomerBO getCustomerBO(){
//        return new CustomerBOImpl();
//    }
//
//    public ItemBO getItemBO(){
//        return new ItemBOImpl();
//    }
//
//    public PurchaseOrderBO getPurchaseOrderBO(){
//        return new PurchaseOrderBOImpl();
//    }

    public enum BOTypes{
        CUSTOMER,ITEM,PO
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PO:
                return new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }


}
