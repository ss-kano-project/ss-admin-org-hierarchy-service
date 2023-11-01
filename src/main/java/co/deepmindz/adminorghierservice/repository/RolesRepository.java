package co.deepmindz.adminorghierservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import co.deepmindz.adminorghierservice.models.Roles;

@Component
public interface RolesRepository extends JpaRepository<Roles, String> {

	@Query("select s.role_id as s_manager_id, s.created_at as s_created_at, "
			+ "s.role_code as s_manager_code, s.supervisorRole_id as s_supervisor_id, "
			+ "s.title as s_title, s.zone_id as s_zone_id, m.role_id as m_id, "
			+ "m.created_at as m_created_at, m.role_code as m_manager_code, "
			+ "m.supervisorRole_id as m_supervisor_id, m.title as m_title, m.zone_id as m_zone_id "
			+ "from Roles m left join Roles s on m.supervisorRole_id = s.role_id " + "where m.role_id = :role_id")
	public String getManagerWithSupervisorDetails(@Param("role_id") String role_id);

	@Query("select role_id from Roles where zone_id = :zone_id")
	public String getSupervisorRoleId(@Param("zone_id") String zone_id);

	@Query(nativeQuery = true, value = "WITH RECURSIVE employee_hierarchy AS ( SELECT role_id, created_at, role_code, "
			+ "supervisor_role_id, title, zone_id FROM Roles WHERE supervisor_role_id is null "
			+ "UNION ALL SELECT e.role_id, e.created_at, e.role_code, e.supervisor_role_id, e.title, e.zone_id "
			+ "FROM Roles e, employee_hierarchy WHERE e.supervisor_role_id = employee_hierarchy.role_id ) "
			+ "SELECT * FROM employee_hierarchy ")
	public List<Roles> getRolesInHierarchy();
}
