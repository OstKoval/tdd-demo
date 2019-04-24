package com.tdd.demo.mapper;

import com.tdd.demo.dto.merchant.MerchantDTO;
import com.tdd.demo.entity.Merchant;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MerchantMapper {

    public MerchantDTO toDTO(final Merchant merchant) {
        if(Objects.isNull(merchant)){
            throw new IllegalArgumentException("Merchant cannot be null in mapper");
        }
        return new MerchantDTO();
    }


    public Merchant fromDTO(final MerchantDTO merchantDTO) {
        if(Objects.isNull(merchantDTO)){
            throw new IllegalArgumentException("Merchant dto cannot be null!");
        }
        return new Merchant();
    }

}
