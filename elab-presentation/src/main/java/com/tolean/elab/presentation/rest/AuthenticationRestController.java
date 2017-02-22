package com.tolean.elab.presentation.rest;

import com.tolean.elab.presentation.security.AuthenticationRequest;
import com.tolean.elab.presentation.security.AuthenticationResponse;
import com.tolean.elab.presentation.security.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tomasz Kołodziej
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationRestController {

    @Value("${app.token.header")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> authenticationRequest(@RequestBody AuthenticationRequest authenticationRequest, Device device) {
        try {
            Authentication authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Reload password post-authentication so we can generate token
            final UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String token = this.tokenUtils.generateToken(userDetails, device);

            // Return the token
            return ResponseEntity.ok(new AuthenticationResponse(userDetails.getUsername(), token));
        } catch (AuthenticationException e) {
            new EidRuntimeException("20161107:1745", "Błędny login lub hasło");
        }

        return null;
    }

    @RequestMapping(value = "${app.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> authenticationRequest(HttpServletRequest request) {
        String token = request.getHeader(this.tokenHeader);
        String refreshedToken = this.tokenUtils.refreshToken(token);
        return ResponseEntity.ok(new AuthenticationResponse(null, refreshedToken));
    }

}
