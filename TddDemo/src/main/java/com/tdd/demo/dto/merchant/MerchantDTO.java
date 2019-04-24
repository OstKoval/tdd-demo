package com.tdd.demo.dto.merchant;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Data
public class MerchantDTO {

    @Valid
    @NotEmpty
    private MerchantBusinessInfoDTO businessInfo;

    @Valid
    @NotEmpty
    private MerchantBusinessAddressDTO businessAddress;

    @Valid
    @NotEmpty
    private MerchantContactInfoDTO contactInfo;
}
