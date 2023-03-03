package com.example.carservice.order;

import java.time.LocalDate;
import java.util.Set;

import com.example.carservice.common.BaseDTO;
import com.example.carservice.service.ServiceDTO;
import com.example.carservice.user.CustomerDTO;
import com.example.carservice.user.StaffDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDTO extends BaseDTO {

	private String note;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate timeOrder;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate timeEstimate;

	private String status;

	private Double totalPrice;

	private CustomerDTO customer;

	private Set<StaffDTO> staffs;

	private Set<ServiceDTO> services;

	private Set<ProductDTO> products;

}
