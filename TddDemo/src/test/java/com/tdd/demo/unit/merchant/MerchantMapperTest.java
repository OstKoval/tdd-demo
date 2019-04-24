package com.tdd.demo.unit.merchant;


import com.tdd.demo.mapper.MerchantMapper;
import com.tdd.demo.unit.BaseUnitTest;
import org.junit.Test;
import org.mockito.InjectMocks;

public class MerchantMapperTest extends BaseUnitTest {

    @InjectMocks
    private MerchantMapper merchantMapper;

    @Test(expected = IllegalArgumentException.class)
    public void toDTO__NullValue() {
        merchantMapper.toDTO(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromDTO__NullValue() {
        merchantMapper.fromDTO(null);
    }
}
