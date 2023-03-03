package com.example.carservice.service;

import java.util.List;

public interface ServiceModelService {

	ServiceDTO createService(ServiceDTO serviceDTO);

	List<ServiceDTO> getServices();

	ServiceDTO getService(Integer id);

}
