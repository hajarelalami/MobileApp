package data.reposetry;

import data.entities.PostEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReposetry extends JpaRepository<PostEntity, Long>  {
    @Query( value = "SELECT * FROM  post WHERE user_id = ?1", nativeQuery = true) List<PostEntity> findPostsByUserId(String userId);
}
