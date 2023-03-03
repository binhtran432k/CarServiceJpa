package com.example.carservice.order;

import java.util.List;

public interface ProductService {

	ProductDTO createProduct(ProductDTO dto);

	List<ProductDTO> getProducts();

	ProductDTO getProduct(Integer id);

}
