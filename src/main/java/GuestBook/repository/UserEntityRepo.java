package GuestBook.repository;

import GuestBook.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserEntityByUsername(String name);
    boolean existUserEntityByUsername(String username);
    boolean existUserEntityByEmail(String email);
}
