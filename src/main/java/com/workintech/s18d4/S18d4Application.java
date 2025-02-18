package com.workintech.s18d4;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class S18d4Application {
private static CustomerRepository customerRepository;
	public static void main(String[] args) {

		SpringApplication.run(S18d4Application.class, args);

//
//		Address address = new Address();
//		address.setStreet("123 Main St");
//		address.setCity("Ankara");
//
//		Customer customer = new Customer();
//		customer.setFirstName("John");
//		customer.setLastName("Doe");
//		customer.setAddress(address); // İlişkiyi Customer tarafından yönetiyoruz.
//
//// Customer kaydedildiğinde Address de otomatik kaydedilir (cascade = CascadeType.ALL).
//		customerRepository.save(customer);
	}

}
