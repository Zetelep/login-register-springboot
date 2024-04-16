package loginregister.user.repository;

import loginregister.user.data.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<Users,Long>{
    Optional<Users> findByEmail(String email);
}
