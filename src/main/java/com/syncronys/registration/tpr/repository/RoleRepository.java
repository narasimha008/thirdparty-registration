package com.syncronys.registration.tpr.repository;

import com.syncronys.registration.tpr.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
