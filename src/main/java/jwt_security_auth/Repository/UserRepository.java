package jwt_security_auth.Repository;

import jwt_security_auth.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserID(Long id);
    Optional<UserEntity> findByEmail(String email);
}
