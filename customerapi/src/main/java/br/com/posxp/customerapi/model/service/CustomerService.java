package br.com.posxp.customerapi.model.service;



import java.util.List;

import br.com.posxp.customerapi.domain.Customer;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(Long id);
    List<Customer> searchByName(String name);
    List<Customer> searchByEmail(String email); 
    List<Customer> searchByNameLikeIgnoreCase(String name); 
    Customer create(Customer customer);
    Customer update(Long id, Customer customer);
    boolean delete(Long id);
    long count();
}

