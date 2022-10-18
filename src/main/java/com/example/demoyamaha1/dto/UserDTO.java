package com.example.demoyamaha1.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends AbstractDTO{
    private String username;
    private String password;
    private String email;
    private String role;
    private int permissionLevel;
    private int status;
}
