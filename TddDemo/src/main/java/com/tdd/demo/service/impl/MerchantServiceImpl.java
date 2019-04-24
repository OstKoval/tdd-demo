package com.tdd.demo.service.impl;

import com.tdd.demo.dto.merchant.MerchantDTO;
import com.tdd.demo.entity.Agency;
import com.tdd.demo.entity.Merchant;
import com.tdd.demo.mapper.MerchantMapper;
import com.tdd.demo.repository.MerchantRepository;
import com.tdd.demo.service.AgencyService;
import com.tdd.demo.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private AgencyService agencyService;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    @Transactional
    public MerchantDTO addMerchant(final MerchantDTO merchantDTO) {
        if (Objects.isNull(merchantDTO)) {
            throw new IllegalArgumentException("DTO should be present!");
        }
        final Agency agency = Optional.ofNullable(agencyService.findAgencyById(merchantDTO.getBusinessInfo().getAgencyId()))
                .orElseThrow(() -> new IllegalArgumentException("Agency not found"));
        final Merchant existingMerchant = merchantRepository.findByEmail(merchantDTO.getContactInfo().getEmail());
        if (Objects.nonNull(existingMerchant)) {
            throw new IllegalArgumentException("Merchant already exists");
        }
        final Merchant merchant = merchantMapper.fromDTO(merchantDTO);
        merchant.setAgency(agency);
        final Merchant savedMerchant = merchantRepository.save(merchant);
        return merchantMapper.toDTO(savedMerchant);
    }
}
