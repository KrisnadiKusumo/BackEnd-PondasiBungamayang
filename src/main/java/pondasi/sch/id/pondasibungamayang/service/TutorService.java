/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondasi.sch.id.pondasibungamayang.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pondasi.sch.id.pondasibungamayang.model.Role;
import pondasi.sch.id.pondasibungamayang.model.Tutor;
import pondasi.sch.id.pondasibungamayang.repository.TutorRepository;

/**
 *
 * @author Asus VivoBook
 */
@Service
@AllArgsConstructor
public class TutorService {
    private TutorRepository tutorRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    
    public List<Tutor> getAll(){
        return tutorRepository.findAll();
    }
    
    public Tutor getById(Long id){
        return tutorRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tutor id not found"
                ));
    }
    
    public Tutor create(Tutor tutor){
        // Set Role
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.getById(1L));
        tutor.getUser().setRoles(roles);
        
        // Set IsEnabled, IsAccountLocked
        tutor.getUser().setIsAccountLocked(true);
        tutor.getUser().setIsEnabled(Boolean.TRUE);
        
        // Set Password
        String password = tutor.getUser().getPassword();
        tutor.getUser().setPassword(passwordEncoder.encode(password));
        
        // Set Employee in User
        tutor.getUser().setTutor(tutor);
        
        return tutorRepository.save(tutor);
    }
    
    public Tutor update(Long id, Tutor tutor){
        getById(id);
        tutor.setId(id);
        return tutorRepository.save(tutor);
    }
    
    public Tutor delete(Long id){
        Tutor tutor = getById(id);
        tutorRepository.delete(tutor);
        return tutor;
    }
}
