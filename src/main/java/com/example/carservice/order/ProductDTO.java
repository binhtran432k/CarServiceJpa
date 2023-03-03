package com.example.carservice.order;

import com.example.carservice.common.NamedDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDTO extends NamedDTO {

	private String color;

	private String status;
}
