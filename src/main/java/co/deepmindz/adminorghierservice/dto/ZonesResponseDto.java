package co.deepmindz.adminorghierservice.dto;
import java.sql.Timestamp;

public class ZonesResponseDto {

	private String zone_id;
	private String parentZone_id;
	private String name;
	private String zone_code;
	private Timestamp created_at;
	public ZonesResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZonesResponseDto(String zone_id, String parentZone_id, String name, String zone_code, Timestamp created_at) {
		super();
		this.zone_id = zone_id;
		this.parentZone_id = parentZone_id;
		this.name = name;
		this.zone_code = zone_code;
		this.created_at = created_at;
	}
	public String getZone_id() {
		return zone_id;
	}
	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}
	public String getParentZone_id() {
		return parentZone_id;
	}
	public void setParentZone_id(String parentZone_id) {
		this.parentZone_id = parentZone_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZone_code() {
		return zone_code;
	}
	public void setZone_code(String zone_code) {
		this.zone_code = zone_code;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	@Override
	public String toString() {
		return "ZonesResponseDto [zone_id=" + zone_id + ", parentZone_id=" + parentZone_id + ", name=" + name
				+ ", zone_code=" + zone_code + ", created_at=" + created_at + "]";
	}
}

