/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondasi.sch.id.pondasibungamayang.service;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pondasi.sch.id.pondasibungamayang.model.Privilage;
import pondasi.sch.id.pondasibungamayang.repository.PrivilageRepository;

/**
 *
 * @author Asus VivoBook
 */
@Service
@AllArgsConstructor
public class PrivilageService {
    private PrivilageRepository privilageRepository;

    public List<Privilage> getAll() {
        return privilageRepository.findAll();
    }

    public Privilage getById(Long id) {
        return privilageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "Privilage id not found"
                        ));
    }

    public Privilage create(Privilage privilage) {
        return privilageRepository.save(privilage);
    }

    public Privilage update(Long id, Privilage privilage) {
        getById(id);
        privilage.setId(id);
        return privilageRepository.save(privilage);
    }

    public Privilage delete(Long id) {
        Privilage privilage = getById(id);
        privilageRepository.delete(privilage);
        return privilage;
    }
}
