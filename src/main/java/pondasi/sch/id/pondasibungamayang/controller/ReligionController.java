/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondasi.sch.id.pondasibungamayang.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pondasi.sch.id.pondasibungamayang.model.Religion;
import pondasi.sch.id.pondasibungamayang.service.ReligionService;

/**
 *
 * @author Asus VivoBook
 */
@RestController
@RequestMapping("/religion")
public class ReligionController {

    private ReligionService religionService;

    @Autowired
    public ReligionController(ReligionService religionService) {
        this.religionService = religionService;
    }

    // http://localhost:8088/religion
    @GetMapping
    public List<Religion> getAll() {
        return religionService.getAll();
    }

    @GetMapping("/{id}")
    public Religion getById(@PathVariable Long id) {
        return religionService.getById(id);
    }
    // http://localhost:8088/religion/1   (PathVariable) Detail

    @PostMapping
    public Religion create(@RequestBody Religion religion) {
        return religionService.create(religion);
    }
    // http://localhost:8088/religion 

    @PutMapping("/{id}")
    public Religion update(@PathVariable Long id, @RequestBody Religion religion) {
        return religionService.update(id, religion);
    }
    // http://localhost:8088/religion/1

    @DeleteMapping("/{id}")
    public Religion delete(@PathVariable Long id) {
        return religionService.delete(id);
    }
    // http://localhost:8088/religion/1

}
