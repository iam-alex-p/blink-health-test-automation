package com.blink.health.tests.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlinkHealthCredentialsEntity {
    private String email;
    private String password;
    private boolean isValidEmail;
    private boolean isValidPassword;
    private boolean isAuthenticatable;
    private boolean isMFA;
    private String description;
}
