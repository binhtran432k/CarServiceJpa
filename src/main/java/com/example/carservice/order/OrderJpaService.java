package com.example.carservice.order;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.carservice.common.BaseJpaService;
import com.example.carservice.service.ServiceDTO;
import com.example.carservice.service.ServiceModel;
import com.example.carservice.service.ServiceModelRepository;
import com.example.carservice.user.Customer;
import com.example.carservice.user.CustomerDTO;
import com.example.carservice.user.CustomerRepository;
import com.example.carservice.user.Staff;
import com.example.carservice.user.StaffDTO;
import com.example.carservice.user.StaffRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderJpaService
		extends BaseJpaService<Order, Integer, OrderCreationDTO, OrderDTO>
		implements OrderService {

	private final OrderRepository orderRepository;

	private final CustomerRepository customerRepository;

	private final StaffRepository staffRepository;

	private final ServiceModelRepository serviceModelRepository;

	private final ProductRepository productRepository;

	private final ModelMapper modelMapper;

	@Override
	public JpaRepository<Order, Integer> getDefaultRepository() {
		return orderRepository;
	}

	@Override
	public Order dtoToEntity(OrderCreationDTO dto) {
		if (dto != null) {
			Order entity = modelMapper.map(dto, Order.class);

			Customer customer = customerRepository.findById(dto.getCustomerId()).get();
			entity.setCustomer(customer);

			Set<Staff> staves = staffRepository.findByIdIn(dto.getStaffIds());
			entity.setStaves(staves);

			Set<ServiceModel> services = serviceModelRepository.findByIdIn(dto.getStaffIds());
			entity.setServices(services);

			Set<Product> products = dto.getProducts().stream()
					.map((p) -> productRepository.save(modelMapper.map(p, Product.class)))
					.collect(Collectors.toSet());
			entity.setProducts(products);

			entity.setStatus("new");

			Double totalPricePerProduct = services.stream()
					.reduce(0.0, (sum, s) -> sum + s.getFee(), (sum1, sum2) -> sum1 + sum2);
			entity.setTotalPrice(totalPricePerProduct * products.size());

			return entity;
		}
		return new Order();
	}

	@Override
	public OrderDTO entityToDTO(Order entity) {
		if (entity != null) {
			OrderDTO dto = modelMapper.map(entity, OrderDTO.class);

			CustomerDTO customer = modelMapper.map(entity.getCustomer(), CustomerDTO.class);
			dto.setCustomer(customer);

			Set<StaffDTO> staves = entity.getStaves().stream()
					.map((s) -> modelMapper.map(s, StaffDTO.class))
					.collect(Collectors.toSet());
			dto.setStaffs(staves);

			Set<ServiceDTO> services = entity.getServices().stream()
					.map((s) -> modelMapper.map(s, ServiceDTO.class))
					.collect(Collectors.toSet());
			dto.setServices(services);

			Set<ProductDTO> products = dto.getProducts().stream()
					.map((p) -> modelMapper.map(p, ProductDTO.class))
					.collect(Collectors.toSet());
			dto.setProducts(products);

			return dto;
		}
		return new OrderDTO();
	}

	@Override
	@Transactional
	public OrderDTO createOrder(OrderCreationDTO dto) {
		return save(dto);
	}

	@Override
	public List<OrderDTO> getOrders() {
		List<Order> entities = orderRepository.findAllByOrderByTimeOrder();
		return entitiesToDTOS(entities);
	}

	@Override
	public OrderDTO getOrder(Integer id) {
		return findById(id);
	}

	@Override
	public OrderDTO doneOrder(Integer id) {
		Order order = orderRepository.findById(id).get();
		order.setStatus("done");
		orderRepository.save(order);
		return entityToDTO(order);
	}

}
