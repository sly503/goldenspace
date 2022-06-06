package com.goldenspace.security.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    private Integer id;
    private String username; // used only to find user - won't be updated
    private String phone;
    private String email;
    private String password;

}
