package com.goldenspace.dao;

import com.goldenspace.entity.Role;
import com.goldenspace.entity.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
