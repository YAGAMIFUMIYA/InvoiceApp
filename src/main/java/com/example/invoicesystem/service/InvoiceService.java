package com.example.invoicesystem.service;

import com.example.invoicesystem.entity.Invoice;
import com.example.invoicesystem.mapper.InvoiceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvoiceService {

    private final InvoiceMapper invoiceMapper;

    public InvoiceService(InvoiceMapper invoiceMapper) {
        this.invoiceMapper = invoiceMapper;
    }

    public List<Invoice> findAll() {
        return invoiceMapper.findAll();
    }

    public Invoice findById(Long id) {
        return invoiceMapper.findById(id);
    }

    public void save(Invoice invoice) {
        if (invoice.getId() == null) {
            invoiceMapper.insert(invoice);
        } else {
            invoiceMapper.update(invoice);
        }
    }

    public void delete(Long id) {
        invoiceMapper.delete(id);
    }
}
