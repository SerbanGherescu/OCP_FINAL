package com.example.ocpv2.repository;


import com.example.ocpv2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role save(Role role);

    Optional<Role> findByName(String name);

    void deleteById(Long id);

}
