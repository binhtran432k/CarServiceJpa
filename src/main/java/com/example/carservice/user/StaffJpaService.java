package com.example.carservice.user;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.carservice.common.BaseJpaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StaffJpaService
		extends BaseJpaService<Staff, Integer, StaffDTO, StaffDTO>
		implements StaffService {

	private final StaffRepository staffRepository;

	private final ModelMapper modelMapper;

	@Override
	public JpaRepository<Staff, Integer> getDefaultRepository() {
		return staffRepository;
	}

	@Override
	public Staff dtoToEntity(StaffDTO dto) {
		if (dto != null) {
			Staff entity = modelMapper.map(dto, Staff.class);
			Wallet wallet = modelMapper.map(dto.getWallet(), Wallet.class);
			entity.setWallet(wallet);
			return entity;
		}
		return new Staff();
	}

	@Override
	public StaffDTO entityToDTO(Staff entity) {
		if (entity != null) {
			StaffDTO dto = modelMapper.map(entity, StaffDTO.class);
			WalletDTO wallet = modelMapper.map(entity.getWallet(), WalletDTO.class);
			dto.setWallet(wallet);
			return dto;
		}
		return new StaffDTO();
	}

	@Override
	public StaffDTO createStaff(StaffDTO dto) {
		return save(dto);
	}

	@Override
	public List<StaffDTO> getStaves() {
		return findAll();
	}

	@Override
	public StaffDTO getStaff(Integer id) {
		return findById(id);
	}
}
