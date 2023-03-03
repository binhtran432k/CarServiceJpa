package com.example.carservice.order;

import java.time.LocalDate;
import java.util.Set;

import com.example.carservice.common.BaseEntity;
import com.example.carservice.service.ServiceModel;
import com.example.carservice.user.Customer;
import com.example.carservice.user.Staff;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders", indexes = @Index(name = "order_time_order", columnList = "time_order asc"))
@Getter
@Setter
public class Order extends BaseEntity {

	@Column(name = "note")
	private String note;

	@Column(name = "time_order", nullable = false)
	private LocalDate timeOrder;

	@Column(name = "time_estimate", nullable = false)
	private LocalDate timeEstimate;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "total_price", nullable = false)
	private Double totalPrice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	private Set<Product> products;

	@ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
	private Set<Staff> staves;

	@ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
	private Set<ServiceModel> services;

}
