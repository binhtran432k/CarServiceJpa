package com.example.carservice.order;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService customerService;

	@PostMapping
	public OrderDTO createOrder(@RequestBody OrderCreationDTO dto) {
		return customerService.createOrder(dto);
	}

	@GetMapping
	public List<OrderDTO> getOrders() {
		return customerService.getOrders();
	}

	@GetMapping("/{id}")
	public OrderDTO getOrder(@PathVariable Integer id) {
		return customerService.getOrder(id);
	}

	@PutMapping("/{id}/done")
	public OrderDTO doneOrder(@PathVariable Integer id) {
		return customerService.doneOrder(id);
	}

}
