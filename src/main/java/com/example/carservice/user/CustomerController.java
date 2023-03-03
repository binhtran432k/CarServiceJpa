package com.example.carservice.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping
	public CustomerDTO createCustomer(@RequestBody CustomerDTO dto) {
		return customerService.createCustomer(dto);
	}

	@GetMapping
	public List<CustomerDTO> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping("/{id}")
	public CustomerDTO getCustomer(@PathVariable Integer id) {
		return customerService.getCustomer(id);
	}

}
