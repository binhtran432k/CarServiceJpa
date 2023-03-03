package com.example.carservice.user;

import com.example.carservice.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "wallets")
@Getter
@Setter
public class Wallet extends BaseEntity {

	@Column(name = "account_num", nullable = false, unique = true)
	private String accountNum;

	@Column(name = "balance", nullable = false)
	private Double balance;

}
