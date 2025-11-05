package com.example.invoicesystem.service;

import com.example.invoicesystem.entity.Customer;
import com.example.invoicesystem.mapper.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    private final CustomerMapper customerMapper;

    public CustomerService(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public List<Customer> findAll() {
        return customerMapper.findAll();
    }

    public Customer findById(Long id) {
        return customerMapper.findById(id);
    }

    public void save(Customer customer) {
        if (customer.getId() == null) {
            customerMapper.insert(customer);
        } else {
            customerMapper.update(customer);
        }
    }

    public void update(Customer customer) {
        customerMapper.update(customer);
    }

    public void delete(Long id) {
        customerMapper.delete(id);
    }
}
