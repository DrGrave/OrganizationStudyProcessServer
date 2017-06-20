package com.vkkzlabs.service;

import com.vkkzlabs.entity.MyUser;
import com.vkkzlabs.entity.MyUserCredentials;
import com.vkkzlabs.entity.enums.RolesMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private
    UserCredentialsService userCredentialsService;

    @Autowired
    private
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MyUserCredentials userCredentials = userCredentialsService.getUserByLogin(s);
        RolesMap rolesMap = new RolesMap();
        rolesMap.getRoles();
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(rolesMap.getRole(userCredentials.getMyUser().getUserType().getIdUserType())));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(userCredentials.getUserLogin(), userCredentials.getUserPassword(), roles);
        return userDetails;
    }
}
