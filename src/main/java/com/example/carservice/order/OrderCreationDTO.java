package com.example.carservice.order;

import java.time.LocalDate;
import java.util.Set;

import com.example.carservice.common.BaseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderCreationDTO extends BaseDTO {

	private String note;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate timeOrder;

	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate timeEstimate;

	private Integer customerId;

	private Set<Integer> staffIds;

	private Set<Integer> serviceIds;

	private Set<ProductDTO> products;

}
