package com.example.carservice.service;

import com.example.carservice.common.NamedDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceDTO extends NamedDTO {

	private Double fee;

}
