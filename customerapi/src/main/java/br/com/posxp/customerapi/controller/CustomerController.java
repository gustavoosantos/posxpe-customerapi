package br.com.posxp.customerapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.posxp.customerapi.domain.Customer;
import br.com.posxp.customerapi.model.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Customer Management API", description = "Customers")
//@Api(value = "Customer Management API", tags = "Customers")

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

	 //@Autowired
     //private CustomerService service;
	
    private final CustomerService service;
    
    public CustomerController(CustomerService customerService) {
    	this.service = customerService;
    }
	
	@Operation(summary = "Incluir Cliente (Create)", description = "Cria um novo registro de cliente")
    @ApiResponse(responseCode = "200", description = "Ok")    
    // POST /customers - Cria um novo cliente
    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.create(customer));
    }

	@Operation(summary = "Consultar Cliente pelo ID (Read)", description = "Consulta os detalhes de um cliente específico com base no ID")
    @ApiResponse(responseCode = "200", description = "Ok")    
    @ApiResponse(responseCode = "404", description = "Not Found")    
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) { 
        Customer customer = service.getById(id);
        
        if (customer != null) {
        	return ResponseEntity.ok(customer);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
	@Operation(summary = "Atualizar Cliente (Update)", description = "Atualiza as informações de um cliente existente")
    @ApiResponse(responseCode = "200", description = "Ok")    
    @ApiResponse(responseCode = "404", description = "Not Found")    
    // PUT /customers/{id} - Atualiza um cliente
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = service.update(id, customer);
        
        if (updatedCustomer != null) {
        	return ResponseEntity.ok(updatedCustomer);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

	@Operation(summary = "Excluir Cliente (Delete)", description = "Remove um cliente do sistema com base no ID")
    @ApiResponse(responseCode = "200", description = "Ok")    
    @ApiResponse(responseCode = "404", description = "Not Found")    
    // DELETE /customers/{id} - Deleta um cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
    	boolean excluiu = service.delete(id);
    	
        if (excluiu) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
	@Operation(summary = "Contar Clientes", description = "Retorna o número total de clientes registrados")
    @ApiResponse(responseCode = "200", description = "Ok")    
    // GET /customers/count - Retorna a contagem de registros
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        Long count = service.count();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
    
	@Operation(summary = "Listar Clientes", description = "Retorna uma lista com todos os clientes")
    @ApiResponse(responseCode = "200", description = "Ok")    
    // GET /customers - Retorna todos os clientes
    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customers = service.getAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
	@Operation(summary = "Consultar Clientes pelo Nome", description = "Retorna uma lista de clientes filtrando pelo campo nome")
    @ApiResponse(responseCode = "200", description = "Ok")    
    @ApiResponse(responseCode = "404", description = "Not Found")    
    // GET /customers/name/{name} - Busca por nome
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Customer>> findByName(@PathVariable String name) {
        List<Customer> customers = service.searchByName(name);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        	return new ResponseEntity<>(customers, HttpStatus.OK);
        }
        
    }
    
	@Operation(summary = "Consultar Clientes por parte do Nome", description = "Retorna uma lista de clientes filtrando por parte do nome (partial/case insensitive)")
    @ApiResponse(responseCode = "200", description = "Ok")    
    @ApiResponse(responseCode = "404", description = "Not Found")    
    // GET /customers/name/{name} - Busca por nome com ignorecase e like
    @GetMapping("/likename/{name}")
    public ResponseEntity<List<Customer>> findByNameLikeIgnoreCase(@PathVariable String name) {
        List<Customer> customers = service.searchByNameLikeIgnoreCase(name);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        	return new ResponseEntity<>(customers, HttpStatus.OK);
        }
        
    }
    
    
}