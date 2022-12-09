/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondasi.sch.id.pondasibungamayang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pondasi.sch.id.pondasibungamayang.model.Privilage;

/**
 *
 * @author Asus VivoBook
 */
@Repository
public interface PrivilageRepository extends JpaRepository<Privilage, Long>{
    
}
