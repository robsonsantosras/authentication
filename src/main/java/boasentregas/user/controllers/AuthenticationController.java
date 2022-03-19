package boasentregas.user.controllers;


import boasentregas.accesslogs.api.Register;
import boasentregas.user.models.JwtToken;
import boasentregas.user.services.implement.TokenService;
import boasentregas.user.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("oauth/v1/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private Register register;

    @PostMapping("")
    public ResponseEntity<?> createAuthenticationToken(@RequestHeader("Authorization") String auth) throws Exception {

        try {
            String[] user = Base64.decriptAuthentication(auth);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user[0], user[1]);

            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

            String token = tokenService.generateToken(authentication);

            register.logAccess(request,user[0],HttpStatus.CREATED.toString());

            return new ResponseEntity<>(JwtToken.builder().type("Bearer").token(token).build(), HttpStatus.CREATED);
        } catch (Exception ex) {
            register.logAccess(request,"",HttpStatus.UNAUTHORIZED.toString(),ex.getMessage());
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }



    }

}
