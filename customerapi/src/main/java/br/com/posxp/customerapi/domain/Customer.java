package br.com.posxp.customerapi.domain;

import jakarta.persistence.*;


@Entity(name="customer")
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    
    
    // 
    public Long getId() { 
    	return id; 
    }

    public void setId(Long id) { 
    	this.id = id; 
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}


