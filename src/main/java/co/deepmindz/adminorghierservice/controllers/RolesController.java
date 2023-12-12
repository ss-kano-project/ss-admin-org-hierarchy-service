package co.deepmindz.adminorghierservice.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import co.deepmindz.adminorghierservice.dto.RolesRequestDto;
import co.deepmindz.adminorghierservice.dto.RolesResponseDto;
import co.deepmindz.adminorghierservice.dto.ZonesResponseDto;
import co.deepmindz.adminorghierservice.exception.ResourceNotFoundException;
import co.deepmindz.adminorghierservice.resources.CustomHttpResponse;
import co.deepmindz.adminorghierservice.service.RolesService;
import co.deepmindz.adminorghierservice.service.ZoneService;
import co.deepmindz.adminorghierservice.utils.CustomDataTypes;
import jakarta.validation.Valid;

/*
 * author : ram kumar
 */

@RestController
@RequestMapping("/organization")
public class RolesController {

	@Autowired
	ZoneService zoneService;

	@Autowired
	RolesService rolesService;

	private static Map<String, String> loginmode = null;

	private Logger logger = LoggerFactory.getLogger(RolesController.class);

	private static final String[] services = { "http://admin-main-service" };

	private static ParameterizedTypeReference<Map<String, String>> responseType = new ParameterizedTypeReference<>() {
	};

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/role")
	public ResponseEntity<Object> createRole(@Valid @RequestBody RolesRequestDto managerDto) {
		logger.info("RolesController.class:createRole():role", managerDto);
		RolesResponseDto responseDto = rolesService.createRole(managerDto);
		return CustomHttpResponse.responseBuilder("Role has been created:", HttpStatus.CREATED, responseDto);
	}

	@GetMapping("/role/{roleID}")
	public ResponseEntity<Object> getRoleDetails(@PathVariable String roleID) {
		logger.info("RolesController.class:getManagerDetails():role", roleID);
		List<RolesResponseDto> responseDto = rolesService.getRoleDetails(roleID);
		return CustomHttpResponse.responseBuilder("Role with : " + roleID, HttpStatus.OK, responseDto.get(0));
	}

	@GetMapping("/role/get-all-roles")
	public ResponseEntity<Object> getAllManagers() {
		logger.info("RolesController.class:getAllManagers():get-all-roles");
		List<RolesResponseDto> responseDto = rolesService.getRoles();
		if (responseDto.size() > 1)
			return CustomHttpResponse.responseBuilder("All Roles  : ", HttpStatus.OK, responseDto);
		else {
			logger.error("RolesController.class:getAllManagers():get-all-roles", "ResourceNotFoundException");
			throw new ResourceNotFoundException("Roles", "any ID", "Roles");
		}
	}

	@GetMapping("/all-organization-relationships")
	public ResponseEntity<Object> getRelationShip() {
		logger.info("RolesController.class:getRelationShip():all-organization-relationships");
		List<RolesResponseDto> allmanagers = rolesService.getRolesHierarchy();
		List<ZonesResponseDto> allZones = zoneService.getZonesHierarchy();

		if (allmanagers.isEmpty() || allmanagers == null) {
			logger.error("RolesController.class:getRelationShip():all-organization-relationships", "Roles Not Found");
			throw new ResourceNotFoundException("Roles", "required relation", null);
		}
		if (allZones.isEmpty() || allZones == null) {
			logger.error("RolesController.class:getRelationShip():all-organization-relationships", "Zones Not Found");
			throw new ResourceNotFoundException("Zones", "required relation", null);
		}
		HashMap<String, RolesResponseDto> idWithRolesMap = new HashMap<>();
		HashMap<String, RolesResponseDto> idWithManagerObjectMap = new HashMap<>();
		List<CustomDataTypes.relation> organizationRelation = new ArrayList<>();
		if (loginmode == null) {
			RequestEntity<Void> request = RequestEntity
					.get(services[0] + "/admin-main/login-mode/current-loginMode-status")
					.accept(MediaType.APPLICATION_JSON).build();
			loginmode = restTemplate.exchange(request, responseType).getBody();
		}

		for (RolesResponseDto manager : allmanagers) {
			idWithManagerObjectMap.put(manager.getRole_id(), manager);
			idWithRolesMap.put(manager.getZone_id(), manager);
		}

		for (ZonesResponseDto zone : allZones) {
			String reportsTo;
			String supervisor = idWithRolesMap.get(zone.getZone_id()).getSupervisorRole_id();

			if (supervisor == null || supervisor.isEmpty()) {
				reportsTo = null;
			} else {
				reportsTo = idWithManagerObjectMap.get(supervisor) == null ? null
						: idWithManagerObjectMap.get(supervisor).getTitle();
			}

			organizationRelation.add(new CustomDataTypes.relation(zone.getName(), zone.getZone_id(),
					idWithRolesMap.get(zone.getZone_id()).getTitle(),
					idWithRolesMap.get(zone.getZone_id()).getRole_id(), reportsTo));
		}

		logger.info("RolesController.class:getRelationShip():all-organization-relationships", organizationRelation);
		return CustomHttpResponse.responseBuilder("Organizational Relation :", HttpStatus.OK, organizationRelation);
	}

	@DeleteMapping("/role/clean-roles")
	public ResponseEntity<Object> cleanRoles() {
		rolesService.cleanRoles();
		return CustomHttpResponse.responseBuilder("All roles has been cleaned", HttpStatus.OK, "/role/clean-roles");

	}
}