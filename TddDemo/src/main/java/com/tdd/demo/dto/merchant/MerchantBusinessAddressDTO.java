package com.tdd.demo.dto.merchant;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MerchantBusinessAddressDTO {

    @NotEmpty
    private String streetAddress;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @NotEmpty
    private String postalCode;

    @NotEmpty
    private String country;

}
