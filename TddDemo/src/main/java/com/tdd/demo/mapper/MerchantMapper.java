package com.tdd.demo.mapper;

import com.tdd.demo.dto.merchant.MerchantBusinessAddressDTO;
import com.tdd.demo.dto.merchant.MerchantBusinessInfoDTO;
import com.tdd.demo.dto.merchant.MerchantContactInfoDTO;
import com.tdd.demo.dto.merchant.MerchantDTO;
import com.tdd.demo.entity.Merchant;
import com.tdd.demo.util.CommonUtil;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.tdd.demo.util.CommonUtil.Countries.validateCountryName;

@Component
public class MerchantMapper {

    public MerchantDTO toDTO(final Merchant merchant) {
        if (Objects.isNull(merchant)) {
            throw new IllegalArgumentException("Merchant cannot be null in mapper");
        }
        final MerchantContactInfoDTO contactInfoDTO = new MerchantContactInfoDTO()
                .setFirstName(merchant.getFirstName())
                .setLastName(merchant.getLastName())
                .setMainPhoneNumber(merchant.getMainPhoneNumber())
                .setEmail(merchant.getEmail());
        final MerchantBusinessInfoDTO businessInfoDTO = new MerchantBusinessInfoDTO()
                .setName(merchant.getName())
                .setGroup(merchant.getGroup())
                .setNickname(merchant.getNickname())
                .setMerchantID(merchant.getMerchantID())
                .setWebsite(merchant.getWebsite())
                .setAgencyId(merchant.getAgency().getId());
        validateCountryName(merchant.getCountry());
        final MerchantBusinessAddressDTO businessAddressDTO = new MerchantBusinessAddressDTO()
                .setStreetAddress(merchant.getStreetAddress())
                .setCity(merchant.getCity())
                .setCountry(merchant.getCountry())
                .setPostalCode(merchant.getPostalCode())
                .setState(merchant.getState());
        return new MerchantDTO()
                .setContactInfo(contactInfoDTO)
                .setBusinessInfo(businessInfoDTO)
                .setBusinessAddress(businessAddressDTO);
    }


    public Merchant fromDTO(final MerchantDTO merchantDTO) {
        if (Objects.isNull(merchantDTO)) {
            throw new IllegalArgumentException("Merchant dto cannot be null!");
        }
        return new Merchant();
    }

}
