package com.tdd.demo.unit.util;

import com.tdd.demo.unit.BaseUnitTest;
import com.tdd.demo.util.CommonUtil;
import org.junit.Test;

import static com.tdd.demo.util.CommonUtil.Countries.ALL_COUNTRIES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommonUtilTest extends BaseUnitTest {

    @Test
    public void getAllCountries() {
        assertEquals("Size of countries is not equals", 249, ALL_COUNTRIES.size());
        assertTrue(ALL_COUNTRIES.contains("Ukraine"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateCountryName(){
        final String countryName = "WRONG";
        CommonUtil.Countries.validateCountryName(countryName);
    }
}
