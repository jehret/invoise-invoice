package com.mycompany.invoise.invoice.api;

import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {
/*
    @Autowired
    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice){

        return invoiceService.createInvoice(invoice);
    }
*/
    @GetMapping
    public Iterable<Invoice> list(){
        System.out.println("La méthode list a été invoquée");

        List<Invoice> liste=new ArrayList<>();
        Customer customer=new Customer("Lambda");
        Invoice invoice=new Invoice("NUM_001","001",customer);
        liste.add(invoice);

        return liste;

        //return invoiceService.getInvoiceList();
    }
/*
    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number){
        System.out.println("La méthode displayInvoice a été invoquée");

        return invoiceService.getInvoiceByNumber(number);
    }*/

   /* @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice){
        //vous pourriez même supprimer l'annotation @ModelAttribute si vous ne comptez
        //pas donner un identifiant personnalisé au backing bean
        return "invoice-create-form";
    }*/


}
