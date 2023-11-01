package co.deepmindz.adminorghierservice.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RolesResponseDto {

	private String role_id;

	private String title;

	private String role_code;

	private String zone_id;

	private String supervisorRole_id;

	private Timestamp created_at;

	private RolesResponseDto supervisor_details;

}
