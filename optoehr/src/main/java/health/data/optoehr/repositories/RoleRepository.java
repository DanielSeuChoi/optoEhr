package health.data.optoehr.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import health.data.optoehr.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();

    List<Role> findByName(String name);
}
