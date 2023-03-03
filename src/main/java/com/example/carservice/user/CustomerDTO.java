package com.example.carservice.user;

import com.example.carservice.common.NamedDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerDTO extends NamedDTO {

	private String phone;

	private String address;

	private WalletDTO wallet;

}
