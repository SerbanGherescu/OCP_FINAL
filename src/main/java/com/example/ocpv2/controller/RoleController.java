package com.example.ocpv2.controller;

import com.example.ocpv2.entity.Role;
import com.example.ocpv2.entity.exceptions.ProductNotFoundException;
import com.example.ocpv2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

//    @GetMapping("/{id}")
//    public ResponseEntity<Role> getRoleByName(@PathVariable Long id) {
//        Role role = roleService.searchRoleById(id);
//        if (id == null) {
//            throw new ProductNotFoundException("Nu se gaseste un rol cu acest id!");
//        }
//        return ResponseEntity.ok(role);
//    }

    @DeleteMapping("/deleteRole/{id}")
    public String deleteRoleById(@PathVariable Long id) {
        roleService.deleteRoleById(id);
        return "Rol sters cu succes!";
    }

}
