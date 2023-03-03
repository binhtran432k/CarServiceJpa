package com.example.carservice.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.carservice.common.BaseJpaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceModelJpaService extends BaseJpaService<ServiceModel, Integer, ServiceDTO, ServiceDTO>
		implements ServiceModelService {

	private final ServiceModelRepository serviceModelRepository;

	private final ModelMapper modelMapper;

	@Override
	public JpaRepository<ServiceModel, Integer> getDefaultRepository() {
		return serviceModelRepository;
	}

	@Override
	public ServiceModel dtoToEntity(ServiceDTO dto) {
		if (dto != null) {
			ServiceModel entity = modelMapper.map(dto, ServiceModel.class);
			return entity;
		}
		return new ServiceModel();
	}

	@Override
	public ServiceDTO entityToDTO(ServiceModel entity) {
		if (entity != null) {
			ServiceDTO dto = modelMapper.map(entity, ServiceDTO.class);
			return dto;
		}
		return new ServiceDTO();
	}

	@Override
	public ServiceDTO createService(ServiceDTO serviceDTO) {
		return save(serviceDTO);
	}

	@Override
	public List<ServiceDTO> getServices() {
		return findAll();
	}

	@Override
	public ServiceDTO getService(Integer id) {
		return findById(id);
	}

}
