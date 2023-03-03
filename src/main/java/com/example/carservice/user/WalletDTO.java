package com.example.carservice.user;

import com.example.carservice.common.BaseDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class WalletDTO extends BaseDTO {

	private String accountNum;

	private Double balance;

}
