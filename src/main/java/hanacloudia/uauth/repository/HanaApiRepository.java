package hanacloudia.uauth.repository;

import hanacloudia.uauth.entity.HanaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HanaApiRepository extends JpaRepository<HanaUserEntity,Long> {

}
