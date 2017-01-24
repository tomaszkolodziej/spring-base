package com.tolean.elab.business.impl.security;

import com.tolean.elab.business.api.security.SecurityService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by Tomasz Kołodziej
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Override
    public boolean hasProtectedAccess() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"));
    }

}
