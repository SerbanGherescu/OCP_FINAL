package com.example.ocpv2.service;

import com.example.ocpv2.entity.Role;
import com.example.ocpv2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role searchRoleById(Long id) {
        Role role = roleRepository.findById(id).get();
        return role;
    }

    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }

}
