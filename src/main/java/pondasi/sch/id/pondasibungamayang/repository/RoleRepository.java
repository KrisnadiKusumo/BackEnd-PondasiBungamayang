/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondasi.sch.id.pondasibungamayang.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pondasi.sch.id.pondasibungamayang.model.Role;

/**
 *
 * @author Asus VivoBook
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String name);
}
