package io.flats.repository;

import io.flats.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Role repository.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Find by name optional.
     *
     * @param role the role curator
     * @return the optional
     */
    Optional<Role> findByName(String role);
}
