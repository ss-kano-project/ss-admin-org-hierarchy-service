package co.deepmindz.adminorghierservice.models;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "zones")
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zones {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String zone_id;

	private String parentZone_id;
	@Column(unique = true)
	private String name;

	@Column(unique = true)
	private String zone_code;

	@Column(name = "create_at", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Timestamp createdat;

}