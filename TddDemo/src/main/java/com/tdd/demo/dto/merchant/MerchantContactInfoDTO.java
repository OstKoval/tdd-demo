package com.tdd.demo.dto.merchant;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MerchantContactInfoDTO {
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String email;

    @NotEmpty
    private String mainPhoneNumber;
}
