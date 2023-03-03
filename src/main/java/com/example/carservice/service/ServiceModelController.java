package com.example.carservice.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceModelController {

	private final ServiceModelService serviceModelService;

	@PostMapping
	public ServiceDTO createService(@RequestBody ServiceDTO dto) {
		return serviceModelService.createService(dto);
	}

	@GetMapping
	public List<ServiceDTO> getServices() {
		return serviceModelService.getServices();
	}

	@GetMapping("/{id}")
	public ServiceDTO getService(@PathVariable Integer id) {
		return serviceModelService.getService(id);
	}

}
