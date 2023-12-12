package co.deepmindz.adminorghierservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.deepmindz.adminorghierservice.models.SSUser;
import co.deepmindz.adminorghierservice.models.Zones_list;

public interface SSUserRepository extends JpaRepository<SSUser, String> {

	public SSUser findByUsername(@Param("username") String username);

	public List<SSUser> findByLinkedSupervisors(String[] roleId);

	public List<SSUser> findByLinkedZone(String zoneId);

	@Query(value = "select z from Zones_list z where z._id IN :zoneid")
	public List<Zones_list> getUserAllZonesDetails(@Param("zoneid") List<String> zoneid);

	
	@Query(value = "select s from SSUser s where s.linkedZone IN :zoneid")
	public List<SSUser> getTeamMemberByZoneId(@Param("zoneid") String zoneId);

	@Query(value = "select s from SSUser s where s.user_id IN :memberIds")
	public List<SSUser> findByIds(@Param ("memberIds") String[] memberIds);
	
}
