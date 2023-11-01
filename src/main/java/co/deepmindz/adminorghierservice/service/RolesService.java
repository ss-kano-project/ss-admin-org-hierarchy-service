package co.deepmindz.adminorghierservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.deepmindz.adminorghierservice.dto.RolesRequestDto;
import co.deepmindz.adminorghierservice.dto.RolesResponseDto;
import co.deepmindz.adminorghierservice.models.Roles;

@Service
public interface RolesService {

	public RolesResponseDto createRole(RolesRequestDto dto);
	
	public List<RolesResponseDto> getRoles();
	
	public List<RolesResponseDto> getRoleDetails(String roleID);
	
	public List<RolesResponseDto> getAllRoles();
	
	public List<RolesResponseDto> getRolesHierarchy();

	public Roles getRoleById(String zone_id);

	public void cleanRoles();
	
}
