package com.tdd.demo.unit.merchant;

import com.tdd.demo.dto.merchant.MerchantBusinessInfoDTO;
import com.tdd.demo.dto.merchant.MerchantContactInfoDTO;
import com.tdd.demo.dto.merchant.MerchantDTO;
import com.tdd.demo.entity.Agency;
import com.tdd.demo.entity.Merchant;
import com.tdd.demo.repository.MerchantRepository;
import com.tdd.demo.service.AgencyService;
import com.tdd.demo.service.impl.MerchantServiceImpl;
import com.tdd.demo.unit.BaseUnitTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

public class MerchantServiceTest extends BaseUnitTest {

    @InjectMocks
    private MerchantServiceImpl merchantService;

    @Mock
    private AgencyService agencyService;

    @Mock
    private MerchantRepository merchantRepository;

    @Test(expected = IllegalArgumentException.class)
    public void addMerchant__throwExceptionIfNullDtoValue() {
        merchantService.addMerchant(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMerchant__AgencyNotExist() {
        final MerchantDTO testDTO = new MerchantDTO()
                .setBusinessInfo(new MerchantBusinessInfoDTO()
                        .setAgencyId(2L));
        when(agencyService.findAgencyById(2L)).thenReturn(null);
        merchantService.addMerchant(testDTO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMerchant__MerchantAlreadyExist() {
        final MerchantDTO testDTO = new MerchantDTO()
                .setBusinessInfo(new MerchantBusinessInfoDTO()
                        .setAgencyId(2L))
                .setContactInfo(new MerchantContactInfoDTO()
                        .setEmail("existingemail@gmail.com"));
        when(agencyService.findAgencyById(2L)).thenReturn(new Agency());
        when(merchantRepository.findByEmail("existingemail@gmail.com")).thenReturn(new Merchant());
        merchantService.addMerchant(testDTO);
    }
}
