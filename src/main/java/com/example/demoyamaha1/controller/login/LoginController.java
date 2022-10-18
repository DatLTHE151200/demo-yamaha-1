package com.example.demoyamaha1.controller.login;

import com.example.demoyamaha1.authentication.jwt.JwtResponse;
import com.example.demoyamaha1.authentication.jwt.JwtService;
import com.example.demoyamaha1.authentication.user.ICustomUserService;
import com.example.demoyamaha1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.demoyamaha1.utils.WebConstants.TOKEN_DURATION;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ICustomUserService userService;

    @PostMapping(value="/login", consumes = {"*/*"})
    public ResponseEntity<?> login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername()).get();
        JwtResponse jwtResponse = new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities());
        Cookie authCookie = new Cookie("AUTH",jwt);
        authCookie.setMaxAge((int)TOKEN_DURATION*1000);
        Cookie[] cookies = request.getCookies();
        if(cookies == null || cookies.length<=1)
        response.addCookie(authCookie);
        return ResponseEntity.ok(jwtResponse);
    }
}

