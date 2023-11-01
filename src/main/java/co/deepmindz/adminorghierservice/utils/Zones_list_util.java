package co.deepmindz.adminorghierservice.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.deepmindz.adminorghierservice.dto.ListSSUserZonesResponseDto;
import co.deepmindz.adminorghierservice.dto.Zones_list_RequestDto;
import co.deepmindz.adminorghierservice.dto.Zones_list_ResponseDto;
import co.deepmindz.adminorghierservice.dto.Zones_list_with_parentZone_response;
import co.deepmindz.adminorghierservice.models.Zones_list;
import co.deepmindz.adminorghierservice.utils.CustomDataTypes.subZoneData;

@Service
public class Zones_list_util {

	public Zones_list mapRequestDtoToEntity(Zones_list_RequestDto dto) {

		Zones_list zones = new Zones_list();
		zones.setName(dto.getName().toLowerCase());
		zones.setLinked_zone_list(dto.getLinked_zone());
		zones.setCode(dto.getCode());
		return zones;
	}

	public Zones_list_ResponseDto mapEntityToResponseDto(Zones_list createdZones) {

		Zones_list_ResponseDto zones = new Zones_list_ResponseDto();
		zones.set_id(createdZones.get_id());
		zones.setName(createdZones.getName());
		zones.setLinked_zone(createdZones.getLinked_zone_list());
		zones.setCode(createdZones.getCode());
		return zones;
	}

	public List<Zones_list_ResponseDto> mapListEntityToListResponseDto(List<Zones_list> zones) {
		List<Zones_list_ResponseDto> listOfDto = new ArrayList<>();
		for (Zones_list zone : zones) {
			listOfDto.add(new Zones_list_ResponseDto(zone.get_id(), zone.getName(), zone.getLinked_zone_list(),
					zone.getCode()));
		}
		return listOfDto;
	}

	public List<Zones_list_with_parentZone_response> mapListEntityToParentListResponseDto(List<Zones_list> zones,
			String parentZonename) {
		List<Zones_list_with_parentZone_response> listOfDto = new ArrayList<>();
		for (Zones_list zone : zones) {
			listOfDto.add(new Zones_list_with_parentZone_response(zone.get_id(), zone.getName(),
					zone.getLinked_zone_list(), parentZonename, zone.getCode()));
		}
		return listOfDto;
	}

	public Zones_list_ResponseDto mapEntityToResponseDto(Optional<Zones_list> findById) {

		Zones_list_ResponseDto zones = new Zones_list_ResponseDto();
		zones.set_id(findById.get().get_id());
		zones.setName(findById.get().getName());
		zones.setLinked_zone(findById.get().getLinked_zone_list());
		zones.setCode(findById.get().getCode());
		return zones;
	}

	public Zones_list mapEntityToResponseDto(Zones_list_RequestDto responseDto) {

		Zones_list zones = new Zones_list();
//	zones.set_id(responseDto.get_id());
		zones.setName(responseDto.getName());
		zones.setLinked_zone_list(responseDto.getLinked_zone());
		zones.setCode(responseDto.getCode());
		return zones;
	}

	public List<Zones_list_ResponseDto> mapEntityToResponseDto(List<Zones_list> zones) {
		List<Zones_list_ResponseDto> listOfDto = new ArrayList<>();
		for (Zones_list zone : zones) {
			listOfDto.add(new Zones_list_ResponseDto(zone.get_id(), zone.getName(), zone.getLinked_zone_list(),
					zone.getCode()));
		}
		return listOfDto;
	}

	public List<subZoneData> populateZonesWithSubZonesList(List<Zones_list_ResponseDto> zonesResponseList,
			List<Zones_list_ResponseDto> subZonesResponseList,
			Map<String, List<Zones_list_ResponseDto>> zoneIDWithSubZones) {
		List<subZoneData> stateWithDistricts = new ArrayList<>();
		for (Zones_list_ResponseDto state : zonesResponseList) {
			subZoneData obj = new subZoneData(state.getName(), zoneIDWithSubZones.get(state.get_id()));
			stateWithDistricts.add(obj);
		}
		return stateWithDistricts;
	}

	public ListSSUserZonesResponseDto prepareZoneWithSubZonesResponse(String role, List<Zones_list> zones,
			List<Zones_list> subZones) {
		Map<String, List<Zones_list_ResponseDto>> zoneIDWithSubZones = new HashMap<>();

		List<Zones_list_ResponseDto> zonesResponseList = mapEntityToResponseDto(zones);
		List<Zones_list_ResponseDto> subZonesResponseList = mapEntityToResponseDto(subZones);

		for (Zones_list_ResponseDto subZn : subZonesResponseList) {
			if (zoneIDWithSubZones.get(subZn.getLinked_zone()) == null) {
				zoneIDWithSubZones.put(subZn.getLinked_zone(), new ArrayList<>(Arrays.asList(subZn)));
			} else {
				zoneIDWithSubZones.get(subZn.getLinked_zone()).add(subZn);
			}
		}

		return new ListSSUserZonesResponseDto(role, zonesResponseList,
				populateZonesWithSubZonesList(zonesResponseList, subZonesResponseList, zoneIDWithSubZones));
	}
}
