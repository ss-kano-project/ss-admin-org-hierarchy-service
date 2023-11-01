package co.deepmindz.adminorghierservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.deepmindz.adminorghierservice.dto.ZonesRequestDto;
import co.deepmindz.adminorghierservice.dto.ZonesResponseDto;
import jakarta.validation.Valid;

@Service
public interface ZoneService {

	ZonesResponseDto createZone(@Valid ZonesRequestDto zonesDto);

	List<ZonesResponseDto> getAllZones(String ZonesId);

	ZonesResponseDto zoneById(String zoneId);

	ZonesResponseDto updateZone(String id, ZonesResponseDto zonesDto);

	ZonesResponseDto deleteZones_list(String zoneId);
	
	List<ZonesResponseDto> getZonesHierarchy();

	void cleanAllZone();
	
//	public void cleanAllLanguageLiterals();
	
}
