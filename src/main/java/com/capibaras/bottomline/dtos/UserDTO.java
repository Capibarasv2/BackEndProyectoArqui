package com.capibaras.bottomline.dtos;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private Long role_id;

}
