package Application.Connection;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SearchesRepository extends CrudRepository<Searches, Integer> {
	
	@Query(value = "SELECT * FROM searches WHERE type = :type AND action = :action AND slug = :slug ORDER BY count DESC LIMIT 1",	nativeQuery =	true)
	Searches getSearch(@Param("type") String type, @Param("action") String action, @Param("slug") String slug);

	@Query(value = "SELECT * FROM searches GROUP BY type, action, slug ORDER BY count DESC", nativeQuery = true)
	List<Searches> getCommon();
}
