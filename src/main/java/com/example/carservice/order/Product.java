package com.example.carservice.order;

import java.util.Set;

import com.example.carservice.common.NamedEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends NamedEntity {

	@Column(name = "color", nullable = false)
	private String color;

	@Column(name = "status", nullable = false)
	private String status;

	@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
	private Set<Order> orders;

}
