package com.achdem.ecommerce;

import com.achdem.ecommerce.entity.Address;
import com.achdem.ecommerce.entity.User;
import com.achdem.ecommerce.repository.AddressRepository;
import com.achdem.ecommerce.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@PostConstruct
	public void test() {
		User user = userRepository.findById(2L).orElseThrow();

		Address address = new Address();
		address.setCity("Istanbul");
		address.setStreet("Street 1");
		address.setPostalCode("34000");
		address.setCountry("Turkey");
		address.setUser(user);

		addressRepository.save(address);

		System.out.println("Address saved!");
	}
}