/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondasi.sch.id.pondasibungamayang.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Asus VivoBook
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "tutor_name")
    private String name;

    @Column(nullable = false, unique = true, name = "tutor_email")
    private String email;

    @Column(length = 13)
    private Long phone;

    @OneToOne(mappedBy = "tutor", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;
}
