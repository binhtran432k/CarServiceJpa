package com.example.carservice.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NamedDTO extends BaseDTO {

	private String name;

}
