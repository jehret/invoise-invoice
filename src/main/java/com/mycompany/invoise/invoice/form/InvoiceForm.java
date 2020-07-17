package com.mycompany.invoise.invoice.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InvoiceForm {

    private String number;
    @Size(min=10,max=13)
    private String orderNumber;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }


}
