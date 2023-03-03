package com.example.carservice.user;

import java.util.Set;

import com.example.carservice.common.NamedEntity;
import com.example.carservice.order.Order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer extends NamedEntity {

	@Column(name = "phone")
	private String phone;

	@Column(name = "address")
	private String address;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "wallet_id")
	private Wallet wallet;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Set<Order> orders;

}
