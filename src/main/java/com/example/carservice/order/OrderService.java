package com.example.carservice.order;

import java.util.List;

public interface OrderService {

	OrderDTO createOrder(OrderCreationDTO dto);

	List<OrderDTO> getOrders();

	OrderDTO getOrder(Integer id);

	OrderDTO doneOrder(Integer id);

}
