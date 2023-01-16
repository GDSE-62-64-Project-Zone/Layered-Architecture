package entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomEntity {
    //customer
    private String id;
    private String name;
    private String address;

    //item
    private String code;
    private String description;
    private int qtyOnHand;
    private BigDecimal unitPrice;

    //Order
    private String oid;
    private LocalDate date;
    private String customerID;

    //OrderDetails
    private String itemCode;
    private int qty;


}
