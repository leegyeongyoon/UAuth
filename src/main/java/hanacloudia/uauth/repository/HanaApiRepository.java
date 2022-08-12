package hanacloudia.uauth.repository;

import hanacloudia.uauth.entity.HanaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HanaApiRepository extends JpaRepository<HanaUserEntity,Long> {
    List<HanaUserEntity> findByHanaPrtlEmpNoAndPassword(String uid, String password);
    List<HanaUserEntity> findByHanaprtlEmpNm(String name);
    List<HanaUserEntity> findByHanaPrtlEmpNo(String empno);
    List<HanaUserEntity> findByEmalAdr(String email);

}
