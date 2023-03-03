package com.example.carservice.user;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.carservice.common.BaseJpaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerJpaService
		extends BaseJpaService<Customer, Integer, CustomerDTO, CustomerDTO>
		implements CustomerService {

	private final CustomerRepository customerRepository;

	private final ModelMapper modelMapper;

	@Override
	public JpaRepository<Customer, Integer> getDefaultRepository() {
		return customerRepository;
	}

	@Override
	public Customer dtoToEntity(CustomerDTO dto) {
		if (dto != null) {
			Customer entity = modelMapper.map(dto, Customer.class);
			Wallet wallet = modelMapper.map(dto.getWallet(), Wallet.class);
			entity.setWallet(wallet);
			return entity;
		}
		return new Customer();
	}

	@Override
	public CustomerDTO entityToDTO(Customer entity) {
		if (entity != null) {
			CustomerDTO dto = modelMapper.map(entity, CustomerDTO.class);
			WalletDTO wallet = modelMapper.map(entity.getWallet(), WalletDTO.class);
			dto.setWallet(wallet);
			return dto;
		}
		return new CustomerDTO();
	}

	@Override
	public CustomerDTO createCustomer(CustomerDTO dto) {
		return save(dto);
	}

	@Override
	public List<CustomerDTO> getCustomers() {
		return findAll();
	}

	@Override
	public CustomerDTO getCustomer(Integer id) {
		return findById(id);
	}
}
