package br.com.posxp.customerapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.posxp.customerapi.domain.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findByName(String name);
	List<Customer> findByEmail(String email);
	List<Customer> findByNameContainingIgnoreCase(String name); 	
	
	Optional<Customer> findById(Long id);

}


