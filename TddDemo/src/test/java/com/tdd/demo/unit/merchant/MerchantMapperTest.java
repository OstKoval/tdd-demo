package com.tdd.demo.unit.merchant;


import com.tdd.demo.dto.merchant.MerchantDTO;
import com.tdd.demo.entity.Agency;
import com.tdd.demo.entity.Merchant;
import com.tdd.demo.mapper.MerchantMapper;
import com.tdd.demo.unit.BaseUnitTest;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.assertEquals;

public class MerchantMapperTest extends BaseUnitTest {

    @InjectMocks
    private MerchantMapper merchantMapper;

    @Test(expected = IllegalArgumentException.class)
    public void toDTO__NullValue() {
        merchantMapper.toDTO(null);
    }

    @Test
    public void toDTO__valuesMatch() {
        final Merchant testMerchantEntity = getDefaultMerchant();
        final MerchantDTO merchantDTO = merchantMapper.toDTO(testMerchantEntity);
        assertEquals(testMerchantEntity.getEmail(), merchantDTO.getContactInfo().getEmail());
        assertEquals(testMerchantEntity.getAgency().getId(), merchantDTO.getBusinessInfo().getAgencyId());
        // all other fields
    }

    @Test(expected = IllegalArgumentException.class)
    public void toDTO__invalidValueForCountry() {
        final Merchant testMerchantEntity = getDefaultMerchant()
                .setCountry("Wrong country");
        merchantMapper.toDTO(testMerchantEntity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromDTO__NullValue() {
        merchantMapper.fromDTO(null);
    }

    private Merchant getDefaultMerchant() {
        return new Merchant()
                .setId(1L)
                .setName("Test name")
                .setMerchantID("Test merchant id")
                .setNickname("Test nickname")
                .setWebsite("web-test.com")
                .setGroup("Test group")
                .setStreetAddress("Parkway Drive, 4")
                .setCity("Denver")
                .setState("Colorado")
                .setPostalCode("82100")
                .setCountry("Ukraine")
                .setFirstName("John")
                .setLastName("Newman")
                .setEmail("test@gmail.com")
                .setMainPhoneNumber("5468647")
                .setAgency(new Agency().setId(1L));
    }
}
