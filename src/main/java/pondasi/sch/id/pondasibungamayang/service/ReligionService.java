/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondasi.sch.id.pondasibungamayang.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pondasi.sch.id.pondasibungamayang.model.Religion;
import pondasi.sch.id.pondasibungamayang.repository.ReligionRepository;

/**
 *
 * @author Asus VivoBook
 */
@Service
public class ReligionService {

    private ReligionRepository religionRepository;

    @Autowired
    public ReligionService(ReligionRepository religionRepository) {
        this.religionRepository = religionRepository;
    }

    public List<Religion> getAll() {
        return religionRepository.findAll();
    }

    public Religion getById(Long id) {
        return religionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Religion not found"));
    }

    public Religion create(Religion religion) {
        if (religion.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Religion already exists");
        }
        if (religionRepository.findByName(religion.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Religion name already exists");
        }
        return religionRepository.save(religion);
    }

    public Religion update(Long id, Religion religion) {
        getById(id);
        religion.setId(id);
        return religionRepository.save(religion);
    }

    public Religion delete(Long id) {
        Religion religion = getById(id);
        religionRepository.delete(religion);
        return religion;
    }

}
