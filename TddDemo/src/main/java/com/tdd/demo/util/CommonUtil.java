package com.tdd.demo.util;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class CommonUtil {

    private CommonUtil() {

    }

    public static class Countries {
        //        public static Set<String> ALL_COUNTRIES =  //TODO one-time init
        public static Set<String> getAllCountries() {
            final Set<String> allCountries = new TreeSet<>();
            final String[] countryCodes = Locale.getISOCountries();

            for (final String countryCode : countryCodes) {
                allCountries.add(new Locale("", countryCode).getDisplayCountry());
            }
            return allCountries;
        }

        public static void validateCountryName(final String countryName) {
            if (!getAllCountries().contains(countryName)) {
                throw new IllegalArgumentException("Wrong value for country name!");
            }
        }

    }


}
