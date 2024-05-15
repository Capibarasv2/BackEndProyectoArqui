package com.capibaras.bottomline.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String email;
    private String password;
    private String name;
    private String lastName;
}
