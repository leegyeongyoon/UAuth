package hanacloudia.uauth.repository;

import hanacloudia.uauth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UAuthRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByHanaPrtlEmpNoAndPassword(String uid,String password);
    UserEntity findByHanaPrtlEmpNo(String uid);

}
