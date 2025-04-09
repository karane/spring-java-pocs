package org.karane.service;

import org.karane.entity.Role;
import org.karane.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    public List<Role> getRoles() {

        Iterable<Role> it = roleRepository.findAll();
        List<Role> result = new ArrayList<>();
        it.forEach(result::add);

        return result;
    }
}
