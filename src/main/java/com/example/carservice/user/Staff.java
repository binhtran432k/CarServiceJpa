package com.example.carservice.user;

import java.util.Set;

import com.example.carservice.common.NamedEntity;
import com.example.carservice.order.Order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "staves")
@Getter
@Setter
public class Staff extends NamedEntity {

	@Column(name = "phone")
	private String phone;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "wallet_id")
	private Wallet wallet;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "order_staff", joinColumns = @JoinColumn(name = "staff_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"))
	private Set<Order> orders;

}
