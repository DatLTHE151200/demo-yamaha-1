package com.example.demoyamaha1.authentication.jwt;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String accessToken, Long id, String username, Collection<? extends GrantedAuthority> roles) {
        this.token = accessToken;
        this.username = username;
        this.roles = roles;
        this.id = id;
    }
}
