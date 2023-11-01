package co.deepmindz.adminorghierservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.deepmindz.adminorghierservice.dto.RolesRequestDto;
import co.deepmindz.adminorghierservice.dto.RolesResponseDto;
import co.deepmindz.adminorghierservice.exception.ResourceNotFoundException;
import co.deepmindz.adminorghierservice.models.Roles;
import co.deepmindz.adminorghierservice.repository.RolesRepository;
import co.deepmindz.adminorghierservice.repository.ZoneRepo;
import co.deepmindz.adminorghierservice.service.RolesService;
import co.deepmindz.adminorghierservice.utils.RoelsUtil;

@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	RoelsUtil rolesUtil;
	
	
	@Autowired
	RolesRepository rolesRepository;

	@Autowired
	ZoneRepo zoneRepo;

	@Override
	public RolesResponseDto createRole(RolesRequestDto dto) {
		Roles manager = rolesUtil.mapRequestDtoToEntity(dto);
		if (zoneRepo.findById(dto.getZone_id()) == null) {
			throw new ResourceNotFoundException("Zone", "zone_id", dto.getZone_id());
		}

		manager = rolesRepository.save(manager);
		return rolesUtil.mapEntityToResposeDto(List.of(manager), manager.getRole_id(), true).get(0);
	}

	public List<RolesResponseDto> getRoles() {
		List<Roles> managerWithSupervisor;
		String embededManagerWithSupervisor;
		List<RolesResponseDto> finalManagers = new ArrayList<>();
		List<Roles> managers = rolesRepository.findAll();
		for (Roles manager : managers) {
			embededManagerWithSupervisor = rolesRepository.getManagerWithSupervisorDetails(manager.getRole_id());
			managerWithSupervisor = rolesUtil.generateManagerWithSupervisor(embededManagerWithSupervisor);
			finalManagers.addAll(rolesUtil.mapEntityToResposeDto(managerWithSupervisor, manager.getRole_id(), false));
		}
		return finalManagers;
	}

	@Override
	public List<RolesResponseDto> getRoleDetails(String roleID) {
		List<Roles> managerWithSupervisor;
		String embededManagerWithSupervisor;
		List<RolesResponseDto> finalManagers = new ArrayList<>();
		embededManagerWithSupervisor = rolesRepository.getManagerWithSupervisorDetails(roleID);
		managerWithSupervisor = rolesUtil.generateManagerWithSupervisor(embededManagerWithSupervisor);
		finalManagers.addAll(rolesUtil.mapEntityToResposeDto(managerWithSupervisor, roleID, false));

		return finalManagers;
	}

	@Override
	public List<RolesResponseDto> getAllRoles() {
		List<Roles> allRoles = rolesRepository.findAll();
		return rolesUtil.MapEntityToWithoutSuperVisorDetailsResposeDto(allRoles);
	}

	@Override
	public List<RolesResponseDto> getRolesHierarchy() {
		List<Roles> allRoles = rolesRepository.getRolesInHierarchy();
		return rolesUtil.MapEntityToWithoutSuperVisorDetailsResposeDto(allRoles);
	}

	@Override
	public Roles getRoleById(String zone_id) {
		return rolesRepository.findById(zone_id).get();
	}

	@Override
	public void cleanRoles() {
		 rolesRepository.deleteAll();
	}
}
