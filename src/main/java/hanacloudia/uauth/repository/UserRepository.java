package hanacloudia.uauth.repository;

import hanacloudia.uauth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByHanaPrtlEmpNoAndPassword(String uid,String password);

    UserEntity findByHanaPrtlEmpNo(String uid);
}
