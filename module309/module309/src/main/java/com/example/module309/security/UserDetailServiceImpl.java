package com.example.module309.security;

import com.example.module309.database.dao.UserDAO;
import com.example.module309.database.dao.UserRoleDAO;
import com.example.module309.database.entity.User;
import com.example.module309.database.entity.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserRoleDAO userRoleDAO;

    // incoming to this method is the username that person type in login form
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByEmailIgnoreCase(username);
        if (user == null) {
            // this is not good practice to printout username
            throw new UsernameNotFoundException("Email not found: " + username);
        }

        // other configuration for spring security
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        List<UserRole> userRoles = userRoleDAO.findByUserId(user.getId());
        Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                springRoles);
    }

    public Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            authorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));
        }
        return authorities;
    }
}
