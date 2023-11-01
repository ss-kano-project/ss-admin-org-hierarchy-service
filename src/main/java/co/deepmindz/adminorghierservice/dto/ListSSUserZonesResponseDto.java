package co.deepmindz.adminorghierservice.dto;

import java.util.List;

import co.deepmindz.adminorghierservice.utils.CustomDataTypes.subZoneData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListSSUserZonesResponseDto {

	private String role;
	
	private List<Zones_list_ResponseDto> zones;
	
	private List<subZoneData> subZones;
	
}
