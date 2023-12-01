package co.deepmindz.adminorghierservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.deepmindz.adminorghierservice.dto.ListSSUserSubZonesRequestDto;
import co.deepmindz.adminorghierservice.dto.ListSSUserZonesResponseDto;
import co.deepmindz.adminorghierservice.dto.MemberResponseDto;
import co.deepmindz.adminorghierservice.dto.SSUserRequestDto;
import co.deepmindz.adminorghierservice.dto.SSUserResponseDto;
import co.deepmindz.adminorghierservice.dto.UpdateMemberRequestDto;
import co.deepmindz.adminorghierservice.dto.Zones_list_ResponseDto;
import co.deepmindz.adminorghierservice.models.Zones_list;

@Service
public interface SSUserService {

	Integer getZonesCountUsingLinkedZones(String parentZoneID);
	
	ListSSUserZonesResponseDto getAllZoneForSSUser(String role, List<String> parentZoneID);
	
//	List<Zones_list_ResponseDto> getSubZonesLevelDetails(ListSSUserSubZonesRequestDto dto);
	
	SSUserResponseDto createSSUser(SSUserRequestDto createSSUserData, String loginmode);
	
	List<SSUserResponseDto> getSubordinateRoleSSUsers(String roleID);
	
	List<SSUserResponseDto> getSupervisorByRelationshipId(String zoneID);
	
	List<SSUserResponseDto> getAllSSUsers(String userIDorUsername, boolean isfindByUsername);
	
	List<Zones_list> getSSUserZonewithSubZoneDetails(String ssuserID);
	
	List<MemberResponseDto> getTeamMemberByZoneId(String zoneId);

	List<SSUserResponseDto> updateUserByIds(String[] memberDto);
}
