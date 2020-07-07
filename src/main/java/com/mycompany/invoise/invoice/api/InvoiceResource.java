package com.mycompany.invoise.invoice.api;

import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceServiceInterface invoiceService;

    @Autowired
    private RestTemplate restTemplate;

/*
    @PostMapping
    public Invoice create(@RequestBody Invoice invoice){

        return invoiceService.createInvoice(invoice);
    }
*/
    @GetMapping
    public Iterable<Invoice> list(){
        System.out.println("La méthode list a été invoquée");
        Iterable<Invoice> invoices= invoiceService.getInvoiceList();
        invoices.forEach(invoice -> {
            invoice.setCustomer(restTemplate.getForObject("http://localhost:8081/customer/"+invoice.getIdCustomer(),
                    Customer.class));
        });
        return invoices;
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number){
        System.out.println("La méthode displayInvoice a été invoquée");
        Invoice invoice=invoiceService.getInvoiceByNumber(number);
        invoice.setCustomer(restTemplate.getForObject("http://localhost:8081/customer/"+invoice.getIdCustomer(),
                Customer.class));
        return invoice;
    }

   /* @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice){
        //vous pourriez même supprimer l'annotation @ModelAttribute si vous ne comptez
        //pas donner un identifiant personnalisé au backing bean
        return "invoice-create-form";
    }*/


    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
