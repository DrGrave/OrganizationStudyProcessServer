package com.vkkzlabs.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by vadim on 29.06.17.
 */
public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService{
    public UserDetails loadUserByUsername(String s);
}
