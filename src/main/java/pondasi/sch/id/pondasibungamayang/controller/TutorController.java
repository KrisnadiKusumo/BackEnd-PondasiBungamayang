/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondasi.sch.id.pondasibungamayang.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pondasi.sch.id.pondasibungamayang.model.Tutor;
import pondasi.sch.id.pondasibungamayang.service.TutorService;

/**
 *
 * @author Asus VivoBook
 */
@RestController
@RequestMapping("/tutor")
@AllArgsConstructor
//@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class TutorController {
    private TutorService tutorService;

    @GetMapping
    public List<Tutor> getAll() {
        return tutorService.getAll();
    }

//    @PreAuthorize("hasAuthority('READ_MANAGER')")
    @GetMapping("/{id}")
    public Tutor getById(@PathVariable Long id) {
        return tutorService.getById(id);
    }

//    @PreAuthorize("hasAuthority('CREATE_USER')")
    @PostMapping
    public Tutor create(@RequestBody Tutor tutor) {
        return tutorService.create(tutor);
    }

    @PutMapping("/{id}")
    public Tutor update(@PathVariable Long id, @RequestBody Tutor tutor) {
        return tutorService.update(id, tutor);
    }

    @DeleteMapping("/{id}")
    public Tutor delete(@PathVariable Long id) {
        return tutorService.delete(id);
    }
}
