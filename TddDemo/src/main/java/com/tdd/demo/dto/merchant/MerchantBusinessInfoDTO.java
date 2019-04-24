package com.tdd.demo.dto.merchant;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MerchantBusinessInfoDTO {
    @NotEmpty(message = "Merchant name should not be empty")
    private String name;

    @NotEmpty(message = "Merchant id not empty")
    private String merchantID;

    private String nickname;

    private String website;

    private String group;

    private Long agencyId;
}
