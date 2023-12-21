package co.deepmindz.adminorghierservice.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.deepmindz.adminorghierservice.dto.ZonesRequestDto;
import co.deepmindz.adminorghierservice.dto.ZonesResponseDto;
import co.deepmindz.adminorghierservice.models.Zones;

@Service
public class ZonesUtil {

	public Zones mapRequestDtoToEntity(ZonesRequestDto dto) {

		Zones zones = new Zones();
		zones.setParentZone_id(dto.getParentZone_id());
		zones.setZone_code(dto.getZone_code());
		zones.setName(dto.getName().toUpperCase());
		return zones;
	}

	public Zones mapRequestDtoToUpdateEntity(ZonesResponseDto zonesDto) {

		Zones zones = new Zones();
		zones.setZone_id(zonesDto.getZone_id());
		zones.setParentZone_id(zonesDto.getParentZone_id());
		zones.setCreated_at(zonesDto.getCreated_at());
		zones.setZone_code(zonesDto.getZone_code());
		zones.setName(zonesDto.getName());
		return zones;
	}

	public List<ZonesResponseDto> mapEntityToResponseDto(List<Zones> zones) {
		List<ZonesResponseDto> listOfDto = new ArrayList<>();
		for (Zones zone : zones) {
			listOfDto.add(new ZonesResponseDto(zone.getZone_id(), zone.getParentZone_id(), zone.getName(),
					zone.getZone_code(), zone.getCreated_at()));
		}
		return listOfDto;
	}

	public List<ZonesResponseDto> mapListEntityToListResponseDto(List<Zones> zones) {
		List<ZonesResponseDto> listOfDto = new ArrayList<>();
		for (Zones zone : zones) {
			listOfDto.add(new ZonesResponseDto(zone.getZone_id(), zone.getParentZone_id(), zone.getName(),
					zone.getZone_code(), zone.getCreated_at()));
		}
		return listOfDto;
	}

	public ZonesResponseDto mapEntityToResponseDto(Zones zones) {
		ZonesResponseDto zoneDto = new ZonesResponseDto();
		zoneDto.setCreated_at(zones.getCreated_at());
		zoneDto.setName(zones.getName());
		zoneDto.setParentZone_id(zones.getParentZone_id());
		zoneDto.setZone_code(zones.getZone_code());
		zoneDto.setZone_id(zones.getZone_id());
		return zoneDto;
	}

	public ZonesResponseDto mapEntityToResponseDto(Optional<Zones> zones) {
		ZonesResponseDto zoneDto = new ZonesResponseDto();
		zoneDto.setCreated_at(zones.get().getCreated_at());
		zoneDto.setName(zones.get().getName());
		zoneDto.setParentZone_id(zones.get().getParentZone_id());
		zoneDto.setZone_code(zones.get().getZone_code());
		zoneDto.setZone_id(zones.get().getZone_id());
		return zoneDto;
	}

}
