package com.example.carservice.user;

import java.util.List;

public interface CustomerService {

	CustomerDTO createCustomer(CustomerDTO dto);

	List<CustomerDTO> getCustomers();

	CustomerDTO getCustomer(Integer id);

}
