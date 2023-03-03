package com.example.carservice.user;

import java.util.List;

public interface StaffService {

	StaffDTO createStaff(StaffDTO dto);

	List<StaffDTO> getStaves();

	StaffDTO getStaff(Integer id);

}
