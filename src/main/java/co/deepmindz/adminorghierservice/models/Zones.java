package co.deepmindz.adminorghierservice.models;

import java.sql.Timestamp;

import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "zones")
@ToString
public class Zones {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String zone_id;

	private String parentZone_id;
	@Column(unique = true)
	private String name;

	@Column(unique = true)
	private String zone_code;

	@Column(updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Timestamp created_at;

	public Zones() {
		super();
	}

	public Zones(String zone_id, String parentZone_id, String name, String zone_code, Timestamp created_at) {
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

}