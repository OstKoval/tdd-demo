package com.tdd.demo.util;

import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CommonUtil {

    private CommonUtil() {

    }

    public static class Countries {
        public static final Set<String> ALL_COUNTRIES = Arrays.stream(Locale.getISOCountries())
                .map(l -> new Locale("", l).getDisplayCountry())
                .collect(Collectors.toSet());

        public static void validateCountryName(final String countryName) {
            if (!ALL_COUNTRIES.contains(countryName)) {
                throw new IllegalArgumentException("Wrong value for country name!");
            }
        }

    }


}
