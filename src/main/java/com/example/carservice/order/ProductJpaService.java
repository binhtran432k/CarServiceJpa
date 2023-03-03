package com.example.carservice.order;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.carservice.common.BaseJpaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductJpaService extends BaseJpaService<Product, Integer, ProductDTO, ProductDTO> implements ProductService {

	private final ProductRepository productRepository;

	private final ModelMapper modelMapper;

	@Override
	public JpaRepository<Product, Integer> getDefaultRepository() {
		return productRepository;
	}

	@Override
	public Product dtoToEntity(ProductDTO dto) {
		if (dto != null) {
			Product entity = modelMapper.map(dto, Product.class);
			return entity;
		}
		return new Product();
	}

	@Override
	public ProductDTO entityToDTO(Product entity) {
		if (entity != null) {
			ProductDTO dto = modelMapper.map(entity, ProductDTO.class);
			return dto;
		}
		return new ProductDTO();
	}

	@Override
	public ProductDTO createProduct(ProductDTO dto) {
		return save(dto);
	}

	@Override
	public List<ProductDTO> getProducts() {
		return findAll();
	}

	@Override
	public ProductDTO getProduct(Integer id) {
		return findById(id);
	}

}
