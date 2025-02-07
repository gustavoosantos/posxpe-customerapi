package br.com.posxp.customerapi.model.service;



import java.util.List;

import org.springframework.stereotype.Service;

import br.com.posxp.customerapi.domain.Customer;
import br.com.posxp.customerapi.model.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    //@Autowired
    //private CustomerRepository repository;
    
     private final CustomerRepository repository;
     
     public CustomerServiceImpl(CustomerRepository customerRepository) {
     	this.repository = customerRepository;
     }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return repository.findByName(name);
    }

    public List<Customer> searchByNameLikeIgnoreCase(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Customer> searchByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer update(Long id, Customer customerDetails) {
        Customer customer = getById(id);
        if (customer != null) {
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            customer.setPhone(customerDetails.getPhone());
            return repository.save(customer);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
        	repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public long count() {
        return repository.count();
    }
}