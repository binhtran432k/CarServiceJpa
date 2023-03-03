package com.example.carservice.service;

import java.util.Set;

import com.example.carservice.common.NamedEntity;
import com.example.carservice.order.Order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "services")
@Getter
@Setter
public class ServiceModel extends NamedEntity {

	@Column(name = "fee", nullable = false)
	private Double fee;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "order_service", joinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"))
	private Set<Order> orders;

}
