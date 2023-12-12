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
public class SSResponseDtoForRestCall {

		private String member_id;

		private String member_name;

//		private String member_code;

		private String phone_number;

		private String user_name;

//		private String department;

		private String designation;

		private String linkedZones;

		private String status;

		private Timestamp created_at;


}
