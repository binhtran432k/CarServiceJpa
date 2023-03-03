package com.example.carservice.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/staves")
@RequiredArgsConstructor
public class StaffController {

	private final StaffService customerService;

	@PostMapping
	public StaffDTO createStaff(@RequestBody StaffDTO dto) {
		return customerService.createStaff(dto);
	}

	@GetMapping
	public List<StaffDTO> getStaves() {
		return customerService.getStaves();
	}

	@GetMapping("/{id}")
	public StaffDTO getStaff(@PathVariable Integer id) {
		return customerService.getStaff(id);
	}

}
