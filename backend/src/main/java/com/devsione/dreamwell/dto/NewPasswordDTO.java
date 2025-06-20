package com.devsione.dreamwell.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPasswordDTO {

    private String oldpass;
    private String newpass;

}
