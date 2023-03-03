package com.example.carservice.user;

import com.example.carservice.common.NamedDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StaffDTO extends NamedDTO {

	private String phone;

	private WalletDTO wallet;

}
