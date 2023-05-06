package org.techtalk.debu.spring.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.techtalk.debu.spring.jpa.entity.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long>{

	@Query(value="SELECT * FROM Tutorial",nativeQuery=true)
	List<Tutorial> findAll();
	
	@Query("SELECT t FROM Tutorial t")
	List<Tutorial> findAllSort(Sort sort);
	
	@Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%'))")
	List<Tutorial> findByTitleAndSort(String title, Sort sort);
	
	@Query("SELECT t FROM Tutorial t")
	Page<Tutorial> findAllWithPagination(Pageable pageable);

	Optional<Tutorial> findByIdAndTitle(long id, String title);

	Optional<Tutorial> findByTitle(String title);
	
/*	
	@Query("SELECT * FROM Tutorial where id ='1'")
	public Tutorial getTutorialById() ;*/
	
	/*	@Query("SELECT t FROM Tutorial t WHERE t.published=?1")
List<Tutorial> findByPublished(boolean isPublished);

@Query("SELECT t FROM Tutorial t WHERE t.title LIKE %?1%")
List<Tutorial> findByTitleLike(String title);*/

/*	@Query("SELECT t FROM Tutorial t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', ?1,'%'))")
List<Tutorial> findByTitleLikeCaseInsensitive(String title);*/

	
}
