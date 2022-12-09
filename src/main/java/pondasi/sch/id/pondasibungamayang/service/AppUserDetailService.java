/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pondasi.sch.id.pondasibungamayang.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pondasi.sch.id.pondasibungamayang.model.AppUserDetail;
import pondasi.sch.id.pondasibungamayang.model.User;
import pondasi.sch.id.pondasibungamayang.repository.UserRepository;

/**
 *
 * @author Asus VivoBook
 */
@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService{
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).
                orElseThrow(()-> new UsernameNotFoundException("Username or password is not correct"));
        return new AppUserDetail(user);
    }
}
