/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondasi.sch.id.pondasibungamayang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "student_code", length = 16)
  private String code;

  @Column(nullable = false, name = "student_name")
  private String name;
  
  @Column(nullable = false, name = "student_nickname")
  private String nickname;
  
  @Column(nullable = false, name = "student_address")
  private String address;
  
  @Column(length = 13)
  private Long phone;
  
  @Column(nullable = false, name = "student_pob")
  private String pob;
  
  @Column(nullable = false, name = "student_dob")
  private String dob;
  
  @Column(nullable = false, name = "student_gender")
  private String gender;
  
  @ManyToOne
  private Religion religion;
}
