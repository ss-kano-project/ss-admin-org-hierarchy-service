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
public class MemberResponseDto {
	
	private String user_id;

	private String name;

	private String role;

	private String username;
	
	private String memberStatus;
	
	private String[] linked_zones;

	private Timestamp created_at;
}


