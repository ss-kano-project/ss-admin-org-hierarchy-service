package co.deepmindz.adminorghierservice.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ZonesResponseDto {

	private String zone_id;
	private String parentZone_id;
	private String name;
	private String zone_code;
	private Timestamp created_at;
}
