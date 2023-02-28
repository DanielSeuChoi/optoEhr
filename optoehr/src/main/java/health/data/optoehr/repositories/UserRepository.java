package health.data.optoehr.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import health.data.optoehr.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

}
