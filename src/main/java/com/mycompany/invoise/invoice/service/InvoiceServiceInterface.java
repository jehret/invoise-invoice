package com.mycompany.invoise.invoice.service;

import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.repository.InvoiceRepositoryInterface;


public interface InvoiceServiceInterface {
    Invoice createInvoice(Invoice invoice);
    Iterable<Invoice> getInvoiceList();
    Invoice getInvoiceByNumber(Long number);
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
}
